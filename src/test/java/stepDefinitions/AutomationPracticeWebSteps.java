package stepDefinitions;
/**
 * This class contains all steps for automation practice web feature scenarios
 */

import pages.LoginPage;
import pages.MyAccountPage;
import pages.PersonalInfoPage;
import pages.TshirtPage;
import utilities.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;


public class AutomationPracticeWebSteps extends BaseUtil{

    protected String baseUrl = "http://automationpractice.com/index.php";
    private BaseUtil baseUtil;

    public AutomationPracticeWebSteps(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }

    @Given("^I navigate to AutomationPractice website$")
    public void iNavigateToAutomationPracticeWebsite() throws Throwable {
        baseUtil.driver.get(baseUrl);
        String pageTitle = baseUtil.driver.getTitle();
        Assert.assertEquals("User not landed on correct page","My Store", pageTitle);
    }

    @And("^I login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iLoginWithAnd(String username, String password) throws Throwable
    {
        LoginPage page = new LoginPage(baseUtil);

        page.enterCredentialsAndLogin(username, password);
        String myAccountPage = baseUtil.driver.findElement(By.tagName("h1")).getText().toLowerCase();
        Assert.assertEquals("User not landed on correct page","my account", myAccountPage);

    }

    @When("^I navigate to Tshirt page$")
    public void iNavigateToTshirtPage()
    {
        MyAccountPage myAccountpage = new MyAccountPage(baseUtil);
        myAccountpage.clickTshirtsTab();
        String tshirtPage = baseUtil.driver.findElement(By.xpath("//h1/span[contains(text(),'T-shirts')]"))
                .getText().toLowerCase().trim();
        Assert.assertEquals("User not landed on correct page","t-shirts", tshirtPage);
    }

    @And("^I add tshirt to cart$")
    public void iAddTshirtToCart()
    {
        TshirtPage tshirtPage = new TshirtPage(baseUtil);
        tshirtPage.clickAddToCart();
    }

    @Then("^I verify item exist in order history$")
    public void iVerifyItemExistInOrderHistory() throws InterruptedException {
        TshirtPage tshirtPage = new TshirtPage(baseUtil);
        String confirmMessage = tshirtPage.verifyConfirmMessage();
        Assert.assertEquals("Product not added to cart",
                "product successfully added to your shopping cart", confirmMessage);

    }

    @And("^I update my \"([^\"]*)\" in my account with same \"([^\"]*)\"$")
    public void iUpdateMyInMyAccountWithSame(String firstname, String password)
    {
        PersonalInfoPage infoPage = new PersonalInfoPage(baseUtil);
        infoPage.enterFirstName(firstname)
                .enterCurrentPwd(password)
                .clickSaveButton();
        String confirmMessage = infoPage.verifyConfirmMessage().toLowerCase();
        Assert.assertEquals("no message displayed",
                "your personal information has been successfully updated.", confirmMessage);

    }


    @Then("^I verify \"([^\"]*)\" field is updated$")
    public void iVerifyFieldIsUpdated(String firstName)
    {
        PersonalInfoPage infoPage = new PersonalInfoPage(baseUtil);
        infoPage.clickBackToAccount().clickMyPersonalInfoButton();
        String updatedFirstName = infoPage.verifyFirstName().toLowerCase().trim();
        Assert.assertEquals("no message displayed",
                firstName.toLowerCase().trim(), updatedFirstName);

    }

    @When("^I click on my personal information button$")
    public void iClickOnMyPersonalInformationButton()
    {
        MyAccountPage myAccountpage = new MyAccountPage(baseUtil);
        myAccountpage.clickMyPersonalInfoButton();

    }

}
