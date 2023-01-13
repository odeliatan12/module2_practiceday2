package onlinestore.practiceday02.models;

public interface BillingService {
    
    public default boolean saveBillingInformation(BillingInformation billingInformation) {
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
