import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

import java.time.Duration;

public class popularpagetest {
    public WebDriver driver;


    @Test(priority = 1)
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @Test(priority = 2)
    public void popularpage() {
        WebElement usernameLink7 = driver.findElement(By.id("usernameInput"));
        usernameLink7.sendKeys("rahul");
        WebElement password7 = driver.findElement(By.id("passwordInput"));
        password7.clear();
        password7.sendKeys("rahul@2021");
        WebElement submitbutton7 = driver.findElement(By.className("login-button"));
        submitbutton7.click();
        WebDriverWait wait7=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait7.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        WebElement homepagelink7= driver.findElement(By.xpath("//a[text()='Home']"));
        homepagelink7.click();
        String actualaurl7="https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait4=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait4.until(ExpectedConditions.urlToBe(actualaurl7));
        String currenturl7=driver.getCurrentUrl();
        if(actualaurl7.equals(currenturl7)){
            System.out.println("navigation to home page");
        }else{
            System.out.println("navigaton failed");
        }
        WebElement popularlink2=driver.findElement(By.xpath("//a[text()='Popular']"));
        popularlink2.click();
        String actualurl8="https://qamoviesapp.ccbp.tech/popular";
        WebDriverWait wait8=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait8.until(ExpectedConditions.urlToBe(actualurl8));
        String expectedurl8= driver.getCurrentUrl();
        if(actualurl8.equals(expectedurl8)){
            System.out.println("navigation to popular page");
        }else{
            System.out.println("naviagtion failed");
        }
        WebDriverWait wait9=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='movie-icon-item']")));

        List<WebElement>movies=driver.findElements(By.xpath("//li[@class='movie-icon-item']"));
        if(movies.size()>0){
            System.out.println("Movies are displayed sucessfully"+movies.size());
        }


    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}