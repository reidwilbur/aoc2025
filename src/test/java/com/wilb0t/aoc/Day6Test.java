package com.wilb0t.aoc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class Day6Test {

  private static final List<String> TEST_INPUT = Input.TEST.loadStrings();
  private static final List<String> PUZZLE_INPUT = Input.PUZZLE.loadStrings();

  @Test
  void testGetProblemSum_test() {
    assertThat(Day6.getProblemSum(Day6.Input.from(TEST_INPUT))).isEqualTo(4277556L);
  }

  @Test
  void testGetProblemSum_puzzle() {
    assertThat(Day6.getProblemSum(Day6.Input.from(PUZZLE_INPUT))).isEqualTo(5346286649122L);
  }

  @Test
  void testGetProblemSumT_test() {
    assertThat(Day6.getProblemSumT(TEST_INPUT)).isEqualTo(3263827L);
  }

  @Test
  void testGetProblemSumT_puzzle() {
    assertThat(Day6.getProblemSumT(PUZZLE_INPUT)).isEqualTo(10389131401929L);
  }
}
