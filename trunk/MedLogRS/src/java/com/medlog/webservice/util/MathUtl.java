/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.util;

import java.math.BigDecimal;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;

/**
 *
 * @author westy
 */
public class MathUtl {

    /**
     *
     * Generate Correlation from values.
     *
     * @param ax
     * @param by
     * @return r
     */
    public static double correlation(double[] ax, double[] by) {
        // TODO: check here that arrays are not null, of the same length etc

        double sx = 0.0;
        double sy = 0.0;
        double sxx = 0.0;
        double syy = 0.0;
        double sxy = 0.0;

        int n = ax.length;

        for (int i = 0; i < n; ++i) {
            double x = ax[i];
            double y = by[i];

            sx += x;
            sy += y;
            sxx += x * x;
            syy += y * y;
            sxy += x * y;
        }
        double corr = new org.apache.commons.math3.stat.correlation.PearsonsCorrelation().correlation(ax, by);

        System.out.println(corr);
        // coV
        double cov = sxy / n - sx * sy / n / n;
        // std(x)
        double sigmax = Math.sqrt(sxx / n - sx * sx / n / n);
        // std(y)
        double sigmay = Math.sqrt(syy / n - sy * sy / n / n);
        // cor
        return cov / sigmax / sigmay;
    }

    public static void main(String[] args) {
        BigDecimal d;
        d = new BigDecimal(0);
        double[] xs = {30,
            80,
            90,
            70,
            70,
            80,
            50,
            50,
            50,
            100,
            10,
            40,
            80,
            100};

        double ys[] = {52.9676423,
            28.14739166,
            45.22978518,
            60.54520645,
            58.43671379,
            15.94587142,
            58.869,
            57.8465,
            58.686,
            40.38026666,
            55.8178,
            60.3812,
            88.1389,
            61.1895};
        
       double r = new  PearsonsCorrelation().correlation(xs, ys);
       double rb = new SpearmansCorrelation().correlation(xs, ys);
        System.out.println("com.medlog.webservice.util.MathUtl.main()" + r*r);
        
        System.out.println("com.medlog.webservice.util.MathUtl.main()" + rb*rb);

    }
}
