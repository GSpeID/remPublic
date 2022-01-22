package ru.x3m.rem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client_types")
public class ClientType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long client_type_id;

    @Column(nullable = false)
    private String client_type_name;

    @OneToMany(
            mappedBy = "clientType",
            cascade = CascadeType.ALL
//            orphanRemoval = true
    )
    private List<Repair> repairs;

    public ClientType(){
    }

    public Long getClient_type_id() {
        return client_type_id;
    }

    public void setClient_type_id(Long client_type_id) {
        this.client_type_id = client_type_id;
    }

    public String getClient_type_name() {
        return client_type_name;
    }

    public void setClient_type_name(String client_type_name) {
        this.client_type_name = client_type_name;
    }



}
