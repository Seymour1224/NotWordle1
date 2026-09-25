package notWordle;

import java.util.Random;

import java.io.*;
import java.util.Scanner;

public class NotWordle {

	public Scanner scan = new Scanner(System.in);
	private String nickName = "";
	private String[][] highscore = {{"-1","NA"},{"-1","NA"},{"-1","NA"},{"-1","NA"},{"-1","NA"}};
	private int[] mixedArray = {1,2,3,4,5};
	private int[] guessArray = {-1,-1,-1,-1,-1};
	private int countCorrect = 0;
	private int guessCounter = 0;
	
	
	
	
	
	public NotWordle() {
		
	}
	
	//********************************************************
	//                  initialization
	
	public void randomize() {
		int temp;
		int index;
		Random rand = new Random();
		int index1;
		int index2;
		
		
		for(index = 0; index < rand.nextInt(10000)+10000; index++) {
			index1 = rand.nextInt(5);
			index2 = rand.nextInt(5);
			
			temp = this.mixedArray[index1];
			this.mixedArray[index1] = this.mixedArray[index2];
			this.mixedArray[index2] = temp;
			
		}
	}
	
	public void show() {
		int index;
		
		for(index = 0; index < this.mixedArray.length; index++) {
			System.out.printf("[%d]  ", this.mixedArray[index]);
		}
		System.out.println(" mixed");
		
		for(index = 0; index < this.guessArray.length; index++) {
			System.out.printf("[%d]  ", this.guessArray[index]);
		}
		System.out.println(" guess");
		
	}
	
	public void name() {
		while(this.nickName == "") {
			System.out.print("Who's Playing: ");
			this.nickName = this.scan.nextLine();
		}
	}
	//********************************************************
	
	//********************************************************
	//               High Score
	
