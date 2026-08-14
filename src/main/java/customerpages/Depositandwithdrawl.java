package customerpages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class Depositandwithdrawl extends loginpage{

    String depositnutton="//button[@type='submit']";
    String withdrawbutton="//button[normalize-space()='Withdraw']";


    public Depositandwithdrawl(Page page){
        super(page);
    }

    public int adddeposite(int amount){
        Locator balance=page.locator("//div[@class='center']//strong[2]");
        int currentbalance=Integer.parseInt(balance.innerText());
        System.out.println("pervious balance is "+currentbalance);
        Locator deposit=page.getByText("Deposit", new Page.GetByTextOptions().setExact(true));
        deposit.click();
        Locator depositeamount=page.getByPlaceholder("amount");
        depositeamount.fill(String.valueOf(amount));
        Locator depositaction=page.locator(depositnutton);
        depositaction.click();
        Locator depositesuccessmssg=page.getByText("Deposit Successful", new Page.GetByTextOptions().setExact(true));
        String successmssg=depositesuccessmssg.innerText();
        System.out.println("Deposit Successful Message: "+successmssg);
        int depositedbalance=Integer.parseInt(balance.innerText());
        System.out.println("Current balance is "+depositedbalance);
        return depositedbalance;
    }

    public String emptydepositeamount(){

        Locator deposit=page.getByText("Deposit", new Page.GetByTextOptions().setExact(true));
        deposit.click();
        Locator depositaction=page.locator(depositnutton);
        depositaction.click();
        Locator depositeamount=page.getByPlaceholder("amount");
        String message = depositeamount.evaluate("element => element.validationMessage").toString();
        return message;
    }

    public int withdrawl(int amount){
        Locator balance=page.locator("//div[@class='center']//strong[2]");
        int currentbalance=Integer.parseInt(balance.innerText());
        System.out.println("pervious balance is "+currentbalance);
        Locator withdrawlbutton=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Withdrawl"));
        withdrawlbutton.click();
        Locator withdrawnamount=page.getByPlaceholder("amount");
        withdrawnamount.fill(String.valueOf(amount));
        Locator submitwithdrawl=page.locator(withdrawbutton);
        submitwithdrawl.click();
        int withdrawlbalance=Integer.parseInt(balance.innerText());
        Locator successmessage=page.getByText("Transaction successful", new Page.GetByTextOptions().setExact(true));
        System.out.println("Transaction Successful Message: "+successmessage.innerText());
        System.out.println("Current balance is "+withdrawlbalance);
        return withdrawlbalance;
    }

    public String setWithdrawlempty(){
        Locator balance=page.locator("//div[@class='center']//strong[2]");
        int currentbalance=Integer.parseInt(balance.innerText());
        System.out.println("Current balance is "+currentbalance);
        Locator withdrawlbutton=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Withdrawl"));
        withdrawlbutton.click();
        Locator submitwithdrawl=page.locator(withdrawbutton);
        submitwithdrawl.click();
        Locator withdrawnamount=page.getByPlaceholder("amount");
        String actualmessage = withdrawnamount.evaluate("element => element.validationMessage").toString();
        return actualmessage;
    }
}