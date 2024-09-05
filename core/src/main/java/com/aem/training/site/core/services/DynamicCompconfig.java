package com.aem.training.site.core.services;
import org.apache.commons.lang.StringUtils;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "my Dynamic SERvoce config")
public @interface DynamicCompconfig {
    @AttributeDefinition(name = "dynamic path")
    String getDynamicPath() default StringUtils.EMPTY;

    @AttributeDefinition(name = "is enables")
    boolean isEnabled() default false;
}
