//package io.gitub.mat3e.security;
//
//import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
//import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
//import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.core.session.SessionRegistryImpl;
//import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
//import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
//
//import static org.springframework.security.config.annotation.web.AbstractRequestMatcherRegistry.RequestMatchers.antMatchers;
//
//@KeycloakConfiguration
//public class SecurityConfiguration extends KeycloakWebSecurityConfigurerAdapter {
//    @Bean
//    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
//        return new KeycloakSpringBootConfigResolver();
//    }
//    @Override
//    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
//    }
//    @Autowired
//    void configureGlobal(AuthenticationManagerBuilder auth){
//        var authorityMapper = new SimpleAutorityMapper();
//        authorityMapper.setPrefix("ROLE_");
//        authorityMapper.setConvertToUpperCase(true);
//        auth.authenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
//        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(authorityMapper);
//        auth.authenticationProvider(keycloakAuthenticationProvider);
//    }
//
//    @Override
//    public void init(WebSecurity builder) throws Exception {
//
//    }
//
//    @Override
//    public void configure(WebSecurity builder) throws Exception {
//
//    }
//
//    @Override
//    public void configure(final HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.authorizeHttpRequests()
//                antMatchers("/info/*")
//                        .hasRole("USER")
//                        .anyRequest()
//                        .permitAll();
//
//    }
//}
