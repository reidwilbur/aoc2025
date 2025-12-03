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

  @Test
  void testGetMaxJoltageOverride() {
    assertThat(Day3.getMaxJoltageOverride("987654321111111")).isEqualTo(987654321111L);
    assertThat(Day3.getMaxJoltageOverride("811111111111119")).isEqualTo(811111111119L);
    assertThat(Day3.getMaxJoltageOverride("234234234234278")).isEqualTo(434234234278L);
    assertThat(Day3.getMaxJoltageOverride("818181911112111")).isEqualTo(888911112111L);
  }

  @Test
  void testGetMaxJoltageOverride_test() {
    assertThat(Day3.getTotalJoltageOverride(TEST_INPUT)).isEqualTo(3121910778619L);
  }

  @Test
  void testGetMaxJoltageOverride_puzzle() {
    assertThat(Day3.getTotalJoltageOverride(PUZZLE_INPUT)).isEqualTo(170997883706617L);
  }
}
