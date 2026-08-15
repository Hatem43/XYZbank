package customerpages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class transactionspage extends loginpage {

    String Transactionstable = "//table[@class='table table-bordered table-striped']//tbody//tr";
    boolean found;
    String accountnum = "//select[@name='accountSelect']";
    boolean is_empty;

    public transactionspage(Page page) {
        super(page);
    }

    public String viewtransactions() {
        Locator transactions = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Transactions"));
        transactions.click();
        String currenturl = page.url();
        return currenturl;
    }

    public boolean transactionslist(String username) {
        if (username == "Hermoine Granger") {
            Locator Transactionadata = page.locator(Transactionstable);
            for (Locator transaction : Transactionadata.all()) {
                if (transaction.innerText()!=null) {
                    System.out.println(" the transactions are " + transaction.innerText());
                    found = true;
                }
            }
        }

        else if (username == "Harry Potter" || username == "Ron Weasly" || username == "Albus Dumbledore" || username == "Neville Longbottom") {
            found = false;
            System.out.println("no transactions found");
        }
        return found;
    }

    public boolean changeAccountnumber(int accountnumber) {
        Locator changeaccount = page.locator("#accountSelect");
        changeaccount.selectOption(String.valueOf(accountnumber));
        Locator transactions = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Transactions"));
        transactions.click();
        boolean cont = page.locator(Transactionstable).all().isEmpty();
        if(cont==true){
            System.out.println("no transactions found");
        }
        return cont;
    }

    public boolean resttransactions() {
                Locator resettransactions = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset"));
                resettransactions.click();
                is_empty = page.locator(Transactionstable).all().isEmpty();
                return is_empty;
    }
        }
