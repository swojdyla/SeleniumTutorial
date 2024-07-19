import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionsTest {

    @Test

    public void performAction() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        basicPageLink.click();
//        WebElement kliknijNaMnie = driver.findElement(By.id("clickOnMe"));
//        kliknijNaMnie.click();
//        driver.findElement(By.id("clickOnMe")).click();
        driver.findElement(By.id("fname")).click();
        driver.findElement(By.id("fname")).sendKeys("Sebastian");
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.clear();
        usernameInput.sendKeys("admin");
        System.out.println(usernameInput.getText());
        System.out.println(usernameInput.getAttribute("value")); // pobiera z pola tekstowego
        usernameInput.sendKeys(Keys.ENTER);
        // obsługa alertu
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();
        driver.switchTo().alert().accept();

//      usernameInput.sendKeys(Keys.TAB);

        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        driver.findElement(By.cssSelector("[value='male']")).click();

        // wybór opcji z Selecta
        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCar);
        cars.selectByIndex(2); // index gdzie 0 to pierwsza wartość w select
        cars.selectByVisibleText("Saab");   // tekst
        cars.selectByValue("volvo");    //przez value w CSS

        List<WebElement> options = cars.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        // zadanie
        SelectCheck selectCheck = new SelectCheck();
        System.out.println(selectCheck.checkOption("Audi", selectCar));
        System.out.println(selectCheck.checkOption("Jeep", selectCar));

        // pobranie watrości z ukrytego elementu
        WebElement para = driver.findElement(By.cssSelector(".topSecret"));
        System.out.println("By attritue text content " + para.getAttribute("textContent"));




    }
}
