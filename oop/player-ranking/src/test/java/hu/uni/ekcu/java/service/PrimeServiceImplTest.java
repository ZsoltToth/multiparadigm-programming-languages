package hu.uni.ekcu.java.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PrimeServiceImplTest {

    private PrimeServiceImpl primeService = new PrimeServiceImpl();

    @Disabled
    @Test
    void isNotPrime() {
        // given
        final int NOT_PRIME_NUMBER = 4;
        final boolean expected = false;
        // when
        final boolean actual = primeService.isPrime(NOT_PRIME_NUMBER);
        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled
    @Test
    void isNotPrimeUglySolution() {
        // given
        // when
        boolean result = primeService.isPrime(4);
        // then
        assertThat(result).isEqualTo(false);
    }

    @Disabled
    @Test
    void isPrime() {
        // given
        final int PRIME_NUMBER = 5;
        final boolean expected = true;
        // when
        final boolean actual = primeService.isPrime(PRIME_NUMBER);
        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled
    @Test
    void shouldBePrimeTwo() {
        // given
        final int TWO = 2;
        final boolean expected = true;
        // when
        final boolean actual = primeService.isPrime(TWO);
        // then
        assertThat(actual).isEqualTo(expected);
    }


    @Disabled
    @Test
    void shouldNotBePrimeOne() {
        // given
        final int ONE = 1;
        final boolean expected = false;
        // when
        final boolean actual = primeService.isPrime(ONE);
        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled
    @Test
    void shouldBeFalseForZero() {
        // given
        final int ZERO = 0;
        final boolean expected = false;
        // when
        final boolean actual = primeService.isPrime(ZERO);
        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled
    @ParameterizedTest
    @CsvSource(value = {
            "-1", "-4", "-1000"
    })
    void shouldBeFalseForNegativeValues(int value) {
        // given
        final boolean expected = false;
        // when
        final boolean actual = primeService.isPrime(value);
        // then
        assertThat(actual).isEqualTo(expected);
    }
}