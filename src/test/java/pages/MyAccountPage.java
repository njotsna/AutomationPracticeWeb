package pages;

/**
 * My account page element locators and methods
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseUtil;

public class MyAccountPage extends BaseUtil
{

    private BaseUtil baseUtil;

    public MyAccountPage(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
        PageFactory.initElements(baseUtil.driver, this);
    }

    @FindBy(how = How.XPATH, using=".//*[@id='block_top_menu']//li[3]/a[contains(text(),'T-shirts')]")
    private WebElement tshirtsTab;

    @FindBy(how = How.XPATH, using="//span[contains(text(), 'My personal information')]")
    private WebElement myPersonalInfoButton;



    public TshirtPage clickTshirtsTab()
    {
        tshirtsTab.click();
        return new TshirtPage(baseUtil);

    }

    public PersonalInfoPage clickMyPersonalInfoButton()
    {
        myPersonalInfoButton.click();
        return new PersonalInfoPage(baseUtil);

    }
}
