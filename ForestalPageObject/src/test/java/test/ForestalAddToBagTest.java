package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ForestalChoosePage;
import page.ForestalHomePage;


public class ForestalAddToBagTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
    }

    @Test
    void openSiryonPageAndChooseParameters(){
        String itemsInBag =
                new ForestalHomePage(driver).openPage()
                        .acceptCookies()
                        .openSiryonPage()
                        .openChoosePage()
                        .chooseParameters()
                        .openBagPage()
                        .numberOfItemsInBag();

        Assert.assertEquals(itemsInBag, "1");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
        driver = null;
    }
}
