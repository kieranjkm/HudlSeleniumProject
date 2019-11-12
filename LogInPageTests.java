package Hudl;


import org.junit.jupiter.api.Test;
public class LogInPageTests extends LogInPageSteps {
	
	//Test to see user is opening correct login page
	@Test
	public void UserCanOpenLogInPage() {
		openBrowser();
		loginPageDisplayed();
		close();
	}

	//Test to see user is seeing the correct fields to be able to log into the system
	@Test
	public void VerifyLoginPageHasCorrectFields() {
		openBrowser();
		fieldsCorrectlyShown();
		close();
	}
	
	//Test to see if the user can enter a email into the email field
	@Test
	public void VerifyUserCanEnterEmail() {
		openBrowser();
		enterEmail();
        emailCheck();
        close();
	}
	
	//Test to see if the user can enter a password into the email field
	@Test
	public void VerifyUserCanEnterPassword() {
		openBrowser();
		enterPassword();
        passwordCheck();
        close();
	}
	
	//Test to see if the user can log into the system 
	@Test
	public void VerifyUserCanLogIn() {
		openBrowser();
		enterEmail();
		enterPassword();
		selectLogInButton();
        homePageDisplayed();
        close();
	}
	
	//Test to see if user cannot log in with an incorrect email
	@Test
	public void UserCannotLogInWithIncorrectEmail() {
		openBrowser();
		enterIncorrectEmail();
		enterPassword();
		selectLogInButton();
		loginErrorMessageDisplayed();
		close();
	}
	
	//Test to see if user cannot log in with an incorrect password
	@Test
	public void UserCannotLogInWithIncorrectPassword() {
		openBrowser();
		enterEmail();
		enterIncorrectPassword();
		selectLogInButton();
		loginErrorMessageDisplayed();
		close();
	}
	
	//Test to see if the system remembers the users email when remember me is selected
	@Test
	public void SystemSavesEmailWhenRememberMeSelected() {
		openBrowser();
		enterEmail();
		enterPassword();
        checkRememberMe();
        selectLogInButton();
        logout();
        verifySystemRemembersEmail(); 
        close();
	}
}

	






