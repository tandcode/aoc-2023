package org.shvetsov.day3;

import d03.Day3Taras$;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.shvetsov.Utils;
import util.SourceUtil$;

import java.util.concurrent.TimeUnit;

//    RESULTS:
//
//    Benchmark                           Mode  Cnt  Score   Error  Units
//    o.s.day3.Benchmarks.day3part1Anton  avgt    3  0,183 ± 0,100  ms/op
//    o.s.day3.Benchmarks.day3part1Dany   avgt    3  0,386 ± 0,106  ms/op
//    o.s.day3.Benchmarks.day3part1Taras  avgt    3  5,137 ± 4,651  ms/op
//    o.s.day3.Benchmarks.day3part2Anton  avgt    3  0,213 ± 0,082  ms/op
//    o.s.day3.Benchmarks.day3part2Dany   avgt    3  1,794 ± 0,321  ms/op
//    o.s.day3.Benchmarks.day3part2Taras  avgt    3  0,807 ± 0,330  ms/op

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

    @Benchmark
    public void day3part1Dany(Blackhole bh) {
        bh.consume(Day3Dany.part1(Utils.parseInputDany(Day3Dany.INPUT_NAME)));
    }

    @Benchmark
    public void day3part2Dany(Blackhole bh) {
        bh.consume(Day3Dany.part2(Utils.parseInputDany(Day3Dany.INPUT_NAME)));
    }

    @Benchmark
    public void day3part1Taras(Blackhole bh) {
        bh.consume(Day3Taras$.MODULE$.sumUpPartNumbers(SourceUtil$.MODULE$.readLinesFrom(Day3Dany.INPUT_NAME)));
    }

    @Benchmark
    public void day3part2Taras(Blackhole bh) {
        bh.consume(Day3Taras$.MODULE$.gearRatios(SourceUtil$.MODULE$.readLinesFrom(Day3Dany.INPUT_NAME)));
    }

}
