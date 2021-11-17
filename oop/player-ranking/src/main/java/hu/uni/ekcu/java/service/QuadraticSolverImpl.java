package hu.uni.ekcu.java.service;

import org.springframework.stereotype.Service;

@Service
public class QuadraticSolverImpl implements QuadraticSolver {

    @Override
    public double[] solve(double a, double b, double c) {
        double discriminant = Math.pow(b, 2) - 4 * a * c;
        if (discriminant < 0) {
            return new double[0];
        }
        if (discriminant == 0.0) {
            return new double[] {(-1 * b) / (2 * a)};
        }
        return new double[] {
            (-1 * b + Math.sqrt(discriminant)) / (2 * a),
            (-1 * b - Math.sqrt(discriminant)) / (2 * a)
        };
    }

    @Override
    public Solution solve(Equation equation) throws NoRealSolutionException {
        double[] solution = this.solve(equation.getCoeff2(), equation.getCoeff1(), equation.getCoeff0());
        if (solution.length == 0) {
            throw new NoRealSolutionException();
        }
        if (solution.length == 1) {
            return new Solution(solution[0], solution[0]);
        }
        return new Solution(solution[0], solution[1]);
    }

    @Override
    public double[] solveWithException(double a, double b, double c) throws NoRealSolutionException {
        double[] solution = this.solve(a, b, c);
        if (solution.length == 0) {
            throw new NoRealSolutionException();
        }
        return solution;
    }

}
