package com.alchemy.newsportal.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class ImageVideoComponent  {
    @ValueMapValue
	private String image;
    @ValueMapValue
    private String video;
//pojo class
    public String getImage() {
        return image;
    }

    public String getVideo() {
        return video;
    }
}
