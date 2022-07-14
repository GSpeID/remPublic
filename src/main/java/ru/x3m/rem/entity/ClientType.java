package ru.x3m.rem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client_types")
public class ClientType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientTypeId;

    @Column(nullable = false)
    private String clientTypeName;


    @OneToMany(
            mappedBy = "clientType",
            cascade = CascadeType.ALL
    )
    private List<Client> clients;


    public ClientType(){
    }

    public Long getClientTypeId() {
        return clientTypeId;
    }

    public void setClientTypeId(Long clientTypeId) {
        this.clientTypeId = clientTypeId;
    }

    public String getClientTypeName() {
        return clientTypeName;
    }

    public void setClientTypeName(String clientTypeName) {
        this.clientTypeName = clientTypeName;
    }
}
