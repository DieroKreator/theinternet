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
    }

    @Test
    public void logarCamposEmBranco() {
        
    }

    @Test
    public void logarUsuarioValidoSenhaEmBranco() {
        
    }

    @Test
    public void logarUsuarioInvalidoSenhaEmBranco() {
        
    }

    @Test
    public void logarUsuarioEmBrancoSenhaValida() {
        
    }

    @Test
    public void logarUsuarioEmBrancoSenhaInvalida() {
        
    }

    @Test
    public void logarUsuarioInvalidoSenhaValida() {
        
    }

    @Test
    public void logarUsuarioValidoSenhaInvalida() {
        
    }

    @Test
    public void logarDadosInvalidos() {
        
    }
}
