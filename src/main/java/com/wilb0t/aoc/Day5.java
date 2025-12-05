package com.wilb0t.aoc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

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
}
