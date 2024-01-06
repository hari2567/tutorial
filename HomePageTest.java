import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomePageTest {
    public WebDriver driver;

    @Test(priority = 1)
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

    }

    @Test(priority = 2)
    public void Loginnput() {
        WebElement usernameLink5 = driver.findElement(By.id("usernameInput"));
        usernameLink5.sendKeys("rahul");
        WebElement password4 = driver.findElement(By.id("passwordInput"));
        password4.clear();
        password4.sendKeys("rahul@2021");
        WebElement submitbutton5 = driver.findElement(By.className("login-button"));
        submitbutton5.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        WebElement websitelink=driver.findElement(By.className("website-logo"));
        boolean isdisplayed= websitelink.isDisplayed();
        System.out.println(isdisplayed);
        List<WebElement>navbarelements=driver.findElements(By.xpath("//li[@class='list-item']"));
        if (navbarelements.size()==2){
            System.out.println("2 items found");
        }else {
            System.out.println("Mismatch");
        }


    }
    @Test(priority = 3)
    public void Headersection(){
        WebElement usernameLink6 = driver.findElement(By.id("usernameInput"));
        usernameLink6.sendKeys("rahul");
        WebElement password5 = driver.findElement(By.id("passwordInput"));
        password5.clear();
        password5.sendKeys("rahul@2021");
        WebElement submitbutton6 = driver.findElement(By.className("login-button"));
        submitbutton6.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        WebElement homepagelink= driver.findElement(By.xpath("//a[text()='Home']"));
        homepagelink.click();
        String actualaurl="https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait3=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.urlToBe(actualaurl));
        String currenturl=driver.getCurrentUrl();
        if(actualaurl.equals(currenturl)){
            System.out.println("navigation to home page");
        }else{
            System.out.println("navigaton failed");
        }
        WebElement popularlink=driver.findElement(By.xpath("//a[text()='Popular']"));
        popularlink.click();
        String actualurl2="https://qamoviesapp.ccbp.tech/popular";
        WebDriverWait wait4=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait4.until(ExpectedConditions.urlToBe(actualurl2));
        String expectedurl= driver.getCurrentUrl();
        if(actualurl2.equals(expectedurl)){
            System.out.println("navigation to popular page");
        }else{
            System.out.println("naviagtion failed");
        }
        WebElement accountpage= driver.findElement(By.className("avatar-button"));
        accountpage.click();
        String actulLink6="https://qamoviesapp.ccbp.tech/account";
        WebDriverWait wait5=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait5.until(ExpectedConditions.urlToBe(actulLink6));
        String expectedpage=driver.getCurrentUrl();
        if(actulLink6.equals(expectedpage)){
            System.out.println("navigation to account page");
        }else{
            System.out.println("navigation failed");
        }

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}