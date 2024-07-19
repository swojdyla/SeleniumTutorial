import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitTest {
    WebDriver driver;

    @Test
        public void waitTest() {
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // czeka max 10 sekund
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();
//        Thread.sleep(5000);     // czas czekania na nastepna akcje

//      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        FluentWait <WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
 //       wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p"));

        waitForElementToExist(By.cssSelector("p"));


    }

public void waitForElementToExist(By locator) {
    FluentWait<WebDriver> wait = new FluentWait<>(driver);
    wait.ignoring(NoSuchElementException.class);
    wait.withTimeout(Duration.ofSeconds(10));
    wait.pollingEvery(Duration.ofSeconds(1));


//    wait.until(new Function<WebDriver, Boolean>() {
//        @Override
//        public Boolean apply(WebDriver webDriver) {
//            List<WebElement> elements = driver.findElements(locator);
//            if (elements.size() > 0) {
//                System.out.println("Element jest na stronie");
//                return true;
//            } else {
//                System.out.println("Elementu nie ma");
//                return false;
//            }
//        }
//    });

    wait.until((driver) -> {
            List<WebElement> elements = driver.findElements(locator);
            if (elements.size() > 0) {
                System.out.println("Element jest na stronie");
                return true;
            } else {
                System.out.println("Elementu nie ma");
                return false;
            }

        });

    }

    
}



