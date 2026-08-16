package customerpages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Homepage extends loginpage{

    String accountnum = "//select[@name='accountSelect']";


    public Homepage(Page page) {
        super(page);
    }

    public String checkusernameinhomepage(){
        Locator welcomemessage=page.getByText("Hermoine Granger", new Page.GetByTextOptions().setExact(true));
        String mssg=welcomemessage.innerText();
        return mssg;
    }

    public int changeaccountnumber(int accountnumber){
        Locator changeaccount = page.locator(accountnum);
        changeaccount.selectOption(String.valueOf(accountnumber));
        Locator currentaccount=page.locator("strong").filter(new Locator.FilterOptions().setHasText("1002"));
        int currentaccountnumber=Integer.parseInt(currentaccount.innerText().trim());
        return  currentaccountnumber;
    }
    public String viewcurrencyofdifferentaccount(String currency,int accountnumber){
        Locator changeaccount = page.locator(accountnum);
        changeaccount.selectOption(String.valueOf(accountnumber));
        Locator curr=page.getByText("Pound", new Page.GetByTextOptions().setExact(true));
        currency=curr.innerText();
        return  currency;
    }
    public int checkbalanceofdifferentaccount(int balance,int accountnumber){
        Locator changeaccount = page.locator(accountnum);
        changeaccount.selectOption(String.valueOf(accountnumber));
        Locator bal=page.getByText("0", new Page.GetByTextOptions().setExact(true));
        balance=Integer.parseInt(bal.innerText());
        return  balance;
    }
}
