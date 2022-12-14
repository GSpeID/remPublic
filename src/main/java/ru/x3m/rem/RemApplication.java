package ru.x3m.rem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//TODO:
// - !при пустой DB возникают ошибки в работе скриптов выпадающих списков, если на странице одна из таблиц пустая
// - !загрузка файлов - Invalid CSRF token found for /rem/management/upload
// -                    несколько вариантов решения, пока в th:action добавлено тело csrf(утечка, необходимо настроить
// -                        filterChain)
// -
// - пользователи\роли:
// -                    для пользователя видны только (заказчик, техника, адрес, дата)
// -
// - service:
// -        напоминания о будущих заказах
// -
// -
// -        неактивная кнопка, если заказ отправлен в календарь
// -
// - charts:
// -     добавить статистику по финансам( нал, безнал, затраты на закупки, прибыль и тд)
// -
// - outlays
// -        зависимый список при создании затрат
// -
// - controllers:
// -
// -
// - thymeleaf:
// -            вывод ошибок валидации(нарушение стиля страницы)
// -
// - adminPanel
// -            управление пользователями(список пользователей, редактирование, удаление)
// -
// - stat
// -     подтверждение удаления
// -     удаление: что  удалять?(только текущую запись(остаются фантомные записи) или каскадом всё зависимое?
// -     отображение списка документов(скачивание,удаление)
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
