package org.dolezel.bnpcardifcasestudy.subscription;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;

@Value
public class SubscriptionRequest {


    @NotNull
    Long quotationId;

    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDate startDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDate validUntil;
}
