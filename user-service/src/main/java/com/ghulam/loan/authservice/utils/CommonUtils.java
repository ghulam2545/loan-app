package com.ghulam.loan.authservice.utils;

import java.util.UUID;

public class CommonUtils {

    public static String uniqueId() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 8);
    }
}
