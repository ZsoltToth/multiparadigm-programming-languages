package hu.uni.ekcu.java.service;

import org.springframework.stereotype.Service;

@Service
public class PrimeServiceImpl implements PrimeService {

    @Override
    public boolean isPrime(int number) {
        if (number < 2) { //Guard Statement
            return false;
        }
        for (int i = 2; i <= (number / 2.0); i++) {
            if (isDividable(number, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDividable(int numerator, int denominator) {
        return (numerator % denominator) == 0;
    }

}
