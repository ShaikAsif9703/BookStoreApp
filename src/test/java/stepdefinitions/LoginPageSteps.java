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
import pages.LoginPages;
public class LoginPageSteps {
    WebDriver driver;
    WebDriverWait wait;
    LoginPages loginDriver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        loginDriver = new LoginPages(driver);
    }
    @Given("I am in the Bookscape login page")
    public void loginPage(){
        driver.get("https://bookscape.com/login");
    }
    @When("I entered the login details")
    public void loginDetails(){
        loginDriver.input("asif37443@gmail.com");
        loginDriver.nextButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        loginDriver.password("@Asif9703976480");
    }
    @When("I entered into home page")
    public void enteringHomePage(){
        loginDriver.input("asif37443@gmail.com");
        loginDriver.nextButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        loginDriver.password("@Asif9703976480");
        loginDriver.signInButton();
    }
    @And("I click on the sign in button")
    public void clickOnSignIn(){
        loginDriver.signInButton();
    }
    @And("I click on the my account and settings")
    public void setings(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ant-dropdown-trigger hidden lg:block menu_icon_hover']/child::div/child::img[@title='Down arrow']")));
        loginDriver.accountButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@class,'profileDropdown')]")));
        loginDriver.viewProfileButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Change Password']")));
        loginDriver.changePassword1();
    }
    @Then("I was able to login into Bookscape home page")
    public void homePage(){
        String expectedUrl = "https://bookscape.com/login";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,currentUrl,"URL's do not match");
    }

    @Then("I can change the password")
    public void changePassword(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Change Password']")));
        List<WebElement> passwordButtons = driver.findElements(By.xpath("//input[@type='password']"));
        WebElement firstButton = passwordButtons.get(0);
        firstButton.sendKeys("@Asif9703976480");
        WebElement secondButton = passwordButtons.get(1);
        secondButton.sendKeys("@Asif9703976480");
        WebElement thirdButton = passwordButtons.get(2);
        thirdButton.sendKeys("@Asif9703976480");
        List<WebElement> updateButtons = driver.findElements(By.xpath("//button[@type='submit']/child::div[text()='UPDATE PASSWORD']"));
        WebElement updateButton1 = updateButtons.get(0);
        updateButton1.click();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