	public void readHighscore() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("notWordleHighscore.txt"));
		String line;
		String[] temp = new String[2];
		int count = 0;
		
		while((line = br.readLine()) != null) {
			temp = line.split(",");
			this.highscore[count][0] = temp[0];
			this.highscore[count][1] = temp[1];
			count++;
		}
		br.close();
	}
	
	public void writeHighscore() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("notWordleHighscore.txt",false));
		int fst = Integer.parseInt(this.highscore[0][0]);
		int snd = Integer.parseInt(this.highscore[1][0]);
		int trd = Integer.parseInt(this.highscore[2][0]);
		int foth = Integer.parseInt(this.highscore[3][0]);
		int fith = Integer.parseInt(this.highscore[4][0]);
		
		if(fst > this.guessCounter || fst == -1) {
			bw.write(this.guessCounter+","+this.nickName+"\n");
			bw.write(this.highscore[0][0]+","+this.highscore[0][1]+"\n");
			bw.write(this.highscore[1][0]+","+this.highscore[1][1]+"\n");
			bw.write(this.highscore[2][0]+","+this.highscore[2][1]+"\n");
			bw.write(this.highscore[3][0]+","+this.highscore[3][1]+"\n");
		} else if(snd > this.guessCounter || snd == -1) {
			bw.write(this.highscore[0][0]+","+this.highscore[0][1]+"\n");
			bw.write(this.guessCounter+","+this.nickName+"\n");
			bw.write(this.highscore[1][0]+","+this.highscore[1][1]+"\n");
			bw.write(this.highscore[2][0]+","+this.highscore[2][1]+"\n");
			bw.write(this.highscore[3][0]+","+this.highscore[3][1]+"\n");
		} else if(trd > this.guessCounter || trd == -1) {
			bw.write(this.highscore[0][0]+","+this.highscore[0][1]+"\n");
			bw.write(this.highscore[1][0]+","+this.highscore[1][1]+"\n");
			bw.write(this.guessCounter+","+this.nickName+"\n");
			bw.write(this.highscore[2][0]+","+this.highscore[2][1]+"\n");
			bw.write(this.highscore[3][0]+","+this.highscore[3][1]+"\n");
		} else if(foth > this.guessCounter || foth == -1) {
			bw.write(this.highscore[0][0]+","+this.highscore[0][1]+"\n");
			bw.write(this.highscore[1][0]+","+this.highscore[1][1]+"\n");
			bw.write(this.highscore[2][0]+","+this.highscore[2][1]+"\n");
			bw.write(this.guessCounter+","+this.nickName+"\n");
			bw.write(this.highscore[3][0]+","+this.highscore[3][1]+"\n");
		} else if(fith > this.guessCounter || fith == -1) {
			bw.write(this.highscore[0][0]+","+this.highscore[0][1]+"\n");
			bw.write(this.highscore[1][0]+","+this.highscore[1][1]+"\n");
			bw.write(this.highscore[2][0]+","+this.highscore[2][1]+"\n");
			bw.write(this.highscore[3][0]+","+this.highscore[3][1]+"\n");
			bw.write(this.guessCounter+","+this.nickName+"\n");
		}
		bw.close();
	}
	//********************************************************
	
	//********************************************************
	//           Display
	
	public void displayHighscore() {
		int index;
		
		System.out.println("  High Scores\n---------------");
		
		for(index = 0; index < this.highscore.length; index++) {
			if(this.highscore[index][0] == null) {
				break;
			}
			System.out.printf("%5s - %s%n", this.highscore[index][0], this.highscore[index][1]);
		}
		
	}
	
	public void displayCheck() {
		System.out.println("make a guess");
		runCheck();
		System.out.printf("You got %d correct%n",this.countCorrect);
	}
	
	public void displayWin() {
		System.out.printf("You guessed it in %d turns",this.guessCounter);
		displayEnd();
	}
	
	public void displayEnd() {
		int index;
		
		System.out.printf("%n%n---------------------%n");
		for(index = 0; index < 5; index++) {
			System.out.printf("| %d ", this.mixedArray[index]);
		}
		System.out.printf("|%n---------------------%n");
	}
	
	
	//********************************************************
	
	//********************************************************
	//              running game
	
	
	public void runGame() throws IOException {
		int index;
		boolean runFlag = true;
		readHighscore();
		name();
		randomize();
		while(runFlag) {
			this.guessCounter++;
			displayCheck();
			for(index = 0; index < 5; index++) {
				if(this.guessArray[index] == 0) {
					runFlag = false;
					displayEnd();
					break;
				}
			}
			if(this.countCorrect == 5) {
				displayWin();
				writeHighscore();
				readHighscore();
				runFlag = false;
			}
		}
		displayHighscore();
	}
	
	public void runCheck() {
		int index;
		boolean flag = true;
		int count = 0;
		
		while(flag) {
			flag = !guess(this.scan.nextLine());
		}
		for(index = 0; index < 5; index++) {
			if(this.mixedArray[index] == this.guessArray[index]) {
				count++;
			}
		}
		this.countCorrect = count;
	}
	
	public boolean zeroCheck() {
		int index;
		boolean flag = false;
		
		for(index = 0; index < this.guessArray.length; index++) {
			if(this.guessArray[index] == 0) {
				flag = true;
			}
		}
		return flag;
	}
	
	public boolean guess(String guess) {
		String newGuess = "";
		int index;
		String temp = "";
		boolean validGuess = true;
		
		for(index = 0; index < guess.length(); index++) {
			if(guess.charAt(index) == '1' || guess.charAt(index) == '2' || guess.charAt(index) == '3' || guess.charAt(index) == '4' || guess.charAt(index) == '5' || guess.charAt(index) == '0') {
				newGuess += guess.charAt(index);
			}
		}
		if(newGuess.length() > 5) {
			for(index = 0; index < 5; index++) {
				temp += newGuess.charAt(index);
			}
			newGuess = temp;
		}
		for(index = 0; index < newGuess.length(); index++) {
			this.guessArray[index] = Integer.parseInt(newGuess.charAt(index)+"");
		}
		for(index = 0; index < this.guessArray.length; index++) {
			if(this.guessArray[index] == -1) {
				validGuess = false;
			}
		}
		
		return validGuess;
	}
	
	
	
}
