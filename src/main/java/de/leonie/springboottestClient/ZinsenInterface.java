package de.leonie.springboottestClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@FeignClient(name="zinsenservice", url="http://localhost:8080/zinsen")

public interface ZinsenInterface {

    @GetMapping
    double berechneGet(
            @RequestParam double kapital,
            @RequestParam double zinssatz,
            @RequestParam int jahre);
    @PostMapping
    double berechnePost(@RequestBody Map<String,Object> params);
}
