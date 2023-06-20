import com.order.api.repository.AccountRepository;
import com.order.api.repository.MealRepository;
import com.order.api.repository.OrderRepository;
import com.order.api.service.AccountService;
import com.order.api.service.MealService;
import com.order.api.service.OrderService;
import com.order.api.service.WalletService;
import com.order.repository.AccountRepositoryImpl;
import com.order.repository.MealRepositoryImpl;
import com.order.repository.OrderRepositoryImpl;
import com.order.service.*;
import com.order.utils.EnterPoint;
import com.order.utils.HibernateUtil;
import com.order.utils.Log;

import java.io.IOException;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws IOException, MyException, SQLException {

        Log log = new Log();
        log.info("rr");

        EnterPoint enter = new EnterPoint();
        enter.enter();

        MealRepository mealRepository = new MealRepositoryImpl();
        MealService mealService = new MealServiceImpl(mealRepository);

        AccountRepository accountRepository = new AccountRepositoryImpl();
        AccountService accountService = new AccountServiceImpl(accountRepository);


        WalletService walletService = new WalletServiceImpl(accountService);

        //var account = accountService.addAccount("Jack", 600,"+375449394875");

       // var meal = mealService.addMeal("sosiski", 200, 5);
       // var meal1 = mealService.addMeal("makaroshki", 200, 10);
      //  var meal2 = mealService.addMeal("Potatos", 65, 20);

        OrderRepository orderRepository = new OrderRepositoryImpl();
        OrderService orderService = new OrderServiceImpl(orderRepository);

      //  var order = orderService.createOrder(account, mealRepository.getAllMeal());
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
    //   var acc =  accountService.addAccount("Sasha", 50000, "+35600000000");
        //accountService.deleteAccountById(orderId); //change ID
        //System.out.println(accountService.getAll().get(7));
      //  accountService.update("G-----ooool", "+102", "2b300f77-3846-47f8-8a8e-e20a0275f2d1");
    //   mealService.addMeal("msd",45.3,700000);
     //   System.out.println(mealService.getAll());

//check
     //   orderService.createOrder(acc, mealService.getAll());
    //    System.out.println(orderService.getOrder(UUID.fromString("bdba49b5-2685-434f-a365-425b1f8e7278")));
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.buildSessionFactory();
    }
}