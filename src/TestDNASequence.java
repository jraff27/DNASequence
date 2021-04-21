///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Test DNA Sequence
// Course:          CS 200, Spring 2020
//
// Author:          Joe Rafferty
// Email:           jrrafferty@wisc.edu
// Lecturer's Name: Jim Williams
//


import java.util.ArrayList;
import java.util.Arrays;

public class TestDNASequence {
	
	/**
     * calls your addNucleotide method to verify correct behavior
     * add more tests to make sure that your method works in all cases
     */
    public static boolean testAddNucleotide() {
        System.out.println("Starting testAddNucleotide...");
        //Test 1
        {
            // this test adds two new nucleotides 'o' and 'k' to the DNA
			// then checks that they were correctly added and capitalized in the ArrayList
			ArrayList<Character> testDNA = new ArrayList<Character>();
            DNASequence.addNucleotide(testDNA, 'a');
            DNASequence.addNucleotide(testDNA, 't');
			
            if(!testDNA.get(0).equals('A') || !testDNA.get(1).equals('T')) {
                System.out.println("  Test 1 failed!");
                System.out.println("    Expected: " + 'A');
                System.out.println("    Result: " + testDNA.get(0));
                System.out.println("    Expected: " + 'T');
                System.out.println("    Result: " + testDNA.get(1));
                return false;
            }
        }
		
		
        {
            // this test adds two new nucleotides 'o' and 'k' to the DNA
            // then checks that they were correctly added and capitalized in the ArrayList
            ArrayList<Character> testDNA = new ArrayList<Character>();
            DNASequence.addNucleotide(testDNA, 'c');
            DNASequence.addNucleotide(testDNA, 'g');
            
            if(!testDNA.get(0).equals('C') || !testDNA.get(1).equals('G')) {
                System.out.println("  Test 1 failed!");
                System.out.println("    Expected: " + 'C');
                System.out.println("    Result: " + testDNA.get(0));
                System.out.println("    Expected: " + 'G');
                System.out.println("    Result: " + testDNA.get(1));
                return false;
            }
        }
        System.out.println("...Done testAddNucleotide");
        return true;
    }
	
	/**
     * calls your getSequence method to verify correct behavior
     * add more tests to make sure that your method works in all cases
     */
    public static boolean testGetSequence() {
        System.out.println("Starting testGetSequence...");
        //Test 1
        {
            // this test makes a new DNA with the characters ATCGATCG
			// then checks that the resulting sequence is "ATCGATCG"
			ArrayList<Character> testDNA = new ArrayList<Character>(Arrays.asList('A', 'T', 'C', 'G', 'A', 'T', 'C', 'G'));
            String result = DNASequence.getSequence(testDNA);
            String expected = "ATCGATCG";
            
			if(!result.equals(expected)) {
                System.out.println("  Test 1 failed!");
                System.out.println("    Expected: " + expected);
                System.out.println("    Result: " + result);
                return false;
            }
        }
        
        {
            // this test makes a new DNA with the characters ATCGATCG
            // then checks that the resulting sequence is "ATCGATCG"
            ArrayList<Character> testDNA = new ArrayList<Character>(Arrays.asList('T', 'T', 'G', 'A', 'A', 'C', 'T', 'G'));
            String result = DNASequence.getSequence(testDNA);
            String expected = "TTGAACTG";
            
            if(!result.equals(expected)) {
                System.out.println("  Test 1 failed!");
                System.out.println("    Expected: " + expected);
                System.out.println("    Result: " + result);
                return false;
            }
        }
		System.out.println("...Done testGetSequence");
        return true;
    }

    public static void main(String[] args) {
        testGetSequence();
		testAddNucleotide();
    }
    
}
