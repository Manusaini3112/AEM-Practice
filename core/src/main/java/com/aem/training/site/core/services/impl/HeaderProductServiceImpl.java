package com.aem.training.site.core.services.impl;
import com.aem.training.site.core.entity.ClientResponse;
import com.aem.training.site.core.entity.HeaderProductEntity;
import com.aem.training.site.core.services.HeaderJsonClass;
import com.aem.training.site.core.services.HeaderProductService;
import com.aem.training.site.core.utils.Trainingutils;
import com.day.cq.commons.jcr.JcrConstants;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Component(service = HeaderProductService.class)
public class HeaderProductServiceImpl implements HeaderProductService {
    @Reference
    HeaderJsonClass headerJsonClass;

    @Override
    public List<HeaderProductEntity> getProducts() throws IOException {
        List<HeaderProductEntity> products = new ArrayList<>();
        ClientResponse clientResponse = null;
        try {
            clientResponse = Trainingutils.getData(headerJsonClass.getBaseurl() + headerJsonClass.getProducturl(), null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (clientResponse != null && clientResponse.getStatusCode() == HttpServletResponse.SC_OK) {
            String data = (String) clientResponse.getData();
            ObjectMapper objectMapper = new ObjectMapper();
            products = objectMapper.readValue(String.valueOf(data), new TypeReference<List<HeaderProductEntity>>() {
            });
        }
        return products;
    }
        @Override
    public void createNode(ResourceResolver resourceResolver) throws IOException {
            try {
                Resource resource = resourceResolver.getResource("/content/training/us");
                Node node = resource.adaptTo(Node.class);
                Node ProductNode = node.addNode("product", JcrConstants.NT_UNSTRUCTURED);
                List<HeaderProductEntity> productEntity1 = getProducts();
//                Set<String> category = new HashSet<>();

                for (HeaderProductEntity product:productEntity1) {
//                    category.add(product.getCategory());
                // String a = category.toString();


//                for (HeaderProductEntity product: productEntity1) {
//                    if (product.getCategory().equals(category.)) {
//                    List<String> list = new ArrayList<>();
//                    list.add(product.getId());
//                    list.add(product.getTitle());
//
//
//                    Map<Object ,Object >  map = new HashMap<>();
//                        map.put(category,list);
//
//                    }



                    Node subNode = ProductNode.addNode(product.getCategory(), JcrConstants.NT_UNSTRUCTURED);
                    subNode.setProperty("title", product.getTitle());
                    subNode.setProperty("Category", product.getCategory());
                    subNode.setProperty("description", product.getDescription());
                   resourceResolver.adaptTo(Session.class).save();
                }

                resourceResolver.adaptTo(Session.class).save();
            } catch (RepositoryException e) {
                e.printStackTrace();
            } finally {
                try {
                    resourceResolver.adaptTo(Session.class).save();
                } catch (RepositoryException e) {
                    throw new RuntimeException(e);
                }
            }
        }
}


