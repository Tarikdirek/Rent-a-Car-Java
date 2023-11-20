package com.example.demo.business.concretes;

import com.example.demo.business.abstracts.ColorService;
import com.example.demo.entities.Color;
import com.example.demo.repositories.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ColorManager implements ColorService {

    @Autowired
    public final ColorRepository colorRepository;

    public void add(Color color) {
        colorRepository.save(color);
    }

    public void update(Color color) {
        Color colorToUpdate = colorRepository.findById(color.getId()).orElseThrow();
        colorToUpdate.setName(color.getName());
        colorRepository.saveAndFlush(colorToUpdate);
    }

    public void delete(int id) {
        Color colorToUpdate = colorRepository.findById(id).orElseThrow();
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
