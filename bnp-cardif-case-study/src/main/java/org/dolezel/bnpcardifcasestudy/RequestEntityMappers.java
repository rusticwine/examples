package org.dolezel.bnpcardifcasestudy;

import org.dolezel.bnpcardifcasestudy.customer.Customer;
import org.dolezel.bnpcardifcasestudy.customer.CustomerUpdateRequest;
import org.dolezel.bnpcardifcasestudy.quotation.Quotation;
import org.dolezel.bnpcardifcasestudy.quotation.QuotationRequest;
import org.dolezel.bnpcardifcasestudy.subscription.Subscription;
import org.dolezel.bnpcardifcasestudy.subscription.SubscriptionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RequestEntityMappers {


    void updateCustomerFromDto(CustomerUpdateRequest dto, @MappingTarget Customer entity);

    Quotation toQuotation(QuotationRequest quotationRequest, Customer customer);

    Subscription toSubscription(Quotation quotation, SubscriptionRequest request);
}
