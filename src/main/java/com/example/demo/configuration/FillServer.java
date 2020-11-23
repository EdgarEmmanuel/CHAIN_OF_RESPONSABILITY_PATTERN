package com.example.demo.configuration;

import com.example.demo.chain.EmailExistMiddleware;
import com.example.demo.chain.PasswordExistMiddleware;
import com.example.demo.database.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;

@Configuration
public class FillServer {
    Server server = new Server();


    @Bean
    public ModelAndView getInit(){
        return new ModelAndView();
    }

    @Bean
    public Server sServer(){
        this.server

                //register the users of the system
                .register("admin@example.com", "admin_pass")
                .register("user@example.com", "user_pass")
                .register("admin@simplon.co", "admin.co")

                //chain of middleware
                .setMiddleware(
                        new EmailExistMiddleware(server)

                                .linkNext(new PasswordExistMiddleware(server))
                );
        return this.server;
    }
}
