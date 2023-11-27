package com.clientHandler.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Transtion_Management")
public class TransMang {
    @Id
    @GeneratedValue
    private int id ;
    private String name ;
    private String product ;

    private double totalAmount ;

    private double reminAmount ;

    private  double creditAmount;

    private LocalDate localDate= LocalDate.now();

    @ManyToOne
    private Client client;

}
