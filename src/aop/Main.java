package aop;

public class Main {
    public static void main(String[] args) {
        Calculator recCal = new ExeTimeCalculator(new RecCalculator());
        Calculator impCal = new ExeTimeCalculator(new ImpCalculator());

        System.out.println("recCal = " + recCal.factorial(100L));
        System.out.println("impCal = " + impCal.factorial(100L));
    }
}
