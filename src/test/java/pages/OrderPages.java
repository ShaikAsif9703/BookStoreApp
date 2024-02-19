package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class OrderPages {
    WebDriver driver;
    WebDriverWait wait;

    By inputEmailLocator = By.xpath("//input[@type='text']");
    By nextButtonLocator = By.xpath("//button[text()='Next']");
    By passwordFieldLocator = By.xpath("//input[@type='password']");
    By signInButtonLocator = By.xpath("//button[text()='SIGN IN']");
    By accountButtonLocator = By.xpath("//a[@class='ant-dropdown-trigger hidden lg:block menu_icon_hover']/child::div/child::img[@title='Down arrow']");
    By myOrdersButtonLocator = By.xpath("//span[text()='My Orders']");
    By detailsButtonLocator = By.xpath("//div[@class='flex items-center justify-end w-full h-full xl:hidden']");

    public OrderPages(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    public void login(String email){
        driver.findElement(inputEmailLocator).sendKeys(email);
    }
    public void nextButton(){
        driver.findElement(nextButtonLocator).click();
    }
    public void password(String password){
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }
    public void signIn(){
        driver.findElement(signInButtonLocator).click();
    }
    public void account(){
        driver.findElement(accountButtonLocator).click();
    }
    public void myOrder(){
        driver.findElement(myOrdersButtonLocator).click();
    }
    public void details(){
        driver.findElement(detailsButtonLocator).click();
    }
}
