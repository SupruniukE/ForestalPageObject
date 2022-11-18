package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForestalHomePage extends AbstractPage{
    private static final String HOMEPAGE_URL = "https://forestal.com/en/home";

    @FindBy(xpath = "//*[text()=\"Accept all cookies\"]")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/header/div/nav[1]/ul/li[4]/a")
    private WebElement siryonButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/header/div/nav[2]/ul/li[2]/a")
    private WebElement loginButton;

    public ForestalHomePage(WebDriver driver) {
        super(driver);
    }

    public ForestalHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public ForestalHomePage acceptCookies() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.elementToBeClickable(acceptCookiesButton))
                .click();
        return this;
    }

    public ForestalSiryonPage openSiryonPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(siryonButton)).click();
        return new ForestalSiryonPage(driver);
    }

    public ForestalLoginPage openLoginPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(loginButton)).click();
        return new ForestalLoginPage(driver);
    }
}
