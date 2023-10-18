package com.tugalsan.blg.gvm.graphicsdevice;

import java.awt.GraphicsEnvironment;
import static java.lang.System.out;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void log(CharSequence funcName, Object... oa) {
        try {
            var lstStr = Arrays.stream(oa)
                    .map(o -> String.valueOf(o))
                    .collect(Collectors.toCollection(ArrayList::new));
            var str = funcName + " -> " + lstStr + "\n";
            out.print(str);
            Files.writeString(file, str, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    final public static Path file = FileSystems.getDefault().getPath(Main.class.getPackageName() + ".log").toAbsolutePath();

    public static void main(String... s) {
        try {
            Files.deleteIfExists(file);
            log("main", "#1");
            var localGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            log("main", "#2");
        } catch (Exception e) {
            e.printStackTrace();
            log("main", e);
        }
    }
}
