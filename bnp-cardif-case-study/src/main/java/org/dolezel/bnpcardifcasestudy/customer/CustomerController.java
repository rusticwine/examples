package org.dolezel.bnpcardifcasestudy.customer;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CustomerController {


    CustomerService customerService;


    @GetMapping
    public List<Customer> getAllCustomerEntities() {
        return customerService.getAllCustomerEntities();
    }


    @PutMapping(path = "/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody @Valid CustomerUpdateRequest customerDto) {
        return customerService.updateCustomer(id, customerDto);
    }
}
