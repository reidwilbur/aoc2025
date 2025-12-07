package com.wilb0t.aoc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class Day7Test {

  private static final List<String> TEST_INPUT = Input.TEST.loadStrings();
  private static final List<String> PUZZLE_INPUT = Input.PUZZLE.loadStrings();

  @Test
  void testGetBeamSplitCount_test() {
    assertThat(Day7.getBeamSplitCount(TEST_INPUT)).isEqualTo(21L);
  }

  @Test
  void testGetBeamSplitCount_puzzle() {
    assertThat(Day7.getBeamSplitCount(PUZZLE_INPUT)).isEqualTo(1619L);
  }

  @Test
  void testGetPathCount_test() {
    assertThat(Day7.getPathCount(TEST_INPUT)).isEqualTo(40L);
  }

  @Test
  void testGetPathCount_puzzle() {
    assertThat(Day7.getPathCount(PUZZLE_INPUT)).isEqualTo(23607984027985L);
  }
}
