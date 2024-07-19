import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.io.FileHandler;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
// import java.util.logging.FileHandler;

public class UploadTest {

    @Test
    public void UploadFile() throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File before = screenshot.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(before, new File("src/test/resources/before.png"));
        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\izama\\Downloads\\Quizz.docx"); // upload pliku
        File after = screenshot.getScreenshotAs(OutputType.FILE); //screenshot z końcówki testu
        FileHandler.copy(after, new File("src/test/resources/after.png")); //screenshot z końcówki testu

        Actions actions = new Actions(driver); // prawy przycisk myszy
        // actions.contextClick().perform(); // prawy przycisk myszy
        actions.contextClick(driver.findElement(By.id("myFile"))).perform();



        // jak uniknąć problemu z napisywaniem screenshotów


//        int randomNumber = (int) (Math.random()*1000);            randomowa liczba jako nazwa pliku
//        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
//        TakesScreenshot screenshot1 = (TakesScreenshot) driver;
//        File before1 = screenshot1.getScreenshotAs(OutputType.FILE);
//        String fileName = "beforeupload" + randomNumber + ".png";
//        FileHandler.copy(before1, new File("src/test/resources/" + fileName));
//        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\izama\\Downloads\\Quizz.docx"); // upload pliku


    }
}