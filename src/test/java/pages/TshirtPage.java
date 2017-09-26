package pages;
/**
 * Tshirt page element locators and methods
 */

import utilities.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TshirtPage extends BaseUtil
{
    private BaseUtil baseUtil;

    public TshirtPage(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
        PageFactory.initElements(baseUtil.driver, this);
    }


    @FindBy(how = How.XPATH, using=".//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span")
    private WebElement addToCartButton;

    @FindBy(how = How.TAG_NAME, using="h2")
    private WebElement confirmMessage;



    public TshirtPage clickAddToCart()
    {
        Actions action = new Actions(baseUtil.driver);
        WebElement we = baseUtil.driver.findElement(By.xpath(".//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img"));
        action.moveToElement(we).moveToElement(baseUtil.driver.findElement(By.xpath(".//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span"))).click().build().perform();
        return this;
    }

    public String verifyConfirmMessage() throws InterruptedException {
        Thread.sleep(Long.parseLong("2500"));
        return confirmMessage.getText().toLowerCase().trim();
    }


}
