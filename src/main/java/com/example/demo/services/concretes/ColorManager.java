package com.example.demo.services.concretes;

import com.example.demo.services.abstracts.ColorService;
import com.example.demo.entities.Color;
import com.example.demo.repositories.ColorRepository;
import com.example.demo.services.dtos.color.requests.AddColorRequest;
import com.example.demo.services.dtos.color.requests.DeleteColorRequest;
import com.example.demo.services.dtos.color.requests.UpdateColorRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ColorManager implements ColorService {


    public final ColorRepository colorRepository;

    public void add(AddColorRequest request)
    {
        Color color = new Color();
        color.setName(request.getName());
        colorRepository.save(color);
    }

    public void update(UpdateColorRequest request) {
        Color colorToUpdate = colorRepository.findById(request.getId()).orElseThrow();
        colorToUpdate.setName(request.getName());
        colorRepository.saveAndFlush(colorToUpdate);
    }

    public void delete(DeleteColorRequest request) {
        Color colorToUpdate = colorRepository.findById(request.getId()).orElseThrow();
        colorRepository.delete(colorToUpdate);
    }

    public List<Color> getALl() {
        var result = colorRepository.findAll();
        return result;
    }

    public Color getById(int id) {
        var result = colorRepository.findById(id).orElseThrow();
        return result;
    }
}
