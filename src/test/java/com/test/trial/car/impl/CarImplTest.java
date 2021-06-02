package com.test.trial.car.impl;

import com.test.trial.AppConfig;
import com.test.trial.car.Car;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Assert;
import org.junit.Before;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
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
}
