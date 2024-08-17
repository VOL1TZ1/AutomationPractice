import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class BuyingShirt {
    WebDriver driver;
    @BeforeTest
    public void startup(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/index.php");
    }
    @Test(priority = 1)
    public void login() throws InterruptedException {
        WebElement signIN=driver.findElement(Locators.SignInButtonHomePage);
        signIN.click();

        String url= "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
        Assert.assertEquals(driver.getCurrentUrl(),url,"there is a differance!!");

        WebElement email=driver.findElement(Locators.EmailTextField);
        email.sendKeys("icemanmods21@gmail.com");

        WebElement password=driver.findElement(Locators.PasswordTextField);
        password.sendKeys("AutomationPractice#2000#");

        WebElement submit =driver.findElement(Locators.SignInButtonSignInPage);
        submit.click();

        WebElement message =driver.findElement(Locators.WelcomeMessage);
        Assert.assertEquals(message.getText(),"Welcome to your account. Here you can manage all of your personal information and orders.");
        Thread.sleep(Duration.ofSeconds(5));
//        WebElement home =driver.findElement(Locators.HomeButtonSignInPage);
//        home.click();

    }
    @Test(priority = 2)
    public void buyingShirt() throws InterruptedException {
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));





        WebElement womenButton= driver.findElement(Locators.WomenButtonMainPage);
        Actions actions =new Actions(driver);
        actions.moveToElement(womenButton).perform();

        WebElement t_shirtButton =wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.TshirtButtonSubMenu));
        t_shirtButton.click();

        Thread.sleep(Duration.ofSeconds(5));



    }
    @AfterTest
    public void tearDown(){
        driver.quit();

    }
}
