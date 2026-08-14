package adminpages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import customerpages.loginpage;

public class Accountprocess extends loginpage {

    String customer_name="//select[@id='userSelect']";
    String currency_type="//select[@id='currency']";

    public Accountprocess(Page page){
        super(page);
    }

    public void opendollaraccount(String customername,String currencytype){
        Locator openaccountbut=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Open Account"));
        openaccountbut.click();
        Locator customer=page.locator(customer_name);
        customer.selectOption(customername);
        Locator currency=page.locator(currency_type);
        currency.selectOption(currencytype);
        Locator submit=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Process"));
        submit.click();
    }

    public void openpoundaccount(String customername,String currencytype){
        Locator openaccountbut=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Open Account"));
        openaccountbut.click();
        Locator customer=page.locator(customer_name);
        customer.selectOption(customername);
        Locator currency=page.locator(currency_type);
        currency.selectOption(currencytype);
        Locator submit=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Process"));
        submit.click();
    }

    public void openrupeeaccount(String customername,String currencytype){
        Locator openaccountbut=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Open Account"));
        openaccountbut.click();
        Locator customer=page.locator(customer_name);
        customer.selectOption(customername);
        Locator currency=page.locator(currency_type);
        currency.selectOption(currencytype);
        Locator submit=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Process"));
        submit.click();
    }
}
