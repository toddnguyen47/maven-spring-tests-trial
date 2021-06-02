package com.test.trial.car;

import javax.management.InvalidAttributeValueException;

public interface Car {
	public void drive();

	public int driveForNMiles(int nMiles);

	public String getManufacturer() throws InvalidAttributeValueException;

	public void setManufacturer(String manufacturer);
}