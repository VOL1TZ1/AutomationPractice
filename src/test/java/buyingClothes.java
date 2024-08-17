import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class buyingClothes extends Hook {

    @Test(priority = 1)
    public void login() {
        WebElement signIN = driver.findElement(Locators.SignInButtonHomePage);
        signIN.click();

        String url = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
        Assert.assertEquals(driver.getCurrentUrl(), url, "there is a differance!!");


        WebElement email = driver.findElement(Locators.EmailTextField);
        email.sendKeys("icemanmods21@gmail.com");

        WebElement password = driver.findElement(Locators.PasswordTextField);
        password.sendKeys("AutomationPractice#2000#");

        WebElement submit = driver.findElement(Locators.SignInButtonSignInPage);
        submit.click();

        WebElement message = driver.findElement(Locators.WelcomeMessage);
        Assert.assertEquals(message.getText(), "Welcome to your account. Here you can manage all of your personal information and orders.");


    }

    @Test(priority = 2)
    public void buyingADress() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement womenButton = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.WomenButtonMainPage));
        Actions actions = new Actions(driver);
        actions.moveToElement(womenButton).perform();

        List<WebElement> summerButton = driver.findElements(Locators.SummerDressesButtonSubMenu);
        summerButton.getFirst().click();

        WebElement secondDressPic = driver.findElement(Locators.SecondDress);
        actions.moveToElement(secondDressPic).perform();

        WebElement moreButton = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.MoreButton));
        moreButton.click();

        WebElement whiteColorButton = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.WhiteButton));
        whiteColorButton.click();

        WebElement dropDownMenu = driver.findElement(Locators.SizeMenu);
        Select selectSize = new Select(dropDownMenu);
        selectSize.selectByVisibleText("M");

        WebElement quantity = driver.findElement(Locators.QuantityValue);
        Assert.assertEquals(quantity.getAttribute("value"), "1");

        WebElement addToCart = driver.findElement(Locators.AddToCart);
        addToCart.click();

        WebElement proceedToCheckout = wait.until(ExpectedConditions.elementToBeClickable(Locators.ProducedToCheckout));
        proceedToCheckout.click();

        WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.PlusButton));
        plusButton.click();

        WebElement counter = driver.findElement(Locators.CheckoutQuantityCounter);
        Assert.assertEquals(counter.getAttribute("size"), "2");



    }

}
