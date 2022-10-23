import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver driver ;
    public LoginPage (WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (id="username")
    WebElement usernamePF;

    public WebElement usernamePom(){
        /*
        By username = By.id("username");
       WebElement usernameEle = driver.findElement(username);
        return usernameEle;
        */

        return driver.findElement(By.id("username"));

    }

    public WebElement PasswordPom(){
//        By Password = By.id("password");
//        WebElement passwordEle =  driver.findElement(Password);
//        return  passwordEle;

        return driver.findElement(By.id("password"));
    }

    public By FlashPom(){

        return  By.id("flash");
    }

    public By LogoutPom(){

        return By.cssSelector("a[href=\"/logout\"]");
    }

    //public void LoginSteps(WebDriver driver,String usename ,String password){

        public void LoginSteps(String usename ,String password){
        //usernamePom().clear();
        usernamePF.clear();
        usernamePom().sendKeys(usename);

        PasswordPom().sendKeys(password);
        PasswordPom().sendKeys(Keys.ENTER);


    }
}
