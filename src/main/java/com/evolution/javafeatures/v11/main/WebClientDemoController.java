package com.evolution.javafeatures.v11.main;

import com.evolution.javafeatures.v11.entity.Device;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/features/v11/web-client-demo")
public class WebClientDemoController {

    private final WebClient customWebClient;


    @GetMapping(path = "/object/{id}")
    ResponseEntity<?> getObjectWebCall(@PathVariable Integer id){

        //The .block() method waits for the HTTP response and returns the result directly.
        //This is not recommended in reactive applications because it blocks the event loop, but it can be used in traditional (non-reactive) code.
        Device response = customWebClient.get().uri("/objects/"+String.valueOf(id))
               .retrieve()
               .bodyToMono(Device.class).block();



        //Non-blocking (asynchronous) — using callbacks (subscribe) or reactive operators (map, flatMap, etc.)
        //Instead of blocking, you subscribe to the Mono or Flux and provide a callback for when the data arrives.
        customWebClient.get().uri("/objects/"+String.valueOf(id))
                .retrieve().bodyToMono(Device.class)
                .subscribe(
                        validResponse -> System.out.println("Webflux async response :"+validResponse), // onNext
                        error -> System.out.println("Webflux async error :"+error), // onError
                        () -> System.out.println("Webflux async process completed!") // onComplete
                );
        //Use Mono when your operation logically produces at most one result.
        //Use Flux when you expect multiple results or a continuous stream.

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/objects")
    ResponseEntity<Flux<Device>> getObjects(){
        return new ResponseEntity<>(customWebClient.get().uri("/objects")
                .retrieve().bodyToFlux(Device.class), HttpStatus.OK);
    }


    @PostMapping(path = "/objects", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> createobject(@RequestBody Device device) {
       return new ResponseEntity<>(customWebClient.post().uri("/objects").bodyValue(device)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve().bodyToMono(Device.class), HttpStatus.CREATED);
    }





}
