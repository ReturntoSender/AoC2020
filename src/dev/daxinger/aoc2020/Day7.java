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
        List<String> containment = new ArrayList<String>();
        Map<String, List<String>> bag = new HashMap<>();
        int max = 0;

        for (String s : input) {
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
                    containment.addAll(Arrays.asList(cut[8], cut[9] + cut[10]));
                    break;
                case 16:
                    containment.addAll(Arrays.asList(cut[12], cut[13] + cut[14]));
                    break;
                case 20:
                    containment.addAll(Arrays.asList(cut[16], cut[17] + cut[18]));
                    break;
            }
            bag.put(cut[0] + cut[1], containment);
            for (Map.Entry<String, List<String>> en : bag.entrySet()) {
                System.out.println(en.getKey() + " " + en.getValue());
            }
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
/*
            switch (list.size()) {
                case 1:
                    break;
                case 4:
                    if (list[1].equalsIgnoreCase(color) || list[3].equalsIgnoreCase(color)) {
                        containsGold.add(name);
                        String color2 = name;
                        containsGold.addAll(searchBag(color2, bags));
                    }
                    break;
                case 2:
                    if (list[1].equalsIgnoreCase(color)) {
                        containsGold.add(name);
                        String color3 = name;
                        containsGold.addAll(searchBag(color3, bags));
                    }
                    break;
            }

 */

            if (!list.contains(color)) {
                String color2 = name;
                containsGold.add(name);
                for (int i = 1 ; i < list.size(); i += 2) {
                    containsGold.addAll(searchBag(color2, bag));
                }
            }
        }
        System.out.println(containsGold);
        return containsGold;
    }
}