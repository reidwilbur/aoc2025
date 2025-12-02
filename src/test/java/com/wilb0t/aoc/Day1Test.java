package com.wilb0t.aoc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class Day1Test {

  private static final List<String> TEST_INPUT = Input.TEST.loadStrings();
  private static final List<String> PUZZLE_INPUT = Input.PUZZLE.loadStrings();

  @Test
  void testGetPassword_test() {
    assertThat(Day1.getPassword(TEST_INPUT)).isEqualTo(3);
  }

  @Test
  void testGetPassword_puzzle() {
    assertThat(Day1.getPassword(PUZZLE_INPUT)).isEqualTo(1086);
  }

  @Test
  void testGetPassword434_test() {
    assertThat(Day1.getPassword434(TEST_INPUT)).isEqualTo(6);
  }

  @Test
  void testGetPassword434_puzzle() {
    assertThat(Day1.getPassword434(PUZZLE_INPUT)).isEqualTo(6268);
  }
}
