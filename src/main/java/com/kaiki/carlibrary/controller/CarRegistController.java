package com.kaiki.carlibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kaiki.carlibrary.entity.CarLibraryEntity;
import com.kaiki.carlibrary.model.CarModel;
import com.kaiki.carlibrary.repository.CarLibraryRepository;

@Controller
@RequestMapping("regist")
@SessionAttributes("cModel")
public class CarRegistController {
	@Autowired
	CarLibraryRepository repository;
	@RequestMapping(method=RequestMethod.GET)
	public String toregist(Model model) {
		List<CarLibraryEntity>list=repository.findAll();
		model.addAttribute("list",list);
		return "carRegist";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String regist(@ModelAttribute CarModel cModel,Model model) {
		CarLibraryEntity cEntity=new CarLibraryEntity();
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
		List<CarLibraryEntity>list=repository.findAll();
		model.addAttribute("list",list);
		return "carRegist";
	}
}
