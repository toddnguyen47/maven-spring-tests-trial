package com.test.trial.car.impl;

import com.test.trial.car.Car;
import com.test.trial.car.Manufacturer;
import com.test.trial.car.Wheel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.System.out;

import java.util.List;

import javax.management.InvalidAttributeValueException;

@Service
public class CarImpl implements Car {
	private String manufacturer = "";

	@Autowired
	private Wheel wheels;

	@Override
	public void drive() {
		out.println("I am in CarImpl class!");
		out.printf("I have %d wheels\n", wheels.getNumberOfWheels());
	}

	@Override
	public int driveForNMiles(int nMiles) {
		out.printf("I have driven for %d miles \n", nMiles);
		return nMiles;
	}

	@Override
	public String getManufacturer() throws InvalidAttributeValueException {
		List<String> manufacturers = Manufacturer.getListOfManufacturers(null);
		if (!manufacturers.contains(this.manufacturer)) {
			String msg = String.format("Manufacturer '%s' not found in list of manufacturers", this.manufacturer);
			throw new InvalidAttributeValueException(msg);
		}
		return this.manufacturer;
	}

	@Override
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
}
