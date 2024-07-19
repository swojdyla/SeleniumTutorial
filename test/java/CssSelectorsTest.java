import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorsTest {

    @Test
    public void findElements(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By cssId = By.cssSelector("#clickOnMe");
        driver.findElement(cssId);

        By cssClass = By.cssSelector(".topSecret");
        driver.findElement(cssClass);

        By cssTag = By.cssSelector("input");
        driver.findElement(cssTag).sendKeys("Pierwszy");

        By cssName = By.cssSelector("[name='fname']");
        driver.findElement(cssName);

        By cssClass2 = By.cssSelector("[class='topSecret']");
        driver.findElement(cssClass2);


        By all = By.cssSelector("*");
        driver.findElements(all);

        // $$("div ul")
        // $$('tbody tr')
        // $$('tbody > tr') tylko gdy tr jest bezpośrednim dzieckiem tbody

        By ulInsideDiv = By.cssSelector("div ul");
        By trInTable = By.cssSelector("table tr");
        By trInBody = By.cssSelector("tbody tr");

        driver.findElement(ulInsideDiv);
        driver.findElement(trInTable);
        driver.findElement(trInBody);

        By firstChildUinDiv = By.cssSelector("div > ul");
        By firstChildTrInTbody = By.cssSelector("tbody > tr");

        driver.findElement(firstChildUinDiv);
        driver.findElement(firstChildTrInTbody);

        // $$("label + form") pierwszy formularz o tagu label(to nie jest rodzic)
        // $$("label ~ form") zwraca wszystkie formularze po tagu label

        By firsFormAfterLabel = By.cssSelector("label + form");
        By allFormsAfterLabel = By.cssSelector("label ~ form");
        driver.findElement(firsFormAfterLabel);
        driver.findElement(allFormsAfterLabel);

        // $$("input[name='fname']");
        // $$([name*='ame']"); czy zawiera dają frazę

        // $$ ("[name^='fna']") rozpoczyna się konkretną frazą

        // $$ ("[name$='name']") kończy się daną frazą

        By attrTag = By.cssSelector("input[name='fname']");
        By attrContains = By.cssSelector("[name*='name']");
        By attrStarts = By.cssSelector("[name^='f']");
        By attrEnds = By.cssSelector("[name$='name']");

       driver.findElement(attrTag);
       driver.findElement(attrContains);
       driver.findElement(attrStarts);
       driver.findElement(attrEnds);

       // $$("li:first-child")
       // $$("li:last-child")
       // $$("li:nth-child(1)")
        // $$("li:nth-child(2)")

       By firstChild = By.cssSelector("li:first-child");
       By lastChild = By.cssSelector("li:last-child");
       By thirdChild = By.cssSelector("li:nth-child(3)");

        driver.findElement(firstChild);
        driver.findElement(lastChild);
        driver.findElement(thirdChild);

        // $x("/html/body/button")
        // $x("/html/body/table/tbody/tr")  są zwrócone tagi tr z tej konkretnej scieżki

        // $x("//tr") - wszystki tagi tr są zwrócone
        // $x("/html/body/table//tr");





        
    }
}
