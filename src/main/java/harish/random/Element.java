package harish.random;

public class Element implements Comparable{

    public int value;
    public int priority;

    public Element(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Object o) {
        Element e = (Element) o;
        return e.priority - this.priority;
    }
}
