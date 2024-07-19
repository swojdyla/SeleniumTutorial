import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
// import java.util.logging.FileHandler;

public class ActionsTest {

    @Test
    public void actionTest() throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");
        Actions actions = new Actions(driver); // prawy przycisk myszy
        actions.contextClick().perform(); // prawy przycisk myszy
        // actions.contextClick(driver.findElement(By.id("myFile"))).perform();

        WebElement button = driver.findElement(By.id("bottom"));
        actions.doubleClick(button).perform();

    }
}