package pageobject;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import framework.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class GoogleHomepage extends BasePage {

	@FindBy(name = "q")
	private static WebElement search_input;
					
    public GoogleHomepage(WebDriver driver) throws Exception {
        super(driver);
    
        System.out.print("Here pageobject calls GoogleHomepage" + "\n");
        
    }
    
	public void searhTestinput(String key) {
		Boolean result;
	
		//WebElement search_input = BasePage
		search_input.clear();
		search_input.sendKeys(key);
		search_input.submit();
		System.out.print("Open " + key + " in MS Edge");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(key));
		//Verify Title
		assertEquals(key, key);
		
		
	}
}

