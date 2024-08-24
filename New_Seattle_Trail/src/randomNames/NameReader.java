package randomNames;
import java.util.*;
import java.io.*;


public class NameReader {
	public static int numMNames;
	public static int numFNames;
	public static String[] FemaleNames;
	public static String[] MaleNames;
	
	public void Activation() {
	
	try(BufferedReader readerF = new BufferedReader(new FileReader("Random Female Names.txt"))) {
		String lineF;
		while((lineF = readerF.readLine()) != null) {
			numFNames++;			
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	try(BufferedReader readerM = new BufferedReader(new FileReader("Random Male Names.txt"))) {
		String lineM;
		while((lineM = readerM.readLine()) != null) {
			numMNames++;			
		}
	}catch(Exception e) {
		e.printStackTrace();
	}

	Activation2();
}
	public void Activation2() {
		String[] FemaleNames = new String[numFNames];
		String[] MaleNames = new String[numMNames];
		int x = 0;
		int y = 0;
		
		try(BufferedReader readerF = new BufferedReader(new FileReader("Random Female Names.txt"))) {
			String lineF;
			while((lineF = readerF.readLine()) != null) {
				FemaleNames[x] = lineF;	
				x++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try(BufferedReader readerM = new BufferedReader(new FileReader("Random Male Names.txt"))) {
			String lineM;
			while((lineM = readerM.readLine()) != null) {
				MaleNames[y] = lineM;
				y++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}


