package com.aem.training.site.core.models;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class parenttest {
    @ValueMapValue
    private String texttitle;

    @ValueMapValue
    private String texti;

    @ValueMapValue
    private String textt;

    @ValueMapValue
    private String textp;

    public String getTexttitle() {
        return texttitle;
    }

    public String getTexti() {
        return texti;
    }

    public String getTextt() {
        return textt;
    }

    public String getTextp() {
        return textp;
    }
}
