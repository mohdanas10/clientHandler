package com.clientHandler.Service;

import com.clientHandler.Entity.Client;
import com.clientHandler.Entity.Customer;
import com.clientHandler.Repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class clientService{
    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private TransitionService transitionService;


    public Client addClient(Client client) {
        List<Client> list = this.clientRepo.findAll();
       List<Client> clients= list.stream().filter(e -> e.getClientName().startsWith(client.getClientName())).collect(Collectors.toList());
        if(clients.size() == 0){
            Client cl = this.clientRepo.save(client);
            return cl;
        }
        else {
            return null;
        }

    }


//    public Client searchById(int id) {
//        Client client = this.clientRepo.findById(id);
//        return client;
//    }
//
//    public Client searchByName(String name ) {
//        Client client = this.clientRepo.findByName(name );
//        return null;
//    }

    public List<Client> allClients(){
        List<Client> clients = (List<Client>) this.clientRepo.findAll();
        return clients;
    }

    public Client updataClient(Client client,int id  ){
        Client upClient = this.clientRepo.findById(id);
        if( upClient.getClientId() == id){
            upClient.setClientName(client.getClientName());
            upClient.setClientCity(client.getClientCity());
            upClient.setClientState(client.getClientState());
            upClient.setClientPhoneNo(client.getClientPhoneNo());
            this.clientRepo.save(upClient);
        }
        return upClient;


    }

    public Client getClientById(int  id ){
        Client cl = this.clientRepo.findById(id);
        return cl;
    }

    public String deleteClientById(int id ){
        Client client = this.clientRepo.findById(id);
        this.clientRepo.delete(client);
        return "user deleted successfully ";
    }

    public List<Client> getByName(String name ){

        List<Client> clients = (List<Client>) this.clientRepo.findAll();
        List<Client> cl =  clients.stream().filter(e -> e.getClientName().startsWith(name)).collect(Collectors.toList());
        String str = name.toUpperCase();
        System.out.println(cl.size());
        if(cl.size() ==  0) {
            List<Client> list = clients.stream().filter(e -> e.getClientName().startsWith(str)).collect(Collectors.toList());
            return list;
        }

        return cl;

    }

//    public Client getNames(String name ){
//        Client client = this.clientRepo.findByClientName(name);
//        return client;
//    }
}
