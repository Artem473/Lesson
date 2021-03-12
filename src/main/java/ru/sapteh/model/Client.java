package ru.sapteh.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FirstName")
    @NonNull
    private String firstname;
    @Column(name = "LastName")
    @NonNull
    private String lastName;
    @Column(name = "Patronymic")
    private String patronymic;
    @Column(name = "BirthDay")
    private Date birthDay;
    @Column(name = "RegistrationDate")
    @NonNull
    private Date registrationDate;
    @Column(name = "Email")
    @NonNull
    private String email;
    @Column(name = "Phone")
    @NonNull
    private String phone;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<ClientService> clientServices;
    @ManyToOne
    @JoinColumn(name = "GenderCode")
    private Gender gender;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthDay=" + birthDay +
                ", registrationDate=" + registrationDate +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                '}';
    }
}
