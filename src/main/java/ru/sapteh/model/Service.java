package ru.sapteh.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Title")
    @NotNull
    private String title;

    @Column(name = "Cost")
    @NotNull
    private double cost;

    @Column(name = "DurationInSeconds")
    private int durationInSecond;

    @Column(name = "description")
    private String description;

    @Column(name = "discount")
    private double discount;

    @Column(name = "MainImagePath")
    private String mainImagePath;

    @OneToMany(mappedBy = "service",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ClientService> clientServices;

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", durationInSecond=" + durationInSecond +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", mainImagePath='" + mainImagePath + '\'' +
                '}';
    }
}
