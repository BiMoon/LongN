package framework.core;
/**
 * Open a selected Browser, pass "F" or "E" and url as argument when calling
 *     "F" open Firefox
 *     "E" open Ms Edge
 * Return a open browser with url of home page need to test       
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    private static WebDriver webdriver;
    private static final String operatingSystem =	System.getProperty("os.name").toUpperCase();
    private static final String systemArchitecture = System.getProperty("os.arch");
    
    public static WebDriver getDriver(WebDriver webdriver) throws Exception {
    	webdriver = new FirefoxDriver();
    	return webdriver;
    
    }
    
    public static WebDriver getDriver(String br, String request) throws Exception {
    	
        if (null == webdriver) {
            System.out.println(" ");
            System.out.println("Current Operating System: " + operatingSystem);
            System.out.println("Current Architecture: " + systemArchitecture);

            System.out.println(" ");
            if (br == "F") {
                System.out.println("Current Browser Selection:Firefox" +"\n");
                //System.setProperty("webdriver.gecko.driver", "src:\\test\\resources\\geckodriver.exe");
                webdriver = new FirefoxDriver();
                webdriver.manage().window().maximize();

            }
            else {
                System.out.println("Current Browser Selection:MS_Egde" + "\n");
                System.setProperty("webdriver.edge.driver","msedgedriver.exe");
                EdgeOptions options = new EdgeOptions();
                options.setPageLoadStrategy("eager");
                // Launch a new Edge instance
                webdriver = new EdgeDriver(options);
                webdriver.manage().window().maximize();
            }
        
            //webdriver.get(request);
        }
        
        else {
        	System.out.println("\n" +"Already have Webdriver instant");
        	System.out.println(" ");
            if (br == "F") {
                System.out.println("Current Browser Selection:Firefox" + "\n");
                webdriver = new FirefoxDriver();
                webdriver.manage().window().maximize();

            }
            else {
                System.out.println("Current Browser Selection:MS_Egde" + "\n");
                System.setProperty("webdriver.edge.driver","msedgedriver.exe");
                EdgeOptions options = new EdgeOptions();
                options.setPageLoadStrategy("eager");
                // Launch a new Edge instance
                webdriver = new EdgeDriver(options);
                webdriver.manage().window().maximize();
            }

        }
        
        webdriver.get(request);
        return webdriver;
    }

    public static void quitDriver() {
        if (null != webdriver) {
            webdriver.quit();
            //webdriver = null;
        }
    }
}
