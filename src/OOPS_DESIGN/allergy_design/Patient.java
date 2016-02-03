package OOPS_DESIGN.allergy_design;

import java.util.List;

public class Patient extends Person{

	private List<Allergy> allergyList;

	private List<Disease> diseaseList;

	public List<Allergy> getAllergyList() {
		return allergyList;
	}

	public void setAllergyList(List<Allergy> allergyList) {
		this.allergyList = allergyList;
	}

	public List<Disease> getDiseaseList() {
		return diseaseList;
	}

	public void setDiseaseList(List<Disease> diseaseList) {
		this.diseaseList = diseaseList;
	}
}