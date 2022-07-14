package ru.x3m.rem.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(unique = true, nullable = false)
    private String clientName;

    @ManyToOne
    @JoinColumn(name = "client_type_id", insertable=false, updatable=false)
    private ClientType clientType;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL
    )
    private List<Repair> repairs;

    @Column(name = "client_type_id")
    private Long clientTypeId;

    public Client(){
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public Long getClientTypeId() {
        return clientTypeId;
    }

    public void setClientTypeId(Long clientTypeId) {
        this.clientTypeId = clientTypeId;
    }
}