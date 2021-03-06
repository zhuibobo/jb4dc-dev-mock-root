package com.jb4dc.devmock.service;

import com.jb4dc.base.service.IBaseService;
import com.jb4dc.core.base.exception.JBuild4DCGenerallyException;
import com.jb4dc.core.base.session.JB4DCSession;
import com.jb4dc.devmock.dbentities.DemoTlTreeEntity;

/**
 * Created with IntelliJ IDEA.
 * User: zhuangrb
 * Date: 2018/7/24
 * To change this template use File | Settings | File Templates.
 */
public interface IDemoTLTreeService extends IBaseService<DemoTlTreeEntity> {
    DemoTlTreeEntity createRootNode(JB4DCSession jb4DSession) throws JBuild4DCGenerallyException;
}
