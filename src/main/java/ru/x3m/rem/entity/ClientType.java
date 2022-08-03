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
@Table(name = "client_types")
public class ClientType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientTypeId;

    @NotNull(message = "Не должно быть пустым")
    @Size(min = 2, max = 45, message = "Миинимум {min}, максимум {max} символов")
    @Column(nullable = false)
    private String clientTypeName;


    @OneToMany(
            mappedBy = "clientType",
            cascade = CascadeType.ALL
    )
    private List<Client> clients;

}
