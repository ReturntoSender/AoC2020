package dev.daxinger.aoc2020;

import java.util.ArrayList;
import java.util.List;

public class Day5 extends AOCPuzzle {
    public Day5() {
        super("5");
    }

    @Override
    void solve(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            String sitz = input.get(i).replace("F", "0");
            sitz = sitz.replace("B", "1");
            sitz = sitz.replace("R", "1");
            sitz = sitz.replace("L", "0");
            int row = Integer.parseInt(sitz.substring(0,7),2);
            int colum = Integer.parseInt(sitz.substring(7, 10),2);
            System.out.println(row + " " + colum);
        }
    }
}
