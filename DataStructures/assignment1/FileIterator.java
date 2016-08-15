package assignment1;
//importing IO/Scanner to take in user input/read files.
import java.io.*;
import java.util.Scanner;


public class FileIterator implements IntegerIterator {
	int counter = 0;
	private Scanner fileInput;
	public File savedFile;
	
	//This constructor takes a file as an argument and stores it as savedFile. It then tries to access
	//this file through the scanner, and if an exception such as fileNotFound is thrown, it catches it.
	public FileIterator(File file){
		savedFile = file;
		try{
		fileInput = new Scanner(savedFile);
		}
		catch (FileNotFoundException rip){
			System.out.println("Unable to open file" + file + ".");
		}
	}
	//The hasNext method initially checks to see if the counter is >= 1, meaning that the file has been closed/open before.
	//If it has been closed before and reopened, it returns false and does not close the file.
	public boolean hasNext(){
		if (counter >= 1)
			return false;
		
		//If counter is not >= 1, then the file has not been closed yet meaning the end was never reached. So it is continuously
		//checked to see if the next value is not End of File through Scanner's hasNext method. If there is no value next, then
		//this conditional returns true and the file closes and counter is incremented so for future purposes, False is returned for
		//the hasNext method.
		else  if (!(fileInput.hasNext())){
			fileInput.close();
			counter++;
				return false;}
		//If none of the previous conditions passed, then the file does have a value next and thus true is returned.
		else{
			return true;
		}
		
	}
	public int getNext(){
		
		return fileInput.nextInt();
		
	}
	//Because Scanner objects don't have a natural "reset" method. One has to close the previous file and instantiate
	//a new instance of it in order to start at the beginning. An exception is necessary in case the file is not found or
	//no longer exists.
	public void reset(){
		try{	
		fileInput.close();
		fileInput = new Scanner(savedFile);
		}
		catch (Exception rip){
			System.out.println("File:" + savedFile + "not found.");
		}
		finally{
		}
	}

}
