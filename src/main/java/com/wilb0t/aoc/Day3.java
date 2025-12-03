package com.wilb0t.aoc;

import java.util.List;

class Day3 {

  public static long getTotalJoltage(List<String> input) {
    return input.stream().mapToLong(Day3::getMaxJoltage).sum();
  }

  public static long getMaxJoltage(String bank) {
    long maxLeft = 0;
    int maxLeftIdx = -1;
    for (int idx = 0; idx < bank.length() - 1; idx++) {
      int joltage = bank.charAt(idx) - '0';
      if (joltage > maxLeft) {
        maxLeftIdx = idx;
        maxLeft = joltage;
      }
    }
    long maxRight = 0;
    for (int idx = maxLeftIdx + 1; idx < bank.length(); idx++) {
      int joltage = bank.charAt(idx) - '0';
      if (joltage > maxRight) {
        maxRight = joltage;
      }
    }
    return (maxLeft * 10) + maxRight;
  }
}
