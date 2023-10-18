package com.tugalsan.blg.gvm.graphicsdevice;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TS_FileTxtUtils {

    public static Path toFile(CharSequence sourceText, Path destFile, boolean append) {
        return toFile(sourceText, destFile, append, StandardCharsets.UTF_8, false, true);
    }

    public static Path toFile(CharSequence sourceText, Path destFile, boolean append, Charset charset, boolean withUTF8BOM, boolean windowsCompatable) {
        return TGS_UnSafe.call(() -> {
            var sourceTextStr = sourceText.toString();
            if (!append) {
                TS_FileUtils.deleteFileIfExists(destFile);
            }
            if (windowsCompatable) {
                sourceTextStr = sourceTextStr.replace("\r\n", "\n");//for source normilize
                sourceTextStr = sourceTextStr.replace("\n", "\r\n");
            }
            Files.writeString(destFile, withUTF8BOM ? new String(getUTF8BOM()) + sourceTextStr : sourceTextStr,
                    charset, StandardOpenOption.CREATE, append ? StandardOpenOption.APPEND : StandardOpenOption.WRITE);
            return destFile;
        });
    }

    public static byte[] getUTF8BOM() {
        return new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};
    }
}
