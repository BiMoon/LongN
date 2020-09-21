package testDemo;

//import org.testng.annotations.Test;
import framework.core.BaseTest;
import pageobject.GoogleHomepage;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

import org.junit.*;
import org.openqa.selenium.WebDriver;
 

public class GoogleHomepageTests extends BaseTest{
		static WebDriver webdriver;
		static String url = "http://www.google.com";
		
		
		@Before
		public void setUp()  {
		
		
		}
		
		
			
        @Test
        public void googlesearchEdge() throws Exception {
        	String key = "JAVA + SELENIUM";

        	GoogleHomepage googleHomepage = new GoogleHomepage(getDriver("E", url)); ; // = new GoogleHomepage(getDriver("F", url)); // "F" with under Firefox browser
        	
            System.out.print("Open " + url + " in MS Edge");
            
            
			googleHomepage.searhTestinput(key);
        }

		//@Test
		
        public void homepageTestsFirefox() throws Exception {
			GoogleHomepage googleHomepage = new GoogleHomepage(getDriver("E", url));
			
            System.out.print("Open " + url + " in Firefox");
        }

        //@Test
        public void homepageTestsMsEdge() throws Exception {
            //GoogleHomepage googleHomepage = new GoogleHomepage(getDriver("E", url));
        	
            System.out.print("Open " + url + " in MS Edge");
        }
            

        @After
		public void tearDown() throws Exception {
		// Close the browser
		Thread.sleep(3000);
		
		quitDriver();
		
	}
}

