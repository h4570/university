package pl.pjatk.sansob.rentalservice.repositories;

public class ExchangeRateNotFoundException extends Exception {
    public ExchangeRateNotFoundException(String message) {
        super(message);
    }
}
