package com.gara.utils;

import java.math.BigDecimal;
import java.util.Objects;


public class BigDecimalUtils {

    public static boolean isIntegerValue(BigDecimal value) {
        return value.signum() == 0 || value.scale() <= 0 || value.stripTrailingZeros().scale() <= 0;
    }

    public static boolean isBetween(BigDecimal value, BigDecimal start, BigDecimal end) {
        if (Objects.isNull(value) || Objects.isNull(start) || Objects.isNull(end)) {
            return false;
        }

        return value.compareTo(start) >= 0 && value.compareTo(end) <= 0;
    }

}
