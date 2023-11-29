package sagan.site.projects.admin;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Pattern;

public class ProjectFormGenerations {

	private String id;

	private List<FormGeneration> generations = new ArrayList<>();

	private FormGeneration newGeneration;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<FormGeneration> getGenerations() {
		return generations;
	}

	public void setGenerations(List<FormGeneration> generations) {
		this.generations = generations;
	}

	public FormGeneration getNewGeneration() {
		return newGeneration;
	}

	public void setNewGeneration(FormGeneration newGeneration) {
		this.newGeneration = newGeneration;
	}

	public static class FormGeneration {

		@Pattern(regexp = "[\\w\\d.]*\\.x")
		private String name;

		private boolean toDelete;

		private String initialReleaseDate;

		private String ossSupportEnforcedEndDate;

		private String ossSupportPolicyEndDate;

		private String commercialSupportEnforcedEndDate;

		private String commercialSupportPolicyEndDate;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public boolean isToDelete() {
			return toDelete;
		}

		public void setToDelete(boolean toDelete) {
			this.toDelete = toDelete;
		}

		public String getInitialReleaseDate() {
			return initialReleaseDate;
		}

		public void setInitialReleaseDate(String initialReleaseDate) {
			this.initialReleaseDate = initialReleaseDate;
		}

		public String getOssSupportEnforcedEndDate() {
			return ossSupportEnforcedEndDate;
		}

		public void setOssSupportEnforcedEndDate(String ossSupportEnforcedEndDate) {
			this.ossSupportEnforcedEndDate = ossSupportEnforcedEndDate;
		}

		public String getOssSupportPolicyEndDate() {
			return ossSupportPolicyEndDate;
		}

		public void setOssSupportPolicyEndDate(String ossSupportPolicyEndDate) {
			this.ossSupportPolicyEndDate = ossSupportPolicyEndDate;
		}

		public String getCommercialSupportEnforcedEndDate() {
			return commercialSupportEnforcedEndDate;
		}

		public void setCommercialSupportEnforcedEndDate(String commercialSupportEnforcedEndDate) {
			this.commercialSupportEnforcedEndDate = commercialSupportEnforcedEndDate;
		}

		public String getCommercialSupportPolicyEndDate() {
			return commercialSupportPolicyEndDate;
		}

		public void setCommercialSupportPolicyEndDate(String commercialSupportPolicyEndDate) {
			this.commercialSupportPolicyEndDate = commercialSupportPolicyEndDate;
		}
	}
}
