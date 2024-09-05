package com.aem.training.site.core.models;

import com.aem.training.site.core.entity.HeaderProductEntity;
import com.aem.training.site.core.services.HeaderProductService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeaderTest {

    @ValueMapValue
    private String motorcycles;
   @ValueMapValue
    private String services;
   @ValueMapValue
    private String apperals;

   @ValueMapValue
   private String Accessories;

    public String getAccessories() {
        return Accessories;
    }

    public String getMotorcycles() {
        return motorcycles;
    }

    public String getServices() {
        return services;
    }

    public String getApperals() {
        return apperals;
    }


    @ChildResource
    private Resource multifield;
    private List<HeaderParent> productcart = new ArrayList<>();
    @PostConstruct
    protected void init()
    {
        if (multifield!=null && multifield.hasChildren())
        {
            for (Resource reslist:multifield.getChildren()) {
                HeaderParent HeaderP=reslist.adaptTo(HeaderParent.class);
                productcart.add(HeaderP);
            }
        }
    }
    public List<HeaderParent> getProductcart() {
        return productcart;
    }
    @OSGiService
    HeaderProductService headerProductService;
    public List<HeaderProductEntity> getData() throws IOException {
        return headerProductService.getProducts();
    }
}



