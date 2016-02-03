package OOPS_DESIGN.allergy_design;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class PatientHealthInfo {
	
	
	public static void main(String[] args) throws IOException {
		Patient pt = new Patient();
		pt.setName("jack");
		Allergy al = new Allergy();
		al.setAllergyName("rashes");
		al.setSeverity("medium");
		Allergy al1 = new Allergy();
		al1.setAllergyName("sweling");
		al1.setSeverity("medium");
		List<Allergy> allergyList = new ArrayList<Allergy>();
		allergyList.add(al);
		allergyList.add(al1);
		pt.setAllergyList(allergyList);
		String str = patient(pt);
		System.out.println(" Result is :: " + str);
		

		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
	        String text = "";  
	        do
	        {
	            System.out.println("Please enter a string: ");
	            text = br.readLine(); 
	            System.out.println(text);
	        }while (!text.equals("stop"));
	        
	}

	public static String patient(Patient pt) {
		if (pt.getAllergyList().size() > 0) {
			return "allergy";
		} else if (pt.getDiseaseList().size() > 0) {
			return "diease";
		}
		return null;
	}

}
