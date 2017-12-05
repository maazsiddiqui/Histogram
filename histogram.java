package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class histogram {
	
	private int[] histoArray;
	private int numRows;
	private int numCols;
	private int minVal;
	private int maxVal;
	private String inFile;
	private String outFile;
	
	public histogram(String inFile, String outFile) throws FileNotFoundException {
		
		this.inFile = inFile;
		this.outFile = outFile;
		
		Scanner dataFile = new Scanner(new File(inFile));
		
		numRows = dataFile.nextInt();
		numCols = dataFile.nextInt();
		minVal = dataFile.nextInt();
		maxVal = dataFile.nextInt();
	
		dataFile.close(); // input file closed

	}
	
	public void computeHistogram() throws FileNotFoundException {
		
		histoArray = new int[maxVal + 1];
		
		Scanner dataFile = new Scanner(new File(inFile));
		
		dataFile.nextLine();	// skip header line
		
		while (dataFile.hasNextInt()) histoArray[dataFile.nextInt()]++;

		dataFile.close();	// input file closed
	}
	
	public void printHistogram() throws IOException {
		
		PrintWriter out = new PrintWriter(new FileWriter(outFile));
		
		out.println("Project 1: Histogram");
		out.println("By: Maaz Siddiqui");
		out.println();
		out.println();
		
		for(int i = 0; i < histoArray.length; i++) {
			out.print("(" + i + "): " + histoArray[i] + " ");
			for(int n = histoArray[i] - 1; n >= 0; n--) {
				if (n > 80) {
					out.print("+'s");
					break;
				}
				out.print("+");
			}
			out.println();
		}
		out.close(); // output file closed
	}
}
