package testDemo;
import framework.core.BaseTest;
import pageobject.Careerbuilder;
import static org.junit.Assert.*;
import org.junit.*;
import TestDemo.ReadTC;
import TestDemo.basicFunc;

public class CareerbuildeTest extends BaseTest{
	static String url = "https://careerbuilder.vn/";
	static String url_en = "https://careerbuilder.vn/en";
	
	//@Test
    public void CareerBuilderTestLoginFirefoxEn() throws Exception {
		String result_update; 
		
		Boolean result, run;
		
		String tc_name = new Throwable() // Get function's name as name of test case, that will be updated to Test_case sheet and Test_report sheet 
                .getStackTrace()[0] 
                .getMethodName(); 
		
		run = basicFunc.makestuffready(tc_name); // Make sure Test_report, Test_case, Build sheet are ready before run the test.
		if (run == false)
		{
			return; //this case has been run and PASSED >>> Skip this test, move to next test case if any
		}
		
		
		String build_id = basicFunc.getBuild_id();
		
        Careerbuilder careerbilder = new Careerbuilder(getDriver("F", url_en)); // "F" with under Firefox browser
        
        System.out.print("Open " + url + " in Firefox");
        
        result = careerbilder.login_en(); // Test Login 
        
        if (result == true) 
        {
        	result_update = "PASSED";
        }
        
        else { result_update = "FAILED"; }
        
		assertTrue(result);
		
		
		ReadTC.updateTestReport(tc_name, result_update , build_id); // update test result to report sheet 
		
	}
	@Test
    public void CareerBuilderTestDashboradFirefoxEn() throws Exception {
		String result_update; 
		
		Boolean result, run;
		
		String tc_name = new Throwable() // Get function's name as name of test case, that will be updated to Test_case sheet and Test_report sheet 
                .getStackTrace()[0] 
                .getMethodName(); 
		
		run = basicFunc.makestuffready(tc_name); // Make sure Test_report, Test_case, Build sheet are ready before run the test.
		if (run == false)
		{
			return; //this case has been run and PASSED >>> Skip this test, move to next test case if any
		}
		
		
		String build_id = basicFunc.getBuild_id();
		
        Careerbuilder careerbilder = new Careerbuilder(getDriver("F", url_en)); // "F" with under Firefox browser
        
        System.out.print("Open " + url + " in Firefox");
        
        result = careerbilder.dashboard_en(); // Test Login 
        
        if (result == true) 
        {
        	System.out.print("GET IN THE Dashboard");
        	result_update = "PASSED";
        }
        
        else { result_update = "FAILED"; }
        
		assertTrue(result);
		
		
		ReadTC.updateTestReport(tc_name, result_update , build_id); // update test result to report sheet 
		
	}
	
	//@Test
    public void CareerBuilderTestLoginFirefox() throws Exception {
		String result_update; 
		
		Boolean result, run;
		
		String tc_name = new Throwable() // Get function's name as name of test case, that will be updated to Test_case sheet and Test_report sheet 
                .getStackTrace()[0] 
                .getMethodName(); 
		
		run = basicFunc.makestuffready(tc_name); // Make sure Test_report, Test_case, Build sheet are ready before run the test.
		if (run == false)
		{
			return; //this case has been run and PASSED >>> Skip this test, move to next test case if any
		}
		
		
		String build_id = basicFunc.getBuild_id();
		
        Careerbuilder careerbilder = new Careerbuilder(getDriver("F", url)); // "F" with under Firefox browser
        
        System.out.print("Open " + url + " in Firefox");
        
        result = careerbilder.login(); // Test Login 
        
        if (result == true) 
        {
        	result_update = "PASSED";
        }
        
        else { result_update = "FAILED"; }
        
		assertTrue(result);
		
		
		ReadTC.updateTestReport(tc_name, result_update , build_id); // update test result to report sheet 
		
	}
    //@Test
	public void CareerBuilderTestLoginMsEdge() throws Exception {
		String result_update;
		
		Boolean result, run;
		
		String tc_name = new Throwable() 
                .getStackTrace()[0] 
                .getMethodName(); 

		run = basicFunc.makestuffready(tc_name);
		if (run == false)
		{
			return;
		}
		//System.out.print("Testcase name" + tc_name);
		
		basicFunc.makestuffready(tc_name);
		
		String build_id = basicFunc.getBuild_id();

        Careerbuilder careerbilder = new Careerbuilder(getDriver("E", url));
        
        System.out.print("Open " + url + " in Edge");
        result = careerbilder.login();
        
        if (result == true) {
        	result_update = "PASSED";
        }
        else {result_update = "FAILED";}
        
		assertTrue(result);
		
		
		ReadTC.updateTestReport(tc_name, result_update , build_id);
		
    }
    
    //@Test
    public void CareerBuilderTestsRegristerFixefox() throws Exception {
    	String result_update;
		
		Boolean result, run;
		
		String tc_name = new Throwable() 
                .getStackTrace()[0] 
                .getMethodName(); 

		run = basicFunc.makestuffready(tc_name);
		if (run == false)
		{
			return;
		}
		
		String build_id =basicFunc.getBuild_id();
		
        Careerbuilder careerbilder = new Careerbuilder(getDriver("F", url));
        
        System.out.print("Open " + url + " in Firefox");
        
        result = careerbilder.register();
        
        
        if (result == true) 
        {
        	result_update = "PASSED";
        }
        else {result_update = "FAILED";}
        
		assertTrue(result);
		
		
		ReadTC.updateTestReport(tc_name, result_update , build_id);
		
		
    }
    @After
	public void tearDown() throws Exception {
    	Thread.sleep(3000);
    	quitDriver();
		
	}
}


