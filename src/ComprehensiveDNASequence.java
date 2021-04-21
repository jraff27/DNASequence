import java.util.ArrayList;
import java.util.Scanner;

public class ComprehensiveDNASequence {
    static int countAdd;

	/**
     * removes the first occurrence of a given nucleotide sequence if it is within the DNA sequence.
     * Do NOT use methods like replaceFirst from the String class, as it will
     * cause an error in testing. Instead, remove the sequence manually, if found.
     * hint: it may be helpful to use getSequence when searching for a particular sequence in the DNA
     * 
     * @param DNA the DNA sequence to remove the given nucleotide sequence from
     * @param sequence the nucleotide sequence that is being removed from the DNA sequence. this may be lowercase!
     */
    public static void removeSequence(ArrayList<Character> DNA,String sequence) {
        String seq = "";
        sequence = sequence.toUpperCase();
        ArrayList<Character> l = new ArrayList<>();
        for(Character c : DNA) {
            seq += c;
        }
        if(seq.contains(sequence)) {
            int index = seq.indexOf(sequence);
            for(int i = 0; i < index; i++) {
                l.add(DNA.get(i));
            }
            for(int i = index + sequence.length(); i < DNA.size(); i++) {
                l.add(DNA.get(i));
               
            }
            for(int i = 0; i < l.size(); i++) {
                DNA.set(i, l.get(i));
            }
            for(int i = l.size(); i < DNA.size(); i++) {
                DNA.set(i, ' ');
            }
        }
    }

	/**
     * checks if a given nucleotide sequence is within the DNA sequence.
     * hint: it may be helpful to use getSequence when searching for a particular sequence in the DNA
     *
     * @param DNA the DNA sequence to search for the sequence within
     * @param sequence the nucleotide sequence to search for within the DNA. this may be lowercase!
     * @return true if the given sequence is found in the DNA sequence, otherwise false. If DNA is null, return false.
     */
    public static boolean containsSequence(ArrayList<Character> DNA,String sequence) {
        String seq = "";
        if(DNA == null)
            return false;
        ArrayList<Character> l = new ArrayList<>();
        for(Character c : DNA) {
            seq += c;
        }
        if(seq.toUpperCase().contains(sequence.toUpperCase())) {
            return true;
        }
        return false;
    }

	/**
     * checks if a given nucleotide is within the DNA sequence
     *
     * @param DNA the DNA sequence to search for the nucleotide in
     * @param nucleotide the single nucleotide that is being searched for in the DNA sequence. this may be lowercase!
     * @return true if the given nucleotide is found in the DNA sequence, otherwise false. If DNA is null, return false.
     */
	public static boolean containsNucleotide(ArrayList<Character> DNA, Character nucleotide) {
		// fill in body
	    nucleotide = Character.toUpperCase(nucleotide);
	    for (char testChar : DNA) {
	        if (testChar == nucleotide) {
	            return true;
	        }
	    }
		return false;
	}

	/**
     * swaps the given Character with another Character if it is within the DNA sequence. Return if DNA is null.
     *
     * @param DNA the DNA sequence to swap matching nucleotides in
     * @param swap1 the nucleotide that should replace swap2
     * @param swap2 the nucleotide that should replace swap1
     */
	public static void swapNucleotide(ArrayList<Character> DNA, Character swap1, Character swap2) {
		// fill in body
	    Character.toUpperCase(swap1);
	    Character.toUpperCase(swap2);
	    for (int i = 0; i < DNA.size(); ++i) {
            if (DNA.get(i) == swap2) {
                DNA.set(i, Character.toUpperCase(swap1));
            }
        }
	}

	/**
     * adds a nucleotide to the given DNA sequence. Return if DNA is null.
     *
     * @param DNA the DNA sequence to add the nucleotide to
     * @param nucleotide the single nucleotide that should be added to the DNA sequence
     */
	public static void addNucleotide(ArrayList<Character> DNA, Character nucleotide) {
		// fill in body
	    DNA.add(Character.toUpperCase(nucleotide));
	}

	/**
     * creates a String representing the given DNA sequence
     *
     * @param DNA the DNA sequence to create a String from
     * @return the String representation of the DNA sequence. Return if DNA is null.
     */
	public static String getSequence(ArrayList<Character> DNA) {
		// fill in body
	    String sequence = "";
	    for (char nucleotide : DNA) {
	        sequence += Character.toString(nucleotide);
	    }
		return sequence;
	}


	/**
	 * first, paste your entire main method from part 1 into the specified section
	 * then, add to this method using the inline comments as a guide
	 */
	public static void main(String[] args) {
	    char userInput1;
	    char userInput2;
	    char userInput3;
	    char userInput4;
	    String userString;
	    String userInput5;
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
                char userInput = input.next().toUpperCase().charAt(0);
                while (!(userInput == 'A') && !(userInput == 'C') && !(userInput == 'G') && !(userInput == 'T')) {
                    userInput = input.next().toUpperCase().charAt(0);
                }
                addNucleotide(DNA, userInput);
            }
            System.out.print("The DNA sequence you entered is ");
            // print out the String representation of the DNA sequence using getSequence
            System.out.println(getSequence(DNA));

		System.out.print("Enter the nucleotide you want to swap: ");
		// read in a nucleotide to replace
		userInput1 = input.next().charAt(0);
		System.out.print("Enter the nucleotide you want to swap it with: ");
		// read in a replacement nucleotide
		userInput2 = input.next().charAt(0);
		System.out.print("The new DNA sequence is ");
		// print the new DNA to the user
		swapNucleotide(DNA, Character.toUpperCase(userInput1), Character.toUpperCase(userInput2));
		for (char nucleotides : DNA) {
		    System.out.print(nucleotides);
		}
		System.out.println();
		System.out.print("Enter the nucleotide you want to look for: ");
		// read in a nucleotide to look for
		userInput3 = input.next().charAt(0);
		System.out.print("The nucleotide was ");
		// print whether the nucleotide was found or not, using "found" or "not found"
		if (containsNucleotide(DNA, userInput3)) {
		    System.out.println("found");
		}
		else {
		    System.out.println("not found");
		}
		System.out.print("Enter the sequence you want to look for: ");
		// read in a nucleotide sequence to look for
		userString = input.next();
		System.out.print("The sequence was ");
		// print whether the nucleotide sequence was found or not, using "found" or "not found"
		if (containsSequence(DNA, userString)) {
            System.out.println("found");
        }
        else {
            System.out.println("not found");
        }
		System.out.print("Enter the sequence you want to remove: ");
		// read in a nucleotide sequence to remove
		userInput5 = input.next();
		System.out.print("The new DNA sequence is ");
		// print the modified DNA sequence
		removeSequence(DNA, userInput5);
		for (char sequenceChars : DNA) {
		    if (Character.toString(sequenceChars) != " ") {
            System.out.print(sequenceChars);
		    }
        }
		System.out.println();
        }

	}
}
