package com.aem.training.site.core.models;
import com.adobe.cq.wcm.core.components.models.Page;
import org.apache.commons.lang.ObjectUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class ,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Testmodel {
    @ValueMapValue
    private String text;

    public String getText() {
        return text;
    }

    @ChildResource
    private Resource textmulti;

 //    @Inject parenttest obj;
   //  @Named("textmulti./'")
 private List<parenttest> productd = new ArrayList<>();
@PostConstruct
    protected void init()
{
    if (textmulti!=null && textmulti.hasChildren())
    {
        for (Resource reslist:textmulti.getChildren()) {
           parenttest parentt=reslist.adaptTo(parenttest.class);
          productd.add(parentt);

        }
    }

}


    public List<parenttest> getProductd() {
        return productd;
    }
}
