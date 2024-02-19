package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;
import pages.BookPages;
public class BooksPageSteps {
    WebDriver driver;
    WebDriverWait wait;
    BookPages bookDriver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        bookDriver = new BookPages(driver);
    }
    @Given("I am in Bookscape home page")
    public void homePage(){
        driver.get("https://bookscape.com/login");
        bookDriver.inputEl("asif37443@gmail.com");
        bookDriver.nextButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        bookDriver.passwordLocate("@Asif9703976480");
        bookDriver.signIn();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Trending Categories']")));
    }
    @When("I click on a book")
    public void book(){
        bookDriver.image();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='569']")));
    }
    @When("I click the search button")
    public void search(){
        List<WebElement> searchInputs = driver.findElements(By.xpath("//input[@name='searchInput']"));
        WebElement firstInput = searchInputs.get(0);
        firstInput.sendKeys("APJ Abdul Kalam");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Jeevani : Mahatma Gandhi Aur APJ Abdul Kalam जीवनी : महात्मा गांधी और ए पी जे अब्दुल कलाम']")));
    }
    @And("I enter a book name or author name")
    public void authorName(){
        WebElement viewButton = driver.findElement(By.xpath("//div[@class='ant-modal-content']/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[2]/child::div"));
        viewButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Showing results for ']")));
    }
    @Then("I should see some list of books")
    public void books(){
        bookDriver.booksDisplayed();
    }
    @Then("I will get the price and author name")
    public void priceAndNameOfAuthor(){
        bookDriver.price();
        bookDriver.author();
    }
    @Then("I will get the required books")
    public void requiredBooks(){
        List<WebElement> books = driver.findElements(By.xpath("//div[@class='xl:relative undefined']"));
        System.out.println(books.size());
        if(books.size() > 0){
            System.out.println("Books are displayed " + books.size());
        }else{
            System.out.println("Books are not displayed " + books.size());
        }
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
