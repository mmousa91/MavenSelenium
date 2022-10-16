import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void OpenBrowser()
    {
      //  System.out.println(System.getProperty("user.dir"));

        String Chromepath = System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe";

     // System.out.println(Chromepath);

        System.setProperty("webdriver.chrome.driver",Chromepath);

        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
    }
    @Test
    public void ValidData() {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
    }
    //invalid username and pass
    @Test
    public void InvalidData() {
        driver.findElement(By.id("username")).sendKeys("zzzz");
        driver.findElement(By.id("password")).sendKeys("gggg");
        driver.findElement(By.className("radius")).click();
    }

    @AfterTest
    public void CloseBrowser() throws InterruptedException {

        Thread.sleep(3000);

        driver.quit();

    }
}
