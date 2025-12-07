package com.wilb0t.aoc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

class Day7 {

  public record Coord(int row, int col) {
    public boolean isValid(int rows, int cols) {
      return row >= 0 && row < rows && col >= 0 && col < cols;
    }
  }

  public static long getBeamSplitCount(List<String> input) {
    var rows = input.size();
    var cols = input.getFirst().length();
    var startCol = input.getFirst().indexOf('S');
    if (startCol == -1) {
      throw new RuntimeException("invalid map");
    }
    var startPos = new Coord(0, startCol);

    var visited = new HashSet<Coord>();
    var queue = new ArrayDeque<Coord>();
    var splits = new HashSet<Coord>();
    queue.add(startPos);
    while (!queue.isEmpty()) {
      var curr = queue.removeFirst();
      if (!visited.contains(curr)) {
        visited.add(curr);
        if (input.get(curr.row).charAt(curr.col) == '^') {
          splits.add(curr);
          Stream.of(new Coord(curr.row, curr.col - 1), new Coord(curr.row, curr.col + 1))
              .filter(c -> c.isValid(rows, cols))
              .forEach(queue::add);
        } else {
          var next = new Coord(curr.row + 1, curr.col);
          if (next.isValid(rows, cols)) {
            queue.add(next);
          }
        }
      }
    }

    return splits.size();
  }
}
