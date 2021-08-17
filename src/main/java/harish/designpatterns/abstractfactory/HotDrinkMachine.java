package harish.designpatterns.abstractfactory;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;

public class HotDrinkMachine {

    private List<Pair<String, HotDrinkFactory>> namedFactories = new ArrayList<>();

    public HotDrinkMachine() {
    }
}
