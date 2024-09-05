package com.aem.training.site.core.services.impl;

import com.aem.training.site.core.services.ManageJcrService;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;


@Component(service = ManageJcrService.class)
public class ManageJcrServiceImpl implements ManageJcrService {
    @Override
    public Page createJcrPage(ResourceResolver resourceResolver) throws WCMException {
        String path= "/content/training/us/en",
                pageName="dynamicpage",
                template="/conf/training/settings/wcm/templates/page-content",
                pageTitle="dynamic page";
        PageManager pm = resourceResolver.adaptTo(PageManager.class);
        return pm.create(path,pageName,template,pageTitle);
    }
@Override
    public Node createjcrnode(String path, String nodeName, Session session) throws RepositoryException {

        Node node = session.getNode(path);
        Node nodemy= node.addNode(nodeName);
        session.save();
        return nodemy;
    }
}
