package com.test.trial.car;

import java.util.ArrayList;
import java.util.List;

public class Manufacturer {
	public final static List<String> getListOfManufacturers(List<String> extraManufacturers) {
		List<String> listOfManufacturers = new ArrayList<>();
		listOfManufacturers.add("Toyota");
		listOfManufacturers.add("Honda");
		listOfManufacturers.addAll(extraManufacturers);

		return listOfManufacturers;
	}
}
