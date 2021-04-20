package com.maczak.jaz3;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

    @GetMapping({"/get/{pVar}", "/get/"})
    ResponseEntity<String> getHomework(@PathVariable Optional<String> pVar, @RequestParam Optional<String> rParam){
        if(pVar.isPresent()){
            return ResponseEntity.ok("Path variable exists: " + pVar.get());
        }
        if(rParam.isPresent()){
            return ResponseEntity.ok("Request param exists: " + rParam.get());
        }
        return ResponseEntity.ok("Nothing here :(");
    }

    @PostMapping("/post/")
    ResponseEntity<Object> postHomework(@RequestBody Optional<Object> objectOptional){
        if(objectOptional.isPresent()){
            return ResponseEntity.ok(objectOptional);
        }else {
            return ResponseEntity.ok("Empty.");
        }
    }

    @PutMapping({"/put/{pVar}", "/put/"})
    ResponseEntity<Object> putHomework(@PathVariable Optional<String> pVar, @RequestBody Optional<Car> car){
        if(pVar.isPresent()){
            return ResponseEntity.ok(pVar);
        }
        if(car.isPresent()){
            return ResponseEntity.ok(car);
        }
        return ResponseEntity.ok("Nothing here");
    }

    @DeleteMapping("/delete/{pVar}")
    HttpStatus deleteWithPathVar(@PathVariable Optional<Object> pVar) {
        if(pVar.isPresent()){
            System.out.println("Received: "+ pVar.get());
        }
        return HttpStatus.OK;
    }
}
