import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XpathTest {

    @Test
    public void findElements() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        //clickOnMe
        By buttonId = By.xpath("//button[@id='clickOnMe']");
        WebElement clickOnMeButton = driver.findElement(buttonId);

        //fname
        By firstName = By.xpath("//input[@name='fname']");
        WebElement firstNameInput = driver.findElement(firstName);
        //WebElement firstNameInput2 = driver.findElement(By.name("fname"));
        //driver.findElement(By.name("fname"));

        //TopSecret
        By paraHidden = By.xpath("//p[@class='topSecret']");
        driver.findElement(paraHidden);

        By inputLocator = By.xpath("//input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("Pierwszy");
        List<WebElement> inputs = driver.findElements(inputLocator); //znalazienie wszystkich elementow
        System.out.println(inputs.size());


        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']");
        WebElement schoolLink = driver.findElement(linkText);

        By partialLink = By.xpath("//a[contains(text(),'Visit')]");
        WebElement parLin = driver.findElement(partialLink);

        // XPATH

        By fullPath = By.xpath("/html/body/div/ul");
        driver.findElement(fullPath);

        By shortPath = By.xpath("//ul");
        driver.findElement(shortPath);

        // $x("//*")
        // $x("(//input)[1]")
        // $x("(//input)[last()]")
        // $x("//*[@name]") wszystkie elementy z atrybutem name
        // $x("//*[@id]")
        // $x("(//button[@id])[1]")
        // $x("(//button[@id]")

        By allXpath = By.xpath("//*");
        driver.findElement(allXpath);

        By secondElement = By.xpath("(//input)[2]");
        driver.findElement(secondElement);

        By lastElement = By.xpath("(//input)[last()]");
        driver.findElement(lastElement);

        By elementWithAttribute = By.xpath("//*[@name]");
        driver.findElement(elementWithAttribute);

        // $x("//*[@id!='clickOnMe']")
        // $x("//*[contains(@name, 'ame')]")
        // $x("//*[starts-with(@name, 'user')]")
        // $x("//*[substring(@name,string-length(@name)-string-length('ame'+1)='ame']")

        By attrEq = By.xpath("//button[@id='clickOnMe']");
        By attrNoEq = By.xpath("//*[@id!='clickOnMe']");
        By attrCont = By.xpath("//*[contains(@name,'ame')]");
        By startsWith = By.xpath("//*[starts-with(@name, 'user')]");
        By endsWith = By.xpath("//*[ends-with(@name, 'user')]");

        driver.findElement(attrEq);
        driver.findElement(attrNoEq);
        driver.findElement(attrCont);
        driver.findElement(startsWith);
       // driver.findElement(endsWith); raczej nie dziala

        // $x("//div/descendant::ul")
        // $x("//div/descendant::*") zwraca wszystkie dzieci
        // $x("//div/ancestor::*") zwraca wszystkich rodziców/wnuków
        // $x("//div/../..")
        // $x("//div/..") zwraca bezprośredniego rodzica
        // $x("//img/following::*")
        // $x("//img/following-sibling::*)
        // $x("//img/preceding::*")
        // $x("//img/preceding-sibling::*")

        By child = By.xpath("//div/child::ul");
        By desc = By.xpath("//div/descendant::ul");
        By parnet = By.xpath("//div/../..");
        By asc = By.xpath("//div/ancestor::*");
        By foll = By.xpath("//img/following::*");
        By follSib = By.xpath("//img/following-sibling::*");
        By prec = By.xpath("//img/preceding::*");
        By precSib = By.xpath("//img/preceding-sibling::*");

        driver.findElement(child);
        driver.findElement(desc);
        driver.findElement(parnet);
        driver.findElement(asc);
        driver.findElement(foll);
        driver.findElement(follSib);
        driver.findElement(prec);
        driver.findElement(precSib);

        // ("//a | //input") suma dwóch selektorów
        // ("//a | //div//a")
        // ("//input[@name='fname']")
        // $x("//input[@name='fname' and @id='fname']" oba warunki muszą być spełnione
        // $x("//input[@name='fname' or @id='fname'] jeden warunek wystarczy by spełniał

        By divsAndLinks = By.xpath("//a | //input");
        By andOp = By.xpath("//input[@name='fname' and @id='fname']");
        By orOp = By.xpath("//input[@name='fname' or @id='fname']");

        driver.findElement(divsAndLinks);
        driver.findElement(andOp);
        driver.findElement(orOp);






    }
}
