package com.wilb0t.aoc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class Day2 {

  public record Range(long start, long end) {
    public static Range from(String string) {
      var parts = string.split("-");
      return new Range(Long.parseLong(parts[0]), Long.parseLong(parts[1]));
    }

    public Stream<Long> findInvalidIds() {
      return LongStream.range(start, end + 1)
          .filter(id -> {
            var intStr = Long.toString(id);
            if (intStr.length() % 2 == 0) {
              return intStr.substring(0, intStr.length() / 2).equals(intStr.substring(intStr.length() / 2));
            }
            return false;
          })
          .boxed();
    }
  }

  public static long findInvalidIds(List<String> input) {
    return Arrays.stream(input.getFirst().split(","))
        .map(Range::from)
        .flatMap(Range::findInvalidIds)
        .mapToLong(Long::valueOf)
        .sum();
  }

}
