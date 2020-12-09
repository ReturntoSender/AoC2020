package dev.daxinger.aoc2020;

import java.util.*;

public class Day5 extends AOCPuzzle {
    public Day5() {
        super("5");
    }

    @Override
    void solve(List<String> input) {
        puzzleA(input);
        puzzleB(input);
    }

    void puzzleA(List<String> input) {

        List<Integer> seats = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            String sitz = input.get(i);
            sitz = sitz.replace("F", "0");
            sitz = sitz.replace("B", "1");
            sitz = sitz.replace("R", "1");
            sitz = sitz.replace("L", "0");
            int row = Integer.parseInt(sitz.substring(0,7),2);
            int colum = Integer.parseInt(sitz.substring(7, 10),2);
            //System.out.println(row + " " + colum);
            int seatID = (row*8)+colum;
            //System.out.println("Seat ID: " + seatID);
            seats.add(seatID);
            Collections.sort(seats);
        }
        System.out.println("Highest seat-ID is: " + (seats.get(seats.size()-1)));
    }

    void puzzleB(List<String> input) {

        List<Integer> seats = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            String sitz = input.get(i);
            sitz = sitz.replace("F", "0");
            sitz = sitz.replace("B", "1");
            sitz = sitz.replace("R", "1");
            sitz = sitz.replace("L", "0");
            int row = Integer.parseInt(sitz.substring(0,7),2);
            int colum = Integer.parseInt(sitz.substring(7, 10),2);
            //System.out.println(row + " " + colum);
            int seatID = (row*8)+colum;
            //System.out.println("Seat ID: " + seatID);
            seats.add(seatID);
            Collections.sort(seats);
        }

        List<Integer> diff = new ArrayList<>();

        for (int i = seats.get(0); i < (seats.get(seats.size()-1)); i++) {
            diff.add(i);
        }
        //System.out.println(diff);
        //System.out.println(seats);

        for (int i = 0; i < seats.size()-1; i++) {
            if (diff.contains(seats.get(i)));
            diff.remove(diff.indexOf(seats.get(i)));
        }
        System.out.println("The middle seat-ID is: " + diff.get(0));
    }
}
