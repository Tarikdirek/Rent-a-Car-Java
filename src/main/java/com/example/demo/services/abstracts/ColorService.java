package com.example.demo.services.abstracts;

import com.example.demo.entities.Color;
import com.example.demo.services.dtos.color.requests.AddColorRequest;
import com.example.demo.services.dtos.color.requests.DeleteColorRequest;
import com.example.demo.services.dtos.color.requests.UpdateColorRequest;
import com.example.demo.services.dtos.color.responses.GetListColorResponse;

import java.util.List;

public interface ColorService {
    void add(AddColorRequest request);
    void update(UpdateColorRequest request);
    void delete(DeleteColorRequest request);

    Color findColorByName(String name);
    List<GetListColorResponse> getColorByOrder();

    List<Color> getALl();
    Color getById(int id);
}
