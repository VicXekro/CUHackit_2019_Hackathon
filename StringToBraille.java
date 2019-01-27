public class StringToBraille{
	
	Gpio gpioPin33;
	Gpio gpioPin31;
	Gpio gpioPin27;
	Gpio gpioPin25;
	GpioProcessor gpioProcessor;
	
	public StringToBraille(){
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
		
	public GpioProcessor getGpioProcessor(){
		return gpioProcessor;
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
		
	public void resetSequence(){
		
			gpioPin25.high();
			gpioPin27.low();
			gpioPin31.low();
			gpioPin33.low();
			
			gpioPin25.low();
		
		}
		
	public static void execSequenceA(){
		StringToBraille s = new StringToBraille();
		
		for(int i=0; i<200;i++){
				s.punchASequence();
				try{
				
				Thread.sleep(10);
				
				}catch(InterruptedException e){
					e.printStackTrace();
					}
			}
			
		s.getGpioProcessor().closePins();	
		}
		
	public static void execSequenceB(){
		StringToBraille s = new StringToBraille();
		for(int i=0; i<200; i++){		
				s.punchBSequence();
				try{
				Thread.sleep(10);
				
				}catch(InterruptedException e){
					e.printStackTrace();
					}
			}
		s.getGpioProcessor().closePins();
		}	
		
	
	public static void main(String[]args){
		
		
		while(true){
			execSequenceA();
			
			//s.resetSequence();
			try{
				
				Thread.sleep(1000);
				
				}catch(InterruptedException e){
					e.printStackTrace();
					}
					
			execSequenceB();
			//s.resetSequence();
			try{
				
				Thread.sleep(1000);
				
				}catch(InterruptedException e){
					e.printStackTrace();
				}
		}
		
		
		//gpioProcessor.closePins();
		
		}
	}
