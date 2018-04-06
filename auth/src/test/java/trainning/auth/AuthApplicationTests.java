package trainning.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import trainning.auth.dao.UserRepository;
import trainning.auth.model.User;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthApplicationTests {

    @Autowired
    private UserRepository userRepository;

    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Test
    public void addTest(){
        User user=new User();
        user.setUsername("haha");
        String password="haha";
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }
}
//    @Test
//    public void contextLoads() {
//        System.out.println("hello");
//    }
