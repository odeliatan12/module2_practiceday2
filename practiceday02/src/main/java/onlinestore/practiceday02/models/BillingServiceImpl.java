package onlinestore.practiceday02.models;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Valid;

public class BillingServiceImpl implements BillingService {

    @Autowired
    private BillingRepository billingRepository;

    

}
