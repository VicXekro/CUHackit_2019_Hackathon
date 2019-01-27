

/**
 * Created by Ara on 7/21/15.
 */

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/*
 This class abstracts the use of the gpio pins. This class can be utilized on any linux operating
 system that has gpio pins defined in the /sys/class/gpio directory. It is required that the gpio
 pins themselves are available for access by the user of this application, and may require a
 change of permissions.
 */
public class GpioProcessor {
	public static final String TAG = "GpioProcessor";
	private String PATH = "/sys/class/gpio";
	private List<Integer> pins = new ArrayList<Integer>();

	public GpioProcessor() {
	}

	/**
	 * Get function of specific pin.
	 * @param pin Desirable pin.
	 */
	public Gpio getPin(int pin) {
		exportPin(pin);
		pins.add(pin);
		return new Gpio(pin);
	}

	/**
	 * Get pin 23;
	 * @returns {Gpio}
	 */
	public Gpio getPin23() {
		return getPin(36);
	}

	/**
	 * Get pin 24.
	 * @returns {Gpio}
	 */
	public Gpio getPin24() {
		return getPin(12);
	}

	/**
	 * Get pin 25.
	 * @returns {Gpio}
	 */
	public Gpio getPin25() {
		return getPin(13);
	}

	/**
	 * Get pin 26.
	 * @returns {Gpio}
	 */
	public Gpio getPin26() {
		return getPin(69);
	}

	/**
	 * Get pin 27.
	 * @returns {Gpio}
	 */
	public Gpio getPin27() {
		return getPin(115);
	}

	/**
	 * Get pin 28.
	 * @returns {Gpio}
	 */
	public Gpio getPin28() {
		return getPin(901);
	}

	/**
	 * Get pin 29.
	 * @returns {Gpio}
	 */
	public Gpio getPin29() {
		return getPin(24);
	}

	/**
	 * Get pin 30.
	 * @returns {Gpio}
	 */
	public Gpio getPin30() {
		return getPin(25);
	}

	/**
	 * Get pin 31.
	 * @returns {Gpio}
	 */
	public Gpio getPin31() {
		return getPin(35);
	}


	/**
	 * Get pin 32.
	 * @returns {Gpio}
	 */
	public Gpio getPin32() {
		return getPin(34);
	}

	/**
	 * Get pin 33.
	 * @returns {Gpio}
	 */
	public Gpio getPin33() {
		return getPin(28);
	}

	/**
	 * Get pin 34.
	 * @returns {Gpio}
	 */
	public Gpio getPin34() {
		return getPin(33);
	}

	/**
	 * Get all GPIO's pins.
	 * @return List of pins.
	 */
	public Gpio[] getAllPins() {
		Gpio[] allPins = new Gpio[12];

		allPins[0] = getPin23();
		allPins[1] = getPin24();
		allPins[2] = getPin25();
		allPins[3] = getPin26();
		allPins[4] = getPin27();
		allPins[5] = getPin28();
		allPins[6] = getPin29();
		allPins[7] = getPin30();
		allPins[8] = getPin31();
		allPins[9] = getPin32();
		allPins[10] = getPin33();
		allPins[11] = getPin34();

		return allPins;
	}

	/**
	 * Enable access to GPIO.
	 * @param pin GPIO pin to access.
	 */
	private void exportPin(int pin) {
		System.out.println("Exporting Ping");
		BufferedWriter out = null;
		try {
			FileWriter fstream = new FileWriter(PATH + "/export", false); // t
			out = new BufferedWriter(fstream);
			out.write(String.valueOf(pin));
			out.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	/**
	 * Disable access to GPIO.
	 * @param pin GPIO pin to disable access.
	 */
	private void unexportPin(int pin) {
		System.out.println("unExporting Ping");
		BufferedWriter out = null;
		try {
			FileWriter fstream = new FileWriter(PATH + "/unexport", false); // t
			out = new BufferedWriter(fstream);
			out.write(String.valueOf(pin));
			out.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void closePins() {
		for (Integer pin : pins) {
			unexportPin(pin);
		}
		pins.clear();
	}
}
