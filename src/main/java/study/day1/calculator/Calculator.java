package study.day1.calculator;

public class Calculator {
    public int plus(int x, int y) {
        return x + y;
    }

    public int minus(int x, int y) {
        // TDD 규칙2. 처음엔 일단 되도록 만들고, 이후에 아래처럼 리펙토링하자.
        // return 2;
        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }
}
