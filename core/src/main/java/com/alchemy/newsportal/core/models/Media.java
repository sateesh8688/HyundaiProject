package com.alchemy.newsportal.core.models;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.request.RequestParameter;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Media {

    @javax.inject.Inject
    private RequestParameter video;

    public String getVideoPath() {
        if (video != null) {
            return video.getFileName();
        }
        return null;
    }

}
