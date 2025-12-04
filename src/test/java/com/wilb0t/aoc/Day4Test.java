package com.wilb0t.aoc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class Day4Test {

  private static final List<String> TEST_INPUT = Input.TEST.loadStrings();
  private static final List<String> PUZZLE_INPUT = Input.PUZZLE.loadStrings();

  @Test
  void testGetLiftableRollCount_test() {
    assertThat(Day4.getLiftableRollCount(TEST_INPUT)).isEqualTo(13L);
  }

  @Test
  void testGetLiftableRollCount_puzzle() {
    assertThat(Day4.getLiftableRollCount(PUZZLE_INPUT)).isEqualTo(1480L);
  }

  @Test
  void testGetRemovableRollCount_test() {
    assertThat(Day4.getRemovableRollCount(TEST_INPUT)).isEqualTo(43L);
  }

  @Test
  void testGetRemovableRollCount_puzzle() {
    assertThat(Day4.getRemovableRollCount(PUZZLE_INPUT)).isEqualTo(8899L);
  }
}
