package com.vytrack.pages;


import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //LOGINPAGE DE LOGIN PAGEIN LOCATORLARINI BULUYORUM.TEST CLASSINDA BU SAYFADAN OBJECT OLUSTURMAM YETERLI OLUYOR.

    @FindBy(id = "prependedInput")
    private WebElement username;
     //they not supposed to be access directly in your test.Thats why publicten private cevirdi.
    // Test should call just the methods.
    // public WebElement username2 = Driver.getDriver().findElement(By.id("prependedInput"));

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;
//WebDriver driver = Driver.getDriver();

    public LoginPage() {
        //to connect our webdriver, page class and page factory
        //PageFactory - used to use @FindBy annotations
        //PageFactory - helps to find elements easier
        PageFactory.initElements(Driver.getDriver(), this);
        //PageFactory.initElements(driver, this);
    }

    public String getWarningMessageText() {
        return warningMessage.getText();
    }

    /**
     * Method to login, version #1
     * Login as a specific user
     * @param usernameValue
     * @param passwordValue
     */
    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    /**
     * Method to login, version #2
     * Login as a default user
     * Credentials will be retrieved from configuration.properties file
     */
    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
    }
//Which want  to use based on your test scenarios. IF you dont care about how to login as whom as what kind of user
   // then use method to login version 2 ---> login as a spesific user
    //if scenario says login as driver defibitely use version 1--> login as default user

}