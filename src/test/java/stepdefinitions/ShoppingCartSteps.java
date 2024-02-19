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
import pages.shoppingPages;
public class ShoppingCartSteps {
    WebDriver driver;
    WebDriverWait wait;
    shoppingPages shoppingDriver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        shoppingDriver = new shoppingPages(driver);
    }
    @Given("I am in the Bookscape home page")
    public void homePage(){
        driver.get("https://bookscape.com/login");
        shoppingDriver.input("asif37443@gmail.com");
        shoppingDriver.nextButton();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        shoppingDriver.password("@Asif9703976480");
        shoppingDriver.signIn();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Breaking the Mould']")));
    }
    @When("I click on the first book")
    public void clickOnBook(){
        shoppingDriver.firstBook();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='569']")));
    }
    @When("I click on the my cart")
    public void cartAccount(){
        shoppingDriver.cartButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='items-end']/preceding-sibling::div")));
    }
    @Then("I should be able to see the books in the cart")
    public void addBooksToCart(){
       shoppingDriver.addToCart();
    }
    @Then("I should see the items and total price")
    public void itemsAndPrice(){
        WebElement items = driver.findElement(By.xpath("//div[@class='items-end']/preceding-sibling::div"));
        System.out.println(items.getText());
        WebElement totalPrice = driver.findElement(By.xpath("//button[text()='PROCEED TO PAYMENT ']/parent::div/preceding-sibling::div/child::div[2]"));
        System.out.println(totalPrice.getText());
    }
    @Then("I remove the item from cart")
    public void removeItem(){
        List<WebElement> removeButton = driver.findElements(By.xpath("//button[@class='rounded-md font-manrope tracking-[0.75px] justify-center items-center w-6 xl:w-7 h-6 xl:h-7 flex border !border-neutral-300 text-[32px] text-neutral-800 !border-primary-default ']"));
        WebElement first = removeButton.get(0);
        first.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Remove item ']")));
        WebElement removeButton1 = driver.findElement(By.xpath("//button[text()='REMOVE']"));
        removeButton1.click();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
