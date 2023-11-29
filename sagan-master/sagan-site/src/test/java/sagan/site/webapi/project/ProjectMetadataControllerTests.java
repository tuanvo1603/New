package sagan.site.webapi.project;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import sagan.site.projects.Project;
import sagan.site.projects.ProjectMetadataService;
import sagan.site.projects.SupportStatus;
import sagan.site.webapi.WebApiTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.MediaTypes;
import org.springframework.restdocs.hypermedia.LinkDescriptor;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for {@link ProjectMetadataController}
 */
@RunWith(SpringRunner.class)
@WebApiTest(ProjectMetadataController.class)
public class ProjectMetadataControllerTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ProjectMetadataService metadataService;

	private Project springBoot;

	private Project springData;

	private Project springDataES;

	@Before
	public void setup() {
		this.springBoot = new Project("spring-boot", "Spring Boot");
		this.springBoot.setRepoUrl("https://github.com/spring-projects/spring-boot");
		this.springBoot.setStatus(SupportStatus.ACTIVE);
		this.springData = new Project("spring-data", "Spring Data");
		this.springData.setRepoUrl("https://github.com/spring-projects/spring-data");
		this.springData.setStatus(SupportStatus.ACTIVE);
		this.springDataES = new Project("spring-data-elasticsearch", "Spring Data Elasticsearch");
		this.springDataES.setRepoUrl("https://github.com/spring-projects/spring-data-elasticsearch");
		this.springDataES.setStatus(SupportStatus.ACTIVE);
		this.springDataES.setParentProject(this.springData);
	}

	@Test
	public void listProjects() throws Exception {
		given(this.metadataService.fetchAllProjects()).willReturn(Arrays.asList(this.springBoot, this.springData, this.springDataES));
		this.mvc.perform(get("/api/projects").accept(MediaTypes.HAL_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$._embedded.projects.length()").value("3"))
				.andDo(document("{method-name}", preprocessResponse(prettyPrint()),
						responseFields(fieldWithPath("_embedded.projects").description("An array of Projects"))
								.andWithPrefix("_embedded.projects[]", projectPayload())));
	}

	@Test
	public void showProject() throws Exception {
		given(this.metadataService.fetchFullProject("spring-boot")).willReturn(this.springBoot);
		this.mvc.perform(get("/api/projects/spring-boot").accept(MediaTypes.HAL_JSON))
				.andExpect(status().isOk())
				.andDo(document("{method-name}", preprocessResponse(prettyPrint()),
						responseFields(projectPayload()), links(projectLinks())));
	}

	FieldDescriptor[] projectPayload() {
		return new FieldDescriptor[] {
				fieldWithPath("name").type(JsonFieldType.STRING).description("Project Name"),
				fieldWithPath("slug").type(JsonFieldType.STRING).description("URL-friendly name of the project"),
				fieldWithPath("repositoryUrl").type(JsonFieldType.STRING).description("URL for the source repository"),
				fieldWithPath("status").type(JsonFieldType.STRING).description("<<project-status, Support status>> of the project"),
				fieldWithPath("_links").description("Links to other resources")
		};
	}

	LinkDescriptor[] projectLinks() {
		return new LinkDescriptor[] {
				linkWithRel("self").description("Canonical self link"),
				linkWithRel("parent").optional().description("Link to <<project, parent Project>>, if any"),
				linkWithRel("generations").optional().description("Link to <<generation, Generations>>"),
				linkWithRel("releases").optional().description("Link to <<release, Releases>>")
		};
	}


	@Configuration
	static class ProjectMetadataTestConfig {

		@Bean
		public ProjectMetadataAssembler projectMetadataAssembler(EntityLinks entityLinks, ModelMapper modelMapper) {
			return new ProjectMetadataAssembler(entityLinks, modelMapper);
		}
	}
}