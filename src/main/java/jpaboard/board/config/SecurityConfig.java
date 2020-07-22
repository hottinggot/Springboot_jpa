package jpaboard.board.config;

import jpaboard.board.service.BoardUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

//WebSecurityConfigurerAdapter를 상속받은 시큐리티 설정 클래스가 빈으로 등록되기만 해도 로그인을 강제하지 않음.
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BoardUserDetailsService boardUserDetailsService;

    @Override
    protected void configure(HttpSecurity security) throws Exception{
        security.authorizeRequests().antMatchers("/").permitAll();
        security.authorizeRequests().antMatchers("/member/**").authenticated();
        security.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
        security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");

        //크로스 사이트 위조 요청에 대한 설정. restful을 사용하기 위해 비활성화 해야함.
        security.csrf().disable();
        security.formLogin().defaultSuccessUrl("/loginSuccess",true);
        security.exceptionHandling().accessDeniedPage("/accessDenied");
        security.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
        security.userDetailsService(boardUserDetailsService);
    }

    //설정한 정보 로그인. {noop}은 비밀번호에 대한 암호화 처리를 하지 않겠다는 뜻임.
    @Autowired
    public void authenticate(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("manager").
                password("{noop}manager123").roles("MANAGER");

        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin123").roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
