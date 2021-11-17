package hu.uni.ekcu.java.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;


@ExtendWith(MockitoExtension.class)
class QuadraticSolverImplTest {

    @InjectMocks
    private QuadraticSolverImpl solver;


    @Test
    void testWithoutSolution() {
        // given
        double a = 1;
        double b = 0;
        double c = 4;
        double[] expected = new double[]{};
        // when
        double[] actual = solver.solve(a,b,c);
        // then
        assertThat(actual).isEmpty();
    }

    @Test
    void testWithSingleSolution() {
        // given
        double a = 1;
        double b = 0;
        double c = 0;
        double[] expected = new double[]{0.0};
        // when
        double[] actual = solver.solve(a,b,c);
        // then
        assertThat(actual).contains(expected, offset(1e4));
    }

    @Test
    void testWithTwoRealSolution() {
        // given
        double a = 1;
        double b = -1;
        double c = -6;
        double[] expected = new double[]{-2.0, +3.0};
        // when
        double[] actual = solver.solve(a,b,c);
        // then
        assertThat(actual).contains(expected, offset(1e4));
    }
}