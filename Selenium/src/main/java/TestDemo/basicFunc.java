package TestDemo;

import java.io.IOException;

public class basicFunc {
	public static String getBuild_id() {
		String build_id = "0102030405";
		return build_id; 
	}
	public static Boolean  makestuffready(String tc) throws IOException {
		Boolean run = true;
		String build_id = getBuild_id();

		ReadTC.updateTestcaseName(tc);

		ReadTC.createTestReport(build_id);
		
		String result = ReadTC.getTestcase_report(tc, "0102030405");
		
		
		String test_name = ReadTC.getTestcaseName(tc);
		
		if (null != test_name) {
			if ((test_name.equals("N")) || (result.equals("PASSED")))
			{
				System.out.println("Test case NO need to be tested");
				run = false;
			}
			
			else 
			{
				System.out.println("Test case need to be tested");
				run = true;
			}

		}
		return run;
 	}
}


