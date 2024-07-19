import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {

    @Test
    public void findElements() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        //clickOnMe
        By buttonId = By.id("clickOnMe");
        WebElement clickOnMeButton = driver.findElement(buttonId);

        //fname
        By firstName = By.name("fname");
        WebElement firstNameInput = driver.findElement(firstName);
        WebElement firstNameInput2 = driver.findElement(By.name("fname"));
        driver.findElement(By.name("fname"));

        //TopSecret
        By paraHidden = By.className("topSecret");
        driver.findElement(paraHidden);

        By inputLocator = By.tagName("input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("Pierwszy");
        List<WebElement> inputs = driver.findElements(inputLocator); //znalazienie wszystkich elementow
        System.out.println(inputs.size());


        By linkText = By.linkText("Visit W3Schools.com!");
        WebElement schoolLink = driver.findElement(linkText);

        By partialLink = By.partialLinkText("Visit");
        WebElement parLin = driver.findElement(partialLink);

    }
}
