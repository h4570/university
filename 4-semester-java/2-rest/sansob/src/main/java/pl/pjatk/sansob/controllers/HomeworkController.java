package pl.pjatk.sansob.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.sansob.models.Car;
import pl.pjatk.sansob.models.Smartphone;

import java.util.ArrayList;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

    public HomeworkController() {
        smartphones = new ArrayList<>();
        smartphones.add(new Smartphone(1, "Samsung"));
        smartphones.add(new Smartphone(2, "Nokia"));
    }

    private final ArrayList<Smartphone> smartphones;

    @Nullable
    private Smartphone getSmartphoneById(int id) {
        return smartphones.stream()
                .filter(c -> c.getId() == id)
                .findAny()
                .orElse(null);
    }

    @GetMapping("{id}")
    public ResponseEntity<Smartphone> Get1(@PathVariable(value = "id") int id) {
        var smartphone = getSmartphoneById(id);
        return smartphone != null ? ResponseEntity.ok(smartphone) : ResponseEntity.notFound().build();
    }

    @GetMapping()
    public ResponseEntity<Smartphone> Get2(@RequestParam(value = "id") int id) {
        var smartphone = getSmartphoneById(id);
        return smartphone != null ? ResponseEntity.ok(smartphone) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Smartphone> Post(@RequestBody Smartphone smartphone) {
        // Add
        return ResponseEntity.ok(smartphone);
    }

    @PutMapping("{id}")
    public ResponseEntity<Smartphone> Put(@PathVariable(value = "id") int id, @RequestBody Smartphone smartphone) {
        var dbSmartphone = getSmartphoneById(id);
        // Full update
        return dbSmartphone != null ? ResponseEntity.ok(dbSmartphone) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> Delete(@PathVariable(value = "id") int id) {
        var smartphone = getSmartphoneById(id);
        // Delete
        return ResponseEntity.ok("Success");
    }

}
