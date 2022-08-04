package ru.x3m.rem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//TODO:
// + service:
        // -            напоминания о будущих заказах
        // -
        // - пользователи\роли:
        // -            для пользователя видны только будущие заказы(заказчик, техника, адрес, дата)
// - Общее:
// -
// -            добавить статистику по финансам( нал, безнал, затраты на закупки, прибыль и тд)
// -


@SpringBootApplication
public class RemApplication {


    public static void main(String[] args) {
        SpringApplication.run(RemApplication.class, args);
    }

}
