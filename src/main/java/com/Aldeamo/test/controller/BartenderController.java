package com.Aldeamo.test.controller;


import com.Aldeamo.test.service.BartenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bartender")
public class BartenderController {

    @Autowired
    BartenderService bartenderService;

    @GetMapping(path = "/{q}/{id}")
    public String processRequest(@PathVariable int q, @PathVariable Integer id){
        return bartenderService.Request(q, id);
    }

}
