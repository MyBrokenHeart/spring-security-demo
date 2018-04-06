package trainning.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import trainning.auth.dao.UserRepository;
import trainning.auth.model.User;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        System.out.println("haha");
        authorities.add(new SimpleGrantedAuthority("ROLE_" + "ADMIN"));
        org.springframework.security.core.userdetails.User userDetails=new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
        return user;
    }
}
