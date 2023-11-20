package com.example.demo.business.abstracts;

import com.example.demo.entities.Color;

import java.util.List;

public interface ColorService {
    void add(Color color);
    void update(Color color);
    void delete(int id);

    List<Color> getALl();
    Color getById(int id);
}
