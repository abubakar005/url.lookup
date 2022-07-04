package stylight.url.lookup.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import stylight.url.lookup.service.URLMappingService;

class URLMappingServiceImplTest {

    @InjectMocks
    private URLMappingService uRLMappingService = new URLMappingServiceImpl();

    @Test
    void addNewMapping() {
        uRLMappingService.addNewMapping("/product?brand=123", "/Fashion2/");
    }
}