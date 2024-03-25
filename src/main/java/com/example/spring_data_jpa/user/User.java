package com.example.spring_data_jpa.user;

import com.example.spring_data_jpa.produce.Produce;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String sex;
    @Column(name = "billingcity")
    private String billingCity;
    private String email;
    private long password;

    @ManyToOne
    @JoinColumn(name = "produce_id", referencedColumnName = "proId")
    private Produce produce;
}
