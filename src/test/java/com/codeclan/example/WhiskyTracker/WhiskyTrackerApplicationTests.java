package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetWhiskeyByYear(){
		List<Whisky> whiskiesByYear = whiskyRepository.findByYear((2018));
		assertEquals(6, whiskiesByYear.size());
	}

	@Test
	public void canGetDistilleriesByRegion(){
		List<Distillery> distilleriesByRegion = distilleryRepository.findByRegion("Speyside");
		assertEquals(3, distilleriesByRegion.size());
	}

	@Test
	public void canGetWhiskyByDistilleryOfAge(){
		List<Whisky> whiskeyFromGlendronachAged15 = whiskyRepository.findByAgeAndDistilleryName(15, "Glendronach");
		assertEquals(1, whiskeyFromGlendronachAged15.size());

	}

	@Test
	public void canGetAllWhiskeyFromRegion(){
		List<Whisky> whiskeyFromRegion = whiskyRepository.findByDistilleryRegion("Highland");
		assertEquals(7, whiskeyFromRegion.size());
	}

	@Test
	public void canGetWhiskiesFromDistilleriesOverAge(){
		List<Distillery> allWhiskiesOverAge = distilleryRepository.findByWhiskiesAge(12);
		assertEquals(10, allWhiskiesOverAge.size());
		System.out.println(allWhiskiesOverAge);
	}

}
