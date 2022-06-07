package fr.esgi.cookRecipe.Domain.User.Service;

import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import fr.esgi.cookRecipe.Domain.User.Repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserAccountService {


    private final UserAccountRepository userAccountRepository;
    private final JdbcUserDetailsManager jdbcUserDetailsManager;
    private final BCryptPasswordEncoder newPassword;


    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository, JdbcUserDetailsManager jdbcUserDetailsManager, BCryptPasswordEncoder newPassword){
        this.userAccountRepository = userAccountRepository;
        this.jdbcUserDetailsManager = jdbcUserDetailsManager;
        this.newPassword=newPassword;
    }

    public List<UserAccount> findAll(){
        return this.userAccountRepository.findAll();
    }

    public UserAccount getUserById(String id){
        return this.userAccountRepository.getById(UUID.fromString(id));
    }

    public UserAccount getUserByUsername(String username){
        return null;//this.userAccountRepository.findByUsername(username);
    }

    public UserAccount createUser(Object request){
//        UserDetails userDetails = new User(request.getUsername(),newPassword.encode(request.getPassword()), List.of(new SimpleGrantedAuthority("USER")));
//        this.jdbcUserDetailsManager.createUser(userDetails);
//        UserAccount user=new UserAccount(UUID.randomUUID(),request.getUsername(),request.getMail(),null, Date.from(Instant.now()));
//        this.userAccountRepository.save(user);
        return null;
    }

    public UserAccount updateUser(String username, Object userRequest){
        //UserAccount userAccountUpdated = this.userAccountRepository.findByUsername(username);
        return null;
    }

    public boolean changePassword(String username,String newPassword) {
        UserDetails currentUser = this.jdbcUserDetailsManager.loadUserByUsername(username);
        String password = this.newPassword.encode(newPassword);
        if (this.newPassword.matches(newPassword, currentUser.getPassword())) {
            System.out.println("error existe déjà : " + newPassword);
            return false;
        }
        else {
            this.jdbcUserDetailsManager.changePassword(currentUser.getPassword(), password);
            return true;
        }
    }

    public String getUsername(String id){
        return this.userAccountRepository.getById(UUID.fromString(id)).getLogin();
    }
}
