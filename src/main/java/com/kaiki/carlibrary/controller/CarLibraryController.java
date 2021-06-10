package com.kaiki.carlibrary.controller;

import java.util.ArrayList;
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
@SessionAttributes("cModel")
@RequestMapping("/")
public class CarLibraryController {
	@Autowired
	CarLibraryRepository repository;

	@ModelAttribute("cModel")
	public CarModel setCarModel() {
		return new CarModel();
	}

	@RequestMapping(method=RequestMethod.GET)
	public String toCarLlibrary(Model model) {
		return "carlibrary";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String explore(@ModelAttribute CarModel cModel,Model model) {
		//System.out.println(cModel.ispCar_type());
		//System.out.println(cModel.ispMaker());
		cModel.setpId(true);
		cModel.setpName(true);
		List<CarLibraryEntity>list=repository.findAll();
		ArrayList<CarLibraryEntity>list2=new ArrayList<>();
		ArrayList<CarLibraryEntity>list3=new ArrayList<>();
		ArrayList<CarLibraryEntity>list4=new ArrayList<>();
		ArrayList<CarLibraryEntity>list5=new ArrayList<>();
		ArrayList<CarLibraryEntity>list6=new ArrayList<>();
		ArrayList<CarLibraryEntity>list7=new ArrayList<>();
		String name=cModel.getName();
		String car_type=cModel.getCar_type();
		String maker=cModel.getMaker();
		String model2=cModel.getModel();
		String dicePlacement=cModel.getDisplacement();
		String fuel=cModel.getFuel();
		String fuel_economy=cModel.getFuel_economy();
		String drive_system=cModel.getDrive_system();
		for(CarLibraryEntity car:list) {
			if(name.equals(car.getName())) {
				list2.add(car);
			}
		}
		if(list2.isEmpty()) {
			for(CarLibraryEntity car:list) {
				if(car_type.equals(car.getCar_type())) {
					list3.add(car);
				}
			}
		}else {
			for(CarLibraryEntity car2:list2) {
				if(car_type==null||car_type.equals("")) {
					list3.add(car2);
				}
				else if(car_type.equals(car2.getCar_type())) {
					list3.add(car2);
				}
			}
		}
		if(list3.isEmpty()) {
			for(CarLibraryEntity car:list) {
				if(maker.equals(car.getMaker())) {
					list4.add(car);
				}
			}
		}else {
			for(CarLibraryEntity car3:list3) {
				if(maker==null||maker.equals("")) {
					list4.add(car3);
				}
				else if(maker.equals(car3.getMaker())) {
					list4.add(car3);
				}
			}
		}
		if(list4.isEmpty()) {
			for(CarLibraryEntity car:list) {
				if(model2.equals(car.getModel())) {
					list5.add(car);
				}
			}
		}else {
			for(CarLibraryEntity car4:list4) {
				if(model2==null||model2.equals("")) {
					list5.add(car4);
				}
				else if(model2.equals(car4.getModel())) {
					list5.add(car4);
				}
			}
		}
		if(list5.isEmpty()) {
			for(CarLibraryEntity car:list) {
				if(fuel.equals(car.getFuel())) {
					list6.add(car);
				}
			}
		}else {
			for(CarLibraryEntity car5:list5) {
				if(fuel==null||fuel.equals("")) {
					list6.add(car5);
				}
				else if(maker.equals(car5.getMaker())) {
					list6.add(car5);
				}
			}
		}
		if(list6.isEmpty()) {
			for(CarLibraryEntity car:list) {
				if(fuel.equals(car.getFuel())) {
					list7.add(car);
				}
			}
		}else {
			for(CarLibraryEntity car6:list6) {
				if(drive_system==null||drive_system.equals("")) {
					list7.add(car6);
				}
				else if(maker.equals(car6.getMaker())) {
					list7.add(car6);
				}
			}
		}
		model.addAttribute("list",list7);
		if(list7.isEmpty()) {
			model.addAttribute("message","検索に該当するものがありませんでした");
		}
		return "carlibrary";
	}
	@RequestMapping(method=RequestMethod.POST,params="all")
	public String all(@ModelAttribute("cModel") CarModel cModel,Model model) {
		//System.out.println(cModel.ispCar_type());
		//System.out.println(cModel.ispMaker());
		cModel.setpId(true);
		cModel.setpName(true);
		List<CarLibraryEntity>list=repository.findAll();
		model.addAttribute("list",list);
		return "carlibrary";
	}
}
