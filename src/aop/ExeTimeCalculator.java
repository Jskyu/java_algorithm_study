package aop;

public class ExeTimeCalculator implements Calculator{

    private final Calculator delegate;

    public ExeTimeCalculator(Calculator delegate) {
        this.delegate = delegate;
    }

    @Override
    public long factorial(long num) {
        long start = System.currentTimeMillis();
        long result = delegate.factorial(num);
        long end = System.currentTimeMillis();

        System.out.println(delegate.getClass().getSimpleName() + ".factorial(" + num + ") 실행시간 = " + (end - start) + "ms");

        return result;
    }
}
