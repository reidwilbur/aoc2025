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

  @Test
  void testFindInvalidIdsSeq_test() {
    assertThat(Day2.findInvalidIdsSeq(TEST_INPUT)).isEqualTo(4174379265L);
  }

  @Test
  void testFindInvalidIdsSeq_puzzle() {
    assertThat(Day2.findInvalidIdsSeq(PUZZLE_INPUT)).isEqualTo(65794984339L);
  }

  @Test
  void rangeTest() {
    assertThat(new Day2.Range(11,22).findInvalidIdsSeq().toList()).isEqualTo(List.of(11L,22L));
    assertThat(new Day2.Range(95,115).findInvalidIdsSeq().toList()).isEqualTo(List.of(99L,111L));
    assertThat(Day2.Range.from("1188511880-1188511890").findInvalidIdsSeq().toList()).isEqualTo(List.of(1188511885L));
    assertThat(Day2.Range.from("565653-565659").findInvalidIdsSeq().toList()).isEqualTo(List.of(565656L));
  }
}
