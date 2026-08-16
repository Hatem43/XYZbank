package adminpages;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import customerpages.loginpage;

public class customeroptions extends loginpage {

    public String submit="//button[@type='submit']";

    public customeroptions(Page page) {
        super(page);
    }

    public int viewcustomers(){
        Locator cutomers=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Customers"));
        cutomers.click();
        Locator customersresult=page.locator("//table[@class='table table-bordered table-striped']//tbody/tr");
        for (Locator customerdata:customersresult.all()){
            System.out.println(customerdata.innerText());
        }
        int customers_count=customersresult.count();
        System.out.println("customer count is "+customers_count);
        return customers_count;
    }

    public void addcustomer(String firstname,String lastname,String postalcard){
        Locator addcustomer=page.getByText("Add Customer", new Page.GetByTextOptions().setExact(true));
        addcustomer.click();
        Locator first_name=page.getByPlaceholder("First Name");
        first_name.fill(firstname);
        Locator last_name=page.getByPlaceholder("Last Name");
        last_name.fill(lastname);
        Locator postal_code=page.locator("//input[@placeholder='Post Code']");
        postal_code.fill(postalcard);
        Locator submitnewcustomer=page.locator(submit);
        submitnewcustomer.click();
    }

    public boolean checkcustomeraddition(String searchedcustomer){
        boolean check=false;
        Locator cutomers=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Customers"));
        cutomers.click();
        Locator customersearch=page.getByPlaceholder("Search Customer");
        customersearch.fill(searchedcustomer);
        Locator customerdata=page.locator("//table[@class='table table-bordered table-striped']//tbody//tr");
        for (Locator customer:customerdata.all()){
            System.out.println(customer.innerText());
            check=customer.innerText().contains("Hatem");
        }
        return check;
    }

        public boolean checkdeletingcustomer(){
        Locator cutomers=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Customers"));
        cutomers.click();
        Locator customersearch=page.getByPlaceholder("Search Customer");
        customersearch.fill("Hatem");
        Locator deletebutton=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Delete"));
        deletebutton.click();
        Locator customerresult=page.locator("//table[@class='table table-bordered table-striped']//tbody");
        boolean isempty=customerresult.innerText().isEmpty();
        return isempty;
    }
    public String addcustomerwithemptydata(){
        Locator addcustomer=page.getByText("Add Customer", new Page.GetByTextOptions().setExact(true));
        addcustomer.click();
        Locator submitnewcustomer=page.locator(submit);
        submitnewcustomer.click();
        Locator firstname=page.getByPlaceholder("First Name");
        String message = firstname.evaluate("element => element.validationMessage").toString();
        return message;
    }

}