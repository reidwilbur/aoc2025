package com.wilb0t.aoc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class Day2Test {

  private static final List<String> TEST_INPUT = Input.TEST.loadStrings();
  private static final List<String> PUZZLE_INPUT = Input.PUZZLE.loadStrings();

  @Test
  void testFindInvalidIds_test() {
    assertThat(Day2.findInvalidIds(TEST_INPUT)).isEqualTo(1227775554L);
  }

  @Test
  void testFindInvalidIds_puzzle() {
    assertThat(Day2.findInvalidIds(PUZZLE_INPUT)).isEqualTo(40398804950L);
  }

}
