package framework.utilities;

// ===============================================================
// @file: FW_NumberUtils.java
// @filepath: src/test/java/framework/utilities/FW_NumberUtils.java
// @version: 1.0.0
// @updated: 2025-01-10 03:28:00 PM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Utility class for numerical operations and precision control.
// This class provides utility functions for numerical operations including
// controlling decimal precision and rounding operations for consistent data
// export to systems like BigQuery. Designed to provide utility methods for
// working with numerical precision in testing and audit scenarios where
// consistent data formatting is critical.
//
// @methods:
// - roundToDecimalPlaces(double, int) - Rounds to decimal places with HALF_UP
// - roundToDecimalPlaces(double, int, RoundingMode) - Rounds with custom mode
//
// @dependencies:
// - java.math.BigDecimal
// - java.math.RoundingMode
//
// @tags: numbers, precision, rounding, bigquery, data-formatting, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-10  G. Paskal       1.0.0    Initial implementation with mAi™ header
// ===============================================================

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Utility class for numerical operations and precision control.
 */
public class FW_NumberUtils {

    /**
     * Rounds a double value to the specified number of decimal places using HALF_UP rounding.
     *
     * @param value the double value to round
     * @param decimalPlaces the number of decimal places to round to
     * @return the rounded value
     * @throws IllegalArgumentException if decimalPlaces is negative
     */
    public static double roundToDecimalPlaces(double value, int decimalPlaces) {
        return roundToDecimalPlaces(value, decimalPlaces, RoundingMode.HALF_UP);
    }

    /**
     * Rounds a double value to the specified number of decimal places using the specified rounding mode.
     *
     * @param value the double value to round
     * @param decimalPlaces the number of decimal places to round to
     * @param roundingMode the rounding mode to use
     * @return the rounded value
     * @throws IllegalArgumentException if decimalPlaces is negative
     */
    public static double roundToDecimalPlaces(double value, int decimalPlaces, RoundingMode roundingMode) {
        if (decimalPlaces < 0) {
            throw new IllegalArgumentException("Decimal places cannot be negative");
        }
        
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            return 0.0;
        }
        
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(decimalPlaces, roundingMode);
        return bd.doubleValue();
    }
}