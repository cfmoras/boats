package com.backapiboats.service;

import com.backapiboats.model.ClientModel;
import com.backapiboats.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> getAllClients() {
        return clientRepository.getAllClients();
    }

    public Optional<ClientModel> getClient(Integer id) {
        return clientRepository.getClient(id);
    }

    public ClientModel saveClient(ClientModel clientModel) {
        if (clientModel.getId() == null) {
            return clientRepository.saveClient(clientModel);
        } else {
            Optional<ClientModel>
                    optionalClientModel = clientRepository.getClient(clientModel.getId());
            if (optionalClientModel.isEmpty()) {
                return
                        clientRepository.saveClient(clientModel);
            } else {
                return clientModel;
            }
        }
    }

    public boolean deleteClient(Integer id) {
        Boolean aBoolean = getClient(id).map(clientModel -> {
            clientRepository.deleteClient(clientModel);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public ClientModel updateClient(ClientModel clientModel){
        if (clientModel.getId()!=null){
            Optional<ClientModel> optionalClientModel=clientRepository.getClient(clientModel.getId());
            if (!optionalClientModel.isEmpty()){
                if (clientModel.getName()!=null){
                    optionalClientModel.get().setName(clientModel.getName());
                }
                if (clientModel.getEmail()!=null){
                    optionalClientModel.get().setEmail(clientModel.getEmail());
                }
                if (clientModel.getAge()!=null){
                    optionalClientModel.get().setAge(clientModel.getAge());
                }
                if (clientModel.getPassword()!=null){
                    optionalClientModel.get().setPassword(clientModel.getPassword());
                }
                clientRepository.saveClient(optionalClientModel.get());
                return optionalClientModel.get();
            }else {
                return clientModel;
            }
        }else {
            return clientModel;
        }
    }
}
