package TestDemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Webdriver {
	private static WebDriver webdriver;
	private static final String operatingSystem =	System.getProperty("os.name").toUpperCase();
	private static final String systemArchitecture = System.getProperty("os.arch");
	public static WebDriver getDriver(String br) throws Exception {
		if (null == webdriver) {
			System.out.println(" ");
			System.out.println("Current Operating System: " + operatingSystem);
			System.out.println("Current Architecture: " + systemArchitecture);
			
			System.out.println(" ");
			if (br == "F") {
				System.out.println("Current Browser Selection:Firefox");
				webdriver = new FirefoxDriver();
				webdriver.manage().window().maximize();
				// 	Navigate to Google
				
			}
			else {
				System.out.println("Current Browser Selection:MS_Egde");
				System.setProperty("webdriver.edge.driver","msedgedriver.exe");
				EdgeOptions options = new EdgeOptions();
				options.setPageLoadStrategy("eager");
				// Launch a new Edge instance
				webdriver = new EdgeDriver(options);
				// Navigate to Google
				
			}
			//webdriver.get("http://www.google.com");
		} 
		
		return webdriver;
	} 
	public static void quitDriver() {
		if (null != webdriver) {
			webdriver.quit();
			webdriver = null;
		}
	}
}