package stylight.url.lookup.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import stylight.url.lookup.service.URLLookupService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class URLLookupServiceImplTest {

    @InjectMocks
    private URLLookupService urlLookupService = new URLLookupServiceImpl();

    @Test
    void getPrettyURLs() {

        List<String> list = Collections.singletonList("/products?brand=123");

        Map<String, String> prettyURLs = urlLookupService.getPrettyURLs(list);

        assertNotNull(prettyURLs);
        assertEquals("/products?brand=123", prettyURLs.get("/products?brand=123"));
        assertEquals(1, prettyURLs.size());
    }

    @Test
    void getParameterizedURLs() {

        List<String> list = Arrays.asList("/Adidas/");

        Map<String, String> parameterizedURLs = urlLookupService.getPrettyURLs(list);

        assertNotNull(parameterizedURLs);
        assertEquals("/Adidas/", parameterizedURLs.get("/Adidas/"));
        assertEquals(1, parameterizedURLs.size());

    }

    private Map<String, String> getMockedParameterizedURLsMap() {
        return new HashMap<>() {{
            put("/products?brand=123", "/Adidas/");
        }};
    }

    private Map<String, String> getMockedPrettyURLsMap() {
        return new HashMap<>() {{
            put("/Adidas/", "/products?brand=123");
        }};
    }
}