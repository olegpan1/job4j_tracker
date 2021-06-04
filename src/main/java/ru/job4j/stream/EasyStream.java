package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private final List<Integer> listCurrent;

    public EasyStream(List<Integer> listCurrent) {
        this.listCurrent = new ArrayList<>(listCurrent);
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        for (int i = 0; i < listCurrent.size(); i++) {
            listCurrent.set(i, fun.apply(listCurrent.get(i)));
        }
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        for (int i = 0; i < listCurrent.size(); i++) {
            if (!fun.test(listCurrent.get(i))) {
                listCurrent.remove(i);
                i--;
            }
        }
        return this;
    }

    public List<Integer> collect() {
        return listCurrent;
    }
}
