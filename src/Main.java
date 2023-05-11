import com.order.api.repository.AccountRepository;
import com.order.api.repository.MealRepository;
import com.order.api.repository.OrderRepository;
import com.order.api.service.*;
import com.order.repository.AccountRepositoryImpl;
import com.order.repository.MealRepositoryImpl;
import com.order.repository.OrderRepositoryImpl;
import com.order.service.*;
import com.order.service.MyException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

import com.order.service.JavaToMySQL;




public class Main {
    public static void main(String[] args) throws IOException, MyException {

        MealRepository mealRepository = new MealRepositoryImpl();
        MealService mealService = new MealServiceImpl(mealRepository);

        AccountRepository accountRepository = new AccountRepositoryImpl();
        AccountService accountService = new AccountServiceImpl(accountRepository);

        Properties properties = new Properties();
        FileInputStream in = new FileInputStream("src/resources/properties/config.property");
        properties.load(in);

        WalletService walletService = new WalletServiceImpl(accountService);

        //var account = accountService.addAccount("Jack", 600,"+375449394875");

       // var meal = mealService.addMeal("sosiski", 200, 5);
       // var meal1 = mealService.addMeal("makaroshki", 200, 10);
      //  var meal2 = mealService.addMeal("Potatos", 65, 20);

        OrderRepository orderRepository = new OrderRepositoryImpl();
        OrderService orderService = new OrderServiceImpl(orderRepository);

        //var order = orderService.createOrder(account, mealRepository.getAllMeal());
       // UUID orderId = order.getId();
        //orderService.addMeal(meal, orderId);
      //  orderService.addMeal(meal1, orderId);
       // orderService.getAllMeals(orderId);
       // orderService.applyDiscount(properties.getProperty("discount"), orderId);
      //  orderService.checkPayment(orderId);

        String s1 = "str";
        String s2 = "str";
        String s3 = new String("str");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

    //JavaToMySQL javaToMySQL = new JavaToMySQL();
    //javaToMySQL.mybd();

      //  System.out.println(accountService.getAccount(orderId));
        accountService.addAccount("Luidge", 95, "+353334400460");
        //accountService.deleteAccountById(orderId); //change ID
        //System.out.println(accountService.getAll().get(7));
        accountService.update("G-----ooool", "+102", "2b300f77-3846-47f8-8a8e-e20a0275f2d1");
        mealService.addMeal("msd",45.3,5);
        System.out.println(mealService.getAll());
    }
}