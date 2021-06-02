package com.test.trial.car.impl;

import com.test.trial.car.Wheel;

import org.springframework.stereotype.Service;

@Service
public class WheelImpl implements Wheel {

	@Override
	public int getNumberOfWheels() {
		return 4;
	}

}
