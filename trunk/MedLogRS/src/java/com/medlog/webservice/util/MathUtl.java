/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.util;

/**
 *
 * @author westy
 */
public class MathUtl {
    
    /**
     * Generate Correlation from values.
     * @param ax  
     * @param by
     * @return r
     */
    public static double correlation(double [] ax, double [] by) {
    // TODO: check here that arrays are not null, of the same length etc

    double sx = 0.0;
    double sy = 0.0;
    double sxx = 0.0;
    double syy = 0.0;
    double sxy = 0.0;

    int n = ax.length;

    for(int i = 0; i < n; ++i) {
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
    double sigmax = Math.sqrt(sxx / n -  sx * sx / n / n);
    // std(y)
    double sigmay = Math.sqrt(syy / n -  sy * sy / n / n);
    // cor
    return cov / sigmax / sigmay;
  }
    
}
