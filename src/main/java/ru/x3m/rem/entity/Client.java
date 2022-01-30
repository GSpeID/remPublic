package ru.x3m.rem.entity;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long client_id;

    @Column(unique = true, nullable = false)
    private String client_name;

    @ManyToOne
    @JoinColumn(name = "client_type_id", insertable=false, updatable=false)
    private ClientType clientType;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL
//            orphanRemoval = true
    )

    private List<Repair> repairs;

    private Long client_type_id;

    public Client(){
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public Long getClient_type_id() {
        return client_type_id;
    }

    public void setClient_type_id(Long client_type_id) {
        this.client_type_id = client_type_id;
    }
}