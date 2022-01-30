package ru.x3m.rem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


        //TODO:
        // - service:   simplify table(full info via "info" button)
        // +            add search
        // +            add sort
        // -            add info button with full information
        // -            add modal on click "cost"(add new table with payment status and other info)
        // -            add schedule and notification
        // +            add statuses: planned, completed, done-waiting for payment(maybe some another statuses)
        // -            add address
        // - management:
        // +             client type selection on creation new client
        // -             add new positions only from admin confirmation
        // - users:     user roles(admin, manager, user)
        // -            access to management only for admin
        // -            for user - only planed repair with date and address


@SpringBootApplication
public class RemApplication {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(RemApplication.class, args);
    }

}
