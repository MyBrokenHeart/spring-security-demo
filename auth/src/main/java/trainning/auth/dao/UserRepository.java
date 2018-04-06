package trainning.auth.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import trainning.auth.model.User;

public interface UserRepository extends MongoRepository<User,String> {
     public User findByUsername(String username);
}
