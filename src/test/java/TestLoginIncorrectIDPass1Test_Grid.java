
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestLoginIncorrectIDPass1Test_Grid {
  private WebDriver driver;

  @BeforeMethod
  public void setUp() throws MalformedURLException {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setBrowserName("chrome");
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\SeleniumGrid\\chromedriver");
    driver = new RemoteWebDriver(new URL("http://192.168.1.13:4444"), caps);
  }
  public void tearDown() {
    driver.quit();
  }
  @Test
  @AfterMethod
  public void testLogin01() throws InterruptedException {
    driver.get("https://www.skullcandy.com");
    driver.findElement(By.className("navUser-action")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("login_email")).click();
    driver.findElement(By.id("login_pass")).sendKeys("Abc12345");
    driver.findElement(By.cssSelector(".form-actions > .button")).click();
    Thread.sleep(1000);
    Assert.assertEquals(driver.findElement(By.className("form-inlineMessage")).getText(),"Please use a valid email address, such as user@example.com.");
  }
}
