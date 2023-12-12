package org.shvetsov.day1;

import d01.Day1Taras$;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.shvetsov.Utils;
import util.SourceUtil$;

import java.util.concurrent.TimeUnit;

//    RESULTS:
//
//        Benchmark                           Mode  Cnt  Score   Error  Units
//        o.s.day1.Benchmarks.day1part1       avgt    3  0,133 ± 0,004  ms/op
//        o.s.day1.Benchmarks.day1part1Alex   avgt    3  0,762 ± 0,032  ms/op
//        o.s.day1.Benchmarks.day1part1Dany   avgt    3  0,194 ± 0,010  ms/op
//        o.s.day1.Benchmarks.day1part1Taras  avgt    3  0,263 ± 0,035  ms/op
//        o.s.day1.Benchmarks.day1part2       avgt    3  1,159 ± 0,102  ms/op
//        o.s.day1.Benchmarks.day1part2Dany   avgt    3  1,418 ± 0,030  ms/op
//        o.s.day1.Benchmarks.day1part2Taras  avgt    3  1,517 ± 0,071  ms/op

@BenchmarkMode({Mode.AverageTime})
@Warmup(iterations = 2, time = 5)
@Measurement(iterations = 3, time = 10)
@Fork(0)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Benchmarks {

    public static final String INPUT_PATH = "src/main/resources/input 1-1, 1-2.txt";

    @Benchmark
    public void day1part1(Blackhole bh) {
        bh.consume(new Day1().partOneAnton(Utils.parseInputByNewLine(INPUT_PATH)));
    }

    @Benchmark
    public void day1part1Alex(Blackhole bh) {
        bh.consume(new Day1().partOneAlex());
    }

    @Benchmark
    public void day1part1Taras(Blackhole bh) {
        bh.consume(Day1Taras$.MODULE$.calibrate(SourceUtil$.MODULE$.readLinesFrom("input 1-1, 1-2.txt")));
    }

    @Benchmark
    public void day1part1Dany(Blackhole bh) {
        bh.consume(Day1.partOneDany(Utils.parseInputByNewLine(INPUT_PATH).toArray(String[]::new)));
    }

    @Benchmark
    public void day1part2(Blackhole bh) {
        bh.consume(new Day1().partTwoAnton(Utils.parseInputByNewLine(INPUT_PATH)));
    }

    @Benchmark
    public void day1part2Dany(Blackhole bh) {
        bh.consume(Day1.partTwoDany(Utils.parseInputByNewLine(INPUT_PATH).toArray(String[]::new)));
    }

    @Benchmark
    public void day1part2Taras(Blackhole bh) {
        bh.consume(Day1Taras$.MODULE$.calibrateImproved(SourceUtil$.MODULE$.readLinesFrom("input 1-1, 1-2.txt")));
    }
}
