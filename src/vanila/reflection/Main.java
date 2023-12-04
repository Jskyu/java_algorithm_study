package vanila.reflection;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {

        A clazz = new A(10, 1.2f, 20, "Hi");
        // class 가져오기
        Class<A> clazz1 = A.class;
        Class<? extends A> clazz2 = new A().getClass();
        System.out.println("clazz1 = " + clazz1.hashCode() + ", clazz3 = " + clazz2.hashCode());

        try {
            Class<?> clazz3 = Class.forName("vanila.reflection.A");
            System.out.println("clazz1 = " + clazz1.hashCode() + ", clazz3 = " + clazz3.hashCode());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

        // public 요소들 (상속받은 내용 포함)
        Method[] publicMethods = clazz1.getMethods();
        Field[] publicFields = clazz1.getFields();

        // 해당 클래스에서 정의된 요소들
        Method[] declaredMethods = clazz1.getDeclaredMethods();
        Field[] declaredFields = clazz1.getDeclaredFields();

        // 어노테이션
        Annotation[] publicAnnotations = clazz1.getAnnotations();
        Annotation[] declaredAnnotations = clazz1.getDeclaredAnnotations();
        AnnotatedType[] annotatedInterfaces = clazz1.getAnnotatedInterfaces();
        ExamAnnotation getAnnotation = clazz1.getDeclaredAnnotation(ExamAnnotation.class);
        String value = getAnnotation.value();
        System.out.println("value = " + value);

        try {
            // 생성자 메서드
            Constructor<A> constructor = clazz1.getDeclaredConstructor();
            A instance = constructor.newInstance();
            System.out.println(instance.toString());
        } catch (NoSuchMethodException e) {
            // constructor 생성 에러
            System.err.println(e.getMessage());
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            // constructor 를 이용한 객체 instance 생성 에러
            System.err.println(e.getMessage());
        }

        try {
            // 매개변수가 존재하는 생성자 메서드 사용
            Constructor<A> constructor = clazz1.getDeclaredConstructor(int.class, float.class, Integer.class, String.class);

            int i = 10;
            float f = 1.1f;
            Integer ic = 11;
            String s = "Hello World";

            A newClazz = constructor.newInstance(i, f, ic, s);
            System.out.println(newClazz.toString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // private 메서드에 접근
        Method method = null;
        for (Method meth : declaredMethods) {
            //private 메서드
            if (Modifier.PRIVATE == meth.getModifiers()) {
                method = meth;
                break;
            }
        }

        try {
            method.invoke(clazz);
        } catch (InvocationTargetException | IllegalAccessException e) {
            System.err.println("private 메서드를 실행하면 예외가 발생한다.");
            System.err.println(e.getMessage());
        }

        try {
            method.setAccessible(true);
            method.invoke(clazz);
        } catch (IllegalArgumentException | InvocationTargetException | IllegalAccessException e) {
            System.err.println("private 메서드를 실행하면 예외가 발생한다.");
            System.out.println("setAccessible(true) 를 이용하여 접근이 가능하도록 만들 수 있다.");
        }
    }
}

@ExamAnnotation(value = "Hello. This is Annotation Change Value.")
class A {
    int i;
    private float f;

    protected Integer ic;

    public String s;

    public A() {
    }

    public A(int i, float f, Integer ic, String s) {
        this.i = i;
        this.f = f;
        this.ic = ic;
        this.s = s;
    }

    public int getI1() {
        System.out.println("public getI1: i = " + i);
        return i;
    }

    private int getI2() {
        System.out.println("private getI2: i = " + i);
        return i;
    }

    @Override
    public String toString() {
        return "A{" +
                "i=" + i +
                ", f=" + f +
                ", ic=" + ic +
                ", s='" + s + '\'' +
                '}';
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@interface ExamAnnotation {

    String value() default "Hi. This is Annotation Default Value.";
}