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
import  java.util.List;

public class SearchTest {
    public WebDriver driver;

    @Test
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @Test(priority = 1)
    public void searchtpage() {
        WebElement usernameLink9 = driver.findElement(By.id("usernameInput"));
        usernameLink9.sendKeys("rahul");
        WebElement password9 = driver.findElement(By.id("passwordInput"));
        password9.clear();
        password9.sendKeys("rahul@2021");
        WebElement submitbutton9 = driver.findElement(By.className("login-button"));
        submitbutton9.click();
        WebDriverWait wait9=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait9.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        WebElement homepagelink9= driver.findElement(By.xpath("//a[text()='Home']"));
        homepagelink9.click();
        String actualaurl9="https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait10=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait10.until(ExpectedConditions.urlToBe(actualaurl9));
        String currenturl9=driver.getCurrentUrl();
        if(actualaurl9.equals(currenturl9)){
            System.out.println("navigation to home page");
        }else{
            System.out.println("navigaton failed");
        }
        WebElement popularlink9=driver.findElement(By.xpath("//a[text()='Popular']"));
        popularlink9.click();
        String actualurl9="https://qamoviesapp.ccbp.tech/popular";
        WebDriverWait wait11=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait11.until(ExpectedConditions.urlToBe(actualurl9));
        String expectedurl9= driver.getCurrentUrl();
        if(actualurl9.equals(expectedurl9)){
            System.out.println("navigation to popular page");
        }else{
            System.out.println("naviagtion failed");
        }
        WebElement searchbutton=driver.findElement(By.className("search-empty-button"));
        searchbutton.click();
        String actualurl10="https://qamoviesapp.ccbp.tech/search";
        WebDriverWait wait12=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait12.until(ExpectedConditions.urlToBe(actualurl10));
        String expectedurl10= driver.getCurrentUrl();
        if(actualurl10.equals(expectedurl10)){
            System.out.println("navigation to search page");
        }else{
            System.out.println("navigation failed");
        }

        WebElement Searchlink11=driver.findElement(By.id("search"));
        Searchlink11.sendKeys("venom");



    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

