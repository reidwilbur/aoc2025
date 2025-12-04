package com.wilb0t.aoc;

import java.util.ArrayList;
import java.util.List;

class Day4 {

  public static long getLiftableRollCount(List<String> input) {
    int rows = input.size();
    int cols = input.getFirst().length();
    long liftable = 0;
    for (var row = 0; row < rows; row++) {
      for (var col = 0; col < cols; col++) {
        if (input.get(row).charAt(col) == '@') {
          var nbors = getNbors(row, col, rows, cols);
          var rollCount = 0;
          for (var nbor : nbors) {
            rollCount += (input.get(nbor[0]).charAt(nbor[1]) == '@') ? 1 : 0;
          }
          liftable += (rollCount < 4) ? 1 : 0;
        }
      }
    }
    return liftable;
  }

  public static List<int[]> getNbors(int row, int col, int rows, int cols) {
    var nbors = new ArrayList<int[]>();
    if (row - 1 >= 0) {
      nbors.add(new int[]{row - 1, col});
      if (col - 1 >= 0) {
        nbors.add(new int[]{row - 1, col - 1});
      }
      if (col + 1 < cols) {
        nbors.add(new int[]{row - 1, col + 1});
      }
    }
    if (row + 1 < rows) {
      nbors.add(new int[]{row + 1, col});
      if (col - 1 >= 0) {
        nbors.add(new int[]{row + 1, col - 1});
      }
      if (col + 1 < cols) {
        nbors.add(new int[]{row + 1, col + 1});
      }
    }
    if (col - 1 >= 0) {
      nbors.add(new int[]{row, col - 1});
    }
    if (col + 1 < cols) {
      nbors.add(new int[]{row, col + 1});
    }
    return nbors;
  }
}
