package stylight.url.lookup.service;

import java.util.List;
import java.util.Map;

public interface URLLookupService {

    Map<String, String> getPrettyURLs(List<String> parameterizedURLs);
    Map<String, String> getParameterizedURLs(List<String> prettyURLs);
}
