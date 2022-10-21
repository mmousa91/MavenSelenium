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
}
