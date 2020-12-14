package dev.daxinger.aoc2020;

import java.util.*;

public class Day8 extends AOCPuzzle {
    public Day8() {
        super("8");
    }

    int globalAcc;
    int pc;

    @Override
    void solve(List<String> input) {
        puzzleA(input);
        puzzleB();
    }

    void puzzleA(List<String> input) {
        runProgram(input);
        System.out.println("Part 1: " + globalAcc + "   " + pc);

    }

    void puzzleB() {

    }

    public Result runProgram(List<String> input) {
        globalAcc = 0;
        pc = 0;
        boolean run = true;
        List<Integer> visitedPCs = new ArrayList<>();
        while(run) {
            visitedPCs.add(pc);
            String op = input.get(pc);
            String[] prog = op.split(" ");

            switch(prog[0]) {
                case "nop":
                    pc++;
                    break;
                case "acc":
                    globalAcc += Integer.parseInt(prog[1]);
                    pc++;
                    break;
                case "jmp":
                    pc += Integer.parseInt(prog[1]);
                    break;

            }
            if (visitedPCs.contains(pc)) {
                run = false;
            }
        }
        return null;
    }

    private static class Result {

    }
}
