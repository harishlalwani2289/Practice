package harish.morganstanley;


import java.util.List;
import java.util.Map;

// class responsible for cart related details
public interface CartService {

    Map<String, Integer> getAvailableInventoryQuantity(List<String> items);
    Map<String, Integer> getLatestPrice(List<String> item);

}
