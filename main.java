/*
	Project 1: Histogram
	By: Maaz Siddiqui
*/

package main;
import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {
		
		if (args.length != 2) {
			System.out.println("Improper command line arguments.");
			return;
		}
		
		histogram hg = new histogram(args[0], args[1]);
		hg.computeHistogram();
		hg.printHistogram();
	}
	
}