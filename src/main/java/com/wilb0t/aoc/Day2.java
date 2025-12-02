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

    public Stream<Long> findInvalidIdsSeq() {
      return LongStream.range(start, end + 1)
          .filter(Range::isInvalidId)
          .boxed();

    }

    static boolean isInvalidId(long id) {
      var longStr = Long.toString(id);
      for (int seqSize = 1; seqSize <= longStr.length() / 2; seqSize++) {
        if (longStr.length() % seqSize == 0) {
          boolean isInvalid = true;
          var seq = longStr.substring(0, seqSize);
          for (int ofs = seqSize; ofs <= longStr.length() - seqSize; ofs += seqSize) {
            if (!longStr.substring(ofs, ofs + seqSize).equals(seq)) {
              isInvalid = false;
              break;
            }
          }
          if (isInvalid) {
            return true;
          }
        }
      }
      return false;
    }
  }

  public static long findInvalidIds(List<String> input) {
    return Arrays.stream(input.getFirst().split(","))
        .map(Range::from)
        .flatMap(Range::findInvalidIds)
        .mapToLong(Long::valueOf)
        .sum();
  }

  public static long findInvalidIdsSeq(List<String> input) {
    return Arrays.stream(input.getFirst().split(","))
        .map(Range::from)
        .flatMap(Range::findInvalidIdsSeq)
        .mapToLong(Long::valueOf)
        .sum();
  }
}
