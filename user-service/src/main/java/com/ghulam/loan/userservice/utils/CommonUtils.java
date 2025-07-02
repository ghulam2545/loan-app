package com.ghulam.loan.userservice.utils;

import java.util.UUID;

public final class CommonUtils {

    public static String uniqueId() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);
    }
}
