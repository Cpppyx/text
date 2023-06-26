import com.example.springmvc_demo.config.WebConfiguration;
import com.example.springmvc_demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    private AnnotationConfigApplicationContext context;
    // 初始化
// 在@Test方法执行前执行
    @BeforeEach
    public void before() {
        context = new
                AnnotationConfigApplicationContext(WebConfiguration.class);
    }
    @Test
    public void checkLoginUser(){
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.checkLoginUser("李四","123456"));
    }
    @Test
    public void getUserList(){
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getUserList());
    }
    @Test
    public boolean deleteUser(){
        UserService userService = context.getBean(UserService.class);
        return userService.deleteUser(1);
    }

}