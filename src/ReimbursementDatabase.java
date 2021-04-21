///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Reimbursement Database
// Course:          CS 200, Spring 2020
//
// Author:          Joe Rafferty
// Email:           jrrafferty@wisc.edu
// Lecturer's Name: Jim Williams
//


import java.util.ArrayList;

/**
 * ReimbursementDatabase class containing all methods for 
 * modifying a database of reimbursement data
 * 
 * @author Joe Rafferty
 *
 */
public class ReimbursementDatabase {
	
    /**
     * Represent the database as a String by iterating through each client and their expense table
     * This should be of the format:
     * 
     * Expenses for Billson
     * [Travel, 11/03/19, 400.01, JetBlue]
     * [Lodging, 11/03/19, 229.99, Marriott]
     * [Food, 11/04/19, 19.78, Room service]
     * [Food, 11/04/19, 15.46, Old Fashioned]
     * [Food, 11/05/19, 26.84, Sheetz]
     * [Other, 11/05/19, 5.00, Metro pass]
     * 
     * Expenses for Brandersoft
     * [Travel, 10/27/19, 150.88, Greyhound]
     * ...
     * 
     * There should be only one newline character at the end of the String.
     * 
     * If a client has no expenses, their expenses should only show "[ no expenses ]", such as:
     * Expenses for Carol
     * [ no expenses ]
     * 
     * Be sure to use the toString() method for each row of the expense table!
     * It will produce a String for you that looks exactly like each row displayed above
     * 
     * @param database Three dimensional database to be converted to a String
     * @param names ArrayList of names for each database entry, parallel with the database
     * @return A single String that displays the database, or 
     *         null if the database or names list is null
     */
	public static String displayDatabase(ArrayList<ArrayList<ArrayList<String>>> database, ArrayList<String> names) {
	    if (!(database == null)) {
	        String databaseString = "";
	        for (int i = 0; i < names.size(); ++i) {
	            databaseString += ("Expenses for " + names.get(i) + "\n");
	            if (database.get(i).size() == 0) {
	                databaseString += "[ no expenses ]" + "\n";
	            }
	            for (int j = 0; j < database.get(i).size(); ++j) {
	                databaseString += database.get(i).get(j).toString() + "\n";
	            }
	            databaseString += "\n";
	        }
	        return databaseString;
	    }
	        
	    else {
		return null;
	}
	}
	
	/**
	 * Calculate the total expense cost of a single client
	 *
	 * If the database is null or the client number is out of range, this should just return -1
	 * If the client's expense table is null or empty, this should just return 0
	 * 
	 * Hint: When converting from a String to a double, you may want to use the Double.valueOf() method
	 * 
	 * @param database  Three dimensional database to find costs in
	 * @param clientNum Index in database for the client whose expenses are being totaled
	 * @return Total expense cost for a single client, or
     *         -1 if database is null or clientNum is out of range, or
     *          0 if the client's expense table is null or empty
	 */
	public static double totalExpensesClient(ArrayList<ArrayList<ArrayList<String>>> database, int clientNum) {
	    double totalExpense = 0;
	    if ((database == null || ((clientNum < 0) || (clientNum >= database.size())))){
            return -1;
        }
        else if ((database.get(clientNum).size() == 0) || (database.get(clientNum) == null)) {
            return 0;
        }
        else {
	        for (int i = 0; i < database.get(clientNum).size(); ++i) {
	            totalExpense += Double.valueOf(database.get(clientNum).get(i).get(2));
	        }
                return totalExpense;

	    }
	}

	
	/**
	 * Calculate the total expense cost across all clients
	 * 
	 * Do not repeat code! You must call your totalExpensesClient method
	 * 
	 * @param database Three dimensional database to find costs in
	 * @return Sum of all expenses across all clients in database, or
	 *         -1 if the database is null
	 */
	public static double totalExpenses(ArrayList<ArrayList<ArrayList<String>>> database) {
	    double totalExpenses = 0;
	    if (!(database == null)) {
	        for (int i = 0; i < database.size(); ++i) {
	            totalExpenses += totalExpensesClient(database, i);
	        }
	        return totalExpenses;
	    }
	    else {
	        return -1;
	    }
	}
	
