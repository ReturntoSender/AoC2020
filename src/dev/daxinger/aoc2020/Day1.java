package dev.daxinger.aoc2020;

import java.util.List;

public class Day1 extends AOCPuzzle
{
    public Day1()
    {
        super("1");
    }

    @Override
    void solve(List<String> input)
    {
        answerPart1(input);
        answerPart2(input);
    }

    public void answerPart2(List<String>  input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i+1; j < input.size(); j++) {
                for (int k = j+1; k < input.size(); k++) {
                    Integer int1 = Integer.parseInt(input.get(i));
                    Integer int2 = Integer.parseInt(input.get(j));
                    Integer int3 = Integer.parseInt(input.get(k));

                    if (int1 + int2 + int3 == 2020) {
                        System.out.println("The second answer is: " + (int1 * int2 * int3));
                    }
                }
            }
        }
    }

    public void answerPart1(List<String>  input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i+1; j < input.size(); j++) {
                Integer int1 = Integer.parseInt(input.get(i));
                Integer int2 = Integer.parseInt(input.get(j));
                if (int1 + int2 == 2020) {
                    System.out.println("The first answer is: " + (int1 * int2));
                }
            }
        }
    }
}