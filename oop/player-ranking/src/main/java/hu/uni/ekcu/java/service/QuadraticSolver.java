package hu.uni.ekcu.java.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public interface QuadraticSolver {

    /**
     * Copied from C example. Use the same approach!
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    double[] solve(double a, double b, double c);

    Solution solve(Equation equation) throws NoRealSolutionException;

    double[] solveWithException(double a, double b, double c) throws NoRealSolutionException;

    @RequiredArgsConstructor
    @Getter
    public static class Equation {

        private final double coeff2;

        private final double coeff1;

        private final double coeff0;
    }

    @RequiredArgsConstructor
    @Getter
    public static class Solution {
        private final double x1;

        private final double x2;
    }

}
