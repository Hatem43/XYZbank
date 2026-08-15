package tests.admin;

import adminpages.Accountprocess;
import adminpages.customeroptions;
import base.baseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import customerpages.loginpage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ExtentManager;

import java.lang.reflect.Method;

public class admintest extends baseTest {

    loginpage log;
    customeroptions options;
    Accountprocess account;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void beforeMethod(Method method){
        log=new loginpage(page);
        log.navigatetologinpage();
        log.bankmanagerlogin();
        options=new customeroptions(page);
        account=new Accountprocess(page);
        extent = ExtentManager.getExtent();
        test = extent.createTest(method.getName());


    }
    @Test(priority = 1)
    public void viewcustomersdata(){
        int actual_count=options.viewcustomers();
        Assert.assertEquals(actual_count,6);
    }


    @Test(priority = 0)
    public void addcustomerTest(){
        options.addcustomer("Hatem","Mamdouh","12345");
        boolean checkcustomer= options.checkcustomeraddition("Hatem");
        Assert.assertTrue(checkcustomer);
    }


    @Test(priority = 2)
    public void deleteaddedcustomerTest(){

        options.checkdeletingcustomer();
    }


    @Test(priority = 3)
    public void opencustomerdollaraccounttest(){

        account.opendollaraccount("Hermoine Granger","Dollar");
    }

    @Test(priority = 4)
    public void openpoundaccounttest(){

        account.openpoundaccount("Hermoine Granger","Pound");
    }

    @Test(priority = 5)
    public void openrupeeaccounttest(){

        account.openrupeeaccount("Hermoine Granger","Rupee");
    }

    @AfterMethod
    public void logout(ITestResult result) {

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
