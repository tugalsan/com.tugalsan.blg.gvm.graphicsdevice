package com.tugalsan.blg.gvm.graphicsdevice;

public class TGS_UnSafeInterruptedException extends RuntimeException {

    public TGS_UnSafeInterruptedException(InterruptedException e) {
        super(e);
    }
}
