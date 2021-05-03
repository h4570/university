package pl.pjatk.sansob.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.sansob.models.Car;

@RestController
@RequestMapping("/test")
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<String> Get(@RequestParam(value="reqParam")String reqParam) {
        return ResponseEntity.ok(reqParam);
    }

    @GetMapping("/model")
    public ResponseEntity<Car> GetCar() {
        var obj = new Car("Porsche","Carrera",2137); // Słoneczna Riviera
        return ResponseEntity.ok(obj);
    }

    @PostMapping("/model")
    public ResponseEntity<Car> PostCar( @RequestBody Car car) {
        return ResponseEntity.ok(car);
    }

}
