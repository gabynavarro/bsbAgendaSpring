package com.bsb.agenda.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "datas")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(length = 30)
    private String phoneLine;
    @Column(name = "zip_code")
    protected String zipCode;
    @Column(length = 70)
    private String address;
    @Column(length = 70)
    private String province;
    @Column(length = 70)
    private String coutry;
}
