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
		
	public void sleep(int millis) {
		try{
			Thread.sleep(millis);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void punchASequence(){
		
			gpioPin25.low();
			gpioPin27.low();
			gpioPin31.low();
			gpioPin33.high();
			
			sleep(10);

			gpioPin25.low();
			gpioPin27.low();
			gpioPin31.high();
			gpioPin33.high();
			
			sleep(10);
			
			gpioPin25.low();
			gpioPin27.low();
			gpioPin31.high();
			gpioPin33.low();
			
			sleep(10);
			
			gpioPin25.low();
			gpioPin27.high();
			gpioPin31.high();
			gpioPin33.low();
			
			sleep(10);
			
			gpioPin25.low();
			gpioPin27.high();
			gpioPin31.low();
			gpioPin33.low();
			
			sleep(10);
		
			gpioPin25.high();
			gpioPin27.high();
			gpioPin31.low();
			gpioPin33.low();
			
			sleep(10);
			
			gpioPin25.high();
			gpioPin27.low();
			gpioPin31.low();
			gpioPin33.low();
			
			sleep(10);
		
			gpioPin25.high();
			gpioPin27.low();
			gpioPin31.low();
			gpioPin33.high();
			
			sleep(10);
		
		}
		
	public void punchBSequence(){
		
			gpioPin25.high();
			gpioPin27.low();
			gpioPin31.low();
			gpioPin33.low();
			
			sleep(10);

			gpioPin25.high();
			gpioPin27.high();
			gpioPin31.low();
			gpioPin33.low();
			
			sleep(10);
			
			gpioPin25.low();
			gpioPin27.high();
			gpioPin31.low();
			gpioPin33.low();
			
			sleep(10);
			
			gpioPin25.low();
			gpioPin27.high();
			gpioPin31.high();
			gpioPin33.low();
			
			sleep(10);
			
			gpioPin25.low();
			gpioPin27.low();
			gpioPin31.high();
			gpioPin33.low();
			
			sleep(10);
		
			gpioPin25.low();
			gpioPin27.low();
			gpioPin31.high();
			gpioPin33.high();
			
			sleep(10);
			
			gpioPin25.low();
			gpioPin27.low();
			gpioPin31.low();
			gpioPin33.high();
			
			sleep(10);
		
			gpioPin25.high();
			gpioPin27.low();
			gpioPin31.low();
			gpioPin33.high();
			
			sleep(10);
		
		}
		
	public void resetSequence(){
		
			gpioPin25.high();
			gpioPin27.low();
			gpioPin31.low();
			gpioPin33.low();
			
			gpioPin25.low();
		
		}
		
	public static void execSequenceA(int n){
		StringToBraille s = new StringToBraille();
		
		int i = 0;
		while (i<n){
			s.punchASequence();
			s.sleep(10);
			i++;
			}
			
		s.getGpioProcessor().closePins();	
		}
		
	public static void execSequenceB(int n){
		StringToBraille s = new StringToBraille();
		int i = 0;
		while (i<n){
			s.punchBSequence();
			s.sleep(10);
			i++;
			}
		s.getGpioProcessor().closePins();
		}	
		
	public static void transcriptCharacter(char c){
		
		int [][] brailleCode = BrailleCharacterConverter.braille(c);
		
		if(brailleCode[0][0]==1){
			execSequenceB(50);
			try{
				Thread.sleep(1000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			execSequenceA(50);
			try{
				Thread.sleep(1000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			}
		if(brailleCode[0][1]==1){
			execSequenceA(50);
			try{
				Thread.sleep(1000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			execSequenceB(50);
			try{
				Thread.sleep(1000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}                         
			}
		if(brailleCode[1][0]==1){
			execSequenceB(50);
			try{
				Thread.sleep(1000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			execSequenceA(50);
			try{
				Thread.sleep(1000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			}
		if(brailleCode[1][1]==1){
			execSequenceA(50);
			try{
				Thread.sleep(1000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			execSequenceB(50);
			try{
				Thread.sleep(1000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			}
		if(brailleCode[2][0]==1){
			execSequenceB(50);
			try{
				Thread.sleep(1000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			execSequenceA(50);
			try{
				Thread.sleep(1000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			}
		if(brailleCode[2][1]==1){
			execSequenceA(50);
			try{
				Thread.sleep(1000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			execSequenceB(50);
			try{
				Thread.sleep(1000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			}
		
		}	
		
	
	public static void main(String[]args){
		transcriptCharacter('f');
		
		/*while(true){
			System.out.println("Turning counter-clockwise\n");

			execSequenceB(50);
			
			//s.resetSequence();
			try{
				Thread.sleep(1000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
					
			System.out.println("Turning clockwise\n");

			execSequenceA(50);
			//s.resetSequence();
			try{
				Thread.sleep(1000);
				
				}catch(InterruptedException e){
					e.printStackTrace();
				}
		}
		
		
		//gpioProcessor.closePins();*/
		
		}
	}
