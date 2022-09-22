package harish.morganstanley;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EcomController {

    // @Autowired
    // Constructor
    CartService cartService;

    // @GetMapping("/cart")
    public Object getCart() {
        return null;
     }

    // @PostMapping("/checkout")
    public Object checkout(Cart cart) {


            Map<String, Integer> availableInventoryQuantity = cartService.getAvailableInventoryQuantity
                    (cart.items.stream().map(item -> item.item_id).collect(Collectors.toList()));
            if(cart.items.stream()
                    .anyMatch(item -> item.item_quantity > availableInventoryQuantity.get(item.item_id))) {
                // Raise an exception
            }

            for(Item item : cart.items) {
                Thread thread = new Thread(new PriceDetails());
                thread.start();
            }
    return null;


    }
}

class PriceDetails implements Runnable {

    @Override
    public void run() {
        // Make a call to fetch the price of 1 item
    }
}

class Cart {

    List<Item> items;
}

class Item {
    String item_id;
    Double item_price;
    Integer item_quantity;
}
