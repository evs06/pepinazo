package ejercicios;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertNotNull;

public class StepDefinitionTodoist {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
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
        //Open the web site
        driver.get("https://todoist.com/es");

        //validate the landing Page
        validateLandingPage();
    }

    @Then("I can see the created project {word} with the {word} and the list projects")
    public void validateCreatedProject(String nombreProyecto, String color) {

        String expectedColor = "color: rgb(";
        switch (color){
            case "Teal":
                expectedColor +="21, 143, 173);";
                break;
            case "Red":
                expectedColor +="219, 64, 53);";
                break;
            case "Grape":
                expectedColor +="175, 56, 235);";
                break;
        }

        List<WebElement> listaProjects = driver.findElements(By.cssSelector(".clickable"));

        for(WebElement projects: listaProjects) {

            String nomProject = projects.getText();

            //#projects_list > li:last-of-type .name > span - último registro de la lista de proyectos
            WebElement listaColores = projects.findElement(By.cssSelector("#projects_list > li > table > tbody > tr > td.td_color > div"));
            String listaColor = listaColores.getAttribute("Style");

            if(nomProject.equals(nombreProyecto) && listaColor.equals(expectedColor)){
                Assert.assertEquals(nomProject, nombreProyecto);
                Assert.assertEquals(listaColor, expectedColor);
                System.out.println("¡Proyecto agregado exitosamente!");
                break;
            }
        }

    }



    @Then("I login with the {word} and {word}")
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

        validateHomePage();

    }

    @And("I can create a new project with the {word} and the {word}")
    public void createNewProject(String nombreProyecto, String color) {

        //Solución °1
        Actions action = new Actions(driver);
        WebElement plusSign = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-track='navigation|projects_quick_add']")));
        //WebElement plusSign = driver.findElement(By.cssSelector("[data-track='navigation|projects_quick_add']"));
        action.moveToElement(plusSign).build().perform();
        plusSign.click();

        //Solución °2
        //WebElement addBtn = driver.findElement(By.cssSelector("[data-track='navigation|projects_quick_add']"));
        //addBtn.click();

        WebElement nameProject = driver.findElement(By.id("edit_project_modal_field_name"));
        nameProject.sendKeys(nombreProyecto);

        WebElement colorProject = driver.findElement(By.cssSelector(".color_dropdown_toggle"));
        colorProject.click();

        List<WebElement> listColors = driver.findElements(By.cssSelector(".color_dropdown_select__name"));

        for(WebElement colors: listColors) {

            String textColor = colors.getText();

            if(textColor.equals(color)){
                colors.click();
                break;
            }
        }

        WebElement btnAdd = driver.findElement(By.cssSelector(".reactist_modal_box__actions > button:last-child"));
        btnAdd.submit();

        //validateCreatedProject(nombreProyecto, color);

    }

    @Then("I can see the Home Page")
    public void validateHomePage() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".left_control > button:last-of-type")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".quick_find__input")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#filter_upcoming")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-track='navigation|projects_panel']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-track='navigation|projects_quick_add']")));

    }

    public void validateLandingPage(){
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[mask*='#logo-wordmark']")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Inicia sesión")));
    }


}