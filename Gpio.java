

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Gpio {
	public static final int HIGH = 1;
	public static final int LOW = 0;
	private int pin;
	private String PATH = "/sys/class/gpio";

	/**
	 * Set desirable pin for the GPIO class.
	 */
	public Gpio(int pin) {
		System.out.println("Initializing pin " + pin);
		this.pin = pin;
	}

	/**
	 * Set pin direction.
	 * @param pin Desirable pin.
	 * @param pin Direction of pin.
	 *      in -> Input.
	 *      out -> Output.
	 * 
	 */
	private void setDirection(String direction) {
		System.out.println("Setting Direction");
		BufferedWriter out = null;
		try {
			FileWriter fstream = new FileWriter(PATH + "/gpio" + pin
					+ "/direction", false); 
			out = new BufferedWriter(fstream);
			out.write(direction);
			out.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * Set pin value.
	 * @param pin Desirable pin.
	 * @param value Value of pin.
	 * 	0 -> Low Level.
	 *	1 -> High Level
	 */
	private void setValue(int value) {
		System.out.println("Setting Value");
		BufferedWriter out = null;
		try {
			FileWriter fstream = new FileWriter(
					PATH + "/gpio" + pin + "/value", false); // t
			out = new BufferedWriter(fstream);
			out.write(Integer.toString(value));
			out.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * Get pin direction.
	 * @param pin Desirable pin.
	 * @returns Direction of pin
	 *      in -> Input.
	 *      out -> Output.
	 */
	public String getDirection() {
		System.out.println("Getting Direction");
		BufferedReader br;
		String line = "";
		try {
			br = new BufferedReader(new FileReader(PATH + "/gpio" + pin
					+ "/direction"));
			line = br.readLine();
			br.close();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());

		}

		return line;
	}

	/**
	 * Get pin value.
	 * @param pin Desirable pin.
	 * @returns Value of pin
	 * 	0 -> Low Level.
	 *	1 -> High Level
	 */
	public int getValue() {
		System.out.println("Getting Value");
		BufferedReader br;
		String line = "";
		try {
			br = new BufferedReader(new FileReader(PATH + "/gpio" + pin
					+ "/value"));
			line = br.readLine();
			br.close();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());

		}

		return Integer.parseInt(line);
	}

	/**
	 * Set pin as high.
	 */
	public void high() {
		setValue(Gpio.HIGH);
	}

	/**
	 * Set pin as low.
	 */
	public void low() {
		setValue(Gpio.LOW);
	}

	/**
	 * Set pin as output.
	 */
	public void out() {
		setDirection("out");
	}

	/**
	 * Set pin as input.
	 * @param pin - Desirable pin.
	 */
	public void in() {
		setDirection("in");
	}
}
