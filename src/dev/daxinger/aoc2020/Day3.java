package dev.daxinger.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3 {



    public static void main(String[] args) throws FileNotFoundException {

        int[] deltaX = {1, 3, 5, 7, 1};
        int[] deltaY = {1, 1, 1, 1, 2};
        long finalCount = 1;

        ArrayList<String> list = new ArrayList<>(readInput("day3.txt"));

        for (int i = 0; i < deltaX.length; i++) {
            finalCount *= traceWay(list, deltaX[i], deltaY[i]);
            System.out.println(finalCount);
        }
    }

    public static List<String> readInput(String input) throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        Scanner scan = new Scanner(new File("inputs/" + input));
        while(scan.hasNextLine()) {
            list.add(scan.nextLine());
        }
        return list;
    }

    public static int traceWay(List<String> list, int deltaX, int deltaY) {
        int x = 0;
        int countTrees= 0;
        for (int i = 0; i < list.size()-1; i += deltaY) {
            x += deltaX;
            if (list.get(i+deltaY).charAt((x)%(list.get(i+deltaY).length())) == '#') countTrees++;
        }
        System.out.println(countTrees);
        return countTrees;
    }
}
