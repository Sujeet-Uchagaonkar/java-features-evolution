package com.evolution.javafeatures.v21.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/features/v21/virtual-threads-demo")
public class VirtualThreadDemoController {


    @GetMapping(path = "/heavy-task")
    public String runHeavyTask() throws InterruptedException {
        //Simulate heavy task e.g. DB operation which is taking 4 seconds
        TimeUnit.SECONDS.sleep(2);
        return "Thread "+Thread.currentThread().toString()+" is completed";
    }


}
