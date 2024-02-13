package com.trustWallet.exceptions;

import java.io.Serial;

public class AndroidDriverException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public AndroidDriverException(String message, Throwable t) {
        super(message, t);
    }
}
