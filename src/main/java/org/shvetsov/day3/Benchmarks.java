package org.shvetsov.day3;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.shvetsov.Utils;

import java.util.concurrent.TimeUnit;

//    RESULTS:
//
//    Benchmark                  Mode  Cnt  Score   Error  Units
//    Benchmarks.day3part1Anton  avgt    3  0,364 ± 0,051  ms/op

@BenchmarkMode({Mode.AverageTime})
@Warmup(iterations = 2, time = 5)
@Measurement(iterations = 3, time = 10)
@Fork(0)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Benchmarks {

    @Benchmark
    public void day3part1Anton(Blackhole bh) {
        bh.consume(new Day3().partOneAnton(Utils.parseInputInTwoDimArray(Day3.INPUT_PATH)));
    }

    @Benchmark
    public void day3part2Anton(Blackhole bh) {
        bh.consume(new Day3().partTwoAnton(Utils.parseInputInTwoDimArray(Day3.INPUT_PATH)));
    }

}
