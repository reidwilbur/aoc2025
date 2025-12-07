package com.wilb0t.aoc;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
      if (curr.isValid(rows, cols) && !visited.contains(curr)) {
        visited.add(curr);
        if (input.get(curr.row).charAt(curr.col) == '^') {
          splits.add(curr);
          queue.add(new Coord(curr.row, curr.col - 1));
          queue.add(new Coord(curr.row, curr.col + 1));
        } else {
          queue.add(new Coord(curr.row + 1, curr.col));
        }
      }
    }

    return splits.size();
  }

  public static long getPathCount(List<String> input) {
    var startCol = input.getFirst().indexOf('S');
    if (startCol == -1) {
      throw new RuntimeException("invalid map");
    }
    var startPos = new Coord(0, startCol);
    var cache = new HashMap<Coord, Long>();
    return getPathCount(cache, input, startPos);
  }

  public static long getPathCount(Map<Coord, Long> cache, List<String> input, Coord pos) {
    var rows = input.size();
    var cols = input.getFirst().length();
    if (cache.containsKey(pos)) {
      return cache.get(pos);
    }
    if (!pos.isValid(rows, cols)) {
      return 1;
    }
    if (input.get(pos.row).charAt(pos.col) == '^') {
      var left = getPathCount(cache, input, new Coord(pos.row, pos.col - 1));
      var right = getPathCount(cache, input, new Coord(pos.row, pos.col + 1));
      var count = left + right;
      cache.put(pos, count);
      return count;
    } else {
      var count = getPathCount(cache, input, new Coord(pos.row + 1, pos.col));
      cache.put(pos, count);
      return count;
    }
  }
}
