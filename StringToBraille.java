public class StringToBraille{
	
	Gpio gpioPin33;
	Gpio gpioPin31;
	Gpio gpioPin27;
	Gpio gpioPin25;
	
	public StringToBraille(){
		GpioProcessor gpioProcessor = new GpioProcessor();
		gpioPin33 = gpioProcessor.getPin33();
		gpioPin31 = gpioProcessor.getPin31();
		gpioPin27 = gpioProcessor.getPin27();
		gpioPin25 = gpioProcessor.getPin25();
		
		
		gpioPin27.out();
		gpioPin25.out();
		gpioPin31.out();
		gpioPin33.out();
		}
	
	public void punchASequence(){
		
			gpioPin25.low();
			gpioPin27.low();
			gpioPin31.low();
			gpioPin33.high();

			gpioPin25.low();
			gpioPin27.low();
			gpioPin31.high();
			gpioPin33.high();
			
			gpioPin25.low();
			gpioPin27.low();
			gpioPin31.high();
			gpioPin33.low();
			
			gpioPin25.low();
			gpioPin27.high();
			gpioPin31.high();
			gpioPin33.low();
			
			gpioPin25.low();
			gpioPin27.high();
			gpioPin31.low();
			gpioPin33.low();
		
			gpioPin25.high();
			gpioPin27.high();
			gpioPin31.low();
			gpioPin33.low();
			
			gpioPin25.high();
			gpioPin27.low();
			gpioPin31.low();
			gpioPin33.low();
		
			gpioPin25.high();
			gpioPin27.low();
			gpioPin31.low();
			gpioPin33.high();
		
		}
		
	public void punchBSequence(){
		
			gpioPin25.high();
			gpioPin27.low();
			gpioPin31.low();
			gpioPin33.low();

			gpioPin25.high();
			gpioPin27.high();
			gpioPin31.low();
			gpioPin33.low();
			
			gpioPin25.low();
			gpioPin27.high();
			gpioPin31.low();
			gpioPin33.low();
			
			gpioPin25.low();
			gpioPin27.high();
			gpioPin31.high();
			gpioPin33.low();
			
			gpioPin25.low();
			gpioPin27.low();
			gpioPin31.high();
			gpioPin33.low();
		
			gpioPin25.low();
			gpioPin27.low();
			gpioPin31.high();
			gpioPin33.high();
			
			gpioPin25.low();
			gpioPin27.low();
			gpioPin31.low();
			gpioPin33.high();
		
			gpioPin25.high();
			gpioPin27.low();
			gpioPin31.low();
			gpioPin33.high();
		
		}
	
	public static void main(String[]args){
		StringToBraille s = new StringToBraille();
		
		while(true){
			
			for(int i=0; i<40;i++){
				s.punchASequence();
			}
			try{
				
				Thread.sleep(1000);
				
				}catch(InterruptedException e){
					e.printStackTrace();
					}
					
			for(int i=0; i<70; i++){		
			s.punchBSequence();
			}
			
			try{
				
				Thread.sleep(1000);
				
				}catch(InterruptedException e){
					e.printStackTrace();
				}
		}
		
		
		//gpioProcessor.closePins();
		
		}
	}
