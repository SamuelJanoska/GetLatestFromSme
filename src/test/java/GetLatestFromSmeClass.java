
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.LocalTime;

public class GetLatestFromSmeClass {

    WebDriver driver;

    @Test
    public void main (){


        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");

/*
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--verbose");
        chromeOptions.addArguments("--whitelisted-ips=''");*/

        driver = new ChromeDriver();
        driver.get("https://sme.sk");

        WebElement paneSplit = driver.findElement(By.xpath("//div[contains(@class, 'cf teraz-box teraz-box_sidebar')]"));

        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'cf teraz-box teraz-box_sidebar')]")));


        new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='js-now-box-items-5']/ul/li[1]/div/span[1]/time")));
        WebElement StringFromLeftBox = paneSplit.findElement(By.xpath("//*[@id='js-now-box-items-5']/ul/li[1]/div/span[1]/time"));
        LocalTime TimeFromLeftBox =  LocalTime.parse(StringFromLeftBox.getText()) ;

        WebElement StringFromRightBox = paneSplit.findElement(By.xpath("//*[@id=\"js-now-box-items-6\"]/ul/li[1]/div/span/time"));
        LocalTime TimeFromRightBox =  LocalTime.parse(StringFromRightBox.getText()) ;

        int comparison = TimeFromRightBox.compareTo(TimeFromLeftBox);


        if(comparison>0){
            jsActions(StringFromRightBox);
            System.out.println("Most recent update is from " + TimeFromRightBox + " and is from sportbox. It's been highlighted yellow for you.");
            //js.executeScript("alert('Most recent update is from " + TimeFromRightBox + " and is from sportbox. It has been highlighted yellow for you.')");
            JOptionPane.showMessageDialog(null, "Most recent update is from " + TimeFromRightBox + " and is from sportbox");
        }
        else{
            jsActions(StringFromLeftBox);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            System.out.println("Most recent update is from " + TimeFromLeftBox + " and is from home and world news box. It's been highlighted yellow for you.");
            js.executeScript("alert('Most recent update is from " + TimeFromLeftBox + " and is from world and home news box. It has been highlighted yellow for you.')");
            //JOptionPane.showMessageDialog(null, "Most recent update is from " + TimeFromLeftBox + " and is from home and world news box. It's been highlighted yellow for you.");
        }
    }

    private void jsActions(WebElement stringFromRightBox) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", stringFromRightBox);
        js.executeScript("arguments[0].style.backgroundColor='yellow'", stringFromRightBox);
    }

}
