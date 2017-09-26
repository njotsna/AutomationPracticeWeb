package pages;
/**
 * Personal info page element locators and methods
 */

import utilities.BaseUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoPage
{
    private BaseUtil baseUtil;

    public PersonalInfoPage(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
        PageFactory.initElements(baseUtil.driver, this);
    }

    @FindBy(how = How.ID, using="firstname")
    private WebElement firstName;

    @FindBy(how = How.NAME, using="submitIdentity")
    private WebElement saveButton;

    @FindBy(how = How.ID, using="old_passwd")
    private WebElement currentPwd;

    @FindBy(how = How.XPATH, using=".//*[@id='center_column']/div/p")
    private WebElement confirmMessage;

    @FindBy(how = How.XPATH, using=".//*[@id='center_column']/ul/li[1]/a/span")
    private WebElement backToAccount;


    public PersonalInfoPage enterFirstName(String firstname)
    {
        firstName.clear();
        firstName.sendKeys(firstname);
        return this;
    }

    public String verifyFirstName()
    {
        return firstName.getAttribute("value").toString();
    }

    public PersonalInfoPage enterCurrentPwd(String password)
    {
        currentPwd.sendKeys(password);
        return this;
    }

    public PersonalInfoPage clickSaveButton()
    {
        saveButton.click();
        return this;
    }

    public String verifyConfirmMessage()
    {
        return confirmMessage.getText();
    }

    public MyAccountPage clickBackToAccount()
    {
        backToAccount.click();
        return new MyAccountPage(baseUtil);
    }
}
