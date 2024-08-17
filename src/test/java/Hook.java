import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Hook {
    public static WebDriver driver;
    @BeforeTest
    public void startup(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/index.php");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
