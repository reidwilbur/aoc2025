package com.wilb0t.aoc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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
}
