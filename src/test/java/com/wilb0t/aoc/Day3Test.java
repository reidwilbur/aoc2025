package com.wilb0t.aoc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class Day3Test {

  private static final List<String> TEST_INPUT = Input.TEST.loadStrings();
  private static final List<String> PUZZLE_INPUT = Input.PUZZLE.loadStrings();

  @Test
  void testGetMaxJoltage_test() {
    assertThat(Day3.getTotalJoltage(TEST_INPUT)).isEqualTo(357L);
  }

  @Test
  void testGetMaxJoltage_puzzle() {
    assertThat(Day3.getTotalJoltage(PUZZLE_INPUT)).isEqualTo(17207L);
  }
}
