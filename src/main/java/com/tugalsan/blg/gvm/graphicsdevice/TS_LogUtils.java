package com.tugalsan.blg.gvm.graphicsdevice;

import static java.lang.System.out;
import java.nio.file.Path;
import java.util.Arrays;

public class TS_LogUtils {

    final public static Path file = TS_PathUtils.getPathCurrent_nio(Main.class.getPackageName() + ".log");

    public static void cr(CharSequence funcName, Object... oa) {
        var lstStr = TGS_StreamUtils.toLst(Arrays.asList(oa).stream().map(o -> String.valueOf(o)));
        var str = "INFO: " + funcName + " -> " + lstStr;
        out.println(str);
        TS_FileTxtUtils.toFile(str, file, true);
    }

    public static void ce(CharSequence funcName, Object... oa) {
        var lstStr = TGS_StreamUtils.toLst(Arrays.asList(oa).stream().map(o -> String.valueOf(o)));
        var str = "ERROR: " + funcName + " -> " + lstStr;
        out.println(str);
        TS_FileTxtUtils.toFile(str, file, true);
    }
}
