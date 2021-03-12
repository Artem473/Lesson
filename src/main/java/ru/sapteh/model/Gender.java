package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gender")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private char code;
    @Column(name = "Name")
    @NonNull
    private String name;

    @Override
    public String toString() {
        return "Gender{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
