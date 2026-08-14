package tests.customer;
import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import customerpages.loginpage;

public class LoginTest extends baseTest {

    public loginpage login;

    @BeforeMethod
    public void beforeMethod() {
        login=new loginpage(page);
        login.navigatetologinpage();
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

    @AfterSuite
    public void tearDown() {

        if (browser!=null){
            browser.close();
        }

        if (playwright!=null){
            playwright.close();
        }
    }
}
