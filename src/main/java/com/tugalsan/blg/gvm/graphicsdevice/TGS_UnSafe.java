package com.tugalsan.blg.gvm.graphicsdevice;

import java.util.concurrent.Callable;

public class TGS_UnSafe {

    public static <R> R call(Callable<R> cmp) {
        return call(cmp, null);
    }

    public static <R> R call(Callable<R> cmp, TGS_CallableType1<R, Exception> exception) {
        return call(cmp, exception, null);
    }

    public static <R> R call(Callable<R> cmp, TGS_CallableType1<R, Exception> exception, TGS_Runnable finalExe) {
        try {
            return cmp.call();
        } catch (Exception e) {
            throwIfInterruptedException(e);
            if (exception == null) {
                throw new RuntimeException(e);
            }
            return exception.call(e);
        } finally {
            if (finalExe != null) {
                finalExe.run();
            }
        }
    }
    
     public static void throwIfInterruptedException(Exception e) {
        if (e instanceof InterruptedException) {// U NEED THIS SO STRUCTURED SCOPE CAN ABLE TO SHUT DOWN
            throw new TGS_UnSafeInterruptedException((InterruptedException) e);
        }
    }
}
