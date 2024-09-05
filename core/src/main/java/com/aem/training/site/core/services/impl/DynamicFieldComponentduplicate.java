//package com.aem.training.site.core.services.impl;
//
//
//
//import com.aem.training.site.core.constants.Constclass;
//import com.aem.training.site.core.entity.DynamicFieldentity;
//import com.aem.training.site.core.services.DynamicFieldcomponent;
//import org.apache.commons.lang.StringUtils;
//import org.apache.sling.api.resource.*;
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//import java.util.*;
//
//
//@Component(service = DynamicFieldcomponent.class)
//public class DynamicFieldComponentduplicate implements DynamicFieldcomponent {
//    @Reference
//    ResourceResolverFactory resourceResolverFactory;
//    @Override
//    public List<DynamicFieldentity> getDynamicField(String parentPath){
//        List<DynamicFieldentity> dynamicfieldlist = new ArrayList<>();
//
//        if(StringUtils.isNotBlank(parentPath))
//        {
//            ResourceResolver resolver = null;
//            try {
//                resolver = getResourceResolver("traininguser");
//            } catch (LoginException e) {
//                throw new RuntimeException(e);
//            }
//            if (Objects.nonNull(resolver))
//            {
//                Resource parentResource = resolver.getResource(parentPath);
//                if (Objects.nonNull(parentResource) && parentResource.hasChildren())
//                {
//                    for (Resource childRes : parentResource.getChildren())
//                    {
//                        ValueMap props = childRes.getValueMap();
//                        DynamicFieldentity dynamicFieldentity = new DynamicFieldentity();
//
//                        if (props.containsKey(Constclass.PRICE))
//                            dynamicFieldentity.setPrice(props.get( Constclass.PRICE,String.class));
//                        if (props.containsKey(Constclass.SUMMERY))
//                            dynamicFieldentity.setSummery(props.get(Constclass.SUMMERY, String.class));
//                        dynamicfieldlist.add(dynamicFieldentity);
//
//
//
//                    }
//                }
//            }
//        }
//
//        return dynamicfieldlist;
//    }
//
//    private ResourceResolver getResourceResolver(String userName) throws LoginException {
//        Map<String,Object> authMap = new HashMap<>();
//        authMap.put(resourceResolverFactory.SUBSERVICE,userName);
//        return resourceResolverFactory.getResourceResolver(authMap);
//
//    }
//}
//
