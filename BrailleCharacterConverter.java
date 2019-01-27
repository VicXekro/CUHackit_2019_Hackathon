public class BrailleCharacterConverter{
	
	public static int[][] braille(char asciiChar){
		int [][] brailleConversion = new int[3][2];
		switch(asciiChar){
			
			case 'A':
			case 'a':
				brailleConversion = new int[][]{{1,0},{0,0},{0,0}};    
			break;
			case 'B':
			case 'b':
				brailleConversion = new int[][]{{1,0},{1,0},{0,0}};
			break;
			case 'C':
			case 'c':
				brailleConversion = new int[][]{{1,1},{0,0},{0,0}};
			break;
			case 'D':
			case 'd':
				brailleConversion = new int[][]{{1,1},{0,1},{0,0}};
			break;
			case 'E':
			case 'e':
				brailleConversion = new int[][]{{1,0},{0,1},{0,0}};
			break;
			case 'F':
			case 'f':
				brailleConversion = new int[][]{{1,1},{1,0},{0,0}};
			break;
			case 'G':
			case 'g':
				brailleConversion = new int[][]{{1,1},{1,1},{0,0}};
			break;
			case 'H':
			case 'h':
				brailleConversion = new int[][]{{1,0},{1,1},{0,0}};
			break;
			case 'I':
			case 'i':
				brailleConversion = new int[][]{{0,1},{1,0},{0,0}};
			break;
			case 'J':
			case 'j':
				brailleConversion = new int[][]{{0,1},{1,1},{0,0}};
			break;
			case 'K':
			case 'k':
				brailleConversion = new int[][]{{1,0},{0,0},{1,0}};
			break;
			case 'L':
			case 'l':
				brailleConversion = new int[][]{{1,0},{1,0},{1,0}};
			break;
			case 'M':
			case 'm':
				brailleConversion = new int[][]{{1,1},{0,0},{1,0}};
			break;
			
			}
			return brailleConversion;
		           
		}
	
	}
