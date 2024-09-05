package com.aem.training.site.core.services;

import com.aem.training.site.core.entity.HeaderProductEntity;
import org.apache.sling.api.resource.ResourceResolver;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface HeaderProductService {
   // Data getProducts();
     List<HeaderProductEntity> getProducts() throws IOException;

    void createNode(ResourceResolver resourceResolver) throws IOException;
}
