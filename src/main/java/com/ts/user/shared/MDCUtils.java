package com.ts.user.shared;

import org.slf4j.MDC;

public class MDCUtils {
    public static void put(Exception e) {
        MDC.put(Constants.MDC.X_ERROR_TYPE, e.getClass().getSimpleName());
    }
}
