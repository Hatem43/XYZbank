package tests.admin;

import adminpages.Accountprocess;
import adminpages.customeroptions;
import base.baseTest;
import customerpages.loginpage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class admintest extends baseTest {

    loginpage log;
    customeroptions options;
    Accountprocess account;

    @BeforeMethod
    public void beforeMethod(){
        log=new loginpage(page);
        log.navigatetologinpage();
        log.bankmanagerlogin();
        options=new customeroptions(page);
        account=new Accountprocess(page);


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
}
