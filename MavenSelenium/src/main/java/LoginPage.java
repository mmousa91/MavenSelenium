import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebElement usernamePom(WebDriver driver){
        By username = By.id("username");
        WebElement usernameEle = driver.findElement(username);
        return usernameEle;

    }

    public WebElement PasswordPom(WebDriver driver){
//        By Password = By.id("password");
//        WebElement passwordEle =  driver.findElement(Password);
//        return  passwordEle;

        return  driver.findElement(By.id("password"));
    }

    public By FlashPom(){

        return  By.id("flash");
    }

    public By LogoutPom(){

        return By.cssSelector("a[href=\"/logout\"]");
    }

    public void LoginSteps(WebDriver driver,String usename ,String password){
        usernamePom(driver).clear();
        usernamePom(driver).sendKeys(usename);

        PasswordPom(driver).sendKeys(password);
        findElement(By.className("radius")).click();


    }
}
