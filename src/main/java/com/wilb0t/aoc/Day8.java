package com.wilb0t.aoc;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

class Day8 {
  public record Coord(int x, int y, int z) {
    public static Coord from(String input) {
      var parts = input.split(",");
      return new Coord(
          Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
    }

    public double dist(Coord other) {
      long xd = other.x - this.x;
      long yd = other.y - this.y;
      long zd = other.z - this.z;
      return Math.sqrt(xd * xd + yd * yd + zd * zd);
    }
  }

  public record Pair(Coord first, Coord second, double dist) {}

  public static long getCircuitSizeMul(List<String> input, int rounds) {
    var coords = input.stream().map(Coord::from).toList();
    var pairs = new PriorityQueue<>(Comparator.comparing(Pair::dist));
    for (var idx = 0; idx < coords.size() - 1; idx++) {
      var first = coords.get(idx);
      for (var sidx = idx + 1; sidx < input.size(); sidx++) {
        var second = coords.get(sidx);
        pairs.add(new Pair(first, second, first.dist(second)));
      }
    }
    var circuit = 0;
    var circuits = new HashMap<Coord, Integer>();
    for (var round = 0; round < rounds; round++) {
      var pair = pairs.poll();
      if (circuits.containsKey(pair.first) && circuits.containsKey(pair.second)) {
        var cf = circuits.get(pair.first);
        var cs = circuits.get(pair.second);
        var union =
            circuits.entrySet().stream()
                .filter(e -> e.getValue().equals(cf) || e.getValue().equals(cs))
                .toList();
        for (var coord : union) {
          circuits.put(coord.getKey(), circuit);
        }
        circuit += 1;
      } else {
        var c = circuits.getOrDefault(pair.first, circuits.getOrDefault(pair.second, circuit));
        circuits.put(pair.first, c);
        circuits.put(pair.second, c);
        circuit += (c == circuit) ? 1 : 0;
      }
    }

    var topThree =
        circuits.values().stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .values()
            .stream()
            .sorted(Comparator.reverseOrder())
            .limit(3)
            .toList();
    var mul = 1;
    for (var size : topThree) {
      mul *= size;
    }
    return mul;
  }
}
