package com.aem.training.site.core.models;
import com.aem.training.site.core.entity.DynamicFieldentity;
import com.aem.training.site.core.entity.HeaderCustom;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Model(adaptables = SlingHttpServletRequest.class , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeaderPath {
    public static final String CATEGORY = "Category";
    public static final String SUMMERY = "title";
    public static final String DESCRIPTION = "description";

    @ValueMapValue
    private String productheader;
    @ScriptVariable
    SlingHttpServletRequest request;
List<HeaderCustom> dynamicfieldlist = new ArrayList<>();
@PostConstruct
    protected void init()
{
    if(StringUtils.isNotBlank(productheader))
{
    ResourceResolver resolver = request.getResourceResolver();
    if (Objects.nonNull(resolver))
    {
        Resource parentResource = resolver.getResource(productheader);
        if (Objects.nonNull(parentResource) && parentResource.hasChildren())
        {
            for (Resource childRes : parentResource.getChildren())
            {
                ValueMap props = childRes.getValueMap();
   //             DynamicFieldentity dynamicFieldentity = new DynamicFieldentity();
                HeaderCustom dynamicFieldentity = new HeaderCustom();
                if (props.containsKey(CATEGORY))
                        dynamicFieldentity.setCategory(props.get( CATEGORY,String.class));
               if (props.containsKey(SUMMERY))
                      dynamicFieldentity.setTitle(props.get(SUMMERY, String.class));
                if (props.containsKey(SUMMERY))
                    dynamicFieldentity.setDescription(props.get(DESCRIPTION, String.class));
                dynamicfieldlist.add(dynamicFieldentity);
            }
        }
    }
}
}
    public List<HeaderCustom> getDynamicfieldlist() {
        return dynamicfieldlist;
    }
}

