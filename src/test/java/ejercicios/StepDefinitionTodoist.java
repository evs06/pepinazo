package ejercicios;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertNotNull;

public class StepDefinitionTodoist {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    @After
    public void tearDownTest() {
        driver.quit();
    }

    @Given("I have to open the browser")
    public void openBrowser() {
        assertNotNull(driver);
    }

    @When("I open the todoist website")
    public void openTodoist() {
        driver.get("https://todoist.com/es");
    }

    @When("I login with the {word} and {word}")
    public void loginTodoist(String username, String password) {

        WebElement loginLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Inicia sesión")));
        loginLink.click();

        WebElement userLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        userLogin.clear();
        userLogin.sendKeys(username);

        WebElement psdLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        psdLogin.clear();
        psdLogin.sendKeys(password);

        WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".submit_btn")));
        loginBtn.click();

    }

    @Then("I can see the Home Page")
    public void validateHomePage(){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".left_control > button:last-of-type")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".quick_find__input")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#filter_upcoming")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-track='navigation|projects_panel']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-track='navigation|projects_quick_add']")));

    }










    @When("I log into todoist with valid credentials")
    public void validateCredentials(){
        //instrucciones de selenium
    }

    @When ("I log into todoist with Facebook account")
    public void loginFacebook(){

    }

    @Then("I should see the home page")
    public void homePageValidate(){
        //instrucciones de selenium
    }


    @And("The list of projects will be visible")
    public void listaProjectValidate(){
        //instrucciones de selenium
    }

}