package stylight.url.lookup.resource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stylight.url.lookup.service.URLLookupService;

import java.util.List;
import java.util.Map;

@Tag(description = "Stylight URL Lookup Resource", name = "URLLookupController")
@RestController
@RequestMapping("/api/v1/url-lookup")
public class URLLookupController {

    @Autowired
    private URLLookupService uRLLookupService;

    @Operation(summary = "Get Pretty URLs API",
            description = "This API will return Pretty URLs Mapping")
    @PostMapping("/prettyURLs")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> getAllPrettyURLs(@RequestBody List<String> parameterizedURLs) {
        return uRLLookupService.getPrettyURLs(parameterizedURLs);
    }

    @Operation(summary = "Get Parameterized URLs API",
            description = "This API will return Parameterized URLs Mapping")
    @PostMapping("/parameterizedURLs")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> getAllParameterizedURLs(@RequestBody List<String> prettyURLs) {
        return uRLLookupService.getParameterizedURLs(prettyURLs);
    }
}
