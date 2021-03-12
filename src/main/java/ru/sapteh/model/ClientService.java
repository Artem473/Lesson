package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientService")
public class ClientService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "StartTime")
    @NonNull
    private Date startTime;
    @Column(name = "Comment")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "ClientId")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "serviceID")
    private Service service;

    @Override
    public String toString() {
        return "ClientService{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", comment='" + comment + '\'' +
                ", client=" + client +
                ", service=" + service +
                '}';
    }
}
