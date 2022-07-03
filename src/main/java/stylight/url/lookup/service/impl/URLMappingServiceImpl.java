package stylight.url.lookup.service.impl;

import org.springframework.stereotype.Service;
import stylight.url.lookup.service.URLMappingService;
import stylight.url.lookup.util.LoadData;

@Service
public class URLMappingServiceImpl implements URLMappingService {

    @Override
    public void addNewMapping(String url1, String url2) {

        // Adding URLS mapping in both MAPs for bi-directional
        LoadData.parameterizedURLsMap.put(url1, url2);
        LoadData.prettyURLsMap.put(url2, url1);
    }
}
