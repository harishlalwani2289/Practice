package practice.harish.designpatterns.openclosedprincipal;

import java.awt.*;
import java.util.List;
import java.util.stream.Stream;

enum Size {
    SMALL, MEDIUM, LARGE, HUGE
}
public class Product {

    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}

class ProductFilter {
    public Stream<Product> filterByColor(List<Product> productList, Color color) {
        return productList.stream().filter(p -> p.color == color);
    }

    public Stream<Product> filterBySize(List<Product> productList, Size size) {
        return productList.stream().filter(p -> p.size == size);
    }

    public Stream<Product> filterBySizeAndColor(List<Product> productList, Size size, Color color) {
        return productList.stream().filter(p -> p.color == color && p.size == size);
    }
}
