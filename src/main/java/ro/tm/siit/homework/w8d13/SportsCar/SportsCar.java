package ro.tm.siit.homework.w8d13.SportsCar;

import java.util.Scanner;

/**
 * Main class modelling a Sport Car. It contains relevant information about a
 * sports car model, tye, horse power and top speed
 * 
 * @author mircea
 * @version 1.0
 */
public class SportsCar {

	String modelName;
	String type;
	int horsepower;
	int topSpeed;
	public static Scanner input = new Scanner(System.in);

	/**
	 * Constructor for class SportsCar
	 * 
	 * @param modelName
	 * @param type
	 * @param horsepower
	 * @param topSpeed
	 */
	public SportsCar(String modelName, String type, int horsepower, int topSpeed) {

		this.modelName = modelName;
		this.type = type;
		this.horsepower = horsepower;
		this.topSpeed = topSpeed;
	}

	/**
	 * 
	 * @return param modelName
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * 
	 * @return param type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @return param horsepower
	 */
	public int getHorsepower() {
		return horsepower;
	}

	/**
	 * 
	 * @return param topSpeed
	 */
	public int getTopSpeed() {
		return topSpeed;
	}

	/**
	 * Checks equality on modelName and horsepower and topSpeed
	 * 
	 * @param another
	 *            of type SportsCar
	 * @return true on equality
	 */
	public boolean equals(SportsCar another) {
		if (another.getModelName() == this.getModelName() && another.getHorsepower() == this.getHorsepower()
				&& another.getTopSpeed() == this.getTopSpeed())
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "Model: " + getModelName() + "\n" + "Horse power: " + getHorsepower() + "\n" + "Top speed: "
				+ getTopSpeed();
	}

}
