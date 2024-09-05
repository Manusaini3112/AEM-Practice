package com.aem.training.site.core.servlets;
import com.aem.training.site.core.entity.Data;
import com.aem.training.site.core.entity.HeaderProductEntity;
import com.aem.training.site.core.services.HeaderProductService;
import com.aem.training.site.core.services.RestProductService;
import com.google.gson.Gson;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import javax.jcr.RepositoryException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
@Component(
        service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION +  "= Product Servlet",
                "sling.servlet.paths=" + "/bin/news"})
public class SampleServlet extends SlingSafeMethodsServlet {
    @Reference
    RestProductService restProductService;

    @Reference
    HeaderProductService headerProductService;
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        List<HeaderProductEntity> mydata = headerProductService.getProducts();
        headerProductService.createNode(request.getResourceResolver());
       // ProductEntity data =restProductService.getProducts();
      // String serrch=request.getParameter("search");
      //  restProductService.createNode(request.getResourceResolver());
        response.setContentType("application/json");
    //    response.getWriter().write(new Gson().toJson(data));
      response.getWriter().write("sucessfullly created data");

      //  response.getWriter().write(new Gson().toJson(mydata));
    }
}
