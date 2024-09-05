package com.aem.training.site.core.services.impl;

import com.aem.training.site.core.services.CovidApiJson;
import com.aem.training.site.core.services.HeaderJsonClass;
import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = CovidApiJson.class)
@Designate(ocd = CovidApiJsonImpl.Config.class)
public class CovidApiJsonImpl implements CovidApiJson {
    private String baseurl = StringUtils.EMPTY;
    private String producturl= StringUtils.EMPTY;

    @Activate
    @Modified
    protected void activate(final HeaderJsonClassImpl.Config config)
    {
        baseurl = config.base_url();
        producturl=config.product_route();
    }
    @Override
    public String getBaseurl() {
        return baseurl;
    }
    @Override
    public String getProducturl() {
        return producturl;
    }

    @ObjectClassDefinition(name = "Covid classs config", description = "data for Covid service json")
    //inner class
    public static @interface Config {

        //service field create
        @AttributeDefinition(name = "baseurl",description = "base url")
        String base_url() default StringUtils.EMPTY;
        @AttributeDefinition(name = "product route" , description = "product route")
        String product_route() default StringUtils.EMPTY;

    }

}
