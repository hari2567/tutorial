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
import java.util.List;

public class MoviedetailsPageTest {
    public WebDriver driver;

    @Test
    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

    }
    @Test(priority = 1)
    public void moviesdetails() {
        WebElement usernameLink10 = driver.findElement(By.id("usernameInput"));
        usernameLink10.sendKeys("rahul");
        WebElement password10 = driver.findElement(By.id("passwordInput"));
        password10.clear();
        password10.sendKeys("rahul@2021");
        WebElement submitbutton10 = driver.findElement(By.className("login-button"));
        submitbutton10.click();
        WebDriverWait wait16 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait16.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        WebElement homepagelink10 = driver.findElement(By.xpath("//a[text()='Home']"));
        homepagelink10.click();
        String actualaurl110 = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait17 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait17.until(ExpectedConditions.urlToBe(actualaurl110));
        String currenturl11 = driver.getCurrentUrl();
        if (actualaurl110.equals(currenturl11)) {
            System.out.println("navigation to home page");
        } else {
            System.out.println("navigaton failed");
        }
        WebElement imageurl = driver.findElement(By.xpath("//img[@class='poster']"));
        imageurl.click();
        String url = "https://qamoviesapp.ccbp.tech/movies/92c2cde7-d740-443d-8929-010b46cb0305";
        WebDriverWait wait18 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait18.until(ExpectedConditions.urlToBe(url));
        String currenturl15 = driver.getCurrentUrl();
        Assert.assertEquals(url, currenturl15, "Invvalid");




    }
    @Test(priority = 2)
    public void display(){
        WebElement usernameLinkdisplay = driver.findElement(By.id("usernameInput"));
        usernameLinkdisplay.sendKeys("rahul");
        WebElement passworddispaly = driver.findElement(By.id("passwordInput"));
        passworddispaly.clear();
        passworddispaly.sendKeys("rahul@2021");
        WebElement submitbuttondispaly = driver.findElement(By.className("login-button"));
        submitbuttondispaly.click();
        WebDriverWait waitdispaly = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitdispaly.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        WebElement homepagelinkdispaly = driver.findElement(By.xpath("//a[text()='Home']"));
        homepagelinkdispaly.click();
        String actualaurldispaly = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait waitdispalyl = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitdispalyl.until(ExpectedConditions.urlToBe(actualaurldispaly));
        String currenturldisplsy = driver.getCurrentUrl();
        if (actualaurldispaly.equals(currenturldisplsy)) {
            System.out.println("navigation to home page");
        } else {
            System.out.println("navigaton failed");
        }
        WebElement popularlink3=driver.findElement(By.xpath("//a[text()='Popular']"));
        popularlink3.click();
        String actualurlpopular="https://qamoviesapp.ccbp.tech/popular";
        WebDriverWait waitpopular=new WebDriverWait(driver,Duration.ofSeconds(10));
        waitpopular.until(ExpectedConditions.urlToBe(actualurlpopular));
        String expectedurlpopular= driver.getCurrentUrl();
        if(actualurlpopular.equals(expectedurlpopular)){
            System.out.println("navigation to popular page");
        }else{
            System.out.println("naviagtion failed");
        }
        WebDriverWait waititms=new WebDriverWait(driver,Duration.ofSeconds(10));
        waititms.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='movie-icon-item']")));

        List<WebElement> movies=driver.findElements(By.xpath("//li[@class='movie-icon-item']"));
        if(movies.size()>0){
            System.out.println("Movies are displayed sucessfully"+movies.size());
            WebElement imageugl=driver.findElement(By.xpath("//img[@class='movie-image']"));
            imageugl.click();
            String urldi="https://qamoviesapp.ccbp.tech/movies/320dee56-fdb2-40cf-8df8-92b251bd781f";
            WebDriverWait waituhl=new WebDriverWait(driver,Duration.ofSeconds(10));
            waituhl.until(ExpectedConditions.urlToBe(urldi));

        }else{
            System.out.println("no products found on the page");
        }


    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
