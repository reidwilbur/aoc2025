package com.wilb0t.aoc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Day5 {

  public record FreshRange(long start, long end) {
    public static FreshRange from(String input) {
      var parts = input.split("-");
      var start = Long.parseLong(parts[0]);
      var end = Long.parseLong(parts[1]);
      return new FreshRange(start, end);
    }

    public boolean isFresh(long ingredient) {
      return ingredient >= start && ingredient <= end;
    }

    public long count() {
      return end - start + 1;
    }
  }

  public record Input(List<FreshRange> ranges, List<Long> ingredients) {
    public static Input from(List<String> input) {
      var split = input.indexOf("");
      if (split == -1) {
        throw new RuntimeException("Invalid input");
      }
      var ranges = new ArrayList<FreshRange>();
      for (var idx = 0; idx < split; ++idx) {
        ranges.add(FreshRange.from(input.get(idx)));
      }
      var ingredients = new ArrayList<Long>();
      for (var idx = split + 1; idx < input.size(); idx++) {
        ingredients.add(Long.parseLong(input.get(idx)));
      }
      return new Input(ranges, ingredients);
    }
  }

  public static long getFreshIngredients(Input input) {
    return input.ingredients.stream()
        .filter(ingredient -> input.ranges.stream().anyMatch(r -> r.isFresh(ingredient)))
        .count();
  }

  public static long getTotalFreshIngredients(Input input) {
    var sortedRanges =
        input.ranges.stream().sorted(Comparator.comparing(FreshRange::start)).toList();
    var mergedRanges = new ArrayList<FreshRange>();
    var curRange = sortedRanges.getFirst();
    for (var idx = 1; idx < sortedRanges.size(); idx++) {
      var next = sortedRanges.get(idx);
      if (next.start <= curRange.end) {
        curRange = new FreshRange(curRange.start, Math.max(curRange.end, next.end));
      } else {
        mergedRanges.add(curRange);
        curRange = next;
      }
    }
    mergedRanges.add(curRange);
    return mergedRanges.stream().mapToLong(FreshRange::count).sum();
  }
}
