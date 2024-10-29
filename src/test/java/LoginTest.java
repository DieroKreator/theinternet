import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        assertEquals("Login Page",
                driver.findElement(By.cssSelector("h2")).getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void logarComSucesso() {

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("button.radius"));

        usernameField.sendKeys("tomsmith");
        passwordField.sendKeys("SuperSecretPassword!");
        loginBtn.click();

        assertEquals("You logged into a secure area!\n" + //
                "×", driver.findElement(By.id("flash")).getText());
    }

    @Test
    public void logarCamposEmBranco() {

        WebElement loginBtn = driver.findElement(By.cssSelector("button.radius"));
        loginBtn.click();

        assertEquals("Your username is invalid!\n" + //
                        "×", driver.findElement(By.id("flash")).getText());
    }

    @Test
    public void logarUsuarioValidoSenhaEmBranco() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement loginBtn = driver.findElement(By.cssSelector("button.radius"));

        usernameField.sendKeys("tomsmith");
        loginBtn.click();

        assertEquals("Your password is invalid!\n" + //
                        "×", driver.findElement(By.id("flash")).getText());
    }

    @Test
    public void logarUsuarioInvalidoSenhaEmBranco() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement loginBtn = driver.findElement(By.cssSelector("button.radius"));

        usernameField.sendKeys("haskhflkafakjl");
        loginBtn.click();

        assertEquals("Your username is invalid!\n" + //
                        "×", driver.findElement(By.id("flash")).getText());
    }

    @Test
    public void logarUsuarioEmBrancoSenhaValida() {
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("button.radius"));

        passwordField.sendKeys("SuperSecretPassword!");
        loginBtn.click();

        assertEquals("Your username is invalid!\n" + //
                        "×", driver.findElement(By.id("flash")).getText());
    }

    @Test
    public void logarUsuarioEmBrancoSenhaInvalida() {
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("button.radius"));

        passwordField.sendKeys("!dwidjiiwjdiwj");
        loginBtn.click();

        assertEquals("Your username is invalid!\n" + //
                        "×", driver.findElement(By.id("flash")).getText());
    }

    @Test
    public void logarUsuarioInvalidoSenhaValida() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("button.radius"));

        usernameField.sendKeys("tomsmsjhdjsdhith");
        passwordField.sendKeys("SuperSecretPassword!");
        loginBtn.click();

        assertEquals("Your username is invalid!\n" + //
                        "×", driver.findElement(By.id("flash")).getText());
    }

    @Test
    public void logarUsuarioValidoSenhaInvalida() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("button.radius"));

        usernameField.sendKeys("tomsmith");
        passwordField.sendKeys("jdhdhhd!");
        loginBtn.click();

        assertEquals("Your password is invalid!\n" + //
                        "×", driver.findElement(By.id("flash")).getText());
    }

    @Test
    public void logarDadosInvalidos() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("button.radius"));

        usernameField.sendKeys("tomsm0s98f98ith");
        passwordField.sendKeys("jdhdhhd!");
        loginBtn.click();

        assertEquals("Your username is invalid!\n" + //
                        "×", driver.findElement(By.id("flash")).getText());
    }
}
