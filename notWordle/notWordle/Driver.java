package notWordle;

import java.io.*;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("notWordleHighscore.txt"));
		Scanner scan = new Scanner(System.in);
		String nickName;
		
		System.out.print("What is Your Name");
		//nickName = scan.nextLine();
		
		NotWordle word = new NotWordle();
		word.show(word.randomize());
		
	}
}
