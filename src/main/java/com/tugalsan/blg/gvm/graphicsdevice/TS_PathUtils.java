package com.tugalsan.blg.gvm.graphicsdevice;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class TS_PathUtils {

    public static Path getPathCurrent_nio(String child, String... more) {
        return FileSystems.getDefault().getPath(child, more).toAbsolutePath();
    }
}
