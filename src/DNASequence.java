///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           DNA Sequence
// Course:          CS 200, Spring 2020
//
// Author:          Joe Rafferty
// Email:           jrrafferty@wisc.edu
// Lecturer's Name: Jim Williams
//


import java.util.ArrayList;
import java.util.Scanner;

public class DNASequence {
    static int countAdd;
	/**
     * adds a nucleotide to the given ArrayList of Characters
     * All nucleotides characters should be converted to upperCase
     *
     * @param DNA the DNA sequence to add the nucleotide to
     * @param nucleotide the Character that should be added to the DNA sequence, or null if the DNA is null
     **/
	public static void addNucleotide(ArrayList<Character> DNA, Character nucleotide) {
		switch (nucleotide) {
		    case 'a':
		    case 'A':
		        DNA.add('A');
		        break;
		        
		    case 'c':
            case 'C':
                DNA.add('C');
                break;
                
            case 't':
            case 'T':
                DNA.add('T');
                break;
                
            case 'g':
            case 'G':
                DNA.add('G');
                break;
                
            case '4':
                DNA.add('4');
                break;
                
            default:
                countAdd += 1;
                break;
		}
	}

	/**
     * creates a String representing the given DNA sequence
     *
     * @param DNA the DNA sequence to create a String from
     * @return the String representation of the DNA sequence, or null if either input is null
     */
	public static String getSequence(ArrayList<Character> DNA) {
	    String DNAstring = "";
	    if (DNA == null) {
	        return null;
	    }
	    else {
	        for (char DNAchar : DNA) {
	            DNAstring = DNAstring + DNAchar;
	        }
		return DNAstring;
	    }
	}

	/**
	 * add to this method using the inline comments as a guide
	 */
	public static void main(String[] args) {

		ArrayList<Character> DNA = new ArrayList<Character>();
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of nucleotides: ");
		// read in the number of nucleotides for this DNA sequence
		int count = input.nextInt();
		// if the number entered is 0 or less, print "No nucleotides available to generate DNA!" and exit
		if (count <= 0) {
		    System.out.println("No nucleotides available to generate DNA!");
		}
		else {
		    System.out.println("Enter each nucleotide on a new line:");
		    // read in each nucleotide individually on a new line, and add it to the DNA sequence using addNucleotide
		    for (int i = 0; i < (count + countAdd); ++i) {
		        String userInput = input.next();
		        addNucleotide(DNA, userInput.charAt(0));
		    }
		    System.out.print("The DNA sequence you entered is ");
	        // print out the String representation of the DNA sequence using getSequence
	        System.out.println(getSequence(DNA));
		}

	}

}
