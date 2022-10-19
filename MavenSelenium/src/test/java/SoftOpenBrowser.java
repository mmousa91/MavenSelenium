import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftOpenBrowser {

        WebDriver driver = null;

        @BeforeTest
        public void OpenBrowser() throws InterruptedException {

            String Chromepath = System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe";

            System.setProperty("webdriver.chrome.driver",Chromepath);

            driver = new ChromeDriver();

            driver.manage().window().maximize();
            Thread.sleep(2000);

        }
        @Test
        public void ValidData() throws InterruptedException {
            driver.get("https://the-internet.herokuapp.com/login");
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys("tomsmith");
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
            driver.findElement(By.className("radius")).click();

            Thread.sleep(2000);

            String expectedResult= "You logged into a secure area!";
            String actualResult =driver.findElement(By.id("flash")).getText();

            SoftAssert Soft = new SoftAssert();
            //  Assert.assertEquals(actualResult.contains(expectedResult),true);
            Soft.assertTrue(actualResult.contains(expectedResult),"1 assert");

            //second assert
            Soft.assertFalse(driver.findElement(By.cssSelector("a[href=\"/logout\"]")).isDisplayed(),"2 assert");

            // third assert

            Soft.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure","3 assert");

            Soft.assertAll();
        }
        //invalid username and pass
        @Test
        public void InvalidData() {
            driver.get("https://the-internet.herokuapp.com/login");
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys("zzzz");
            driver.findElement(By.id("password")).sendKeys("gggg");
            driver.findElement(By.className("radius")).click();

            String expectedResult = "Your username is invalid!";
            String actualResult = driver.findElement(By.id("flash")).getText();

            Assert.assertTrue(actualResult.contains(expectedResult));
        }

        @AfterTest
        public void CloseBrowser() throws InterruptedException {

            Thread.sleep(3000);

            driver.quit();

        }
    }


