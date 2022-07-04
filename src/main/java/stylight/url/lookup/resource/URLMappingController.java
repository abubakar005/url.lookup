package stylight.url.lookup.resource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stylight.url.lookup.service.URLMappingService;

@Tag(description = "Stylight URL Mapping Resource", name = "URLMappingController")
@RestController
@RequestMapping("/api/v1/url-mapping")
public class URLMappingController {

    @Autowired
    private URLMappingService urlMappingService;

    @Operation(summary = "Add New URLs Mapping API",
            description = "This API will add new URLs Mapping in the Maps (bi-directional)")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> addNewURLsMapping(@RequestParam("url1") String url1, @RequestParam("url2") String url2) {
        urlMappingService.addNewMapping(url1, url2);
        return new ResponseEntity<>("URLs Successfully added", HttpStatus.CREATED);
    }
}
