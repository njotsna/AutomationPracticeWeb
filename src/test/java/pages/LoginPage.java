package pages;
/**
 * Login page element locators and methods
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseUtil;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BaseUtil
{
    private BaseUtil baseUtil;

    public LoginPage(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
        PageFactory.initElements(baseUtil.driver, this);
    }

    @FindBy(how = How.XPATH, using="//a[contains(text(), 'Sign in')]")
    private WebElement signIn;

    @FindBy(how = How.ID, using="email")
    private WebElement emailId;

    @FindBy(how = How.ID, using="passwd")
    private WebElement pwd;

    @FindBy(how = How.ID, using="SubmitLogin")
    private WebElement submitButton;


    public MyAccountPage enterCredentialsAndLogin(String userName, String password) throws InterruptedException {
        signIn.click();
        emailId.sendKeys(userName);
        Thread.sleep(Long.parseLong("2500"));
        pwd.sendKeys(password);
        Thread.sleep(Long.parseLong("2500"));
        submitButton.click();
        return new MyAccountPage(baseUtil);


    }

}
