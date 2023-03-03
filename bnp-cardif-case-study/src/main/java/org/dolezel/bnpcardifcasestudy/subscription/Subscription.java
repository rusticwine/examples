package org.dolezel.bnpcardifcasestudy.subscription;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.dolezel.bnpcardifcasestudy.BaseEntity;
import org.dolezel.bnpcardifcasestudy.quotation.Quotation;

import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter(value = AccessLevel.PACKAGE)
@Data
public class Subscription extends BaseEntity {

    @OneToOne
    Quotation quotation;

    LocalDate startDate;

    LocalDate validUntil;

}
