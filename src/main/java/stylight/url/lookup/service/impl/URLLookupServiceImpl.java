package stylight.url.lookup.service.impl;

import org.springframework.stereotype.Service;
import stylight.url.lookup.service.URLLookupService;
import stylight.url.lookup.util.Constants;
import stylight.url.lookup.util.LoadData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class URLLookupServiceImpl implements URLLookupService {

    @Override
    public Map<String, String> getPrettyURLs(List<String> parameterizedURLs) {

        return parameterizedURLs.parallelStream()
                .collect(Collectors.toMap(key -> key, this::prettyUrlFromParametrized));
    }

    @Override
    public Map<String, String> getParameterizedURLs(List<String> prettyURLs) {

        return prettyURLs.parallelStream()
                .collect(Collectors.toMap(key -> key, this::parametrizedUrlFromPretty));
    }

    private String prettyUrlFromParametrized(String parametrizedUrl) {

        Map<String, String> map = LoadData.parameterizedURLsMap;
        StringBuilder prettyUrl = new StringBuilder();

        if(map.containsKey(parametrizedUrl))
            return map.get(parametrizedUrl);

        StringBuilder notMatched = new StringBuilder();
        String temp = parametrizedUrl;

        // If URL have multiple params
        if (parametrizedUrl.contains(Constants.SYMBOL_AMPERSAND)) {

            String[] array = parametrizedUrl.split(Constants.REGEX_AMPERSAND);

            for(int i=array.length-1; i > 0; i--) {

                if (notMatched.length() != 0)
                    notMatched.insert(0, Constants.SYMBOL_AMPERSAND);

                notMatched.insert(0, array[i]);

                temp = temp.replace(Constants.SYMBOL_AMPERSAND+array[i], Constants.EMPTY_STRING);

                if(map.containsKey(temp)) {
                    prettyUrl.append(map.get(temp));
                    prettyUrl.append(Constants.SYMBOL_QUESTION_MARK);
                    prettyUrl.append(notMatched);

                    return prettyUrl.toString();
                }
            }
        }

        // If URL have single param
        if (temp.contains(Constants.SYMBOL_QUESTION_MARK) ) {

            String[] array = temp.split(Constants.REGEX_QUESTION_MARK);

            if (notMatched.length() != 0)
                notMatched.insert(0, Constants.SYMBOL_AMPERSAND);

            notMatched.insert(0, array[1]);

            if(map.containsKey(array[0])) {
                prettyUrl.append(map.get(array[0]));
                prettyUrl.append(Constants.SYMBOL_QUESTION_MARK);
                prettyUrl.append(notMatched);

                return prettyUrl.toString();
            }
        }

        return parametrizedUrl;
    }

    private String parametrizedUrlFromPretty(String prettyUrl) {

        Map<String, String> map = LoadData.prettyURLsMap;
        StringBuilder parametrizedUrl = new StringBuilder();

        if(map.containsKey(prettyUrl))
            return map.get(prettyUrl);

        if (prettyUrl.contains(Constants.SYMBOL_QUESTION_MARK)) {

            String[] array = prettyUrl.split(Constants.REGEX_QUESTION_MARK);

            if(map.containsKey(array[0])) {

                String pretty = map.get(array[0]);

                if(pretty.contains(Constants.SYMBOL_QUESTION_MARK))
                    parametrizedUrl.append(Constants.SYMBOL_AMPERSAND);
                else
                    parametrizedUrl.append(Constants.SYMBOL_QUESTION_MARK);

                parametrizedUrl.insert(0, pretty);
                parametrizedUrl.append(array[1]);

                return parametrizedUrl.toString();
            }
        }

        return prettyUrl;
    }
}
