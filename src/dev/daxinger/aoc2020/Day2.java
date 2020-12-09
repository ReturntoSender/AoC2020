package dev.daxinger.aoc2020;

import java.util.List;

public class Day2 extends AOCPuzzle
{
    public Day2()
    {
        super("2");
    }

    @Override
    void solve(List<String> input) {
        puzzleA(input);
        puzzleB(input);
    }

    public void puzzleA (List<String> input) {
        int valids = 0;
        for (String line : input) {
            String[] cut = line.split(" ");

            String[] minmax = cut[0].split("-");
            int min = Integer.parseInt(minmax[0]);
            int max = Integer.parseInt(minmax[1]);

            char key = cut[1].charAt(0);

            String password = cut[2];

            //System.out.println("min-max " + min + " und " + max);
            //System.out.println("Buchstabe ist: " + key);
            //System.out.println("Passwort ist: " + password);

            int counter = 0;
            for (int i = 0; i < password.length(); i++) {
                //System.out.println(password.charAt(i) + " " + key);
                if (password.charAt(i) == key) {
                    counter++;
                }
                //System.out.println(counter);
            }
            //System.out.println("Counter steht bei " + counter);
            if (counter <= max && counter >= min) {
                valids++;
                //System.out.println(valids);

            }
        }
        System.out.println("Anzahl der Vailds Aufgabe 1: " + valids);
    }

    public void puzzleB (List<String> input) {
        int valids = 0;
        for (String line : input) {
            String[] cut = line.split(" ");

            String[] minmax = cut[0].split("-");
            int min = Integer.parseInt(minmax[0]);
            int max = Integer.parseInt(minmax[1]);

            char key = cut[1].charAt(0);

            String password = cut[2];

            if (password.charAt(min-1) == key ^ password.charAt(max-1) == key) {
                valids++;
            }

        }
        System.out.println("Anzahl der Vailds Aufgabe 2: " + valids);
    }
}