package tests.customer;
import base.baseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import customerpages.Depositandwithdrawl;
import customerpages.loginpage;
import utils.ExtentManager;

import java.lang.reflect.Method;


public class depositeandwithdrawltest extends baseTest {

    loginpage logintest;
    Depositandwithdrawl deposittest;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void loginsetup(Method method){
        logintest=new loginpage(page);
        logintest.navigatetologinpage();
        deposittest=new Depositandwithdrawl(page);
        extent = ExtentManager.getExtent();
        test = extent.createTest(method.getName());
    }

    @Test
    public void depositTest(){
        logintest.loginasHermoineGranger("Hermoine Granger");
        int actualamount=deposittest.adddeposite(200);
        Assert.assertEquals(actualamount,5296);
    }

    @Test
    public void emptydepositTest(){
        logintest.loginasHermoineGranger("Hermoine Granger");
        String actualmessage=deposittest.emptydepositeamount();
        System.out.println("the actual message is " +actualmessage);
        Assert.assertEquals(actualmessage,"Please fill out this field.");
    }

    @Test
    public void withdrawlTest(){
        logintest.loginasHermoineGranger("Hermoine Granger");
        int actualamount=deposittest.withdrawl(200);
        Assert.assertEquals(actualamount,5096);
    }

    @Test
    public void emptywithdrawlTest(){
        logintest.loginasHermoineGranger("Hermoine Granger");
        String actualmessage=deposittest.setWithdrawlempty();
        System.out.println("the actual message is " +actualmessage);
        Assert.assertEquals(actualmessage,"Please fill out this field.");
    }


    @Test
    public void adddepositwithdifferentcutsomer(){
           logintest.loginasHarryPotter("Harry Potter");
           int actualbalance=deposittest.adddepositetoharrpoter("Harry Potter",200);
           Assert.assertEquals(actualbalance,200);
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
