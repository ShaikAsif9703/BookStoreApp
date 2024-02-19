package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Duration;

public class BookPages {
    WebDriver driver;
    WebDriverWait wait;

    By inputElLocator = By.xpath("//input[@type='text']");
    By nextButtonLocator = By.xpath("//button[text()='Next']");
    By passwordFieldLocator = By.xpath("//input[@type='password']");
    By signInButtonLocator = By.xpath("//button[text()='SIGN IN']");
    By imageLocator = By.xpath("//img[@alt='Breaking the Mould']");
    By booksLocator = By.xpath("//h2[text()='Trending Categories']");
    By priceLocator = By.xpath("//span[text()='569']");
    By authorNameLocator = By.xpath("//div[text()='Raghuram Rajan, Rohit Lamba']");

    public BookPages(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void inputEl(String email){
        driver.findElement(inputElLocator).sendKeys(email);
    }
    public void nextButton(){
        driver.findElement(nextButtonLocator).click();
    }
    public void passwordLocate(String password){
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }
    public void signIn(){
        driver.findElement(signInButtonLocator).click();
    }
    public void image(){
        driver.findElement(imageLocator).click();
    }
    public void booksDisplayed(){
        WebElement number = driver.findElement(booksLocator);
        Assert.assertTrue(number.isDisplayed(),"Not Displayed");
        return;
    }
    public void price(){
        WebElement price = driver.findElement(priceLocator);
        String bookPrice = price.getText();
        return;
    }
    public void author(){
        WebElement authorName = driver.findElement(authorNameLocator);
        String name = authorName.getText();
        return;
    }
}
