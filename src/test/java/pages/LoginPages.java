package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPages {
    WebDriver driver;
    WebDriverWait wait;

    By inputLocator = By.xpath("//input[@type='text']");
    By nextButtonLocator = By.xpath("//button[text()='Next']");
    By passwordLocator = By.xpath("//input[@type='password']");
    By signInButtonLocator = By.xpath("//button[text()='SIGN IN']");
    By forgotPasswordButtonLocator = By.xpath("//a[text()='Forgot Password?']");
    By emailInputLocator = By.xpath("//input[@name='email_phone']");
    By sendOtpButtonLocator = By.xpath("//button[text()='SEND OTP']");
    By input0Locator = By.xpath("//input[@id='otp-input-0']");
    By input1Locator = By.xpath("//input[@id='otp-input-1']");
    By input2Locator = By.xpath("//input[@id='otp-input-2']");
    By input3Locator = By.xpath("//input[@id='otp-input-3']");
    By verifyButtonLocator = By.xpath("//button[text()='VERIFY & PROCEED']");
    By changePasswordLocator = By.xpath("//input[@name='password']");
    By reEnterPasswordLocator = By.xpath("//input[@name='password_confirmation']");
    By resetButtonLocator = By.xpath("//button[text()='Reset Password']");
    By accountButtonLocator = By.xpath("//a[@class='ant-dropdown-trigger hidden lg:block menu_icon_hover']/child::div/child::img[@title='Down arrow']");
    By viewProfileLocator = By.xpath("//button[text()='View profile']");
    By changePasswordLocator1 = By.xpath("//div[text()='Change Password']");

    public LoginPages(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void input(String email){
        driver.findElement(inputLocator).sendKeys(email);
    }
    public void nextButton(){
        driver.findElement(nextButtonLocator).click();
    }
    public void password(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public void signInButton(){
        driver.findElement(signInButtonLocator).click();
    }
    public void forgotButton(){
        driver.findElement(forgotPasswordButtonLocator).click();
    }
    public void emailInput(String email){
        driver.findElement(emailInputLocator).sendKeys(email);
    }
    public  void sendOtp(){
        driver.findElement(sendOtpButtonLocator).click();
    }
    public void input1(String input1){
        driver.findElement(input0Locator).sendKeys(input1);
    }
    public void input2(String input2){
        driver.findElement(input1Locator).sendKeys(input2);
    }
    public void input3(String input3){
        driver.findElement(input2Locator).sendKeys(input3);
    }
    public void input4(String input4){
        driver.findElement(input3Locator).sendKeys(input4);
    }
    public void verifyButton(){
        driver.findElement(verifyButtonLocator).click();
    }
    public  void changePassword(String changePassword){
        driver.findElement(changePasswordLocator).sendKeys(changePassword);
    }
    public void reEnterPassword(String reEnterPassword){
        driver.findElement(reEnterPasswordLocator).sendKeys(reEnterPassword);
    }
    public void resetButton(){
        driver.findElement(resetButtonLocator).click();
    }
    public void accountButton(){
        driver.findElement(accountButtonLocator).click();
    }
    public void viewProfileButton(){
        driver.findElement(viewProfileLocator).click();
    }
    public void changePassword1(){
        driver.findElement(changePasswordLocator1).click();
    }
}
