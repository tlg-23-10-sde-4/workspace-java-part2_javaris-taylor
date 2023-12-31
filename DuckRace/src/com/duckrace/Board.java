package com.duckrace;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

public class Board implements Serializable {
    private static final String dataFilePath = "data/board.dat";

    // If data/board.dat exists, read that file into a Board object and return it.
    // Otherwise, return a new Board().
    public static Board getInstance() {

        Board board = null;

        if(Files.exists(Path.of(dataFilePath))) {
            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataFilePath))) {
                board = (Board) in.readObject();
            }
            catch(Exception e) {

            }
        }
        else {
            board = new Board();
        }
        return board;
    }


    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    private Board() {

    }



    /*
     * Updates the board (racerMap) by making a DuckRacer "win"
     */
    public void update(int id, Reward reward) {
        DuckRacer racer = null;
        if(racerMap.containsKey(id)) { // check if ID is in the map
            racer = racerMap.get(id);
        }
        else { // id not present
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);
        }
        racerWin(reward, racer);
        save();
    }

    /*
     * Writes *this* Board object to binary file data/board.dat
     * Uses built-in Java ojbect serialization facility.
     */
    private void save() {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataFilePath))) {
        out.writeObject(this);
        }
        catch(Exception e) {

        }
    }

    // TESTING PURPOSES ONLY
    public void showResults() {

        if(racerMap.isEmpty()) {
            System.out.println("+ + + + + + + + + + + + + + + + + + + + +");
            System.out.println("YOU NEED RACERS FOR RESULTS, WIN FIRST");
            System.out.println("+ + + + + + + + + + + + + + + + + + + + +");
        }
        else{
            Collection<DuckRacer> racers = racerMap.values();
            System.out.println("id\t name\t wins\t rewards");
            for(DuckRacer racer : racers) {
                System.out.format("%s\t%s    %s\t%s\n",racer.getId(), racer.getName(), racer.getWins(), racer.getRewards());
//            System.out.println(racer);
            }
        }
    }

    private void racerWin(Reward reward, DuckRacer racer) {
        racer.win(reward);
    }

    // Testing purposes only
    void dumpStudentIdMap() {
        System.out.println(studentIdMap);
    }
    private Map<Integer, String> loadStudentIdMap(){
        Map<Integer,String> idMap = new HashMap<>();

        // read all lines from conf/student-ids.csv into a List<String>
        try {
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));

            for(String line : lines) {
                String[] tokens = line.split(","); // tokens [0] is "1", tokens[1] "Aaron"
                idMap.put(Integer.valueOf(tokens[0]), tokens[1]);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return idMap;
    }

}