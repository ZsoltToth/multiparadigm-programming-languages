//
// Created by zsolt on 2020. 09. 11..
//
#include <stdlib.h>
#include <math.h>
#include "quadratic.h"

/**
 * Task:
 *  - Refactor to increase readability.
 *
 * Discussion:
 *  - Why does it return with integer?
 *
 * @param a
 * @param b
 * @param c
 * @return
 */
int solve(double a, double b, double c, double *x1, double *x2) {
    if ((b * b - 4 * a * c) < 0) {
        return 0;
    }
    if ((b * b - 4 * a * c) == 0) {
        *x1 = (-1 * b) / (2 * a);
        *x2 = *x1;
        return 1;
    }
    *x1 = (-1 * b + sqrt(b * b - 4 * a * c)) / (2 * a);
    *x2 = (-1 * b - sqrt(b * b - 4 * a * c)) / (2 * a);
    return 2;
}

struct QuadraticSolution* solve_struct(double a, double b, double c){
    struct QuadraticSolution *result = malloc(sizeof(struct QuadraticSolution));
    if ((b * b - 4 * a * c) < 0) {
        result->status = NO_SOLUTION;
        return result;
    }
    if ((b * b - 4 * a * c) == 0) {
        result->x1 = (-1 * b) / (2 * a);
        result->x2 = result->x1;
        result->status = SINGLE_SOLUTION;
        return result;
    }
    result->x1 = (-1 * b + sqrt(b * b - 4 * a * c)) / (2 * a);
    result->x2 = (-1 * b - sqrt(b * b - 4 * a * c)) / (2 * a);
    result->status = TWO_REAL_SOLUTIONS;
    return result;
}

