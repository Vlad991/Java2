package ua.univer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {
		
//		InputStreamReader isr = new InputStreamReader(System.in);
//		
//		BufferedReader br = new BufferedReader(isr);
//		
//		String s = br.readLine();
//		
//		System.out.println(s);
		
		String separator = File.separator;
		String pth = separator + "Users" + separator + "kuzmavladislavvladimirovic" + separator + "Desktop" + separator + "test.txt";
		File file = new File(pth);
		
	    Square[][] lab = new Square[5][5];
	    String s;
	    int i = 0;
	    
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			s = scanner.nextLine();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '1') {
					lab[i][j] = new Square(j, i, ESquareCondition.Opened);
				} else {
					lab[i][j] = new Square(j, i, ESquareCondition.Closed);
				}
			}
			i++;
		}
		
//		for ( i1 = 0; i1 < lab.length; i1++) {
//			for ( j = 0; j < lab.length; j++) {
//				System.out.print(lab[i1][j]);
//			}
//			System.out.println();
//		}
		Square entry = lab[0][0];
		Square exit = lab[4][1];
		
		StackSquare path = new StackSquare();
		path.push(entry);
		for (int m = 0; m < 10000; m++) {
//		while (path.peek() != exit) {
			for (i = 0; i < lab.length; i++) {
				for (int j = 0; j < lab.length; j++) {
					if (path.peek() == lab[i][j]) {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////						
						if (i != 0 && j != 0 && i != 4 && j != 4) {
							if (lab[i+1][j].getCondition() == ESquareCondition.Opened) {path.push(lab[i+1][j]); continue;}
							else if (lab[i][j+1].getCondition() == ESquareCondition.Opened) {path.push(lab[i][j+1]); continue;}
							else if (lab[i-1][j].getCondition() == ESquareCondition.Opened) {path.push(lab[i-1][j]); continue;}
							else if (lab[i][j-1].getCondition() == ESquareCondition.Opened) {path.push(lab[i][j-1]); continue;}
							else {
								lab[i][j].setCondition(ESquareCondition.Closed);
								path.pop();
							}
						} else if (i != 0 && j != 0 && i != 4 && j == 4) {
							if (lab[i+1][j].getCondition() == ESquareCondition.Opened) {path.push(lab[i+1][j]); continue;}
							else if (lab[i][j-1].getCondition() == ESquareCondition.Opened) {path.push(lab[i][j-1]); continue;}
							else if (lab[i-1][j].getCondition() == ESquareCondition.Opened) {path.push(lab[i-1][j]); continue;}
							else {
								lab[i][j].setCondition(ESquareCondition.Closed);
								path.pop();
							}
						} else if (i != 0 && j != 0 && i == 4 && j != 4) {
							if (lab[i-1][j].getCondition() == ESquareCondition.Opened) {path.push(lab[i-1][j]); continue;}
							else if (lab[i][j+1].getCondition() == ESquareCondition.Opened) {path.push(lab[i][j+1]); continue;}
							else if (lab[i][j-1].getCondition() == ESquareCondition.Opened) {path.push(lab[i][j-1]); continue;}
							else {
								lab[i][j].setCondition(ESquareCondition.Closed);
								path.pop();
							}
						} else if (i != 0 && j == 0 && i != 4 && j != 4) {
							if (lab[i-1][j].getCondition() == ESquareCondition.Opened) {path.push(lab[i-1][j]); continue;}
							else if (lab[i][j+1].getCondition() == ESquareCondition.Opened) {path.push(lab[i][j+1]); continue;}
							else if (lab[i+1][j].getCondition() == ESquareCondition.Opened) {path.push(lab[i+1][j]); continue;}
							else {
								lab[i][j].setCondition(ESquareCondition.Closed);
								path.pop();
							}
						} else if (i == 0 && j != 0 && i != 4 && j != 4) {
							if (lab[i+1][j].getCondition() == ESquareCondition.Opened) {path.push(lab[i+1][j]); continue;}
							else if (lab[i][j+1].getCondition() == ESquareCondition.Opened) {path.push(lab[i][j+1]); continue;}
							else if (lab[i][j-1].getCondition() == ESquareCondition.Opened) {path.push(lab[i][j-1]); continue;}
							else {
								lab[i][j].setCondition(ESquareCondition.Closed);
								path.pop();
							}
						} else if (i != 0 && j != 0 && i == 4 && j == 4) {
							if (lab[i-1][j].getCondition() == ESquareCondition.Opened) {path.push(lab[i-1][j]); continue;}
							else if (lab[i][j-1].getCondition() == ESquareCondition.Opened) {path.push(lab[i][j-1]); continue;}
							else {
								lab[i][j].setCondition(ESquareCondition.Closed);
								path.pop();
							}
						} else if (i == 0 && j == 0 && i != 4 && j != 4) {
							if (lab[i+1][j].getCondition() == ESquareCondition.Opened) {path.push(lab[i+1][j]); continue;}
							else if (lab[i][j+1].getCondition() == ESquareCondition.Opened) {path.push(lab[i][j+1]); continue;}
							else {
								lab[i][j].setCondition(ESquareCondition.Closed);
								path.pop();
							}
						} else if (i == 0 && j != 0 && i != 4 && j == 4) {
							if (lab[i+1][j].getCondition() == ESquareCondition.Opened) {path.push(lab[i+1][j]); continue;}
							else if (lab[i][j-1].getCondition() == ESquareCondition.Opened) {path.push(lab[i][j-1]); continue;}
							else {
								lab[i][j].setCondition(ESquareCondition.Closed);
								path.pop();
							}
						} else if (i != 0 && j == 0 && i == 4 && j != 4) {
							if (lab[i-1][j].getCondition() == ESquareCondition.Opened) {path.push(lab[i-1][j]); continue;}
							else if (lab[i][j+1].getCondition() == ESquareCondition.Opened) {path.push(lab[i][j+1]); continue;}
							else {
								lab[i][j].setCondition(ESquareCondition.Closed);
								path.pop();
							}
						}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					}
				}
			}
			
//		}
		}
		path.print();
		
		int[][] matr = new int[5][5];
		
		while (!path.isEmpty()) {
			matr[path.peek().getY()][path.peek().getX()] = 1;
			path.pop();
		}
		
		for (int k = 0; k < matr.length; k++) {
			for (int k2 = 0; k2 < matr.length; k2++) {
				System.out.print(matr[k][k2]);
			}
			System.out.println();
		}
		
		
		
	}

}
