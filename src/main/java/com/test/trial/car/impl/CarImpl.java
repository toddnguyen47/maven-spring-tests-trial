package com.test.trial.car.impl;

import com.test.trial.car.Car;
import com.test.trial.car.Wheel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.System.out;

@Service
public class CarImpl implements Car {

	@Autowired
	private Wheel wheels;

	@Override
	public void drive() {
		out.println("I am in CarImpl class!");
		out.printf("I have %d wheels\n", wheels.getNumberOfWheels());
	}
}
