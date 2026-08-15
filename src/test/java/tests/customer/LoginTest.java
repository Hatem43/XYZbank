package tests.customer;
import base.baseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import customerpages.loginpage;
import utils.ExtentManager;

import java.lang.reflect.Method;

public class LoginTest extends baseTest {

    public loginpage login;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void beforeMethod(Method method) {
        login=new loginpage(page);
        login.navigatetologinpage();
        extent = ExtentManager.getExtent();
        test = extent.createTest(method.getName());
    }
    
    @Test
    public void loginHermoineGranger(){
        String actualmessage1=login.loginasHermoineGranger("Hermoine Granger");
        Assert.assertEquals(actualmessage1,"Hermoine Granger");
    }

    @Test
    public void loginHarrypotter(){
        String actualmessage2=login.loginasHarryPotter("Harry Potter");
        Assert.assertEquals(actualmessage2,"Harry Potter");
    }

    @Test
    public void loginRonWeasly(){
        String actualmessage3=login.loginasRonWeasly("Ron Weasly");
        Assert.assertEquals(actualmessage3,"Ron Weasly");
    }

    @Test
    public void loginAlbusDumbledore(){
        String actualmessage4=login.loginasAlbusDumbledore("Albus Dumbledore");
        Assert.assertEquals(actualmessage4,"Albus Dumbledore");
    }
    @Test
    public void loginNevilleLongbottom(){
        String actualmessage5=login.loginasNevilleLongbottom("Neville Longbottom");
        Assert.assertEquals(actualmessage5,"Neville Longbottom");
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
