package com.aem.training.site.core.services;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

public interface ManageJcrService {
   public Page createJcrPage(ResourceResolver resourceResolver) throws WCMException;

    public Node createjcrnode(String path, String nodeName, Session session) throws RepositoryException;
}
