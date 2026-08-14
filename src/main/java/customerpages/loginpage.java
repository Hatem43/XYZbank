package customerpages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class loginpage {

    public Page page;
    public String cutomername="//select[@name='userSelect']";
    public String welcomemessage="//span[@class='fontBig ng-binding']";


    public loginpage(Page page) {
        this.page = page;
    }

    public void navigatetologinpage() {

        page.navigate("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    public String loginasHermoineGranger(String username1){
        Locator customerlogin=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Customer Login"));
        customerlogin.click();
        Locator customer=page.locator(cutomername);
        customer.selectOption(username1);
        Locator loginbutton=page.getByText("Login", new Page.GetByTextOptions().setExact(true));
        loginbutton.click();
        Locator customerwelcomemessage=page.locator(welcomemessage);
        String message1=customerwelcomemessage.innerText();
        return message1;
    }
    public String loginasHarryPotter(String username2){
        Locator customerlogin=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Customer Login"));
        customerlogin.click();
        Locator customer=page.locator(cutomername);
        customer.selectOption(username2);
        Locator loginbutton=page.getByText("Login", new Page.GetByTextOptions().setExact(true));
        loginbutton.click();
        Locator customerwelcomemessage=page.locator(welcomemessage);
        String message2=customerwelcomemessage.innerText();
        return message2;
    }
    public String loginasRonWeasly(String username3){
        Locator customerlogin=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Customer Login"));
        customerlogin.click();
        Locator customer=page.locator(cutomername);
        customer.selectOption(username3);
        Locator loginbutton=page.getByText("Login", new Page.GetByTextOptions().setExact(true));
        loginbutton.click();
        Locator customerwelcomemessage=page.locator(welcomemessage);
        String message3=customerwelcomemessage.innerText();
        return message3;
    }
    public String loginasAlbusDumbledore(String username4){
        Locator customerlogin=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Customer Login"));
        customerlogin.click();
        Locator customer=page.locator(cutomername);
        customer.selectOption(username4);
        Locator loginbutton=page.getByText("Login", new Page.GetByTextOptions().setExact(true));
        loginbutton.click();
        Locator customerwelcomemessage=page.locator(welcomemessage);
        String message4=customerwelcomemessage.innerText();
        return message4;
    }
    public String loginasNevilleLongbottom(String username4){
        Locator customerlogin=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Customer Login"));
        customerlogin.click();
        Locator customer=page.locator(cutomername);
        customer.selectOption(username4);
        Locator loginbutton=page.getByText("Login", new Page.GetByTextOptions().setExact(true));
        loginbutton.click();
        Locator customerwelcomemessage=page.locator(welcomemessage);
        String message5=customerwelcomemessage.innerText();
        return message5;
    }

    public String bankmanagerlogin(){
        Locator managerlogin=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Bank Manager Login"));
        managerlogin.click();
        String actual=page.url();
        return actual;
    }
}
