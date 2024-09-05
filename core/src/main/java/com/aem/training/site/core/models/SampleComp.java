package com.aem.training.site.core.models;

import com.aem.training.site.core.entity.CovidEntity;
import com.aem.training.site.core.entity.HeaderProductEntity;
import com.aem.training.site.core.entity.ProductEntity;
import com.aem.training.site.core.services.CovidService;
import com.aem.training.site.core.services.RestProductService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SampleComp {

//    @ValueMapValue
//    private String text;
//    @ValueMapValue
//    private String textarea;
//    @ValueMapValue
//    private  String texta;
//
//    public String getTextarea() {
//        return textarea.toUpperCase();
//    }
//
//    public String getTexta() {
//        return texta.toUpperCase();
//    }
//
//
//
//
//
//    public String getText() {
//        return text.toUpperCase();
//    }
//    @OSGiService
//    RestProductService restProductService;
//
//    public ProductEntity getProductResponse() throws IOException {
//        return restProductService.getProducts();
//
//    }
    @OSGiService
    CovidService covidService;
    public List<CovidEntity> getData() throws IOException {
        return covidService.getProducts();

    }

}
