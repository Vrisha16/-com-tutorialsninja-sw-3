package myaccounts;

import com.google.common.base.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyAccountsTest extends BaseTest {
    String baseurl = ("http://tutorialsninja.com/demo/index.php?");
    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        // Open the base URL
        driver.get("http://tutorialsninja.com/demo/index.php?");

        // Click on "My Account" dropdown
        WebElement myAccountDropdown = driver.findElement(By.xpath("//a[contains(@title, 'My Account')]"));
        myAccountDropdown.click();

        // Find all the options within the dropdown
        WebElement myAccountDropdownOptions = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']"));
        Select selectOptions = new Select(myAccountDropdownOptions);
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        // Open the base URL
        driver.get("http://tutorialsninja.com/demo/index.php");

        // Click on "My Account" link
        WebElement myAccountLink = driver.findElement(By.xpath("//a[contains(@title, 'My Account')]"));
        myAccountLink.click();

        // Verify the text "Register Account"
        WebElement registerText = driver.findElement(By.xpath("//h1[contains(text(), 'Register Account')]"));
        Assert.assertEquals(registerText.getText(), "Register Account");
    }
    @Test
public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        // Open the base URL
        driver.get("http://tutorialsninja.com/demo/index.php");

        //2.1 Click on "My Account" link
        WebElement myAccountLink = driver.findElement(By.xpath("//a[contains(@title, 'My Account')]"));
        myAccountLink.click();
       //2.3Verify the text “Returning Customer”
        WebElement registerText = driver.findElement(By.xpath("//h2[contains(text(), 'Returning Customer')]"));
        Assert.assertEquals(registerText.getText(), "Returning Customer");
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
      //3.1 Click on My Account Link.
        WebElement myAccountLink = driver.findElement(By.xpath("//a[contains(@title, 'My Account')]"));
        myAccountLink.click();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        //selectMyAccountOptions("Register");
        //3.3 Enter First Name
        WebElement firstNameField = driver.findElement(By.id("input-firstname"));
        firstNameField.sendKeys("Jay");
        //3.4 Enter Last Name
        WebElement lastNameField = driver.findElement(By.id("input-lastname"));
        lastNameField.sendKeys("Letap");
        //3.5 Enter Email
        WebElement emailField = driver.findElement(By.id("input-email"));
        emailField.sendKeys("utisletap@gmail.com");
        //3.6 Enter Telephone
        WebElement telephonelField = driver.findElement(By.id("input-telephone"));
        emailField.sendKeys("07912345678");
        //3.7 Enter Password
        WebElement passwordlField = driver.findElement(By.id("input-password"));
        emailField.sendKeys(   "Msm_23");
        //3.8 Enter Password Confirm
        WebElement confirmPasswordField = driver.findElement(By.id("input-confirm"));
        confirmPasswordField.sendKeys("Msm_23");
        //3.9 Select Subscribe Yes radio button
        WebElement subscribeYesRadioButton = driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']"));
        subscribeYesRadioButton.click();
        //3.10 Click on Privacy Policy check box
        WebElement privacyPolicyCheckbox = driver.findElement(By.xpath("//input[@name='agree']"));
        privacyPolicyCheckbox.click();
        //3.11 Click on Continue button
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();
        //3.12 Verify the message “Your Account Has Been Created!”
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='content']/h1"));
        Assert.assertEquals(successMessage.getText(), "Your Account Has Been Created!");
        //3.13 Click on Continue button
        continueButton = driver.findElement(By.xpath("//a[contains(text(), 'Continue')]"));
        continueButton.click();
        //3.14 Clickr on My Account Link.
        myAccountLink = driver.findElement(By.xpath("//a[contains(@title, 'My Account')]"));
        myAccountLink.click();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
       //selectMyAccountOption("Logout");
        //3.16 Verify the text “Account Logout”
        WebElement logoutText = driver.findElement(By.xpath("//h1[contains(text(), 'Account Logout')]"));
        Assert.assertEquals(logoutText.getText(),
        //3.17 Click on Continue button
                 WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']")));
      continueButton.click();//try to lot but could not correct 1 error...

    }

@Test
public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
   // 4.1 Clickr on My Account Link.
    WebElement myAccountLink = driver.findElement(By.xpath("//a[contains(@title, 'My Account')]"));
    myAccountLink.click();
    //4.2 Call the method “selectMyAccountOptions” method and pass the parameter login
    selectMyAccountOptions("Login");
    //4.3 Enter Email address
    WebElement emailField = driver.findElement(By.id("input-email"));
    emailField.sendKeys("utisletap@gmail.com");
    //4.4 Enter Last Name
    WebElement lastNameField = driver.findElement(By.id("input-password"));
    lastNameField.sendKeys("Letap");
    //4.5 Enter Password
    WebElement passwordField = driver.findElement(By.id("input-password"));
    passwordField.sendKeys("Msm_23");
    //4.6 Click on Login button
    WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
    loginButton.click();
   // 4.7 Verify text “My Account”
    WebElement myAccountText = driver.findElement(By.xpath("//h2[contains(text(), 'My Account')]"));
    Assert.assertEquals(myAccountText.getText(), "My Account");
    //4.8 Clickr on My Account Link.
    myAccountLink = driver.findElement(By.xpath("//a[contains(@title, 'My Account')]"));
    myAccountLink.click();
    //4.9 Call the method “selectMyAccountOptions” method and pass the parameter logout
    selectMyAccountOptions("Logout");
    //4.10 Verify the text “Account Logout”
    WebElement logoutText = driver.findElement(By.xpath("//h2[contains(text(), 'Account Logout')]"));
    Assert.assertEquals(logoutText.getText(), "Account Logout");
    //4.11 Click on Continue button
    WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
    continueButton.click();
}
  public void selectMyAccountOptions(String option) {
        WebElement myAccountLink = driver.findElement(By.xpath("//a[contains(@title, 'My Account')]"));
        myAccountLink.click();

        WebElement myAccountOptions = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']"));
        WebElement optionToSelect = myAccountOptions.findElement(By.xpath(".//a[text()='" + option + "']"));
        optionToSelect.click();
    }
}













