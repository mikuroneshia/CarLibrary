package com.kaiki.carlibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kaiki.carlibrary.entity.CarLibraryEntity;
import com.kaiki.carlibrary.model.CarModel;
import com.kaiki.carlibrary.repository.CarLibraryRepository;

@Controller
@RequestMapping("edit")
@SessionAttributes("cModel")
public class CarEditController {
	@Autowired
	CarLibraryRepository repository;
	@RequestMapping(method=RequestMethod.GET)
	public String toEdit(@RequestParam int id,@ModelAttribute("cModel") CarModel cModel,Model model) {
		//System.out.println("id:"+id);
		List<CarLibraryEntity>list=repository.findAll();
		for(CarLibraryEntity car:list) {
			if(car.getId()==id) {
				cModel.setId(car.getId());
				cModel.setName(car.getName());
				cModel.setCar_type(car.getCar_type());
				cModel.setMaker(car.getMaker());
				cModel.setModel(car.getModel());
				cModel.setDisplacement(car.getDisplacement());
				cModel.setFuel(car.getFuel());
				cModel.setFuel_economy(car.getFuel_economy());
				cModel.setDrive_system(car.getDrive_system());
				cModel.setPrice(car.getPrice());
				cModel.setLength(car.getLength());
				cModel.setWidth(car.getWidth());
				cModel.setHeight(car.getHeight());
				model.addAttribute("cModel",cModel);
			}
		}
		return "carEdit";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String edit(@ModelAttribute CarModel cModel,Model model) {
		CarLibraryEntity cEntity=new CarLibraryEntity();
		cEntity.setId(cModel.getId());
		cEntity.setName(cModel.getName());
		cEntity.setCar_type(cModel.getCar_type());
		cEntity.setMaker(cModel.getMaker());
		cEntity.setModel(cModel.getModel());
		cEntity.setDisplacement(cModel.getDisplacement());
		cEntity.setFuel(cModel.getFuel());
		cEntity.setFuel_economy(cModel.getFuel_economy());
		cEntity.setDrive_system(cModel.getDrive_system());
		cEntity.setPrice(cModel.getPrice());
		cEntity.setLength(cModel.getLength());
		cEntity.setWidth(cModel.getWidth());
		cEntity.setHeight(cModel.getHeight());
		repository.saveAndFlush(cEntity);
		repository.saveAndFlush(cEntity);
		model.addAttribute("message","変更が完了しました");
		return "carEdit";
	}

}
