package dev.daxinger.aoc2020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6 extends AOCPuzzle
{
    public Day6()
    {
        super("6");
    }

    @Override
    void solve(List<String> input) {
        puzzleA(input);
        puzzleB(input);
    }

    void puzzleA(List<String> input) {

        List<Character> answers = new ArrayList<>();
        int yeses = 0;

        for (String s : input ) {

            if(s.isEmpty()) {
                //System.out.println(answers);
                yeses += answers.size();
                answers.clear();
            }
            else {
                for (char c : s.toCharArray() ) {
                    if (!answers.contains(c))
                    answers.add(c);
                }
            }
        }
        System.out.println("The count you search is: " + yeses);
    }

    void puzzleB(List<String> input) {

        List<Character> answers = new ArrayList<>();

        int yeses = 0;
        boolean firstInGroup = true;
        List<Character> first = new ArrayList<>();

        for (String s : input) {

            if(s.isEmpty()) {
                //System.out.println(first.size());
                yeses += first.size();
                first.clear();
                firstInGroup = true;
            }
            else {

                if (firstInGroup) {
                    for (char c : s.toCharArray()) {
                        first.add(c);
                    }
                    //System.out.println(first);
                    firstInGroup = false;
                }
                else {
                    List<Character> second = new ArrayList<>();
                    for (char c : s.toCharArray()) {
                        second.add(c);
                    }
                    //System.out.println(first + " " + second);
                    first.removeIf(b -> !second.contains(b));
                    firstInGroup = false;
                }
            }
        }
        System.out.println("The count you search is: " + yeses);
    }
}