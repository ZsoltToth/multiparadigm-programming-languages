//
// Created by zsolt on 2020. 09. 11..
//

#ifndef PROCEDURAL_PROGRAMMING_QUADRATIC_H
#define PROCEDURAL_PROGRAMMING_QUADRATIC_H

int solve(double a, double b, double c, double *x1, double *x2);


#define NO_SOLUTION  0
#define SINGLE_SOLUTION  1
#define TWO_REAL_SOLUTIONS  2

struct QuadraticSolution{
    int status;
    double x1;
    double x2;
};
/**
 * Task:
 *  - Wrap the a,b,c coefficients of the Quadratic Equation into a struct;
 *  - struct QuadraticSolution* solve_qe(struct QuadraticEquation* equation);
 *
 * @param a
 * @param b
 * @param c
 * @return
 */
struct QuadraticSolution* solve_struct(double a, double b, double c);

#endif //PROCEDURAL_PROGRAMMING_QUADRATIC_H
