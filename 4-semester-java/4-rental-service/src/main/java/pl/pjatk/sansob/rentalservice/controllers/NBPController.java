package pl.pjatk.sansob.rentalservice.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/nbp")
public class NBPController {

    public NBPController(RestTemplate restTemplate) {

    }

    @ApiOperation(
            value = "Get average exchange rate by given days count",
            response = String.class,
            notes = "Exchange rate is based on public NBP exchange rates"
    )
    @GetMapping("{days}")
    public ResponseEntity<String> getByDaysCount(
            @ApiParam(name = "days", type = "Long", value = "Days count", example = "1", required = true)
            @PathVariable Long days
    ) {
        var test = "123";
        return ResponseEntity.ok(test);
    }

}