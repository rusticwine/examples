package org.dolezel.bnpcardifcasestudy.quotation;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.dolezel.bnpcardifcasestudy.BaseEntity;
import org.dolezel.bnpcardifcasestudy.customer.Customer;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter(value = AccessLevel.PACKAGE)
@Data
public class Quotation extends BaseEntity {


    /*
        Notes - I assume date is appropriate, although some contracts may include clause
        "applies from time of signature" where in such a case some Local or OffsetDateTime would be used
     */
    LocalDate beginingOfInsurance;

    LocalDate dateOfSigningMortgage;

    BigDecimal insuredAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
}
