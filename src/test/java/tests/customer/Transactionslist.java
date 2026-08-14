package tests.customer;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import customerpages.loginpage;
import customerpages.transactionspage;

public class Transactionslist extends baseTest {

    loginpage login;
    transactionspage transaction;

    @BeforeMethod
    public void setupemethod(){
      login=new loginpage(page);
      login.navigatetologinpage();
      transaction=new transactionspage(page);
    }

    @Test
    public void transactiontesthermoinegranger(){
        login.loginasHermoineGranger("Hermoine Granger");
        String url=transaction.viewtransactions();
        Assert.assertEquals(url,"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/listTx");
        boolean fon= transaction.transactionslist("Hermoine Granger");
        Assert.assertEquals(fon,true);
    }

    @Test
    public void transactiontestHarryPotter(){
        login.loginasHarryPotter("Harry Potter");
        String url=transaction.viewtransactions();
        Assert.assertEquals(url,"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/listTx");
        boolean fon= transaction.transactionslist("Harry Potter");
        Assert.assertEquals(fon,false);
}
    @Test
    public void transactiontestRonWeasly(){
        login.loginasRonWeasly("Ron Weasly");
        String url=transaction.viewtransactions();
        Assert.assertEquals(url,"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/listTx");
        boolean fon= transaction.transactionslist("Ron Weasly");
        Assert.assertEquals(fon,false);
    }
    @Test
    public void transactionAlbusDumbledore(){
        login.loginasRonWeasly("Albus Dumbledore");
        String url=transaction.viewtransactions();
        Assert.assertEquals(url,"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/listTx");
        boolean fon= transaction.transactionslist("Albus Dumbledore");
        Assert.assertEquals(fon,false);
    }
    @Test
    public void transactionNevilleLongbottom(){
        login.loginasRonWeasly("Neville Longbottom");
        String url=transaction.viewtransactions();
        Assert.assertEquals(url,"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/listTx");
        boolean fon= transaction.transactionslist("Neville Longbottom");
        Assert.assertEquals(fon,false);
    }


    @Test
    public void tranactionusingermoinegrangeranddifferentaccountnumber(){
        login.loginasHermoineGranger("Hermoine Granger");
        boolean actual= transaction.changeAccountnumber(1002);
        Assert.assertTrue(actual);
    }



    @Test(priority = 7)
    public void testresttransaction(){
        login.loginasHermoineGranger("Hermoine Granger");
        transaction.viewtransactions();
        transaction.transactionslist("Hermoine Granger");
        boolean actual=transaction.resttransactions("Hermoine Granger");
        Assert.assertTrue(actual);
    }

}
