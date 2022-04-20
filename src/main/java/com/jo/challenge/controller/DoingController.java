package com.jo.challenge.controller;

import com.jo.challenge.dto.Doing;
import com.jo.challenge.service.DoingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DoingController {
    private final DoingService doingService;

    @PostMapping("/doing")
    public void add(@RequestBody Doing doing) {
        doingService.addDoing(doing);
    }

    @PutMapping("/doing/{id}")
    public void edit(@RequestBody Doing doing) {doingService.editDoing(doing);}

    @GetMapping("/doing")
    public List<Doing> getAll(){return doingService.getAllDoing();}

    @GetMapping("/doing/{id}")
    public Optional<Doing> getDoingById(@PathVariable Long id) {return doingService.getDoingById(id);}

    @DeleteMapping("/doing/{id}")
    public void del(@PathVariable("id") Long id) {doingService.delDoing(id);}
}
