package org.dolezel.bnpcardifcasestudy.subscription;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.dolezel.bnpcardifcasestudy.RequestEntityMappers;
import org.dolezel.bnpcardifcasestudy.PersistentResourceNotFoundException;
import org.dolezel.bnpcardifcasestudy.quotation.Quotation;
import org.dolezel.bnpcardifcasestudy.quotation.QuotationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class SubscriptionService {

    SubscriptionRepository subscriptionRepository;

    QuotationRepository quotationRepository;

    RequestEntityMappers requestEntityMappers;

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }


    public Subscription addSubscription(SubscriptionRequest request) {
        Quotation quotation = quotationRepository.findById(request.getQuotationId())
                .orElseThrow(() -> new PersistentResourceNotFoundException(
                        "Quotation does not exist with id",
                        String.valueOf(request.getQuotationId()),
                        "quotation"));

        Subscription subscription = requestEntityMappers.toSubscription(quotation, request);
        return subscriptionRepository.save(subscription);
    }


    public Optional<Subscription> getSubscription(Long id) {
        //eventually throw an exception
        return subscriptionRepository.findById(id);
    }
}
