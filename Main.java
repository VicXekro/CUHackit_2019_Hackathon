package com.dragonboard.led;

public class Main {

	public static void main(String[] args) {
		int count = 0;
		int buttonValue = 0;

		GpioProcessor gpioProcessor = new GpioProcessor();

		/* Get reference of GPIO27 and GPIO29.* */
		Gpio gpioPin27 = gpioProcessor.getPin27();
		Gpio gpioPin29 = gpioProcessor.getPin29();

		/*
		 * Set GPIO27 as output.Set GPIO29 as input.
		 */
		gpioPin27.out();
		gpioPin29.in();

		while (count < 20) {

			count++;
			/* Read value of GPIO29. */
			buttonValue = gpioPin29.getValue();

			if (buttonValue == 0) {
				// Set GPIO27 as low level.
				gpioPin27.low();
			} else {
				// Set GPIO27 as high level.
				gpioPin27.high();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		/* Disable access GPIO27 and GPIO29. */
		gpioProcessor.closePins();
	}
}
