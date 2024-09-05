package com.aem.training.site.core.services;

import com.aem.training.site.core.entity.CovidEntity;
import org.apache.sling.api.resource.ResourceResolver;

import java.io.IOException;
import java.util.List;

public interface CovidService {
    List<CovidEntity> getProducts() throws IOException;

    void createNode(ResourceResolver resourceResolver) throws IOException;
}