	/**
	 * Calculate the average expense cost of a single client
	 * 
	 * If the database is null or the client number is out of range, this should just return -1
	 * If the client's expense table is null or empty, this should just return 0
	 * 
	 * @param database Three dimensional database with all clients' expenses
	 * @param clientNum Index in database for the client whose expenses are being averaged
	 * @return Average expense cost for a single client, or
	 *         -1 if database is null or clientNum is out of range, or
	 *          0 if the client's expense table is null or empty  
	 */
	public static double averageExpensesClient(ArrayList<ArrayList<ArrayList<String>>> database, int clientNum) {
	    if ((database == null || ((clientNum < 0) || (clientNum >= database.size())))){
	        return -1;
	    }
	    else if ((database.get(clientNum).size() == 0) || (database.get(clientNum) == null)) {
            return 0;
        }
	    else {
	        double totalExpenses = totalExpensesClient(database, clientNum);
            double numExpenses = database.get(clientNum).size();
            double avgExpenses = totalExpenses / numExpenses;
            return avgExpenses;

	    }
	}
	
	/**
	 * Calculate the average expense cost across all clients, calculated *per client* 
	 * So you must find the average of each client's costs,
	 * Then average each of their average costs
	 * 
	 * For two clients with these expenses:
	 * Expenses for Billson
	 * [Travel, 11/03/19, 400.01, JetBlue]
	 * [Lodging, 11/03/19, 229.99, Marriott]
	 * 
	 * Expenses for Brandersoft
	 * [Travel, 10/27/19, 150.88, Greyhound]
	 * 
	 * You should take the average of the first client  = 315, 
	 * then take the average of the second client = 150.88,
	 * then take the average of their average costs = 232.94
	 * 
	 * Do not repeat code! You must call your averageExpensesClient method
	 * 
	 * @param database Three dimensional database to find costs in
	 * @return The average expense cost across all clients, or 
	 *         -1 if the database is null
	 */
	public static double averageExpenses(ArrayList<ArrayList<ArrayList<String>>> database) {
	    double avgExpensesSum = 0;
	    double avgExpensesTotal = 0;
	    if (database == null) {
	        return -1;
	    }
	    else {
	        for (int i = 0; i < database.size(); ++i) {
	            avgExpensesSum += averageExpensesClient(database, i);
	        }
	        avgExpensesTotal = avgExpensesSum / database.size();
	        return avgExpensesTotal;
	    }
	}
	
	/**
	 * Clear a client's expense table
	 * After this method finishes, the client's expense table should have 0 entries (not null)
	 * 
	 * If database is null, clientNum is out of range, or client's expense table is null, this method should exit
	 * 
	 * @param database Three dimensional database with all clients' expenses
	 * @param clientNum Index in database for the client who is being reimbursed
	 */
	public static void reimburseClient(ArrayList<ArrayList<ArrayList<String>>> database, int clientNum) {
	    if ((database == null) || ((clientNum < 0) || (clientNum >= database.size())) || (database.get(clientNum) == null)) {
	        return;
	    }
	    else {
	        /*
	        for (int i = 0; i < database.get(clientNum).size(); ++i) {
	            database.get(clientNum).remove(i);
	        }
	        */
	        database.get(clientNum).clear();
	    }
	}
	
	/**
	 * Get the most recent expense (last row in their table) for a single client, as a String
	 * 
	 * For a client with these expenses:
	 * Expenses for Billson
	 * [Travel, 11/03/19, 400.01, JetBlue]
	 * [Lodging, 11/03/19, 229.99, Marriott]
	 * 
	 * This method should return the Lodging expense row, as a String:
	 * [Lodging, 11/03/19, 229.99, Marriott]
	 * 
	 * Be sure to use the toString() method for the row of the expense table you are getting!
	 * It will produce a String for you that looks exactly like each row displayed above
	 * 
	 * @param database  Three dimensional database to find expenses in
	 * @param clientNum Index in database for the client whose most recent expense is being found
	 * @return String representation of the client's most recent expense, or
	 *         null if the database is null or the clientNum is out of range, or
	 *         "[ no expenses ]" if the client's expense table is null or empty
	 */
	public static String mostRecentExpense(ArrayList<ArrayList<ArrayList<String>>> database, int clientNum) {
	    String recentExpense = "";
	    if ((database == null) || ((clientNum < 0) || (clientNum >= database.size()))) {
	        return null;
	    }
	    else if ((database.get(clientNum).size() == 0) || (database.get(clientNum) == null)) {
	        recentExpense += "[ no expenses ]";
	        return recentExpense;
	    }
	    else {
	        recentExpense += database.get(clientNum).get(database.get(clientNum).size() - 1);
	        return recentExpense;
	    }
	}
	
	/**
	 * Main method 
	 * Created a database and parallel ArrayList for names using the given data, then calls the Config.menu() method
	 * 
	 * @param args Unused
	 */
	public static void main(String[] args) {
		ArrayList<ArrayList<ArrayList<String>>> database = Config.DATABASE;
		ArrayList<String> names = Config.NAMES;
		
		Config.menu(database, names);
	}
}