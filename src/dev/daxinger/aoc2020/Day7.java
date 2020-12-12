package dev.daxinger.aoc2020;

import java.util.*;

public class Day7 extends AOCPuzzle {
    public Day7() {
        super("7");
    }


    @Override
    void solve(List<String> input) {
        //puzzleA(input);
        puzzleB(input);
    }

    void puzzleA(List<String> input) {
        String color = "shinygold";
        Map<String, List<String>> bags = splitInput(input);
        Set<String> soManyGold = searchBag(color, bags);
        if (!soManyGold.contains(color)) {
            System.out.println("In " + soManyGold.size() + " bags is gold");
        }
    }

    void puzzleB(List<String> input) {
        String color = "shinygold";
        Map<String, List<String>> bags = splitInput(input);
        System.out.println(bags.size());
        System.out.println("So many bags are inside your goldbag: " + (countBags(color, bags)-1));
    }

    int countBags(String color, Map<String, List<String>> bag) {
        int counter = 1;
        List<String> inside = bag.get(color);
        if (!inside.isEmpty()) {
            switch (inside.size()) {
                case 2:
                    int bagcount1 = Integer.parseInt(inside.get(0)) * countBags(inside.get(1), bag);
                    counter = bagcount1 +1;
                    break;
                case 4:
                    int bagcount = Integer.parseInt(inside.get(0)) * countBags(inside.get(1), bag);
                    bagcount += Integer.parseInt(inside.get(2)) * countBags(inside.get(3), bag);
                    counter = bagcount +1;
                    break;
                case 6:
                    int bagcount2 = Integer.parseInt(inside.get(0)) * countBags(inside.get(1), bag);
                    bagcount2 += Integer.parseInt(inside.get(2)) * countBags(inside.get(3), bag);
                    bagcount2 += Integer.parseInt(inside.get(4)) * countBags(inside.get(5), bag);
                    counter = bagcount2 +1;
                    break;
                case 8:
                    int bagcount3 = Integer.parseInt(inside.get(0)) * countBags(inside.get(1), bag);
                    bagcount3 += Integer.parseInt(inside.get(2)) * countBags(inside.get(3), bag);
                    bagcount3 += Integer.parseInt(inside.get(4)) * countBags(inside.get(5), bag);
                    bagcount3 += Integer.parseInt(inside.get(6)) * countBags(inside.get(7), bag);
                    counter = bagcount3 +1;
                    break;
            }
            return counter;
        }
        else return 0;
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
        for (Map.Entry<String, List<String>> c : bag.entrySet()) {
            String name = c.getKey();
            ArrayList<String> list = new ArrayList<>(c.getValue());
            if (!list.isEmpty()) {
                if (list.contains(color)) {
                    containsGold.add(name);
                    String newColor = name;
                    containsGold.addAll(searchBag(newColor, bag));
                }
            }
        }
        return containsGold;
    }
}