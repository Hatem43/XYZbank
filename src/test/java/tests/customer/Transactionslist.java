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
import customerpages.loginpage;
import customerpages.transactionspage;
import utils.ExtentManager;

import java.lang.reflect.Method;

public class Transactionslist extends baseTest {

    loginpage login;
    transactionspage transaction;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void setupemethod(Method method){
      login=new loginpage(page);
      login.navigatetologinpage();
      transaction=new transactionspage(page);
      extent = ExtentManager.getExtent();
      test = extent.createTest(method.getName());
    }

    @Test(priority = 1)
    public void transactiontesthermoinegranger(){
        login.loginasHermoineGranger("Hermoine Granger");
        String url=transaction.viewtransactions();
        Assert.assertEquals(url,"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/listTx");
        boolean fon= transaction.transactionslist("Hermoine Granger");
        Assert.assertEquals(fon,true);
    }

    @Test(priority = 2)
    public void transactiontestHarryPotter(){
        login.loginasHarryPotter("Harry Potter");
        String url=transaction.viewtransactions();
        Assert.assertEquals(url,"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/listTx");
        boolean fon= transaction.transactionslist("Harry Potter");
        Assert.assertEquals(fon,false);
}
    @Test(priority = 3)
    public void transactiontestRonWeasly(){
        login.loginasRonWeasly("Ron Weasly");
        String url=transaction.viewtransactions();
        Assert.assertEquals(url,"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/listTx");
        boolean fon= transaction.transactionslist("Ron Weasly");
        Assert.assertEquals(fon,false);
    }
    @Test(priority = 4)
    public void transactionAlbusDumbledore(){
        login.loginasRonWeasly("Albus Dumbledore");
        String url=transaction.viewtransactions();
        Assert.assertEquals(url,"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/listTx");
        boolean fon= transaction.transactionslist("Albus Dumbledore");
        Assert.assertEquals(fon,false);
    }
    @Test(priority = 5)
    public void transactionNevilleLongbottom(){
        login.loginasRonWeasly("Neville Longbottom");
        String url=transaction.viewtransactions();
        Assert.assertEquals(url,"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/listTx");
        boolean fon= transaction.transactionslist("Neville Longbottom");
        Assert.assertEquals(fon,false);
    }


    @Test(priority = 6)
    public void tranactionusingermoinegrangeranddifferentaccountnumber(){
        login.loginasHermoineGranger("Hermoine Granger");
        boolean actual= transaction.checktransactionafterchangingAccountnumber(1002);
        Assert.assertTrue(actual);
    }

    @Test(priority = 7)
    public void testresttransaction(){
        login.loginasHermoineGranger("Hermoine Granger");
        transaction.viewtransactions();
        boolean actual=transaction.resttransactions();
        Assert.assertTrue(actual);
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
