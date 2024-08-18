import org.openqa.selenium.By;

public class Locators {
    //Home Page
    public static By SignInButtonHomePage =By.className("login");
    public static By WomenButtonMainPage = By.className("sf-with-ul");
    public static By SummerDressesButtonSubMenu = By.cssSelector("a[title='Summer Dresses']");

    //Login Page
    public static By EmailTextField = By.id("email");
    public static By PasswordTextField = By.id("passwd");
    public static By SignInButtonSignInPage = By.id("SubmitLogin");
    public static By WelcomeMessage = By.className("info-account");

    //Summer Dresses Page
    public static By SecondDress = By.cssSelector("a[href='http://www.automationpractice.pl/index.php?id_product=6&controller=product']");
    public static By MoreButton = By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a/span");

    //Product Page
    public static By WhiteButton =By.cssSelector("a[title='White']");
    public static By SizeMenu = By.id("group_1");
    public static By QuantityValue = By.id("quantity_wanted");
    public static By AddToCart = By.name("Submit");
    public static By ProducedToCheckout = By.cssSelector("a.btn.btn-default.button.button-medium");

    //Checkout Page
    public static By PlusButton = By.cssSelector("span > i.icon-plus");
    //public static By CheckoutQuantityCounter=By.name("quantity_6_41_0_0");
    public static By CheckoutQuantityCounter=By.className("cart_quantity_input");



}
