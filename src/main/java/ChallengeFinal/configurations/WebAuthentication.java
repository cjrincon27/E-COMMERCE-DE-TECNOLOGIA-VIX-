package ChallengeFinal.configurations;

import ChallengeFinal.models.Buyer;
import ChallengeFinal.repository.BuyerRepository;
import ChallengeFinal.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    private BuyerService buyerService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inputEmail->{

            Buyer buyer = buyerService.findByEmail(inputEmail);

            if (buyer != null && buyer.isValidator()) {
                if (buyer.getEmail().contains("admin") && buyer.getEmail().contains("pollo")){
                    return new User(buyer.getEmail(), buyer.getPassword(),
                            AuthorityUtils.createAuthorityList("ADMIN"));
                }else {
                    return new User(buyer.getEmail(), buyer.getPassword(),
                            AuthorityUtils.createAuthorityList("BUYER"));
                }

            } else {
                    throw new UsernameNotFoundException("Unknown user " + inputEmail);
            }
        });
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
