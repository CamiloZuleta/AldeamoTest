package com.Aldeamo.test.persistence.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "Arrays")
@Getter
public class Arrays {

    @Id
    @SequenceGenerator(name="seq", sequenceName = "seq",initialValue = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    @Column(name = "INPUT_ARRAY")
    private String arrayString;

    public Arrays(Integer id, String array) {
        this.id = id;
        this.arrayString= array;
    }

    public Arrays(){}
}
