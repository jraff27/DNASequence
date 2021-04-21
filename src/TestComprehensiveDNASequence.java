import java.util.ArrayList;
import java.util.Arrays;

public class TestComprehensiveDNASequence {
	
	/**
     * calls your removeSequence method to verify correct behavior
     * add more tests to make sure that your method works in all cases
     */
    public static boolean testRemoveSequence() {
        System.out.println("Starting testRemoveSequence...");
        //Test 1
        {
			// this test removes "RTG" from the DNA sequence "DFRTGYG"
			// starting sequence is "DFRTGYG", should turn into "DFYG"
         ArrayList<Character> testDNA = new ArrayList<Character>(Arrays.asList('D', 'F', 'R', 'T', 'G', 'Y', 'G'));
			ComprehensiveDNASequence.removeSequence(testDNA, "rtg");
			String result = ComprehensiveDNASequence.getSequence(testDNA);
			String expected = "DFYG";
			
			if(!expected.equals(result)) {
                System.out.println("  Test 1 failed!");
                System.out.println("    Expected: " + expected);
                System.out.println("    Result: " + result);
                return false;
            }
        }
        

         ArrayList<Character> testDNA = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G'));
            ComprehensiveDNASequence.removeSequence(testDNA, "cde");
            String result = ComprehensiveDNASequence.getSequence(testDNA);
            String expected = "ABFG";
            
            if(!expected.equals(result)) {
                System.out.println("  Test 2 failed!");
                System.out.println("    Expected: " + expected);
                System.out.println("    Result: " + result);
                return false;
            }
        
		
		// add more tests here
		
        System.out.println("...Done testRemoveSequence");
        return true;
    }
	
	/**
     * calls your containsSequence method to verify correct behavior
     * add more tests to make sure that your method works in all cases
     */
    public static boolean testContainsSequence() {
        System.out.println("Starting testContainsSequence...");
        //Test 1
        {
			// this test checks that the sequence DFRTGYG has the sequence "RTG" in it, which it does
            ArrayList<Character> testDNA = new ArrayList<Character>(Arrays.asList('D', 'F', 'R', 'T', 'G', 'Y', 'G'));
            boolean result = ComprehensiveDNASequence.containsSequence(testDNA, "rtg");
			boolean expected = true;
			
			if(expected != result) {
                System.out.println("  Test 1 failed!");
                System.out.println("    Expected: " + expected);
                System.out.println("    Result: " + result);
                return false;
            }
        }
		
		// add more tests here
        {
            ArrayList<Character> testDNA = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G'));
            boolean result = ComprehensiveDNASequence.containsSequence(testDNA, "cde");
            boolean expected = true;
            
            if(expected != result) {
                System.out.println("  Test 2 failed!");
                System.out.println("    Expected: " + expected);
                System.out.println("    Result: " + result);
                return false;
            }
        }
		
        System.out.println("...Done testContainsSequence");
        return true;
    }
	
	/**
     * calls your replaceNucleotide method to verify correct behavior
     * add more tests to make sure that your method works in all cases
     */
    public static boolean testContainsNucleotide() {
        System.out.println("Starting testContainsNucleotide...");
        //Test 1
        {
			// this test checks that the sequence DFRTGYG has the nucleotide 'y' in it, which it does
            ArrayList<Character> testDNA = new ArrayList<Character>(Arrays.asList('D', 'F', 'R', 'T', 'G', 'Y', 'G'));
            boolean result = ComprehensiveDNASequence.containsNucleotide(testDNA, 'y');
			boolean expected = true;
			
			if(expected != result) {
                System.out.println("  Test 1 failed!");
                System.out.println("    Expected: " + expected);
                System.out.println("    Result: " + result);
                return false;
            }
        }
		
		// add more tests here
        {
            ArrayList<Character> testDNA = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G'));
            boolean result = ComprehensiveDNASequence.containsNucleotide(testDNA, 'd');
            boolean expected = true;
            
            if(expected != result) {
                System.out.println("  Test 2 failed!");
                System.out.println("    Expected: " + expected);
                System.out.println("    Result: " + result);
                return false;
            }
        }
		
        System.out.println("...Done testContainsNucleotide");
        return true;
    }
	
