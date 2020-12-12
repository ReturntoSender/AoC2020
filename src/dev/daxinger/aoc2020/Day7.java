package dev.daxinger.aoc2020;

import java.util.*;

public class Day7 extends AOCPuzzle {
    public Day7() {
        super("test");
    }


    @Override
    void solve(List<String> input) {
        puzzleA(input);
        puzzleB(input);
    }

    void puzzleA(List<String> input) {
        String color = "shinygold";
        Map<String, List<String>> bags = splitInput(input);
        Set<String> soManyGold = searchBag(color, bags);
        System.out.println("In " + soManyGold.size() + " bags is gold");
    }

    void puzzleB(List<String> input) {

    }

    Map splitInput(List<String> input) {
        Map<String, List<String>> bag = new HashMap<>();
        int max = 0;

        for (String s : input) {
            List<String> containment = new ArrayList<String>();
            String[] cut = s.split(" ");
            if (cut.length > max) max = cut.length;
            switch(cut.length) {
                case 7:
                    containment.add("");
                    break;
                case 8:
                    List<String> newlist = Arrays.asList(cut[4], cut[5] + cut[6]);
                    containment.addAll(newlist);
                    break;
                case 12:
                    List<String> newlist2 = Arrays.asList(cut[4], cut[5] + cut[6], cut[8], cut[9] + cut[10]);
                    containment.addAll(newlist2);
                    break;
                case 16:
                    List<String> newlist3 = Arrays.asList(cut[4], cut[5] + cut[6], cut[8], cut[9] + cut[10], cut[12], cut[13] + cut[14]);
                    containment.addAll(newlist3);
                    break;
                case 20:
                    List<String> newlist4 = Arrays.asList(cut[4], cut[5] + cut[6], cut[8], cut[9] + cut[10], cut[12], cut[13] + cut[14], cut[16], cut[17] + cut[18]);
                    containment.addAll(newlist4);
                    break;
            }
            bag.put(cut[0] + cut[1], containment);
        }
        return bag;
    }

    Set<String> searchBag(String color, Map<String, List<String>> bag) {
        Set<String> containsGold = new HashSet<>();
        int counter = 0;

        for (Map.Entry<String, List<String>> c : bag.entrySet()) {
            String name = c.getKey();
            ArrayList<String> list = new ArrayList<>();
            list.addAll(c.getValue());
        }
        System.out.println(containsGold);
        return containsGold;
    }
}