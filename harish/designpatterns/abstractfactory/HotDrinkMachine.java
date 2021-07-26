package practice.harish.designpatterns.abstractfactory;

import org.javatuples.Pair;
import sun.reflect.ReflectionFactory;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.*;

public class HotDrinkMachine {

    private List<Pair<String, HotDrinkFactory>> namedFactories = new ArrayList<>();

    public HotDrinkMachine() {
    }
}
