package ru.x3m.rem.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @NotNull(message = "Не должно быть пустым")
    @Size(min = 2, max = 45, message = "Миинимум {min}, максимум {max} символов")
    @Column(unique = true, nullable = false)
    private String clientName;

    @Column(name = "client_contact")
    private String clientContact;

    @Column(name = "client_phone")
    private String clientPhone;

    @Column(name = "client_mail")
    private String clientMail;

    @ManyToOne
    @JoinColumn(name = "client_type_id", insertable = false, updatable = false)
    private ClientType clientType;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL
    )
    private List<Repair> repairs;

    @NotNull(message = "Выберите тип клиента")
    @Column(name = "client_type_id")
    private Long clientTypeId;

}