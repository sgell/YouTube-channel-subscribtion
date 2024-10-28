import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class YoutubeChannelSubscription {

    private WebDriver driver;

    @BeforeClass
    private void browser(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("https://www.youtube.com/");
}

    @AfterClass
    private void closeWindow(){
        driver.quit();
    }

    @Test
    private void findAndSubscribeChannel(){
    String expectedTitle = "YouTube";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.findElement(By.cssSelector("#content > div.body.style-scope.ytd-consent-bump-v2-lightbox > div.eom-buttons.style-scope.ytd-consent-bump-v2-lightbox > div:nth-child(1) > ytd-button-renderer:nth-child(1) > yt-button-shape > button > yt-touch-feedback-shape " +
            "> div > div.yt-spec-touch-feedback-shape__fill")).click();
    String actualTitle = driver.getTitle();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    driver.findElement(By.name("search_query")).sendKeys("valentin despa");
    driver.findElement(By.cssSelector("#search-icon-legacy > yt-icon > span > div")).click();
        Assert.assertEquals(actualTitle,expectedTitle);

        driver.findElement(By.linkText("Subscribe")).click();
    }




}
