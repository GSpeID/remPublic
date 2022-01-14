package ru.x3m.rem.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x3m.rem.dto.ClientDTO;
import ru.x3m.rem.dto.ClientTypeDTO;
import ru.x3m.rem.entity.Client;
import ru.x3m.rem.entity.ClientType;
import ru.x3m.rem.repository.ClientRepo;
import ru.x3m.rem.repository.ClientTypeRepo;

import java.util.List;

@Service
@Transactional
public class ClientService {

    private final ClientRepo clientRepo;
    private final ClientTypeRepo clientTypeRepo;

    public ClientService(ClientRepo clientRepo, ClientTypeRepo clientTypeRepo) {
        this.clientRepo = clientRepo;
        this.clientTypeRepo = clientTypeRepo;
    }

    public List<Client> findAllClients(){
        List<Client> clients = (List<Client>) clientRepo.findAll();
        return  clients;
    }

    public void createClient(ClientDTO clientDTO, ClientTypeDTO clientTypeDTO){
        Client client = new Client();
        ClientType clientType = new ClientType();
        client.setClient_id(clientDTO.getClient_id());
        client.setClient_name(clientDTO.getClient_name());
        clientType.setClient_type_id(clientTypeDTO.getClient_type_id());
        clientType.setClient_type_name(clientTypeDTO.getClient_type_name());

        clientRepo.save(client);

        clientTypeRepo.save(clientType);
    }


}
