package lambda_study.withInterface;
/**
    람다식이란 "식별자없이 실행가능한 함수"

    함수인데 함수를 따로 만들지 않고 코드한줄에 함수를 써서 그것을 호출하는 방식이라고 생각하시면 되겠습니다.
    함수적 프로그래밍을 위해 자바 8부터 람다식(Lambda Expressions)을 지원하면서 기존의 코드 패턴이 많이 달라졌습니다.
    자바스크립트에서 주로 봤었던 문법들을 이제 자바에서도 종종 보이곤 해요.
    람다가 처음에는 생소하게 느껴질 수 있지만 문법이 간결한만큼 익숙해지면 가독성 면에서 장점이 큰 듯 합니다.
    (고급 프로그래머들중에서는 람다를 최대한 쓰지말라고 하는 사람도 있습니다.)


    람다식 사용법

    (매개변수, ...) -> { 실행문 ... }
    (매개변수, ...)는 오른쪽 중괄호 { } 블록을 실행하기 위해 필요한 값을 제공하는 역할을 합니다.
    매개 변수의 이름은 개발자가 자유롭게 지정할 수 있으며 인자타입도 명시하지 않아도 됩니다.
    -> 기호는 매개 변수를 이용해서 중괄호 { } 바디를 실행한다는 뜻으로 해석하면 됩니다.

 **/

class Example1 {
    //람다식 문법 (매개변수 목록)->{실행문}
    @FunctionalInterface
    interface Compare{
        int compareTo(int a, int b);
    }
    static void exec(Compare com) {
        int k = 10;
        int m = 20;
        int value = com.compareTo(k, m);
        System.out.println(value);
    }
    public static void main(String[] args) {
        exec((i,j)->{
            return i+j;
        });
    }
}

class Ramda3 {
    @FunctionalInterface//함수형 인터페이스 체크 어노테이션
    public interface MyNumber{
        int getMax(int num1, int num2);
    }

    public static void main(String[] args) {
        MyNumber max = (x,y)->(x>=y)? x:y;

        System.out.println(max.getMax(10, 30));
    }
}

class RunnableEx {
    public static void main(String[] args) throws InterruptedException{
        Runnable runnable = () -> {
            for (int i = 0; i < 30; i++) {
                System.out.println(i);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        thread = new Thread( () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        });
        thread.start();
    }
}