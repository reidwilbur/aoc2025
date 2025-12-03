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

  public static long getTotalJoltageOverride(List<String> input) {
    return input.stream().mapToLong(Day3::getMaxJoltageOverride).sum();
  }

  public static long getMaxJoltageOverride(String bank) {
    var batteries = new StringBuilder(12);
    for (int idx = 0, ofs = 0; idx < 12; idx++) {
      var candidates = bank.substring(ofs, bank.length() - (12 - batteries.length()) + 1);
      var batteryIdx = getNextMaxBattery(candidates);
      batteries.append(candidates.charAt(batteryIdx));
      ofs = batteryIdx + ofs + 1;
    }
    return Long.parseLong(batteries.toString());
  }

  public static int getNextMaxBattery(String bank) {
    if (bank.length() == 1) {
      return 0;
    }
    long maxLeft = 0;
    int maxLeftIdx = -1;
    for (int idx = 0; idx < bank.length(); idx++) {
      int joltage = bank.charAt(idx) - '0';
      if (joltage > maxLeft) {
        maxLeftIdx = idx;
        maxLeft = joltage;
      }
    }
    return maxLeftIdx;
  }
}
