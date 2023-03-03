package org.dolezel.bnpcardifcasestudy.subscription;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("subscriptions")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class SubscriptionController {

    SubscriptionService subscriptionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Subscription getAllSubscriptions(@RequestBody @Valid SubscriptionRequest subscription) {
        return subscriptionService.addSubscription(subscription);
    }

    @GetMapping("/{id}")
    public Optional<Subscription> getSubscriptions(@PathVariable Long id) {
        return subscriptionService.getSubscription(id);
    }

    @GetMapping
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }
}
