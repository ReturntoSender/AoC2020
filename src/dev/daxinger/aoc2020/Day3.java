package dev.daxinger.aoc2020;

import java.util.List;

public class Day3 extends AOCPuzzle
{
    public Day3()
    {
        super("3");
    }

    @Override
    void solve(List<String> input) {
        puzzleA(input);
        puzzleB(input);
    }

    void puzzleA(List<String> input) {

        int x = 0;
        int y = 0;
        int deltaX = 3;
        int deltaY = 1;
        int treeCount = 0;

        for (int i = 0; i < input.size()-1; i += deltaY ) {
            x += deltaX;
            //System.out.println("X: " + x);
            y += deltaY;
            //System.out.println("Y: " + y);

            if (input.get(y).charAt(x%input.get(y).length()) == '#') {
                treeCount++;
            }
            //System.out.println(input.get(y).charAt(x%input.get(y).length()));
        }
        System.out.println("You hit " + treeCount + " trees in puzzle 1");

    }

    void puzzleB(List<String> input) {

        int[] deltaX = {1, 3, 5, 7, 1};
        int[] deltaY = {1, 1, 1, 1, 2};
        int treeCount;
        long prud = 1;

        for (int j = 0; j < deltaX.length; j++) {
            treeCount = 0;
            int x = 0;
            int y = 0;
            for (int i = 0; i < input.size()-1; i += deltaY[j] ) {
                x += deltaX[j];
                //System.out.println("X: " + x);
                y += deltaY[j];
                //System.out.println("Y: " + y);

                if (input.get(y).charAt(x%input.get(y).length()) == '#') {
                    treeCount++;
                }

                //System.out.println(input.get(y).charAt(x%input.get(y).length()));
            }
            prud *= treeCount;
        }
        System.out.println("You hit " + prud + " trees in puzzle 2");
    }
}
