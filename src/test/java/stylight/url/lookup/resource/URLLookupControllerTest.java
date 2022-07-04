package stylight.url.lookup.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import stylight.url.lookup.service.URLLookupService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = URLLookupController.class)
@AutoConfigureMockMvc
class URLLookupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private URLLookupService uRLLookupService;

    public String BASE_URL = "/api/v1/url-lookup";


    @Test
    void getAllPrettyURLs() throws Exception {

        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        when(uRLLookupService.getPrettyURLs(any()))
                .thenReturn(map);

        RequestBuilder request = MockMvcRequestBuilders
                .post(BASE_URL+"/prettyURLs")
                .content(asJsonString(list))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getAllParameterizedURLs() throws Exception {

        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        when(uRLLookupService.getParameterizedURLs(any()))
                .thenReturn(map);

        RequestBuilder request = MockMvcRequestBuilders
                .post(BASE_URL+"/parameterizedURLs")
                .content(asJsonString(list))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}