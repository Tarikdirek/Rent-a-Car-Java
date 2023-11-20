package com.example.demo.controllers;

import com.example.demo.business.abstracts.ColorService;
import com.example.demo.entities.Category;
import com.example.demo.entities.Color;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/colors")
public class ColorsController {

    @Autowired
    public ColorService colorService;

    @GetMapping("/getAll")
    public List<Color> getAll(){
        var result = colorService.getALl();
        return result;
    }

    @GetMapping("/getById/{id}")
    public Color getById(@PathVariable int id) {
        var result =colorService.getById(id);
        return result;
    }


    @PostMapping("/add")
    public String add(@RequestBody Color color){

        // individualService.add(individual);
        colorService.add(color);

        return "Color added";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable int id){
        colorService.delete(id);
        return "Color deleted";
    }

    @PutMapping("update")
    public String update(@RequestBody Color color){
        colorService.update(color);
        return "Color updated";
    }


}
