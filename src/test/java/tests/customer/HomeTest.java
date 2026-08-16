package tests.customer;

import base.baseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import customerpages.Homepage;
import customerpages.loginpage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ExtentManager;

import java.lang.reflect.Method;

public class HomeTest extends baseTest {

    Homepage home;
    loginpage login;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void beforeMethod(Method method){
        extent = ExtentManager.getExtent();
        test = extent.createTest(method.getName());
        login=new loginpage(page);
        home=new Homepage(page);
        login.navigatetologinpage();
        login.loginasHermoineGranger("Hermoine Granger");
    }

   @Test(priority = 0)
   public void usernametest(){
        String actaulmessage=home.checkusernameinhomepage();
        Assert.assertEquals(actaulmessage,"Hermoine Granger");
   }

    @Test(priority = 1)
    public void changeaccountest(){
       home.changeaccountnumber(1002);
    }

    @Test(priority = 2)
    public void currencyofdifferentaccounttest(){
        home.viewcurrencyofdifferentaccount("Pound",1002);
    }

    @Test(priority = 3)
    public void balanceofdifferentaccounttest(){
        home.checkbalanceofdifferentaccount(0,1002);
    }

    @AfterMethod
    public void logout(ITestResult result) {
        Locator logoutbutton=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Logout"));
        logoutbutton.click();

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else {
            test.skip("Test Skipped");
        }
        extent.flush();
    }
}
