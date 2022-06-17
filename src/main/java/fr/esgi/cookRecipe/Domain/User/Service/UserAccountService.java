package fr.esgi.cookRecipe.Domain.User.Service;

import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import fr.esgi.cookRecipe.Domain.User.Repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Streamable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final JdbcUserDetailsManager jdbcUserDetailsManager;
    private final BCryptPasswordEncoder bcryptPasswordEncoder;

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository, JdbcUserDetailsManager jdbcUserDetailsManager, BCryptPasswordEncoder bcryptPasswordEncoder){
        this.userAccountRepository = userAccountRepository;
        this.jdbcUserDetailsManager = jdbcUserDetailsManager;
        this.bcryptPasswordEncoder = bcryptPasswordEncoder;
    }

    public List<UserAccount> findAll(){
        Iterable<UserAccount> users = this.userAccountRepository.findAll();
        return Streamable.of(users).toList();
    }

    public UserAccount getUserById(UUID id){
        Optional<UserAccount>  userAccount =  this.userAccountRepository.findById(id);
        if(userAccount.isEmpty()){
            // throw account not found
        }
        return  userAccount.get();
    }

    public List<UserAccount> getUsersByUsername(String username, Pageable pagination){
        return this.userAccountRepository.findUserAccountsByUsernameContaining(username, pagination).getContent();
    }

    public void createUser(UserAccount userAccount, String email, String password, List<GrantedAuthority> grntdAuths) {
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(email,bcryptPasswordEncoder.encode(password),grntdAuths);
        jdbcUserDetailsManager.createUser(userDetails);
        this.saveUserAccount(userAccount);
    }

    public void changePassword(String newPassword) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserDetails currentUser = this.jdbcUserDetailsManager.loadUserByUsername(username);
        String password = this.bcryptPasswordEncoder.encode(newPassword);
        this.checkPasswordAreDifferent(password, currentUser.getPassword());
        this.jdbcUserDetailsManager.changePassword(currentUser.getPassword(), password);
    }

    public void changeMail(String newEmail) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        this.checkMailAreDifferent(newEmail, email);
        this.checkMailNotAlreadyTaken(newEmail);

        UserAccount userAccount = this.getUserAccountByEmail(email);
        userAccount.setEmail(newEmail);

        UserDetails currentUser = this.jdbcUserDetailsManager.loadUserByUsername(email);
        UserDetails newUserDetails = new org.springframework.security.core.userdetails.User(newEmail,currentUser.getPassword(),currentUser.getAuthorities());

        this.jdbcUserDetailsManager.deleteUser(email);

        jdbcUserDetailsManager.createUser(newUserDetails);
        this.saveUserAccount(userAccount);
    }

    public UserAccount getUserAccountByEmail(String email){
        Optional<UserAccount>  userAccount = this.userAccountRepository.findUserAccountByEmail(email);
        if(userAccount.isEmpty()){
            // throw account not found
        }
        return userAccount.get();
    }

    private void saveUserAccount(UserAccount userAccount){
        this.userAccountRepository.save(userAccount);
    }

    private void checkPasswordAreDifferent(String newPassword, String oldpassword){
        if (this.bcryptPasswordEncoder.matches(newPassword, oldpassword)) {
            //throw new Exception("error existe déjà : " + newPassword);
        }
    }

    private void checkMailAreDifferent(String newEmail, String oldEmail){
        if(oldEmail.equals(newEmail)){
            // throw exception meme mail
        }
    }

    private void checkMailNotAlreadyTaken(String email){
        try {
            this.getUserAccountByEmail(email);
            // throw excetion mail deja pris
        } catch (Exception e){
            // email pas déjas pris donc good
        }
    }

}
