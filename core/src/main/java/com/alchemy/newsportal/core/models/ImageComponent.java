package com.alchemy.newsportal.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
		adaptables = {Resource.class,SlingHttpServletRequest.class}, 
		resourceType = "newsportal/components/image-component",
		defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(extensions = "json",name = "jackson")
public class ImageComponent {

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String text;
	
	@ValueMapValue
	private String fileReference;
	
	@ScriptVariable
	ValueMap pageProperties;
	
	@RequestAttribute
	private String type;
	
	boolean showContent = true;

	public String getText() {
		return text;
	}

	public String getFileReference() {
		return fileReference;
	}
	
	public boolean isShowContent() {
		return showContent;
	}

}