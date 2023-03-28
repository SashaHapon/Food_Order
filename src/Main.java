import com.cafe.Cafe;
import com.cafe.ICafe;
import com.menu.IMenu;
import com.menu.Menu;
import com.order.IOrder;
import com.order.Order;
import com.user.Account;
import com.user.IAccount;

public class Main {
    public static void main(String[] args) {
        IOrder order = new Order();
        IAccount account = new Account();
        ICafe cafe = new Cafe();
        IMenu menu = new Menu();

        cafe.setMenu(menu);
        order.setAccountsParameters(account);
        order.setCafeParameters(cafe);

        System.out.println(order.getAccountName(account, 0));
        System.out.println(order.choizeOfMeal(cafe, 1));

        account.setAccount("Vlad", 50, "45325252");


    }
}