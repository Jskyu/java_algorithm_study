package generic.list;

import java.util.*;
import java.util.stream.Stream;

public class NumberList<T extends Number & Comparable<? super T>> {

    private final List<T> list;

    public NumberList() {
        list = new ArrayList<>();
    }

    public static<T extends Number & Comparable<? super T>> NumberList<T> toNumberList(List<T> list) {
        NumberList<T> toList = new NumberList<>();
        list.forEach(toList::add);
        return toList;
    }

    public void add(T element) {
        this.list.add(element);
    }

    public T get(int index) {
        return list.get(index);
    }

    public static<T extends Number & Comparable<? super T>> NumberList<T> asList(T... t){
        NumberList<T> list = new NumberList<>();
        list.addAll(t);
        return list;
    }

    private void addAll(T[] ts) {
        for (T t : ts) {
            this.add(t);
        }
    }

    public int size(){
        return list.size();
    }

    public void clear(){
        list.clear();
    }

    public boolean contains(T t){
        return list.contains(t);
    }

    public Stream<T> stream(){
        return list.stream();
    }

    public String toString() {
        Iterator<T> it = list.iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            T e = it.next();
            sb.append(e);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }
}
