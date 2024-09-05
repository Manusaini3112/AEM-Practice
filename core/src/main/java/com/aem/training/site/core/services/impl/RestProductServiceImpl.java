package com.aem.training.site.core.services.impl;
import com.aem.training.site.core.entity.ClientResponse;
import com.aem.training.site.core.entity.ProductEntity;
import com.aem.training.site.core.services.JsonClass;
import com.aem.training.site.core.services.RestProductService;
import com.aem.training.site.core.utils.Trainingutils;
import com.day.crx.JcrConstants;
import com.google.gson.Gson;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(service = RestProductService.class)
public class RestProductServiceImpl implements RestProductService{
@Reference
    JsonClass jsonClass;
@Override
public ProductEntity getProducts() throws IOException {
    ProductEntity Product = new ProductEntity();
   ClientResponse clientResponse= Trainingutils.getData(jsonClass.getBaseurl()+jsonClass.getProducturl(),null);
if(clientResponse!=null && clientResponse.getStatusCode()== HttpServletResponse.SC_OK)
{
  String data= (String) clientResponse.getData();
  Product = new Gson().fromJson(data, ProductEntity.class);
}
return Product;
}
@Override
public void createNode(ResourceResolver resourceResolver) throws IOException {
    try {
        Resource resource = resourceResolver.getResource("/content/training");
        Node node = resource.adaptTo(Node.class);
        Node ProductNode = node.addNode("products", JcrConstants.NT_UNSTRUCTURED);
        ProductEntity productEntity1 = getProducts();
        Node subNode = ProductNode.addNode(productEntity1.getTitle(), JcrConstants.NT_UNSTRUCTURED);
        subNode.setProperty("id", productEntity1.getId());
        subNode.setProperty("userid", productEntity1.getUserId());
        resourceResolver.adaptTo(Session.class).save();
    } catch (RepositoryException e) {
       e.printStackTrace();
    }
//    finally {
//        resourceResolver.adaptTo(Session.class).save();
//    }
}
}
