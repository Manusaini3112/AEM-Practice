package com.aem.training.site.core.servlets;

import com.aem.training.site.core.entity.CovidEntity;
import com.aem.training.site.core.entity.HeaderProductEntity;
import com.aem.training.site.core.services.CovidService;
import com.aem.training.site.core.services.HeaderProductService;
import com.google.gson.Gson;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@Component(
        service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION +  "= Covid Servlet",
                "sling.servlet.paths=" + "/bin/new"})
public class CovidServlet extends SlingSafeMethodsServlet {
    @Reference
  //  HeaderProductService headerProductService;
    CovidService covidService;
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        List<CovidEntity> mydata = covidService.getProducts();
        covidService.createNode(request.getResourceResolver());
        // ProductEntity data =restProductService.getProducts();
        // String serrch=request.getParameter("search");
        //  restProductService.createNode(request.getResourceResolver());
        response.setContentType("application/json");
        //    response.getWriter().write(new Gson().toJson(data));
      //  response.getWriter().write("sucessfullly created data");

         response.getWriter().write(new Gson().toJson(mydata));
    }

}
