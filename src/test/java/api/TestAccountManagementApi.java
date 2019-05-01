package api;


import data.AccountDAO;
import model.Account;
import model.Currency;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAccountManagementApi {
    @Test
    public void testAccountIsCreated(){
        Account account = null;
        try {
            account = new Account("123", Currency.GBP, 1000);
        }catch (Exception e){

        }
        AccountDAO.getInstance().addAccount(account);

        Assert.assertEquals(account.getAccountID(), AccountDAO.getInstance().getAccount(account.getAccountID()).getAccountID());
    }

}
