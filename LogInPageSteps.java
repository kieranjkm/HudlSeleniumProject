package Hudl;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPageSteps {
	
	WebDriver driver = new ChromeDriver();
	String baseUrl = "https://www.hudl.com/login";
	String password = "VolkswagenGolfCP12";
	String email = "kieranmcginley7@gmail.com";
	String incorrectpassword = "Kieran123";
	String incorrectemail = "john567@gmail.com";
	
	
	//Steps to create the tests from
	public void enterEmail() {
		driver.findElement(By.id("email")).isEnabled();
		driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);   	
	}
	
	public void emailCheck() {
		 String enteredemail = driver.findElement(By.id("email")).getAttribute("value");
	     Assert.assertEquals(email, enteredemail );
	}
	
	public void enterIncorrectEmail() {
		driver.findElement(By.id("email")).isEnabled();
		driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(incorrectemail);   	
	}
		
    public void enterPassword() {
   		driver.findElement(By.id("password")).isEnabled();
   		driver.findElement(By.id("password")).sendKeys(password);       	
	}
    
    public void passwordCheck() {
    	String enteredpassword = driver.findElement(By.id("password")).getAttribute("value");
        Assert.assertEquals(password, enteredpassword );
    }
    
    public void enterIncorrectPassword() {
		driver.findElement(By.id("password")).isEnabled();
        driver.findElement(By.id("password")).sendKeys(incorrectpassword);   	
	}
    
    public void checkRememberMe() {
    	driver.findElement(By.className("form__label--custom")).click();
    }
    
    public void selectLogInButton() {
    	 driver.findElement(By.id("logIn")).click();
    }
    
    public void logout() {
    	WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("uni-avatar__content-container")));
        driver.findElement(By.className("uni-avatar__content-container")).click();
        driver.findElement(By.xpath("//a[@href='/logout']")).click();
    }
    
    public void verifySystemRemembersEmail() {
    	WebDriverWait wait = new WebDriverWait(driver, 7);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']")));
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        String rememberMeEmail = driver.findElement(By.id("email")).getAttribute("value");
        Assert.assertEquals(email, rememberMeEmail);
	}
    
    public void fieldsCorrectlyShown() {
    	WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logIn")));
    }
    
    public void loginPageDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(baseUrl, currentUrl );
    }
    
    public void homePageDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hui-globalnav__home-logo")));
    }
    
    public void loginErrorMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-error-container")));
    }
    
    public void openBrowser() {
    	driver.get(baseUrl);
		driver.manage().window().maximize();
    }
    
    public void close() {

	    driver.close();
    }
	
	

}
