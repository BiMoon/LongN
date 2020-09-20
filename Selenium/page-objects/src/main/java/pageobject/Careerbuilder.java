package pageobject;
import org.openqa.selenium.WebDriver;
import framework.core.BasePage;
import framework.core.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Careerbuilder extends BasePage{
	@FindBy(linkText = "Sign in") //Login button
	private WebElement login_en;
	
	@FindBy(linkText = "Sign up") //link to open register form
	private WebElement reg_link_en; 
	
	
	@FindBy(linkText = "Đăng nhập") //Login button
	private WebElement login;
	
	@FindBy(linkText = "Đăng ký") //link to open register form
	private WebElement reg_link; 
	
	@FindBy(xpath = "//input[@name='username']") //email as user name
	private WebElement user;
	
	@FindBy(xpath = "//input[@name='password']") // password to login
	private WebElement pass;
	
	@FindBy(xpath = "//button[@type='submit']") // button login
	private WebElement login_bt;
	
	@FindBy(xpath = "//button[@class='btn-gradient']") //register button
	private WebElement reg_bt;
	
	@FindBy(xpath = "//input[@id='firstname']") // fill reg form
	private WebElement fname;
	
	@FindBy(xpath = "//input[@id='lastname']") // fill reg form
	private WebElement lname;
	
	@FindBy(xpath = "//input[@id='email']") // fill reg form
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='password']") // fill reg form
	private WebElement pass_reg;
	
	@FindBy(xpath = "//input[@id='confirm_password']") // fill reg form
	private WebElement pass_confirm;
	
	
	@FindBy(className = "info-box-number") //email as user name
	private WebElement static_empl; //My Employers

	@FindBy(className = "info-box-text") //email as user name
	private WebElement my_empl; //My Employers

	
	
	String fname_send = "lucky";
	String lname_send = "lucky";
	String email_send = "lucky4.com@homeabc.com";
	String pass_send = "123456789";
	
		public Careerbuilder(WebDriver driver) throws Exception {
			
        super(driver);
        
        //PageFactory.initElements(BaseTest.getDriver(driver), this);
        System.out.print("Here pageobject called: Test Careerbuilder Page" + "\n");    }
	
	public Boolean login() {
		Boolean result;
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		wait.until(ExpectedConditions.elementToBeClickable(reg_link));
		
		login.click();
		user.sendKeys(email_send);
		pass.sendKeys(pass_send);
		login_bt.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		try {
			driver.findElement(By.className("hassuser"));
			System.out.print(" đăng nhập thành công" + "\n");
			result = true;
			
		} catch (NoSuchElementException e) {
		    System.out.print("Không thể đăng nhập" + "\n");
		    result = false;		    }

		return result;
	}
	public Boolean login_en() {
		Boolean result;
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		wait.until(ExpectedConditions.elementToBeClickable(reg_link_en));
		
		login_en.click();
		user.sendKeys(email_send);
		pass.sendKeys(pass_send);
		login_bt.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		try {
			driver.findElement(By.className("hassuser"));
			System.out.print(" đăng nhập thành công" + "\n");
			result = true;
			
		} catch (NoSuchElementException e) {
		    System.out.print("Không thể đăng nhập" + "\n");
		    result = false;		    }

		return result;
	}

	public Boolean dashboard_en() throws Exception {
		Boolean result = false, loginOk;
				
		loginOk = login_en();
		
		Thread.sleep(3000);
		
		
		if (loginOk == true)
		{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				System.out.print("Check static of Emple:" + my_empl.getText());
				//static_empl.getText();
				result = true;

		}
		
		return result;
		
	}

	
	public Boolean register() {
		Boolean result; 
		WebElement reg_link = driver.findElement(By.linkText("Đăng ký"));
		WebDriverWait wait = new WebDriverWait(driver, 5, 100);
		wait.until(ExpectedConditions.elementToBeClickable(reg_link));
		reg_link.click();
		fname.sendKeys(fname_send);
		lname.sendKeys(lname_send);
		email.sendKeys(email_send);
		pass_reg.sendKeys(pass_send);
		pass_confirm.sendKeys(pass_send);
		reg_bt.click();
		//verify đăng ký thành công
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			driver.findElement(By.className("hassuser"));
			System.out.print(" đăng ký thành công" + "\n");
			result = true;
			
		} catch (NoSuchElementException e) {
		    System.out.print(email_send +" đã đăng ký" + "\n");
		    result = false;
		    }
		return result;
	}

}
