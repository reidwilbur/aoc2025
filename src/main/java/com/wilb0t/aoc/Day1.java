package com.wilb0t.aoc;

import java.util.List;

class Day1 {

  private static final int DIAL_SIZE = 100;

  public static int getPassword(List<String> input) {
    var zeroCount = 0;
    var pos = 50;
    for (var instr : input) {
      var clicks = Integer.parseInt(instr.substring(1));
      if (instr.charAt(0) == 'L') {
        pos = (pos - clicks) % DIAL_SIZE;
        pos = (pos < 0) ? pos + DIAL_SIZE: pos;
      } else {
        pos = (pos + clicks) % DIAL_SIZE;
      }
      zeroCount += (pos == 0) ? 1 : 0;
    }
    return zeroCount;
  }

  public static int getPassword434(List<String> input) {
    var zeroCount = 0;
    var pos = 50;
    for (var instr : input) {
      var clicks = Integer.parseInt(instr.substring(1));
      var turns = clicks / DIAL_SIZE;
      var clamped = clicks % DIAL_SIZE;
      zeroCount += turns;
      if (instr.charAt(0) == 'L') {
        if (clamped > pos && pos > 0) {
          zeroCount += 1;
        }
        pos = (DIAL_SIZE + pos - clamped) % DIAL_SIZE;
      } else {
        pos += clamped;
        if (pos > DIAL_SIZE) {
          zeroCount += 1;
        }
        pos %= DIAL_SIZE;
      }
      zeroCount += (pos == 0) ? 1 : 0;
    }
    return zeroCount;
  }
}
