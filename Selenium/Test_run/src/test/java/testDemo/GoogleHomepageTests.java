package testDemo;

//import org.testng.annotations.Test;
import framework.core.BaseTest;
//import pageobject.GoogleHomepage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
 

public class GoogleHomepageTests extends BaseTest{
		static WebDriver webdriver;
		static String url = "http://www.google.com";

		@Test
        public void homepageTestsFirefox() throws Exception {
			//GoogleHomepage googleHomepage = new GoogleHomepage(getDriver("E", url));
			BaseTest.getDriver("F", url);
            System.out.print("Open " + url + " in Firefox");
        }
        @Test
        public void homepageTestsMsEdge() throws Exception {
            //GoogleHomepage googleHomepage = new GoogleHomepage(getDriver("E", url));
        	BaseTest.getDriver("E", url);
            System.out.print("Open " + url + " in MS Edge");
        }
        @After
		public void tearDown() throws Exception {
		// Close the browser
		//Thread.sleep(3);
		quitDriver();
		
	}
}

