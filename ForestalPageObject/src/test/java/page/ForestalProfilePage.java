package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForestalProfilePage extends AbstractPage{
    @FindBy(xpath = "//*[text()=\"Hello, John \"]")
    private WebElement hello;

    public ForestalProfilePage(WebDriver driver) {
        super(driver);
    }

    public String helloText() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(hello));
        return hello.getText();
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
