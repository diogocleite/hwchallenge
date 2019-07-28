package ui;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Homepage;
import pages.SearchResultPage;

import java.util.List;

import static org.junit.Assert.*;

public class WebHWTests {

    private static WebDriver driver;

    @BeforeClass
    public static void beginTests() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @Before
    public void beginTest() {
        driver = new ChromeDriver();
        driver.get("https://www.hostelworld.com");
    }

    @After
    public void endTest(){
        driver.quit();
    }

    @Test
    public void checkPropertiesListPage() throws InterruptedException {

        driver.manage().window().setSize(new Dimension(768,1024));
        WebDriverWait wait = new WebDriverWait(driver, 2000);

        //search for city porto
        Homepage.load(driver,wait);

        //wait for the results
        SearchResultPage.waitForLoad(wait);

        //get the city name in the results page
        WebElement elementCityName = SearchResultPage.getCityName(driver);

        //check if the name of the city we search is correct
        assertTrue(elementCityName.getText().contains("PORTO"));

        //check if list have elements with results
        List<WebElement> propertyDivs = SearchResultPage.findProperties(driver);
        assertFalse(propertyDivs.isEmpty());
    }

}