	/**
     * calls your replaceNucleotide method to verify correct behavior
     * add more tests to make sure that your method works in all cases
     */
    public static boolean testSwapNucleotide() {
        System.out.println("Starting testSwapNucleotide...");
        //Test 1
        {
			// this test replaces all G nucleotides with D, then checks that they were replaced
			// starting sequence is DFRTGYG, should turn into DFRTDYD
            ArrayList<Character> testDNA = new ArrayList<Character>(Arrays.asList('D', 'F', 'R', 'T', 'G', 'Y', 'G'));
			ComprehensiveDNASequence.swapNucleotide(testDNA, 'g', 'd');
			String result = ComprehensiveDNASequence.getSequence(testDNA);
			String expected = "GFRTDYD";
			
            if(!expected.equals(result)) {
                System.out.println("  Test 1 failed!");
                System.out.println("    Expected: " + expected);
                System.out.println("    Result: " + result);
                return false;
            }
        }
		
		// add more tests here
        {
            // this test replaces all G nucleotides with D, then checks that they were replaced
            // starting sequence is DFRTGYG, should turn into DFRTDYD
            ArrayList<Character> testDNA = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G'));
            ComprehensiveDNASequence.swapNucleotide(testDNA, 'b', 'a');
            String result = ComprehensiveDNASequence.getSequence(testDNA);
            String expected = "BACDEFG";
            
            if(!expected.equals(result)) {
                System.out.println("  Test 2 failed!");
                System.out.println("    Expected: " + expected);
                System.out.println("    Result: " + result);
                return false;
            }
        }
		
        System.out.println("...Done testReplaceNucleotide");
        return true;
    }
	
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
            ComprehensiveDNASequence.addNucleotide(testDNA, 'o');
            ComprehensiveDNASequence.addNucleotide(testDNA, 'k');
			
            if(!testDNA.get(0).equals('O') || !testDNA.get(1).equals('K')) {
                System.out.println("  Test 1 failed!");
                System.out.println("    Expected: " + 'O');
                System.out.println("    Result: " + testDNA.get(0));
                System.out.println("    Expected: " + 'O');
                System.out.println("    Result: " + testDNA.get(1));
                return false;
            }
        }
		
		// add more tests here
        {
            ArrayList<Character> testDNA = new ArrayList<Character>();
            ComprehensiveDNASequence.addNucleotide(testDNA, 'a');
            ComprehensiveDNASequence.addNucleotide(testDNA, 'b');
            
            if(!testDNA.get(0).equals('A') || !testDNA.get(1).equals('B')) {
                System.out.println("  Test 2 failed!");
                System.out.println("    Expected: " + 'A');
                System.out.println("    Result: " + testDNA.get(0));
                System.out.println("    Expected: " + 'A');
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
            // this test makes a new DNA with the characters L, O, V, E, J, A, V, A
			// then checks that the resulting sequence is "LOVEJAVA"
			ArrayList<Character> testDNA = new ArrayList<Character>(Arrays.asList('L', 'O', 'V', 'E', 'J', 'A', 'V', 'A'));
            String result = ComprehensiveDNASequence.getSequence(testDNA);
            String expected = "LOVEJAVA";
            
			if(!result.equals(expected)) {
                System.out.println("  Test 1 failed!");
                System.out.println("    Expected: " + expected);
                System.out.println("    Result: " + result);
                return false;
            }
        }
        
		// add more tests here
        {
            ArrayList<Character> testDNA = new ArrayList<Character>(Arrays.asList('C', 'O', 'R', 'O', 'N', 'A', 'V', 'I'));
            String result = ComprehensiveDNASequence.getSequence(testDNA);
            String expected = "CORONAVI";
            
            if(!result.equals(expected)) {
                System.out.println("  Test 2 failed!");
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
		testSwapNucleotide();
		testContainsNucleotide();
		testContainsSequence();
		testRemoveSequence();
    }
    
}
