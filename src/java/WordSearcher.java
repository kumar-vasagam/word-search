import java.util.HashMap;
import java.util.LinkedHashMap;


public class WordSearcher {

	private char[][] wordMatrix = new char[][]{
		{'A','N','C','D','T','E','T','R','O','A'},
		{'K','J','Y','N','T','H','E','L','L','O'},
		{'G','A','Z','S','O','A','N','D','S','D'},
		{'H','L','A','B','T','C','A','V','E','E'},
		{'A','P','P','L','E','A','C','I','D','A'}
	};
	
	private int numOfRowsInMatrix;
	private int numOfColsInMatrix;
	private int diagonalLengthOfMatrix;
		
//	private String searchEast(char[] searchChars){
//		//x is constant. increment y to find out the word
//		System.out.println("--searchEast for--" + new String(searchChars));
//		int wordLength = searchChars.length;
//		LinkedHashMap coordinates = new LinkedHashMap();
//		
//		char[] charsAtThisRow = new char[wordLength];
//		
//		 for (int row=0;row<numOfRowsInMatrix;row++){
//			 coordinates.clear(); 
//			 for(int col=0;col<numOfColsInMatrix;col++){
//				if (searchChars[0] == wordMatrix[row][col]){
//					int i=0;
//					//perform searchEast only when # of characters in the current row is at least equal to length of the word being searched for.
//					if(col+searchChars.length <= numOfColsInMatrix){
//						int endPosn = col+wordLength-1;
//						
//						for (int startPos=col;startPos<=endPosn;startPos++){
//							charsAtThisRow[i] = wordMatrix[row][startPos];
//							//System.out.println(charsAtThisRow[i]);
//							coordinates.put(String.valueOf(row)+String.valueOf(startPos), String.valueOf(charsAtThisRow[i]));
//							i++; 	
//						}
//						String wordAtThisRow = new String(charsAtThisRow);
//						if(wordAtThisRow.equalsIgnoreCase(new String(searchChars))){
//							System.out.println("--found it :)--");
//							System.out.println("Coordinates	in String:	"+ coordinates.toString());
//							return coordinates.toString();						
//						}
//						else{
//							//System.out.println("--nope :(--");
//							coordinates.clear();
//						}
//						
//					}
//				}
//			}
//			
//		}
//		//end
//		return coordinates.toString();
//
//	}
//	
//	private String searchSouth(char[] searchChars)
//	{
//		//y is constant. increment x to find out the word
//		System.out.println("--searchSouth for--" + new String(searchChars));
//		int wordLength = searchChars.length;
//		LinkedHashMap coordinates = new LinkedHashMap();
//
//		char[] charsAtThisColumn = new char[wordLength];
//
//		for(int col=0;col<numOfColsInMatrix;col++){
//			coordinates.clear();
//			for (int row=0;row<numOfRowsInMatrix;row++){
//				if(searchChars[0] == wordMatrix[row][col]){
//					int i=0;
//					if(row+searchChars.length <= numOfRowsInMatrix){
//						int endPosn = row+wordLength-1;
//						for (int startPos=row;startPos<=endPosn;startPos++){
//							//System.out.println(wordMatrix[startPos][col]);
//							charsAtThisColumn[i] = wordMatrix[startPos][col];
//							coordinates.put(String.valueOf(startPos)+String.valueOf(col), String.valueOf(charsAtThisColumn[i]));
//							i++;
//						}
//						String wordAtThisColumn = new String(charsAtThisColumn);
//						String searchWord = new String(searchChars);
//						
//						if(wordAtThisColumn.equalsIgnoreCase(searchWord)){
//							System.out.println("--found it :)--");
//							System.out.println("Coordinates	:	"+ coordinates.keySet().toString());
//							System.out.println("Coordinates	in String:	"+ coordinates.toString());
//							return coordinates.toString();
//						}
//						else{
//							//System.out.println("--nope :(--");
//							coordinates.clear();
//							}
//
//					}
//				}
//			}
//		}
//		return coordinates.toString();
//	}
//	private String searchNorth(char[] searchChars){
//		//col is constant. decrement row to find out the word
//		System.out.println("--searchNorth for--" + new String(searchChars));
//		int wordLength = searchChars.length;
//		LinkedHashMap coordinates = new LinkedHashMap();
//
//		char[] charsAtThisColumn = new char[wordLength];
//
//		rowIterator : for(int row=0;row<numOfRowsInMatrix;row++){
//			coordinates.clear();
//			colIterator : for (int col=0;col<numOfColsInMatrix;col++){
//				if(searchChars[0] == wordMatrix[row][col]){
//					int i=0;
//					if(searchChars.length <= numOfRowsInMatrix){
//						int endPosn = row-wordLength+1;
//						if(endPosn < 0){
//							break colIterator;
//						}
//						for (int startPos=row;startPos>=endPosn;startPos--){
//							//System.out.println(wordMatrix[startPos][col]);
//							charsAtThisColumn[i] = wordMatrix[startPos][col];
//							coordinates.put(String.valueOf(startPos)+String.valueOf(col), String.valueOf(charsAtThisColumn[i]));
//							i++;
//						}
//						String wordAtThisColumn = new String(charsAtThisColumn);
//						String searchWord = new String(searchChars);
//						
//						if(wordAtThisColumn.equalsIgnoreCase(searchWord)){
//							System.out.println("--found it :)--");
//							System.out.println("Coordinates	:	"+ coordinates.keySet().toString());
//							System.out.println("Coordinates	in String:	"+ coordinates.toString());
//							return coordinates.toString();
//						}
//						else{
//							//System.out.println("--nope :(--");
//							coordinates.clear();
//							}
//
//					}
//				}
//			}
//		}
//		return coordinates.toString();
//	}
//	private String searchWest(char[] searchChars){
//		//row is constant. decrement col to find out the word
//				System.out.println("--searchWest for--" + new String(searchChars));
//				int wordLength = searchChars.length;
//				LinkedHashMap coordinates = new LinkedHashMap();
//
//				char[] charsAtThisRow = new char[wordLength];
//
//				rowIterator : for(int row=0;row<numOfRowsInMatrix;row++){
//					coordinates.clear();
//					colIterator : for (int col=0;col<numOfColsInMatrix;col++){
//						if(searchChars[0] == wordMatrix[row][col]){
//							int i=0;
//							if(searchChars.length <= numOfColsInMatrix){
//								int endPosn = col-wordLength+1;
//								if(endPosn < 0){
//									break colIterator;
//								}
//								for (int startPos=col;startPos>=endPosn;startPos--){
//									System.out.println(wordMatrix[row][startPos]);
//									charsAtThisRow[i] = wordMatrix[row][startPos];
//									coordinates.put(String.valueOf(row)+String.valueOf(startPos), String.valueOf(charsAtThisRow[i]));
//									i++;
//								}
//								
//								String wordAtThisRow = new String(charsAtThisRow);
//								String searchWord = new String(searchChars);
//								
//								if(wordAtThisRow.equalsIgnoreCase(searchWord)){
//									System.out.println("--found it :)--");
//									System.out.println("Coordinates	:	"+ coordinates.keySet().toString());
//									System.out.println("Coordinates	in String:	"+ coordinates.toString());
//									return coordinates.toString();
//								}
//								else{
//									System.out.println("--nope :(--");
//									coordinates.clear();
//									}
//
//							}
//						}
//					}
//				}
//				return coordinates.toString();
//	}
//	private String searchSouthEast(char[] searchChars)
//	{
//		//increment both x and y to find out the word
//		System.out.println("--searchSouthEast for --" + new String(searchChars));
//		int wordLength = searchChars.length;
//		LinkedHashMap coordinates = new LinkedHashMap();		
//		char[] charsAtDiagonal = new char[wordLength];
//		
//		for(int row=0;row<numOfRowsInMatrix;row++){
//			coordinates.clear();
//			for(int col=0;col<numOfColsInMatrix;col++){
//				if(searchChars[0] == wordMatrix[row][col]){
//					int i = 0;
//					//find the diagonal of the rectangle from the relative position of the current character in SE direction					
//					int currentDiagonal = (numOfRowsInMatrix-row <= numOfColsInMatrix-col) ? (numOfRowsInMatrix-row) : (numOfColsInMatrix-col);
//					int diagOfCurrentRect = (currentDiagonal <= wordLength) ? currentDiagonal : wordLength;
//					int currentCol = col;
//					for (int startPos=row;startPos<diagOfCurrentRect+row;startPos++){
//						//System.out.println(wordMatrix[startPos][currentCol]);
//						charsAtDiagonal[i] = wordMatrix[startPos][currentCol];
//						coordinates.put(String.valueOf(startPos)+String.valueOf(currentCol), String.valueOf(charsAtDiagonal[i]));
//						currentCol++;
//						i++;
//					}
//					String wordAtThisDiagnoal = new String(charsAtDiagonal);
//					String searchWord = new String(searchChars);
//					
//					if(wordAtThisDiagnoal.equalsIgnoreCase(searchWord)){
//						System.out.println("--found it :)--");
//						System.out.println("Coordinates	:	"+ coordinates.keySet().toString());
//						System.out.println("Coordinates	in String:	"+ coordinates.toString());
//						return coordinates.toString();
//					}
//					else{
//						//System.out.println("--nope :(--");
//						coordinates.clear();
//					}
//				}
//				
//
//			}
//		}
//		System.out.println("at the very end, returning empty handed, may be for good");
//		return coordinates.toString();
//	}
//	
//	private String searchNorthEast(char[] searchChars)
//	{
//		System.out.println("--searchNorthEast for --" + new String(searchChars));
//		int wordLength = searchChars.length;
//		LinkedHashMap coordinates = new LinkedHashMap();		
//		char[] charsAtDiagonal = new char[wordLength];
//		
//		for(int row=0;row<numOfRowsInMatrix;row++){
//			coordinates.clear();
//			for(int col=0;col<numOfColsInMatrix;col++){
//				if(searchChars[0] == wordMatrix[row][col]){
//					int i=0;
//					//find the diagonal of the rectangle from the relative position of the current character in NE direction					
//					int currentDiagonal = (row+1 <= numOfColsInMatrix-col) ? (row+1) : (numOfColsInMatrix-col);
//					int diagOfCurrentRect = (currentDiagonal <= wordLength) ? currentDiagonal : wordLength;
//					//System.out.println("diagOfCurrentRect	:	" + diagOfCurrentRect);
//					int currentCol = col;
//					int endPosn = row-diagOfCurrentRect+1;
//					for(int startPos=row;startPos>=endPosn;startPos--){
//						//System.out.println("char at	"+startPos + ", " + currentCol + " = " + wordMatrix[startPos][currentCol]);
//						charsAtDiagonal[i] = wordMatrix[startPos][currentCol];
//						coordinates.put(String.valueOf(startPos)+String.valueOf(currentCol), String.valueOf(charsAtDiagonal[i]));
//						i++;
//						currentCol++;
//					}
//					String wordAtThisDiagnoal = new String(charsAtDiagonal);
//					String searchWord = new String(searchChars);
//					
//					if(wordAtThisDiagnoal.equalsIgnoreCase(searchWord)){
//						System.out.println("--found it :)--");
//						System.out.println("Coordinates	:	"+ coordinates.keySet().toString());
//						System.out.println("Coordinates	in String:	"+ coordinates.toString());
//						return coordinates.toString();
//					}
//					else{
//						//System.out.println("--nope :(--");
//						coordinates.clear();
//					}
//				}
//			}
//		}
//		//System.out.println("at the very end, returning empty handed, may be for good");
//		return coordinates.toString();
//	}
	private String searchNorthWest(char[] searchChars){
		System.out.println("--searchNorthWest for --" + new String(searchChars));
		int wordLength = searchChars.length;
		LinkedHashMap coordinates = new LinkedHashMap();		
		char[] charsAtDiagonal = new char[wordLength];
		for(int row=0;row<numOfRowsInMatrix;row++){
			coordinates.clear();
			for(int col=0;col<numOfColsInMatrix;col++){
				if(searchChars[0] == wordMatrix[row][col]){
					int i=0;
					//find the diagonal of the rectangle from the relative position of the current character in NE direction					
					int currentDiagonal = (row+1 <= numOfColsInMatrix-col) ? (row+1) : (numOfColsInMatrix-col);
					int diagOfCurrentRect = (currentDiagonal <= wordLength) ? currentDiagonal : wordLength;
					System.out.println("diagOfCurrentRect	:	" + diagOfCurrentRect);
					int currentCol = col;
					
					//loop thru to find the word here
					String wordAtThisDiagnoal = new String(charsAtDiagonal);
					String searchWord = new String(searchChars);
					
					if(wordAtThisDiagnoal.equalsIgnoreCase(searchWord)){
						System.out.println("--found it :)--");
						System.out.println("Coordinates	:	"+ coordinates.keySet().toString());
						System.out.println("Coordinates	in String:	"+ coordinates.toString());
						return coordinates.toString();
					}
					else{
						System.out.println("--nope :(--");
						coordinates.clear();
					}
				}
				
			}
		}
		System.out.println("at the very end, returning empty handed, may be for good");
		return coordinates.toString();
	}
	
	private void manageSearch(char[] searchChars){
		
		/*
		 * This FOR loop takes each character from the target word and iterates through
		 * the rows and column of the word matrix
		 * 
		 * TODO : 8 directions. Need to be intelligent on which direction to search based on the position
		 * For example, if the character is on the top right corner of the matrix, there is no need to searchEast().
		 * 
		 * */
		
		//searchEast(searchChars);
		//searchSouth(searchChars);
		//searchNorth(searchChars);
		//searchWest(searchChars);
		//searchSouthEast(searchChars);
		//searchNorthEast(searchChars);
		searchNorthWest(searchChars);
		
	}
	
	private void initialize(){
		numOfRowsInMatrix = wordMatrix.length;
		numOfColsInMatrix = wordMatrix[0].length;
		diagonalLengthOfMatrix = (numOfRowsInMatrix <= numOfColsInMatrix) ? numOfRowsInMatrix : numOfColsInMatrix;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearcher searchObj = new WordSearcher();
		searchObj.initialize();
		int numberOfArgs = args.length;
		for (int k=0;k<numberOfArgs;k++){
			searchObj.manageSearch(args[k].toCharArray());
		}
	}

}
