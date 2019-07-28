package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultPage {

    public static void waitForLoad(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"top-search\"]/div/div[2]")));
    }

    public static WebElement getCityName(WebDriver driver){
        WebElement elementCityName = driver.findElement(By.xpath("//*[@id=\"pagebody\"]/div[1]/div[1]/div[2]/div[10]/div[4]/div/div/div/span"));
        return elementCityName;
    }

    public static List<WebElement> findProperties(WebDriver driver){
        List<WebElement> propertyDivs = driver.findElements(By.className("hwta-property"));
        return propertyDivs;
    }
}
