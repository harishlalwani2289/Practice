package harish.designpatterns.openclosedprincipal;


import java.awt.*;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.LIGHT_GRAY, Size.LARGE);

        List<Product> productList = java.util.List.of(apple, house, tree);
        ProductFilter productFilter = new ProductFilter();
        System.out.println("Green Products (old) :");
        productFilter.filterByColor(productList, Color.GREEN).forEach((p) -> System.out.println(p.name + " is green"));


        NewProductFilter newProductFilter = new NewProductFilter();
        System.out.println("Green Products (new) :");
        newProductFilter.filter(productList, new ColorSpecification(Color.GREEN)).forEach((p) -> System.out.println(p.name + " is green"));

        System.out.println("Large green items:");
        newProductFilter.filter(productList, new AndSpecification<>(
                new ColorSpecification(Color.GREEN), new SizeSpecification(Size.LARGE)
        )).forEach(p -> System.out.println(p.name + " is large and green"));
    }
}
