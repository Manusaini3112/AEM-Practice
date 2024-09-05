package com.aem.training.site.core.models;
import com.aem.training.site.core.entity.DynamicFieldentity;
import com.aem.training.site.core.services.DynamicFieldcomponent;
import com.aem.training.site.core.services.ManageJcrService;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import javax.annotation.PostConstruct;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DynamicFieldV {

    @ValueMapValue
    private String product;

    @ScriptVariable
    SlingHttpServletRequest request;
    @OSGiService
    DynamicFieldcomponent dynamicFieldcomponent;

    @OSGiService
    ManageJcrService manageJcrService;

    @PostConstruct
    protected void init()
    {
     //   try {
    //      Page page= manageJcrService.createJcrPage(request.getResourceResolver());
     //     String a= "page";
        //    ResourceResolver resourceResolver = request.getResourceResolver();
     //       Session session= resourceResolver.adaptTo(Session.class);
     //       manageJcrService.createjcrnode("/content/training/us/en/dynamicpage/jcr:content","samplenode",session);
    //    } catch (RepositoryException e) {
    //        throw new RuntimeException(e);
     //   }

    }

    public List<DynamicFieldentity> getDynamicfieldlist() {

        return dynamicFieldcomponent.getDynamicField();
    }

}
