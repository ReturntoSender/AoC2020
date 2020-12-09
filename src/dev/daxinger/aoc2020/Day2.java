package dev.daxinger.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {

    public static List<String> readInput(String input) throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        Scanner scan = new Scanner(new File("inputs/" + input));
        while(scan.hasNextLine()) {
            list.add(scan.nextLine());
        }
        return list;
    }

    public static void pruefen(List<String> list) {
        int minX;
        int maxX;
        char c = ' ';
        String pass;
        int count = 0;

        for (String line: list) {
            // String der Zeile in Variablen aufspalten
            int z = 0;
            String p = line;
            String[] policy = p.split(": ");
            pass = policy[1];
            String[] minmax = policy[0].split("-");
            minX = Integer.parseInt(minmax[0]);
            maxX = Integer.parseInt(minmax[1].substring(0, (minmax[1].length()-2)));
            c = minmax[1].charAt((minmax[1].length()-1));

            //Prüfen ob Voraussetzung erfüllt ist 1
            //for (int i = 0; i < pass.length(); i++) {
            //    if(pass.charAt(i) == c) z++;
            //}
            //if (z < minX ^ z > maxX) continue;
            //else count++;

            //Prüfen ob Voraussetzung erfüllt ist 2
            if (pass.charAt(minX-1) == c ^ pass.charAt(maxX-1) == c) count++;
        }
        System.out.println(count);

    }

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> list = new ArrayList<>(readInput("day2.txt"));
        pruefen(list);
    }
}