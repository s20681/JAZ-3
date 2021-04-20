package com.maczak.jaz3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class FirstController {

    @GetMapping(path = "/hello")
    ResponseEntity<String> firstMapping(){
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping(path = "/model")
    ResponseEntity<Car> modelMapping() {
        Car car = new Car("VW", "Polo");
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/hello/{path_var}")
    public ResponseEntity<String> usePathVariable(@PathVariable String path_var) {
        return ResponseEntity.ok(path_var);
    }

    @GetMapping("/hello/")
    public ResponseEntity<String> useRequestParam(@RequestParam String req_param) {
        return ResponseEntity.ok(req_param);
    }

    @GetMapping("/hello/req_param_list/")
    public ResponseEntity<List<String>> useRequestParamList(@RequestParam List<String> req_param) {
        return ResponseEntity.ok(req_param);
    }

    @PostMapping("/model/")
    public ResponseEntity<Car> newCar(@RequestBody Car car){
        return ResponseEntity.ok().body(car);
    }
}
