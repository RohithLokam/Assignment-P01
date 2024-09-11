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
 * Manages election candidates with methods to add, drop, and find candidates.
 */
public class ElectionManager {

    /**
     * Adds a candidate to the array if they do not already exist.
     * 
     * @param candidates The array of candidates.
     * @param numCandidates The current number of candidates.
     * @param name The name of the candidate.
     * @param party The party of the candidate.
     * @param numVotes The number of votes the candidate has.
     * @return The updated number of candidates.
     */
    public static int addCandidate(String[][] candidates, int numCandidates, String name, String party, int numVotes) {
        if (containsCandidate(candidates, numCandidates, name, party)) {
            System.out.println("Candidate already exists.");
            return numCandidates;
        }
        if (numCandidates < candidates.length) {
            candidates[numCandidates][0] = name;
            candidates[numCandidates][1] = party;
            candidates[numCandidates][2] = Integer.toString(numVotes);
            return numCandidates + 1;
        } else {
            System.out.println("No space left to add candidate.");
            return numCandidates;
        }
    }

    /**
     * Checks if a candidate already exists in the array.
     * 
     * @param candidates The array of candidates.
     * @param numCandidates The current number of candidates.
     * @param name The name of the candidate.
     * @param party The party of the candidate.
     * @return True if the candidate exists, otherwise false.
     */
    public static boolean containsCandidate(String[][] candidates, int numCandidates, String name, String party) {
        for (int i = 0; i < numCandidates; i++) {
            if (candidates[i][0].equals(name) && candidates[i][1].equals(party)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes a candidate from the array.
     * 
     * @param candidates The array of candidates.
     * @param numCandidates The current number of candidates.
     * @param name The name of the candidate to remove.
     * @param party The party of the candidate to remove.
     * @return The updated number of candidates.
     */
    public static int dropCandidate(String[][] candidates, int numCandidates, String name, String party) {
        for (int i = 0; i < numCandidates; i++) {
            if (candidates[i][0].equals(name) && candidates[i][1].equals(party)) {
                // Shift remaining candidates
                for (int j = i; j < numCandidates - 1; j++) {
                    candidates[j] = candidates[j + 1];
                }
                candidates[numCandidates - 1] = new String[3]; // Clear the last slot
                return numCandidates - 1;
            }
        }
        System.out.println("Candidate not found.");
        return numCandidates;
    }

    /**
     * Finds the candidate with the highest number of votes.
     * 
     * @param candidates The array of candidates.
     * @param numCandidates The current number of candidates.
     * @return The name of the candidate with the highest votes.
     */
    public static String findWinner(String[][] candidates, int numCandidates) {
        if (numCandidates == 0) return "No candidates";

        String winner = candidates[0][0];
        int maxVotes = Integer.parseInt(candidates[0][2]);

        for (int i = 1; i < numCandidates; i++) {
            int votes = Integer.parseInt(candidates[i][2]);
            if (votes > maxVotes) {
                maxVotes = votes;
                winner = candidates[i][0];
            }
        }
        return winner != null ? winner : "No valid candidates";
    }

    /**
     * Finds the candidate with the lowest number of votes.
     * 
     * @param candidates The array of candidates.
     * @param numCandidates The current number of candidates.
     * @return The name of the candidate with the lowest votes.
     */
    public static String findLowestPollingCandidate(String[][] candidates, int numCandidates) {
        if (numCandidates == 0) return "No candidates";
        String lowest = candidates[0][0];
        int minVotes = Integer.parseInt(candidates[0][2]);

        for (int i = 1; i < numCandidates; i++) {
            int votes = Integer.parseInt(candidates[i][2]);
            if (votes < minVotes) {
                minVotes = votes;
                lowest = candidates[i][0];
            }
        }
        return lowest != null ? lowest : "No valid candidates";
    }
}
