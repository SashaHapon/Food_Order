import com.order.api.repository.AccountRepository;
import com.order.api.repository.MealRepository;
import com.order.api.service.AccountService;
import com.order.api.service.MealService;
import com.order.api.service.Wallet;
import com.order.repository.AccountRepositoryImpl;
import com.order.repository.MealRepositoryImpl;
import com.order.service.AccountServiceImpl;
import com.order.service.MealServiceImpl;
import com.order.service.OrderImpl;
import com.order.service.WalletImpl;

public class Main {
    public static void main(String[] args) {
        MealRepository mealRepository = new MealRepositoryImpl();
        MealService mealService = new MealServiceImpl(mealRepository);

        AccountRepository accountRepository = new AccountRepositoryImpl();
        AccountService accountService = new AccountServiceImpl(accountRepository);

        var meal = mealService.addMeal("sosiski", 200, 5);
        var meal1 = mealService.addMeal("makaroshki", 200, 10);
        var meal2 = mealService.addMeal("Potatos", 65, 20);
        var meals = mealService.getAll();
        System.out.println(meals);

        System.out.println(meal.getNameOfMeal());
        System.out.println(meal1.getId());



        var account = accountService.addAccount("Jack", 20,"+375449394875");
        System.out.println(account);
        accountService.update("Jin", "+34824",  account.getId());
        System.out.println(account);

        Wallet wallet = new WalletImpl();
        System.out.println(wallet.getMoneyOnCard(accountService, account.getId()));
        System.out.println(wallet.enrollmentMoney(accountService, account.getId(), 300));
        System.out.println(wallet.writeOffMoneyOnCard(accountService,account.getId(), 40));
        System.out.println(wallet.getMoneyOnCard(accountService, account.getId()));

        System.out.println(wallet.orderSum(meals));

        OrderImpl order = new OrderImpl(mealService,accountService,wallet,account.getId());

        System.out.println(order.getAccount());
        System.out.println(order.getAllMeals());

    }
}