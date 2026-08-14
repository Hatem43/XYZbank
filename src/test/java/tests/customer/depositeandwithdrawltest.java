package tests.customer;
import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import customerpages.Depositandwithdrawl;
import customerpages.loginpage;

public class depositeandwithdrawltest extends baseTest {

    loginpage logintest;
    Depositandwithdrawl deposittest;

    @BeforeMethod
    public void loginsetup(){
        logintest=new loginpage(page);
        logintest.navigatetologinpage();
        logintest.loginasHermoineGranger("Hermoine Granger");
        deposittest=new Depositandwithdrawl(page);
    }


    @Test
    public void depositTest(){
        int actualamount=deposittest.adddeposite(200);
        Assert.assertEquals(actualamount,5296);
    }

    @Test
    public void emptydepositTest(){
        String actualmessage=deposittest.emptydepositeamount();
        System.out.println("the actual message is " +actualmessage);
        Assert.assertEquals(actualmessage,"Please fill out this field.");
    }

    @Test
    public void withdrawlTest(){
        int actualamount=deposittest.withdrawl(200);
        Assert.assertEquals(actualamount,5096);
    }

    @Test
    public void emptywithdrawlTest(){
        String actualmessage=deposittest.setWithdrawlempty();
        System.out.println("the actual message is " +actualmessage);
        Assert.assertEquals(actualmessage,"Please fill out this field.");
    }
}
