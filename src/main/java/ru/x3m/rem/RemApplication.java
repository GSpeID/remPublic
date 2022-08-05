package ru.x3m.rem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//TODO:
// - пользователи\роли:
// -                    для пользователя видны только (заказчик, техника, адрес, дата)
// -
// - service:
// -        напоминания о будущих заказах
// -
// - stat:
// -     добавить статистику по финансам( нал, безнал, затраты на закупки, прибыль и тд)
// -
// -
// - DTO:
// -     маппинг
// -
// - controllers:
// -            проверки на ifExist и проверки в целом
// -
// - thymeleaf:
// -            вывод ошибок валидации(приемлемый вид)
// -
// - REST:
// -      довести до нормального вида\функционала
// -
// -
// -
// -
// -
// -
// -
// -
// -
// -
// -
// -
// -
// -
// -
// -
// -
// -
// -
// -
// -
// -


@SpringBootApplication
public class RemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemApplication.class, args);
    }

}
