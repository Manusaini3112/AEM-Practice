package com.aem.training.site.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeaderParent {
    @ValueMapValue
    private String finance;
    @ValueMapValue
    private String motorcycle;
    @ValueMapValue
    private String price;

    public String getFinance() {
        return finance;
    }

    public String getMotorcycle() {
        return motorcycle;
    }

    public String getPrice() {
        return price;
    }
}
