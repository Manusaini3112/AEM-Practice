package com.aem.training.site.core.services;

import com.aem.training.site.core.entity.ProductEntity;
import org.apache.sling.api.resource.ResourceResolver;

import javax.jcr.RepositoryException;
import java.io.IOException;

public interface RestProductService {


  public  ProductEntity getProducts() throws IOException;



//   public void createNode(ResourceResolver resourceResolver,ProductEntity productEntity) throws RepositoryException, IOException;

  public  void createNode(ResourceResolver resourceResolver) throws IOException;
}
