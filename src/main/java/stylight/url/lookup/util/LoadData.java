package stylight.url.lookup.util;

import java.util.HashMap;
import java.util.Map;

public class LoadData {

    public static Map<String, String> parameterizedURLsMap = new HashMap<>();
    public static Map<String, String> prettyURLsMap = new HashMap<>();

    public static void loadParameterizedURLsMap() {
        parameterizedURLsMap.put("/products", "/Fashion/");
        parameterizedURLsMap.put("/products?gender=female", "/Women/");
        parameterizedURLsMap.put("/products?tag=5678", "/Boat--Shoes/");
        parameterizedURLsMap.put("/products?gender=female&tag=123&tag=1234", "/Women/Shoes/");
        parameterizedURLsMap.put("/products?brand=123", "/Adidas/");
    }

    public static void loadPrettyURLsMap() {
        prettyURLsMap.put("/Fashion/", "/products");
        prettyURLsMap.put("/Women/", "/products?gender=female");
        prettyURLsMap.put("/Boat--Shoes/", "/products?tag=5678");
        prettyURLsMap.put("/Women/Shoes/", "/products?gender=female&tag=123&tag=1234");
        prettyURLsMap.put("/Adidas/", "/products?brand=123");
    }
}
