package com.wilb0t.aoc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Day5Test {

  private static final Day5.Input TEST_INPUT = Input.TEST.parse(Day5.Input::from);
  private static final Day5.Input PUZZLE_INPUT = Input.PUZZLE.parse(Day5.Input::from);

  @Test
  void testGetFreshIngredients_test() {
    assertThat(Day5.getFreshIngredients(TEST_INPUT)).isEqualTo(3L);
  }

  @Test
  void testGetFreshIngredients_puzzle() {
    assertThat(Day5.getFreshIngredients(PUZZLE_INPUT)).isEqualTo(874L);
  }

  @Test
  void testGetTotalFreshIngredients_test() {
    assertThat(Day5.getTotalFreshIngredients(TEST_INPUT)).isEqualTo(14L);
  }

  @Test
  void testGetTotalFreshIngredients_puzzle() {
    assertThat(Day5.getTotalFreshIngredients(PUZZLE_INPUT)).isEqualTo(348548952146313L);
  }
}
