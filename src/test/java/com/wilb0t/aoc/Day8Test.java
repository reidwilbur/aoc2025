package com.wilb0t.aoc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class Day8Test {

  private static final List<String> TEST_INPUT = Input.TEST.loadStrings();
  private static final List<String> PUZZLE_INPUT = Input.PUZZLE.loadStrings();

  @Test
  void testGetCircuitSizeMul_test() {
    assertThat(Day8.getCircuitSizeMul(TEST_INPUT, 10)).isEqualTo(40L);
  }

  @Test
  void testGetCircuitSizeMul_puzzle() {
    assertThat(Day8.getCircuitSizeMul(PUZZLE_INPUT, 1000)).isEqualTo(153328L);
  }
}
