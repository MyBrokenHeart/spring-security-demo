package trainning.auth.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainning.auth.dao.UserRepository;
import trainning.auth.model.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User add(User user){
        return userRepository.save(user);
    }
}
