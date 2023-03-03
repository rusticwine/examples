package org.dolezel.bnpcardifcasestudy.quotation;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.dolezel.bnpcardifcasestudy.PersistentResourceNotFoundException;
import org.dolezel.bnpcardifcasestudy.RequestEntityMappers;
import org.dolezel.bnpcardifcasestudy.customer.Customer;
import org.dolezel.bnpcardifcasestudy.customer.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class QuotationService {

    
    QuotationRepository quotationRepository;

    CustomerRepository customerRepository;

    RequestEntityMappers requestEntityMappers;


    public Quotation addQuotation(QuotationRequest quotationRequest) {
        Customer customer = customerRepository.findById(quotationRequest.getCustomerId())
                .orElseThrow(() -> new PersistentResourceNotFoundException(
                        "Customer does not exist with id",
                        String.valueOf(quotationRequest.getCustomerId()),
                        "customer"));

        Quotation quotation = requestEntityMappers.toQuotation(quotationRequest, customer);
        return quotationRepository.save(quotation);
    }

    public List<Quotation> getQuotations() {
        return quotationRepository.findAll();
    }
}
