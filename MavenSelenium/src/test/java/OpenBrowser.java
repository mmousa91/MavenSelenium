import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenBrowser {

   /* public static void main(String[] args) throws InterruptedException {

      //  System.out.println(System.getProperty("user.dir"));
        String Chromepath = System.getProperty("user.dir") + "\\MavenSelenium\\src\\test\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",Chromepath);

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        //driver.findElement(By.name("q")).click();

            driver.findElement(By.id("username")).sendKeys("tomsmith");
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
            driver.findElement(By.className("radius")).click();

       //invalid username and pass
            driver.findElement(By.id("username")).sendKeys("zzzz");
            driver.findElement(By.id("password")).sendKeys("gggg");
            driver.findElement(By.className("radius")).click();



       // driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        //driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

       // driver.findElement(By.linkText("Elemental Selenium")).click();
        Thread.sleep(2000);
        String Successmsg = driver.findElement(By.id("flash")).getText();
        System.out.println(Successmsg);

        Thread.sleep(3000);


        driver.quit();



    }*/

    WebDriver driver = null;

    @BeforeTest
    public void OpenBrowser() throws InterruptedException {
      //  System.out.println(System.getProperty("user.dir"));

        String Chromepath = System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe";

     // System.out.println(Chromepath);

        System.setProperty("webdriver.chrome.driver",Chromepath);

        driver = new ChromeDriver();

//        driver.get("https://the-internet.herokuapp.com/login");
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

      //  Assert.assertEquals(actualResult.contains(expectedResult),true);
        Assert.assertTrue(actualResult.contains(expectedResult),"error plz. try again");

         //second assert
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href=\"/logout\"]")).isDisplayed());

        // third assert
//        String expectedResult2="http://the-internet.herokuapp.com/secure";
//        String actualResult2= driver.getCurrentUrl();
//        Assert.assertTrue(actualResult2.contains(expectedResult2),"some wrong");
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
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
