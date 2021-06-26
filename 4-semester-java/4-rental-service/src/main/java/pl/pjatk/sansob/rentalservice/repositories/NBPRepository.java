package pl.pjatk.sansob.rentalservice.repositories;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.sansob.rentalservice.models.ExchangeRateResponse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public class NBPRepository {

    private final RestTemplate restTemplate;
    // TODO, move me to app props
    private final String url;

    public NBPRepository(RestTemplate template) {
        this.restTemplate = template;
        this.url = " http://api.nbp.pl/api";
    }

    public ExchangeRateResponse getExchangeRate(Date date) throws HttpClientErrorException, ExchangeRateNotFoundException {
        // TODO, refactor this
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = formatter.format(date);
        var uri = String.format("/exchangerates/rates/c/usd/%s/?format=json", stringDate);
        var res = this.restTemplate.getForEntity(url + uri, ExchangeRateResponse.class);
        if (res.hasBody())
            return res.getBody();
        else throw new ExchangeRateNotFoundException("Exchange was not found!");
    }

    public CompletableFuture<ExchangeRateResponse> getExchangeRateAsync(Date date) throws HttpClientErrorException, ExchangeRateNotFoundException {
        return CompletableFuture.supplyAsync(NBPRepository::getExchangeRate)
                .thenApply(tables -> {
                    for (ExchangeTable table: tables) {
                        for (ExchangeRate rate: table.getRates()) {
                            if (rate.getCode().equals("EUR")) {
                                return rate.getRate();
                            }
                        }
                    }
                    throw new RuntimeException("Kurs wymiany niedostępny!");
                });
    }

    public List<ExchangeRateResponse> getExchangeRates(){
        CompletableFuture<ExchangeRateResponse> conversionRate = printExchangeRate();

    }

}
