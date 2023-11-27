package com.clientHandler.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.websocket.server.ServerEndpoint;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Customer {

    @Id
    @GeneratedValue
    private int customerId ;
    private String  customerName ;
}
