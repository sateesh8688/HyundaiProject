package com.alchemy.newsportal.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import com.day.cq.wcm.api.PageManager;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class,
        property = {
                "sling.servlet.methods=GET",
                "sling.servlet.resourceTypes=newsportal/components/page",
                "sling.servlet.selectors=model",
                "sling.servlet.extensions=html"
        })
public class PageName extends SlingAllMethodsServlet {

	 private static final long serialVersionUID = 4009390965847889732L;

	@Override
	    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
	            throws ServletException, IOException {
	        Resource resource = request.getResource();
	        ResourceResolver resourceResolver = request.getResourceResolver();

	        String pageTitle = resourceResolver.adaptTo(PageManager.class).getContainingPage(resource).getTitle();

	        response.setContentType("text/html");
	        response.getWriter().write("Current Page Name : " + pageTitle);
	    }
}
