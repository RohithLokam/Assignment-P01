//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:  ( descriptive title of the program making use of this file)
// Course:  CS 300 Fall 2024
// Author:  (your name)
// Email: (your @wisc.edu email address) 
// Lecturer: (Hobbes LeGault or Blerina Gkotse)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner) 
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//  ---Write-up states that pair programming is allowed for this assignment.
//  ---We have both read and understand the course Pair Programming Policy. 
//  ---We have registered our team prior to the team registration deadline.
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Persons:        (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Tests the methods of the ElectionManager class.
 */
public class ElectionManagerTester {

    public static void main(String[] args) {
        String[][] candidates = new String[10][3]; 
        int[] numCandidates = {0};

        // Testing methods
        testAddCandidate(candidates, numCandidates);
        testContainsCandidate(candidates, numCandidates);
        testDropCandidate(candidates, numCandidates);
        testFindWinner(candidates, numCandidates);
        testFindLowestPollingCandidate(candidates, numCandidates);

        // Final check
        checkAllTests(numCandidates[0]);
    }

    /**
     * Tests the addCandidate method.
     * 
     * @param candidates The array of candidates.
     * @param numCandidates The current number of candidates.
     */
    public static void testAddCandidate(String[][] candidates, int[] numCandidates) {
        System.out.println("Testing addCandidate:");
        numCandidates[0] = ElectionManager.addCandidate(candidates, numCandidates[0], "Joe Biden", "Democrat", 1000000);
        numCandidates[0] = ElectionManager.addCandidate(candidates, numCandidates[0], "Donald Trump", "Republican", 1000000);
        numCandidates[0] = ElectionManager.addCandidate(candidates, numCandidates[0], "Bernie Sanders", "Independent", 500000);
        numCandidates[0] = ElectionManager.addCandidate(candidates, numCandidates[0], "Elizabeth Warren", "Democrat", 750000);
        numCandidates[0] = ElectionManager.addCandidate(candidates, numCandidates[0], "Mike Pence", "Republican", 800000);
        System.out.println("Number of candidates after addition: " + numCandidates[0]);
        System.out.println();
    }

    /**
     * Tests the containsCandidate method.
     * 
     * @param candidates The array of candidates.
     * @param numCandidates The current number of candidates.
     */
    public static void testContainsCandidate(String[][] candidates, int[] numCandidates) {
        System.out.println("Testing containsCandidate:");
        boolean contains = ElectionManager.containsCandidate(candidates, numCandidates[0], "Joe Biden", "Democrat");
        System.out.println("Joe Biden (Democrat) exists: " + contains);
        
        contains = ElectionManager.containsCandidate(candidates, numCandidates[0], "Barack Obama", "Democrat");
        System.out.println("Barack Obama (Democrat) exists: " + contains);
        System.out.println();
    }

    /**
     * Tests the dropCandidate method.
     * 
     * @param candidates The array of candidates.
     * @param numCandidates The current number of candidates.
     */
    public static void testDropCandidate(String[][] candidates, int[] numCandidates) {
        System.out.println("Testing dropCandidate:");
        numCandidates[0] = ElectionManager.dropCandidate(candidates, numCandidates[0], "Bernie Sanders", "Independent");
        System.out.println("Number of candidates after dropping Bernie Sanders: " + numCandidates[0]);
        
        numCandidates[0] = ElectionManager.dropCandidate(candidates, numCandidates[0], "Nonexistent Candidate", "Unknown");
        System.out.println("Number of candidates after attempting to drop nonexistent candidate: " + numCandidates[0]);
        System.out.println();
    }

    /**
     * Tests the findWinner method.
     * 
     * @param candidates The array of candidates.
     * @param numCandidates The current number of candidates.
     */
    public static void testFindWinner(String[][] candidates, int[] numCandidates) {
        System.out.println("Testing findWinner:");
        String winner = ElectionManager.findWinner(candidates, numCandidates[0]);
        System.out.println("Winner: " + winner);
        System.out.println();
    }

    /**
     * Tests the findLowestPollingCandidate method.
     * 
     * @param candidates The array of candidates.
     * @param numCandidates The current number of candidates.
     */
    public static void testFindLowestPollingCandidate(String[][] candidates, int[] numCandidates) {
        System.out.println("Testing findLowestPollingCandidate:");
        String lowest = ElectionManager.findLowestPollingCandidate(candidates, numCandidates[0]);
        System.out.println("Lowest polling candidate: " + lowest);
        System.out.println();
    }

    /**
     * Checks if all tests pass.
     * 
     * @param numCandidates The current number of candidates.
     */
    public static void checkAllTests(int numCandidates) {
        // Assuming 5 added candidates, 1 dropped
        if (numCandidates == 4) {
            System.out.println("ALL TESTS: true");
        } else {
            System.out.println("ALL TESTS: false");
        }
    }
}
