package com.wilb0t.aoc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Day6Test {

  private static final Day6.Input TEST_INPUT = Input.TEST.parse(Day6.Input::from);
  private static final Day6.Input PUZZLE_INPUT = Input.PUZZLE.parse(Day6.Input::from);

  @Test
  void testGetProblemSum_test() {
    assertThat(Day6.getProblemSum(TEST_INPUT)).isEqualTo(4277556L);
  }

  @Test
  void testGetProblemSum_puzzle() {
    assertThat(Day6.getProblemSum(PUZZLE_INPUT)).isEqualTo(5346286649122L);
  }
}
