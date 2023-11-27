package com.clientHandler.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ClientId ;
    @NotEmpty
    private String clientName ;
    @NotEmpty
    private String clientCity ;


    @NotEmpty
    private String clientPhoneNo ;
    @NotEmpty
    private String clientState;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<TransMang> transMangs;

    public Client(int clientId, String clientName, String clientCity, String clientPhoneNo, String clientState, List<TransMang> transMangs) {
        ClientId = clientId;
        this.clientName = clientName;
        this.clientCity = clientCity;
        this.clientPhoneNo = clientPhoneNo;
        this.clientState = clientState;
        this.transMangs = transMangs;
    }
}
