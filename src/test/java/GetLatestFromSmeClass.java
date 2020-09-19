
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetLatestFromSmeClass {

    WebDriver driver;

    @Test
    public void lenTak(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = newChromeDriver();
    }

    @Test
    public void main (String[] args){


        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = newChromeDriver();

    }

}
