package org.dolezel.bnpcardifcasestudy.customer;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.dolezel.bnpcardifcasestudy.RequestEntityMappers;
import org.dolezel.bnpcardifcasestudy.PersistentResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CustomerService {

    CustomerRepository customerRepository;

    RequestEntityMappers requestEntityMappers;


    @PostConstruct
    private void init() {
        loadTestData();
    }


    public List<Customer> getAllCustomerEntities() {
        return customerRepository.findAll();
    }

    public Customer updateCustomer(Long customerId, CustomerUpdateRequest customerUpdateRequest) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new PersistentResourceNotFoundException("Customer does not exist with id", String.valueOf(customerId), "customer"));

        requestEntityMappers.updateCustomerFromDto(customerUpdateRequest, customer);
        customerRepository.save(customer);
        return customer;
    }


    /**
     * Used to have some customer in the DB as there is no endpoint for creation. Nothing even close to production-ready
     */
    private synchronized void loadTestData() {
        //no need for if the DB is not empty
        if (customerRepository.findAll().isEmpty()) {
            Customer exampleCustomer = Customer.builder()
                    .firstName("Jara")
                    .lastName("Cimrman")
                    .birthdate(LocalDate.of(2000, 11, 11))
                    .email("go@upper.cz")
                    .build();

            customerRepository.save(exampleCustomer);
        }
    }
}
