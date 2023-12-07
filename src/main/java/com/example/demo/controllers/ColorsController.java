package com.example.demo.controllers;

import com.example.demo.services.abstracts.ColorService;
import com.example.demo.entities.Color;
import com.example.demo.services.dtos.color.requests.AddColorRequest;
import com.example.demo.services.dtos.color.requests.DeleteColorRequest;
import com.example.demo.services.dtos.color.requests.UpdateColorRequest;
import com.example.demo.services.dtos.color.responses.GetListColorResponse;
import com.example.demo.services.dtos.color.responses.GetListColorResponseWithId;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/colors")
public class ColorsController {


    public ColorService colorService;

    @GetMapping("/getAll")
    public List<GetListColorResponseWithId> getAll(){
        return colorService.getALl();

    }

    @GetMapping("/getById/{id}")
    public Color getById(@PathVariable int id) {
        return  colorService.getById(id);

    }

    @GetMapping("/getByColorName")
    public GetListColorResponseWithId findColorByName(String name) {
        return colorService.findColorByName(name);
    }
    @GetMapping("/getColorsByOrder")
    public List<GetListColorResponse> getTop3Color() {
        return colorService.getColorByOrder();
    }


    @PostMapping("/add")
    public String add(@RequestBody @Valid AddColorRequest request){

        colorService.add(request);

        return "Color added";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody @Valid DeleteColorRequest request){
        colorService.delete(request);
        return "Color deleted";
    }

    @PutMapping("/update")
    public String update(@RequestBody @Valid UpdateColorRequest request){
        colorService.update(request);
        return "Color updated";
    }


}
