package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

    public static void load(WebDriver driver, WebDriverWait wait){
        WebElement elementSearch = driver.findElement(By.id("home-search-keywords"));
        elementSearch.sendKeys("port");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"top-search\"]/div[1]/div/div[2]/ul/li[2]")));

        WebElement elementDropDown = driver.findElement(By.xpath("//*[@id=\"top-search\"]/div[1]/div/div[2]/ul/li[2]"));
        elementDropDown.click();

        WebElement elementLetsGo = driver.findElement(By.xpath("//*[@id=\"top-search\"]/div[2]/button"));
        elementLetsGo.click();
    }





}
