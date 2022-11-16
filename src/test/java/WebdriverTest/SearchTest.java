package WebdriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;

public class SearchTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.skullcandy.com/");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void refresh() {
        driver.navigate().refresh();
    }

    @Test
    public void testSearch01() throws InterruptedException {
        String originUrl = driver.getCurrentUrl();
        driver.findElement(By.cssSelector(".navUser-action--quickSearch use")).click();
        driver.findElement(By.id("search_query_desktop")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        String nextUrl = driver.getCurrentUrl();
        Assert.assertEquals(originUrl,nextUrl);
    }

    @Test
    public void testSearch02() throws InterruptedException {
        String originUrl = driver.getCurrentUrl();
        driver.findElement(By.cssSelector(".navUser-action--quickSearch use")).click();
        driver.findElement(By.id("search_query_desktop")).sendKeys("headphone" + Keys.ENTER);
        Thread.sleep(10000);
        String nextUrl = driver.getCurrentUrl();
        if(!nextUrl.equals(originUrl)) {
            Assert.assertEquals(driver.findElement(By.className("page-heading")).getText(), "SEARCH RESULTS FOR 'HEADPHONE'");
        } else Assert.assertEquals(0,1);
    }
}
