//package com.aem.training.site.core.servlets;
//import org.apache.sling.api.SlingHttpServletRequest;
//import org.apache.sling.api.SlingHttpServletResponse;
//import org.apache.sling.api.servlets.HttpConstants;
//import org.apache.sling.api.servlets.SlingAllMethodsServlet;
//import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
//import org.osgi.framework.Constants;
//import org.osgi.service.component.annotations.Component;
//import javax.servlet.Servlet;
//import javax.servlet.ServletException;
//import java.io.IOException;
//
//@Component(
//        service = Servlet.class,
//        property = {
//                Constants.SERVICE_DESCRIPTION +  "= Product Servlet",
//                "sling.servlet.paths=" + "/bin/news"})
//class ProductServlet extends SlingSafeMethodsServlet{
//    @Override
//    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().write("hello");
//    }
//}
