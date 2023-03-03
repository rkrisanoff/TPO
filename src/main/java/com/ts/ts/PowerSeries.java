package com.ts.ts;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class PowerSeries {
    final static double  eps = 0.000001d;
    public static double calculateArctg(double arg, int n) throws IllegalArgumentException {
        if (abs(arg) > 1) {
            throw new IllegalArgumentException("Argument "+arg+" is out of definition are");
        }

        double result = 0;
        double part = 0;
        int i = 1;

        do {
            result += part ;
            part = pow(-1, i - 1 ) * pow(arg, i * 2 - 1) / (i * 2 - 1);
            i += 1;
        } while ((abs(part) > eps) && (i <= n));

        return result;
    }
}
