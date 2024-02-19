package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import pages.CheckoutPages;
public class checkoutSteps {
    WebDriver driver;
    WebDriverWait wait;
    CheckoutPages checkDriver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        checkDriver = new CheckoutPages(driver);
    }
    @Given("I am on the Bookscape home page")
    public void login(){
        driver.get("https://bookscape.com/login");
        checkDriver.input("asif37443@gmail.com");
        checkDriver.nextButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        checkDriver.password("@Asif9703976480");
        checkDriver.signIn();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Breaking the Mould']")));
    }
    @When("I add a book to cart")
    public void addBook(){
        checkDriver.firstBook();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='569']")));
        checkDriver.addToCart();
    }
    @Then("I should see the details about total price and details")
    public void shippingDetails(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Cart ']")));
        checkDriver.cartButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flex items-center justify-between col-span-12 mt-3 space-x-6']")));
        WebElement text = driver.findElement(By.xpath("//div[@class='flex items-center justify-between col-span-12 mt-3 space-x-6']"));
        System.out.println(text.getText());
    }
    @Then("I should see the details about total price")
    public void totalPrice(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Cart ']")));
        checkDriver.cartButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flex items-center justify-between col-span-12 mt-3 space-x-6']")));
        WebElement totalPrice = driver.findElement(By.xpath("//div[text()='Total order value']/parent::div/child::div[2]"));
        System.out.println(totalPrice.getText());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
