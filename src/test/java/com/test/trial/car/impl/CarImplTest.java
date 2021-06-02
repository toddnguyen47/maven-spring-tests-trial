package com.test.trial.car.impl;

import java.util.ArrayList;
import java.util.List;

import javax.management.InvalidAttributeValueException;

import com.test.trial.AppConfig;
import com.test.trial.car.Car;
import com.test.trial.car.Manufacturer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;
import org.junit.Before;

// @RunWith(SpringJUnit4ClassRunner.class)
@PrepareForTest(Manufacturer.class)
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CarImplTest {
	@Autowired
	private ApplicationContext applicationContext;

	private Car carImpl;

	@Before
	public void setup() {
		this.carImpl = applicationContext.getBean(Car.class);
	}

	@Test
	public void testShouldReturnNMilesDriven() {
		int nMiles = 5;
		int milesDrivenActual = this.carImpl.driveForNMiles(nMiles);

		Assert.assertEquals(nMiles, milesDrivenActual);
	}

	@Test(expected = Test.None.class)
	public void testShouldBeAbleToMockStaticFunctions() throws InvalidAttributeValueException {
		PowerMockito.mockStatic(Manufacturer.class);
		List<String> expectedList = new ArrayList<>();
		String manufacturer = "Mercedes Benz";
		expectedList.add(manufacturer);
		PowerMockito.when(Manufacturer.getListOfManufacturers(Matchers.anyListOf(String.class)))
				.thenReturn(expectedList);
		this.carImpl.setManufacturer(manufacturer);

		this.carImpl.getManufacturer();
	}
}
