import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AccountpageTest {
    public WebDriver driver;
    @Test
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
    }
    @Test(priority = 1)
    public void accountpage(){
        WebElement usernameLinkaccount = driver.findElement(By.id("usernameInput"));
        usernameLinkaccount.sendKeys("rahul");
        WebElement passwordaccount = driver.findElement(By.id("passwordInput"));
        passwordaccount.clear();
        passwordaccount.sendKeys("rahul@2021");
        WebElement submitbuttonaccount = driver.findElement(By.className("login-button"));
        submitbuttonaccount.click();
        WebDriverWait waitaccount=new WebDriverWait(driver, Duration.ofSeconds(10));
        waitaccount.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        WebElement homepagelinkaccount= driver.findElement(By.xpath("//a[text()='Home']"));
        homepagelinkaccount.click();
        String actualaurla="https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait3a=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait3a.until(ExpectedConditions.urlToBe(actualaurla));
        String currenturla=driver.getCurrentUrl();
        if(actualaurla.equals(currenturla)){
            System.out.println("navigation to home page");
        }else{
            System.out.println("navigaton failed");
        }
        WebElement popularlinka=driver.findElement(By.xpath("//a[text()='Popular']"));
        popularlinka.click();
        String actualurl2a="https://qamoviesapp.ccbp.tech/popular";
        WebDriverWait wait4a=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait4a.until(ExpectedConditions.urlToBe(actualurl2a));
        String expectedurla= driver.getCurrentUrl();
        if(actualurl2a.equals(expectedurla)){
            System.out.println("navigation to popular page");
        }else{
            System.out.println("naviagtion failed");
        }
        WebElement accountpagea= driver.findElement(By.className("avatar-button"));
        accountpagea.click();
        String actulLink6a="https://qamoviesapp.ccbp.tech/account";
        WebDriverWait wait5a=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait5a.until(ExpectedConditions.urlToBe(actulLink6a));
        String expectedpagea=driver.getCurrentUrl();
        if(actulLink6a.equals(expectedpagea)){
            System.out.println("navigation to account page");
        }else{
            System.out.println("navigation failed");
        }
        WebElement memberdetails=driver.findElement(By.xpath("//div[@class='membership-container']/child::*"));
        String msg= memberdetails.getText();
        System.out.println(msg);
        WebElement planetails=driver.findElement(By.xpath("//div[@class='plan-container']/child::*"));
        String plan= planetails.getText();
        System.out.println(plan);
        WebElement buttonel=driver.findElement(By.className("logout-button"));
        buttonel.click();


    }

}
