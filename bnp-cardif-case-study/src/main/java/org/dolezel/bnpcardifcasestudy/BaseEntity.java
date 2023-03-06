package org.dolezel.bnpcardifcasestudy;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@Getter
public class BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
}
