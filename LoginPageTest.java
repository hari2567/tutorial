import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest {
    public WebDriver driver;
    @Test(priority = 1)
    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        WebElement imageurl=driver.findElement(By.className("login-website-logo"));
        boolean isdisplayed= imageurl.isDisplayed();
        System.out.println(isdisplayed);

        WebElement headingurl= driver.findElement(By.className("sign-in-heading"));
        boolean isdisplayed2= headingurl.isDisplayed();
        System.out.println(isdisplayed2);
        WebElement usernameLink=driver.findElement(By.xpath("//label[text()='USERNAME']"));
        boolean isdispayed3= usernameLink.isDisplayed();
        System.out.println(isdispayed3);
        WebElement passwordLnk=driver.findElement(By.xpath("//label[text()='PASSWORD']"));
        boolean isdisplayed4=passwordLnk.isDisplayed();
        System.out.println(isdisplayed4);
        WebElement submitbutton=driver.findElement(By.className("login-button"));
        submitbutton.click();

            
        }
        @Test(priority=2)
    public void Loginwithempty(){
        WebElement submitlnk2=driver.findElement(By.className("login-button"));
        submitlnk2.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        WebElement errormessage=driver.findElement(By.className("error-message"));
        String actualmessage="*Username or password is invalid";
        String expectedmessage= errormessage.getText();
        Assert.assertEquals(actualmessage,expectedmessage,"Invalid");

        }
        @Test(priority=3)
        public void Loginusername(){
        WebElement usernameLink2=driver.findElement(By.id("usernameInput"));
        usernameLink2.sendKeys("rahul");
        WebElement submitbutton2=driver.findElement(By.className("login-button"));
        submitbutton2.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        WebElement errormessage2= driver.findElement(By.className("error-message"));
        String actuallink="*Username or password is invalid";
        String expectedLink= errormessage2.getText();
        Assert.assertEquals(actuallink,expectedLink,"invalid");
        }
        @Test(priority = 4)
        public void Loginpassword(){
            WebElement usernameLink3=driver.findElement(By.id("usernameInput"));
            usernameLink3.clear();
            WebElement password=driver.findElement(By.id("passwordInput"));
            password.sendKeys("rahul@2021");
            WebElement submitbutton3=driver.findElement(By.className("login-button"));
            submitbutton3.click();
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
            WebElement errormessage3= driver.findElement(By.className("error-message"));
            String actuallink3="*Username or password is invalid";
            String expectedLink2= errormessage3.getText();
            Assert.assertEquals(actuallink3,expectedLink2,"invalid");


        }
        @Test(priority = 5)
        public void Lognwithvalidnput(){
            WebElement usernameLink4=driver.findElement(By.id("usernameInput"));
            usernameLink4.sendKeys("rahul");
            WebElement password3=driver.findElement(By.id("passwordInput"));
            password3.clear();
            password3.sendKeys("rahul@2021");
            WebElement submitbutton4=driver.findElement(By.className("login-button"));
            submitbutton4.click();


        }
        @AfterMethod
    public  void teardown(){
        driver.quit();

    }
}
