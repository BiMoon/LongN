package pageobject;
import org.openqa.selenium.WebDriver;
import framework.core.BasePage;

public class GoogleHomepage extends BasePage {
	
    public GoogleHomepage(WebDriver driver) throws Exception {
        super(driver);
      
        System.out.print("Here pageobject calls GoogleHomepage" + "\n");
        
    }
    
}

