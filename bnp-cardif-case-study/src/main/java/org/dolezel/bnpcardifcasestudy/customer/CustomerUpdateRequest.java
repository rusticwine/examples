package org.dolezel.bnpcardifcasestudy.customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Value;

import java.time.LocalDate;

@Value
public class CustomerUpdateRequest {

    String firstName;
    String lastName;
    String middleName;
    @Email
    String email;
    @Pattern(regexp = "(^$|[0-9]{10})") //just a simple validation
    String phoneNumber;
    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDate birthdate;
}
