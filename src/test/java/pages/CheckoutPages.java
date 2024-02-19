package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CheckoutPages {
    WebDriver driver;

    By inputEmailLocator = By.xpath("//input[@type='text']");
    By nextButtonLocator = By.xpath("//button[text()='Next']");
    By passwordLocator = By.xpath("//input[@type='password']");
    By signInButtonLocator = By.xpath("//button[text()='SIGN IN']");
    By firstBookLocator = By.xpath("//img[@alt='Breaking the Mould']");
    By cartButtonLocator = By.xpath("//div[text()='Cart ']");
    By addToCartButtonLocator = By.xpath("//div[@class='flex items-center mt-6 space-x-6 ']/child::button[1]");

    public CheckoutPages(WebDriver driver){
        this.driver = driver;
    }
    public void input(String email){
        driver.findElement(inputEmailLocator).sendKeys(email);
    }
    public void nextButton(){
        driver.findElement(nextButtonLocator).click();
    }
    public void password(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public void signIn(){
        driver.findElement(signInButtonLocator).click();
    }
    public void firstBook(){
        driver.findElement(firstBookLocator).click();
    }
    public void cartButton(){
        driver.findElement(cartButtonLocator).click();
    }
    public void addToCart(){
        driver.findElement(addToCartButtonLocator).click();
    }
}
