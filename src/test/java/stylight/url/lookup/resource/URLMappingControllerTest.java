package stylight.url.lookup.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import stylight.url.lookup.service.URLMappingService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = URLMappingController.class)
@AutoConfigureMockMvc
class URLMappingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private URLMappingService urlMappingService;

    public String BASE_URL = "/api/v1/url-mapping";


    @Test
    void addNewURLsMapping() throws Exception {

        doNothing().when(urlMappingService).addNewMapping(any(), any());

        RequestBuilder request = MockMvcRequestBuilders
                .post(BASE_URL)
                .param("url1", "/product?brand=123")
                .param("url2", "/Fashion2/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andReturn();
    }
}