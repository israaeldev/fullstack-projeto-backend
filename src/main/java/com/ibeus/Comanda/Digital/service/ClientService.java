package com.ibeus.Comanda.Digital.service;

import com.ibeus.Comanda.Digital.model.Client;
import com.ibeus.Comanda.Digital.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepository repository;

    public Client createClient(Client client){

        return repository.save(client);

    }
}
