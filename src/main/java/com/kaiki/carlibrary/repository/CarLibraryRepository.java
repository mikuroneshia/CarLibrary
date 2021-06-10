package com.kaiki.carlibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaiki.carlibrary.entity.CarLibraryEntity;


@Repository
public interface CarLibraryRepository extends JpaRepository<CarLibraryEntity, String> {
	List<CarLibraryEntity>findByName(String name);
	//Optional<CarLibraryEntity> findById(int id);
	//List<CarLibraryEntity>findByCar_type(String car_type);
}
