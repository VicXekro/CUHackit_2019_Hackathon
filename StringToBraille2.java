public class StringToBraille2{
	
	Gpio gpioPin33;
	Gpio gpioPin31;
	Gpio gpioPin27;
	Gpio gpioPin25;
	GpioProcessor gpioProcessor;
	
	int steps=0;
	boolean direction=true;
	long lastime;
	long currentMillis;
	int steps_left=4095;
	long time;
	
	public StringToBraille2(){
		gpioProcessor = new GpioProcessor();
		gpioPin33 = gpioProcessor.getPin33();
		gpioPin31 = gpioProcessor.getPin31();
		gpioPin27 = gpioProcessor.getPin27();
		gpioPin25 = gpioProcessor.getPin25();
		
		
		gpioPin27.out();
		gpioPin25.out();
		gpioPin31.out();
		gpioPin33.out();
		}
	
	public void stepper(int length){
		for(int i=0;i<length; i++){
			switch(steps){
				case 0:
					gpioPin25.low();
					gpioPin27.low();
					gpioPin31.low();
					gpioPin33.high();
				break;
				case 1:
					gpioPin25.low();
					gpioPin27.low();
					gpioPin31.high();
					gpioPin33.high();
				break;
				case 2:
					gpioPin25.low();
					gpioPin27.low();
					gpioPin31.high();
					gpioPin33.low();
				break;
				case 3:
					gpioPin25.low();
					gpioPin27.high();
					gpioPin31.high();
					gpioPin33.low();
				break;
				case 4:
					gpioPin25.low();
					gpioPin27.high();
					gpioPin31.low();
					gpioPin33.low();
				break;
				case 5:
					gpioPin25.high();
					gpioPin27.high();
					gpioPin31.low();
					gpioPin33.low();
				break;
				case 6:
				break;
				case 7:
				break;
				default:
				break;
				}
			}
		
		}
	
	}
