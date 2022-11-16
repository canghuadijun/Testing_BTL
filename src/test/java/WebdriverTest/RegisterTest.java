package WebdriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegisterTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.skullcandy.com/login.php?action=create_account");
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
    public void testRegister01() throws InterruptedException {
        String originUrl = driver.getCurrentUrl();
        driver.findElement(By.id("FormField_1_input")).sendKeys("12345@vnu.edu.vn");
        driver.findElement(By.id("FormField_2_input")).sendKeys("hello1234");
        driver.findElement(By.id("FormField_3_input")).sendKeys("hello1234");
        driver.findElement(By.id("FormField_4_input")).sendKeys("a");
        driver.findElement(By.id("FormField_4_input")).sendKeys("a");
        driver.findElement(By.id("FormField_5_input")).sendKeys("b");
        driver.findElement(By.id("FormField_6_input")).sendKeys("");
        driver.findElement(By.id("FormField_10_input")).sendKeys("New York");
        Thread.sleep(1000);
        driver.findElement(By.id("FormField_12_select")).sendKeys("New York");
        driver.findElement(By.id("FormField_13_input")).sendKeys("10001");
        driver.findElement(By.id("FormField_8_input")).sendKeys("01");
        driver.findElement(By.id("FormField_7_input")).sendKeys("02");
        driver.findElement(By.cssSelector(".button:nth-child(1)")).click();
        Thread.sleep(10000);
        String nextUrl = driver.getCurrentUrl();
        if (originUrl.equals(nextUrl)) {
            Assert.assertEquals(driver.findElement(By.className("alertBox-message")).getText(), "The email address 12345@vnu.edu.vn is already in use. Please enter a different one.");
        } else
            Assert.assertEquals(driver.findElement(By.className("page-heading")).getText(), "YOUR ACCOUNT HAS BEEN CREATED");
    }

    @Test
    public void testRegister02() throws InterruptedException {
        String originUrl = driver.getCurrentUrl();
        driver.findElement(By.id("FormField_1_input")).sendKeys("20021461@vnu.edu.vn");
        driver.findElement(By.id("FormField_2_input")).sendKeys("hello1234");
        driver.findElement(By.id("FormField_3_input")).sendKeys("hello1234");
        driver.findElement(By.id("FormField_4_input")).sendKeys("a");
        driver.findElement(By.id("FormField_4_input")).sendKeys("a");
        driver.findElement(By.id("FormField_5_input")).sendKeys("b");
        driver.findElement(By.id("FormField_6_input")).sendKeys("");
        driver.findElement(By.id("FormField_10_input")).sendKeys("New York");
        Thread.sleep(1000);
        driver.findElement(By.id("FormField_12_select")).sendKeys("New York");
        driver.findElement(By.id("FormField_13_input")).sendKeys("10001");
        driver.findElement(By.id("FormField_8_input")).sendKeys("01");
        driver.findElement(By.id("FormField_7_input")).sendKeys("02");
        driver.findElement(By.cssSelector(".button:nth-child(1)")).click();
        Thread.sleep(10000);
        String nextUrl = driver.getCurrentUrl();
        if (originUrl.equals(nextUrl)) {
            Assert.assertEquals(driver.findElement(By.className("alertBox-message")).getText(), "The email address 20021461@vnu.edu.vn is already in use. Please enter a different one.");
        } else
            Assert.assertEquals(driver.findElement(By.className("page-heading")).getText(), "YOUR ACCOUNT HAS BEEN CREATED");

    }

    @Test
    public void testRegister03() throws InterruptedException {
        driver.findElement(By.id("FormField_1_input")).sendKeys("20021461@vnu.edu.vn");
        driver.findElement(By.id("FormField_2_input")).sendKeys("hello1234");
        driver.findElement(By.id("FormField_3_input")).sendKeys("hello1234");
        driver.findElement(By.id("FormField_4_input")).sendKeys("a");
        driver.findElement(By.id("FormField_4_input")).sendKeys("a");
        driver.findElement(By.id("FormField_5_input")).sendKeys("");
        driver.findElement(By.id("FormField_6_input")).sendKeys("");
        driver.findElement(By.id("FormField_10_input")).sendKeys("New York");
        Thread.sleep(1000);
        driver.findElement(By.id("FormField_12_select")).sendKeys("New York");
        driver.findElement(By.id("FormField_13_input")).sendKeys("10001");
        driver.findElement(By.id("FormField_8_input")).sendKeys("01");
        driver.findElement(By.id("FormField_7_input")).sendKeys("");
        driver.findElement(By.cssSelector(".button:nth-child(1)")).click();
        Thread.sleep(10000);
        Assert.assertEquals(driver.findElement(By.className("alertBox-message")).getText(), "The 'Last Name' field is required.");
    }
}
