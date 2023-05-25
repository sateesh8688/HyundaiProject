package com.alchemy.newsportal.core.models;



import java.util.Arrays;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Countries {

    private static final List<String> COUNTRY_NAMES = Arrays.asList("India", "US","UK","London","Dubai");

    public List<String> getCountries() {
        return COUNTRY_NAMES;
    }
}
