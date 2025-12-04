package com.wilb0t.aoc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

class Day4 {

  public static long getLiftableRollCount(List<String> input) {
    var rolls = Pos.from(input);
    return rolls.stream().filter(pos -> pos.nbors().filter(rolls::contains).count() < 4).count();
  }

  record Pos(int row, int col) {
    public Stream<Pos> nbors() {
      return Stream.of(
          new Pos(row - 1, col - 1),
          new Pos(row - 1, col),
          new Pos(row - 1, col + 1),
          new Pos(row, col - 1),
          new Pos(row, col + 1),
          new Pos(row + 1, col - 1),
          new Pos(row + 1, col),
          new Pos(row + 1, col + 1));
    }

    public static Set<Pos> from(List<String> input) {
      int rows = input.size();
      int cols = input.getFirst().length();
      var rolls = new HashSet<Pos>();
      for (var row = 0; row < rows; row++) {
        for (var col = 0; col < cols; col++) {
          if (input.get(row).charAt(col) == '@') {
            rolls.add(new Pos(row, col));
          }
        }
      }
      return rolls;
    }
  }

  public static long getRemovableRollCount(List<String> input) {
    var rolls = Pos.from(input);

    boolean didRemove = true;
    int removeCount = 0;
    while (didRemove) {
      didRemove = false;
      var nextRolls = new HashSet<Pos>(rolls.size());
      for (var pos : rolls) {
        var nborCount = pos.nbors().filter(rolls::contains).count();
        if (nborCount >= 4) {
          nextRolls.add(pos);
        } else {
          didRemove = true;
          removeCount += 1;
        }
      }
      rolls = nextRolls;
    }
    return removeCount;
  }
}
