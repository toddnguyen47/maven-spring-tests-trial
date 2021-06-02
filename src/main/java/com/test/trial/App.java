package com.test.trial;

import com.test.trial.car.Car;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		App app = new App();
		// app.execute(new String[] { "175" });
		app.executeCar();
	}

	public int returnTwo() {
		return 2;
	}

	public enum Planet {
		MERCURY(3.303e+23, 2.4397e6), VENUS(4.869e+24, 6.0518e6), EARTH(5.976e+24, 6.37814e6), MARS(6.421e+23, 3.3972e6),
		JUPITER(1.9e+27, 7.1492e7), SATURN(5.688e+26, 6.0268e7), URANUS(8.686e+25, 2.5559e7), NEPTUNE(1.024e+26, 2.4746e7);

		private final double mass; // in kilograms
		private final double radius; // in meters

		Planet(double mass, double radius) {
			this.mass = mass;
			this.radius = radius;
		}

		public double getMass() {
			return mass;
		}

		public double getRadius() {
			return radius;
		}

		// universal gravitational constant (m3 kg-1 s-2)
		public static final double G = 6.67300E-11;

		public double surfaceGravity() {
			return Planet.G * this.mass / (this.radius * this.radius);
		}

		public double surfaceWeight(double otherMass) {
			return otherMass * this.surfaceGravity();
		}
	}

	public void execute(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: java Planet <earth_weight>");
			System.exit(-1);
		}
		double earthWeight = Double.parseDouble(args[0]);
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		for (Planet p : Planet.values()) {
			System.out.printf("Your weight on %s is %f%n", p, p.surfaceWeight(mass));
			System.out.printf("Mass: %.2f, Radius: %.2f%n", p.getMass(), p.getRadius());
		}
	}

	public void executeCar() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		this.executeCarHelper(ctx);
		ctx.close();
	}

	private void executeCarHelper(AnnotationConfigApplicationContext ctx) {
		Car car = ctx.getBean(Car.class);
		car.drive();
	}
}
