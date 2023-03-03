package org.dolezel.bnpcardifcasestudy.quotation;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class QuotationRequest {


    @NotNull
    Long customerId;

    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDate beginingOfInsurance;

    @DecimalMin(value = "10.0", inclusive = false)
    BigDecimal insuredAmount;

    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDate dateOfSigningMortgage;
}
