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
import org.testng.Assert;

import java.time.Duration;
import pages.OrderPages;
public class OrderPageSteps {
    WebDriver driver;
    WebDriverWait wait;
    OrderPages orderDriver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        orderDriver = new OrderPages(driver);
    }
    @Given("I am on Bookscape home page")
    public void home(){
        driver.get("https://bookscape.com/login");
        orderDriver.login("asif37443@gmail.com");
        orderDriver.nextButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        orderDriver.password("@Asif9703976480");
        orderDriver.signIn();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Breaking the Mould']")));
    }
    @When("I click on account button and click on order button")
    public void accountButton(){
        orderDriver.account();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Orders']")));
        orderDriver.myOrder();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orderStatus Cancelled']")));
    }
    @Then("I want to see the orders")
    public void orders(){
        WebElement orderStatus = driver.findElement(By.xpath("//div[@class='orderStatus Cancelled']"));
        Assert.assertTrue(orderStatus.isDisplayed(),"Not Displayed");
    }
    @Then("I can get the order details")
    public void orderDetails(){
        orderDriver.details();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-collapse-item ant-collapse-item-active pt-3 ssOrderStatus']")));
        WebElement details = driver.findElement(By.xpath("//div[@class='ant-collapse-item ant-collapse-item-active pt-3 ssOrderStatus']"));
        System.out.println(details.getText());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
