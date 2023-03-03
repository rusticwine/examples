package org.dolezel.bnpcardifcasestudy.quotation;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quotations")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class QuotationController {


    QuotationService quotationService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Quotation createQuototaion(@RequestBody @Valid QuotationRequest quotation) {
        return quotationService.addQuotation(quotation);
    }

    @GetMapping
    public List<Quotation> getQuotations() {
        return quotationService.getQuotations();
    }
}
