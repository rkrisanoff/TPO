package com.ts.ts;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class PowerSeries {
    final static double  eps = 0.000001d;
    public static double calculateArctg(double arg, int n) {
//        arg = (arg + Math.PI) % (0.5 * Math.PI);


        double result = 0;
        double part = 0;
        int i = 1;

        do {
            result += part ;
            part = pow(arg, i * 2 - 1) / (i * 2 - 1) * (i % 2 == 0 ? -1 : 1);
            i += 1;
        } while ((abs(part) > eps) && (i <= n));

        return result;
    }
}