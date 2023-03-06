package org.dolezel.bnpcardifcasestudy.customer;

import jakarta.persistence.Entity;
import lombok.*;
import org.dolezel.bnpcardifcasestudy.BaseEntity;

import java.time.LocalDate;


/**
 * Currently business key is not know so appropriate hashcode and equals implementation is missing
 */
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Customer extends BaseEntity {


    String firstName;

    String lastName;

    String middleName;

    String email;

    String phoneNumber;

    LocalDate birthdate;
}
