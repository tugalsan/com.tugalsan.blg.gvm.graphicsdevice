package com.tugalsan.blg.gvm.graphicsdevice;

import java.nio.file.Files;
import java.nio.file.Path;

public class TS_FileUtils {

    public static boolean deleteFileIfExists(Path file) {
        return deleteFileIfExists(file, true);
    }

    public static boolean deleteFileIfExists(Path file, boolean printStackTrace) {
        return TGS_UnSafe.call(() -> {
            if (!isExistFile(file)) {
                return true;
            }
            Files.deleteIfExists(file);
            return !isExistFile(file);
        }, exception -> {
            if (printStackTrace) {
                exception.printStackTrace();
            }
            return false;
        });
    }

    public static boolean isExistFile(Path file) {
        return file != null && !Files.isDirectory(file) && Files.exists(file);
    }

}
