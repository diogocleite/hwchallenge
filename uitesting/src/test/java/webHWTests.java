import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.*;

public class webHWTests {

    private static WebDriver driver;

    @BeforeClass
    public static void testsSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @Before
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.get("https://www.hostelworld.com");
    }

    @After
    public void testClose(){
        driver.quit();
    }

    @Test
    public void checkPropertiesListPage() throws InterruptedException {

        driver.manage().window().setSize(new Dimension(768,1024));

        WebElement elementSearch = driver.findElement(By.id("home-search-keywords"));
        elementSearch.sendKeys("port");

        WebDriverWait wait = new WebDriverWait(driver, 2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"top-search\"]/div[1]/div/div[2]/ul/li[2]")));

        WebElement elementDropDown = driver.findElement(By.xpath("//*[@id=\"top-search\"]/div[1]/div/div[2]/ul/li[2]"));
        elementDropDown.click();

        WebElement elementLetsGo = driver.findElement(By.xpath("//*[@id=\"top-search\"]/div[2]/button"));
        elementLetsGo.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"top-search\"]/div/div[2]")));

        WebElement elementCityName = driver.findElement(By.xpath("//*[@id=\"pagebody\"]/div[1]/div[1]/div[2]/div[10]/div[4]/div/div/div/span"));

        //check if the name of the city we search is correct
        assertTrue(elementCityName.getText().contains("PORTO"));

        //check if list have elements with results
        List<WebElement> propertyDivs = driver.findElements(By.className("hwta-property"));
        assertFalse(propertyDivs.isEmpty());
    }

}
