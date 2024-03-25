package com.example.spring_data_jpa.produce;

import com.example.spring_data_jpa.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produces")
@Builder
public class Produce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long proId;
    private String tittle;
    private String Description;

    @OneToMany(mappedBy = "produce")
    private List<User>users;


}
