package com.wilb0t.aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Day6 {

  public record Input(List<List<Integer>> nums, List<String> ops) {
    public static Input from(List<String> input) {
      var nums = new ArrayList<List<Integer>>();
      for (var line : input.subList(0, input.size() - 1)) {
        var numline = Arrays.stream(line.split("\\s+"))
            .filter(s -> !s.isEmpty())
            .map(Integer::parseInt)
            .toList();
        nums.add(numline);
      }
      var ops = Arrays.stream(input.getLast().split("\\s+")).filter(s -> !s.isEmpty()).toList();
      return new Input(nums, ops);
    }
  }

  public static long getProblemSum(Input input) {
    var probs = input.nums.getFirst().size();
    var accum = 0L;
    for (var col = 0; col < probs; col++) {
      long probVal = input.nums.getFirst().get(col);
      for (var row = 1; row < input.nums.size(); row++) {
        switch (input.ops.get(col)) {
          case "+" -> probVal += input.nums.get(row).get(col);
          case "*" -> probVal *= input.nums.get(row).get(col);
        }
      }
      accum += probVal;
    }
    return accum;
  }
}
