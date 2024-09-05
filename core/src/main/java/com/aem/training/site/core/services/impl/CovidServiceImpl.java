package com.aem.training.site.core.services.impl;
import com.aem.training.site.core.entity.ClientResponse;
import com.aem.training.site.core.entity.CovidEntity;
import com.aem.training.site.core.entity.HeaderProductEntity;
import com.aem.training.site.core.services.CovidApiJson;
import com.aem.training.site.core.services.CovidService;
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
import java.util.ArrayList;
import java.util.List;
@Component(service = CovidService.class)
public class CovidServiceImpl implements CovidService{
    @Reference
    CovidApiJson covidApiJson;
    @Override
    public List<CovidEntity> getProducts() throws IOException {
        List<CovidEntity> products = new ArrayList<>();
        ClientResponse clientResponse = null;
        try {
            clientResponse = Trainingutils.getData(covidApiJson.getBaseurl() + covidApiJson.getProducturl(), null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (clientResponse != null && clientResponse.getStatusCode() == HttpServletResponse.SC_OK) {
            String data = (String) clientResponse.getData();
            ObjectMapper objectMapper = new ObjectMapper();
            products = objectMapper.readValue(String.valueOf(data), new TypeReference<List<CovidEntity>>() {
            });
        }
        return products;
    }
    @Override
    public void createNode(ResourceResolver resourceResolver) throws IOException {
        try {
            Resource resource = resourceResolver.getResource("/content/training/us/en");
            Node node = resource.adaptTo(Node.class);
            Node ProductNode = node.addNode("covidcase", JcrConstants.NT_UNSTRUCTURED);
            List<CovidEntity> productEntity1 = getProducts();
            for (CovidEntity product:productEntity1) {
                Node subNode = ProductNode.addNode(product.getDailyconfirmed(), JcrConstants.NT_UNSTRUCTURED);
                subNode.setProperty("title", product.getDailydeceased());
                subNode.setProperty("Category", product.getDate());
                subNode.setProperty("description", product.getTotalconfirmed());
                subNode.setProperty("description", product.getTotaldeceased());
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


