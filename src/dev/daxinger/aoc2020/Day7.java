package dev.daxinger.aoc2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7 extends AOCPuzzle
{
    public Day7()
    {
        super("test");
    }

    public static List<String> containments = new ArrayList<String>();
    public static Map<String, Bags> bag = new HashMap<>();

    @Override
    void solve(List<String> input) {
        puzzleA(input);
        puzzleB(input);
    }

    void puzzleA(List<String> input) {
        splitInput(input);
    }

    void puzzleB(List<String> input) {

    }

    void splitInput(List<String> input) {
        for (String s : input) {

            String[] cut = s.split(" ");
            if (cut.length == 12) {
                containments.add(cut[4]);
                containments.add(cut[5] + cut[6]);
                containments.add(cut[8]);
                containments.add(cut[9] + cut[10]);
                bag.put(cut[0]+cut[1], new Bags(cut[0]+cut[1], containments));
                containments.clear();
            }
            else if (cut.length == 8) {
                containments.add(cut[4]);
                containments.add(cut[5] + cut[6]);
                bag.put(cut[0]+cut[1], new Bags(cut[0]+cut[1], containments));
                containments.clear();
            }
            else if (cut.length == 7) {
                bag.put(cut[0]+cut[1], new Bags(cut[0]+cut[1]));

            }
            else {
                System.out.println("Fehler: unbekannte Stringlänge");
            }
        }
        System.out.println(bag.get("lightred").getInsideBags().get(0));
    }

    public class Bags {

        private String name;



        private List<String> insideBags = new ArrayList<>();

        Bags(String name) {
            this.name = name;
        }

        Bags(String name, List<String> insideBags){
            this.insideBags = insideBags;
            this.name = name;
            System.out.println(name + "-" + insideBags);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getInsideBags() {
            return insideBags;
        }

        public void setInsideBags(List<String> insideBags) {
            this.insideBags = insideBags;
        }
    }
}