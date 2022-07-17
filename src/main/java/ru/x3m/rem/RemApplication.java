package ru.x3m.rem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


        //TODO:
        // + service:
        // -            напоминания о будущих заказах
        // -
        // - пользователи\роли:
        // -            для пользователя видны только будущие заказы(заказчик, техника, адрес, дата)
        // - Общее:
        // -            добавить нал\безнал к заказм
        // -            добавить статистику по финансам( нал, безнал, затраты на закупки, прибыль и тд)
        // -            стили таблиц(размещение кнопок, приемлемый вид)


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
