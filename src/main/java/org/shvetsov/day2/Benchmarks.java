package org.shvetsov.day2;

import d02.Day2Taras$;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.shvetsov.Utils;
import util.SourceUtil$;

import java.util.concurrent.TimeUnit;

//    RESULTS:
//
//    Benchmark                           Mode  Cnt  Score   Error  Units
//    o.s.day2.Benchmarks.day2part1Anton  avgt    3  0,212 ± 0,023  ms/op
//    o.s.day2.Benchmarks.day2part1Dany   avgt    3  0,419 ± 0,079  ms/op
//    o.s.day2.Benchmarks.day2part1Taras  avgt    3  1,302 ± 0,060  ms/op
//    o.s.day2.Benchmarks.day2part2Anton  avgt    3  0,216 ± 0,186  ms/op
//    o.s.day2.Benchmarks.day2part2Dany   avgt    3  0,519 ± 0,218  ms/op
//    o.s.day2.Benchmarks.day2part2Taras  avgt    3  1,371 ± 0,866  ms/op

@BenchmarkMode({Mode.AverageTime})
@Warmup(iterations = 2, time = 5)
@Measurement(iterations = 3, time = 10)
@Fork(0)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Benchmarks {

    @Benchmark
    public void day2part1Anton(Blackhole bh) {
        bh.consume(new Day2().partOneAnton(Utils.parseInputByNewLine(Day2.INPUT_PATH)));
    }

    @Benchmark
    public void day2part2Anton(Blackhole bh) {
        bh.consume(new Day2().partTwoAnton(Utils.parseInputByNewLine(Day2.INPUT_PATH)));
    }

    @Benchmark
    public void day2part1Dany(Blackhole bh) {
        bh.consume(Day2Dany.part1Dany(Utils.parseInputDany(Day2Dany.INPUT)));
    }

    @Benchmark
    public void day2part2Dany(Blackhole bh) {
        bh.consume(Day2Dany.part2Dany(Utils.parseInputDany(Day2Dany.INPUT)));
    }

    @Benchmark
    public void day2part1Taras(Blackhole bh) {
        bh.consume(Day2Taras$.MODULE$.countValidGames(
                Day2Taras$.MODULE$.gameIdToGameSets(SourceUtil$.MODULE$.readLinesFrom(Day2Dany.INPUT)),
                Day2Taras$.MODULE$.totalCubes()
        ));
    }

    @Benchmark
    public void day2part2Taras(Blackhole bh) {
        bh.consume(Day2Taras$.MODULE$.countMinPowers(
                Day2Taras$.MODULE$.gameIdToGameSets(SourceUtil$.MODULE$.readLinesFrom(Day2Dany.INPUT))
        ));
    }
}
