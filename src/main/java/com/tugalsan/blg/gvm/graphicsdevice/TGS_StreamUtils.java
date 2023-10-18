package com.tugalsan.blg.gvm.graphicsdevice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TGS_StreamUtils {

    public static <T> List<T> toLst(Stream<T> map) {
        return map.collect(Collectors.toCollection(ArrayList::new));
    }

    public static List<Integer> toLst(IntStream map) {
        return map.boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    public static List<Long> toLst(LongStream map) {
        return map.boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    public static List<Double> toLst(DoubleStream map) {
        return map.boxed().collect(Collectors.toCollection(ArrayList::new));
    }
}
