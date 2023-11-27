package com.clientHandler.Controller;
import com.clientHandler.Entity.Client;
import com.clientHandler.Service.clientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private clientService cl;

    @Autowired
    private  TransManagement transManagement;

    @PostMapping("/add")
    public Client addClient(@Valid @RequestBody Client client){
        return this.cl.addClient(client);
    }

    @GetMapping("/allClient")
    public List<Client> getAllClient(){
        List<Client> client = this.cl.allClients();
        return client;
    }

    @PostMapping("/update/{id}")
    public Client updateClient(@Valid  @PathVariable("id") int id  , @RequestBody Client client ){
        Client cl  =  this.cl.updataClient(client , id );
        return cl;
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable("id") int id ){
       Client client =  this.cl.getClientById(id);
        return client;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") int id ){
       String str =  this.cl.deleteClientById(id);
       return str;
    }

    @GetMapping("/names/{name}")
    public List<Client>  getByName(@PathVariable("name") String name ){
        return this.cl.getByName(name);
    }

}
