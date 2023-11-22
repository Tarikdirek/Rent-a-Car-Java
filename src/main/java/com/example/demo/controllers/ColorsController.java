package com.example.demo.controllers;

import com.example.demo.services.abstracts.ColorService;
import com.example.demo.entities.Color;
import com.example.demo.services.dtos.color.requests.AddColorRequest;
import com.example.demo.services.dtos.color.requests.DeleteColorRequest;
import com.example.demo.services.dtos.color.requests.UpdateColorRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/colors")
public class ColorsController {


    public ColorService colorService;

    @GetMapping("/getAll")
    public List<Color> getAll(){
        var result = colorService.getALl();
        return result;
    }

    @GetMapping("/getById")
    public Color getById(@PathVariable int id) {
        var result =colorService.getById(id);
        return result;
    }


    @PostMapping("/add")
    public String add(@RequestBody AddColorRequest request){

        colorService.add(request);

        return "Color added";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody DeleteColorRequest request){
        colorService.delete(request);
        return "Color deleted";
    }

    @PutMapping("/update")
    public String update(@RequestBody UpdateColorRequest request){
        colorService.update(request);
        return "Color updated";
    }


}
