package com.aem.training.site.core.services.impl;
import com.aem.training.site.core.constants.Constclass;
import com.aem.training.site.core.entity.DynamicFieldentity;
import com.aem.training.site.core.services.DynamicCompconfig;
import com.aem.training.site.core.services.DynamicFieldcomponent;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.SearchResult;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.*;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;

import javax.jcr.Session;
import java.util.*;
@Component(service = DynamicFieldcomponent.class)
@Designate(ocd = DynamicCompconfig.class)
public class DynamicFieldcomponentImpl implements DynamicFieldcomponent {
@Reference
    ResourceResolverFactory resourceResolverFactory;
@Reference
    QueryBuilder queryBuilder;

   private String parentPath= StringUtils.EMPTY;

   @Activate
   @Modified
   protected void activqatemodified(DynamicCompconfig config)
   {
       parentPath = config.getDynamicPath();
   }

@Override
public List<DynamicFieldentity> getDynamicField(){
    List<DynamicFieldentity> dynamicfieldlist = new ArrayList<>();
    ResourceResolver resolver = null;
    if(StringUtils.isNotBlank(parentPath))
    {

        try {
            resolver = getResourceResolver("traininguser");
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }
        if (Objects.nonNull(resolver))
        {
            Query query = queryBuilder.createQuery(PredicateGroup.create(getQuery()),resolver.adaptTo(Session.class));
            SearchResult searchResult=query.getResult();
            Iterator<Resource> resourceIterator=searchResult.getResources();
            for (Iterator<Resource> it = resourceIterator; it.hasNext(); ) {
                Resource resource = it.next();

                ValueMap props = resource.getValueMap();
                DynamicFieldentity dynamicFieldentity = new DynamicFieldentity();

                if (props.containsKey(Constclass.PRICE))
                    dynamicFieldentity.setPrice(props.get( Constclass.PRICE,String.class));
                if (props.containsKey(Constclass.SUMMERY))
                    dynamicFieldentity.setSummery(props.get(Constclass.SUMMERY, String.class));
                if (props.containsKey(Constclass.PRODUCT))
                    dynamicFieldentity.setProduct(props.get(Constclass.PRODUCT,String.class));

                dynamicfieldlist.add(dynamicFieldentity);

            }
        }

    }
    return dynamicfieldlist;
}
private ResourceResolver getResourceResolver(String userName) throws LoginException {
        Map<String,Object> authMap = new HashMap<>();
        authMap.put(resourceResolverFactory.SUBSERVICE,userName);
      return resourceResolverFactory.getResourceResolver(authMap);

}
private Map<String,String> getQuery()

    {
        Map<String, String> map = new HashMap<>();
        map.put("path", parentPath);
        map.put("property", "rating");
        map.put("property.value", "4");
        return map;

    }
}
