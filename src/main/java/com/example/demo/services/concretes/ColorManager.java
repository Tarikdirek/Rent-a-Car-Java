package com.example.demo.services.concretes;

import com.example.demo.services.abstracts.ColorService;
import com.example.demo.entities.Color;
import com.example.demo.repositories.ColorRepository;
import com.example.demo.services.dtos.brand.responses.GetListBrandResponseWithId;
import com.example.demo.services.dtos.color.requests.AddColorRequest;
import com.example.demo.services.dtos.color.requests.DeleteColorRequest;
import com.example.demo.services.dtos.color.requests.UpdateColorRequest;
import com.example.demo.services.dtos.color.responses.GetListColorResponse;
import com.example.demo.services.dtos.color.responses.GetListColorResponseWithId;
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

    public GetListColorResponseWithId findColorByName(String name) {
        return colorRepository.findAll().stream()
                .filter(color -> color.getName().equals(name))
                .map(color -> new GetListColorResponseWithId(color.getId(),color.getName())).findAny().orElseThrow();
    }

    public List<GetListColorResponse> getColorByOrder() {
        return colorRepository.getColorByOrder();
    }

    public List<GetListColorResponseWithId> getALl() {
        return  colorRepository.findAll().stream()
                .map(color -> new GetListColorResponseWithId(color.getId(), color.getName())).toList();

    }

    public GetListColorResponseWithId getById(int id) {
        return colorRepository.findAll().stream().filter(color -> color.getId()==id)
                .map(color -> new GetListColorResponseWithId(color.getId(),color.getName()))
                .findAny().orElseThrow();

    }
}
