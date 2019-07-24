package com.jb4dc.devmock.webserver.beanconfig.sys;

import com.jb4dc.core.base.session.JB4DCSession;
import com.jb4dc.sso.client.extend.ICheckSessionSuccess;
import com.jb4dc.sso.client.filter.SsoWebFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: zhuangrb
 * Date: 2019/7/16
 * To change this template use File | Settings | File Templates.
 */

@Configuration
public class SsoFilter {

    @Value("${jb4dc.sso.server.address}")
    private String ssoServerAddress;

    @Value("${jb4dc.sso.login.path}")
    private String ssoLoginPath;

    @Value("${jb4dc.sso.logout.path}")
    private String ssoLogoutPath;

    @Value("${jb4dc.sso.excluded.paths}")
    private String ssoExcludedPaths;

    @Value("${jb4dc.sso.server.rest.base.path}")
    private String restBasePath;

    //@Bean
    public FilterRegistrationBean xxlSsoFilterRegistration() {
        // xxl-sso, filter init
        FilterRegistrationBean registration = new FilterRegistrationBean();

        registration.setName("XxlSsoWebFilter");
        registration.setOrder(1);
        registration.addUrlPatterns("/*");
        SsoWebFilter filter = new SsoWebFilter();
        filter.setCheckSessionSuccess(new ICheckSessionSuccess() {
            @Override
            public void run(ServletRequest request, ServletResponse response, FilterChain chain, JB4DCSession jb4DSession) {
                System.out.println("重远程获取Session完成,用户:"+jb4DSession.getUserName());
            }
        });
        registration.setFilter(filter);
        registration.addInitParameter(SsoWebFilter.KEY_SSO_SERVER_ADDRESS, ssoServerAddress);
        registration.addInitParameter(SsoWebFilter.KEY_SSO_LOGIN_PATH,ssoLoginPath);
        registration.addInitParameter(SsoWebFilter.KEY_SSO_LOGOUT_PATH, ssoLogoutPath);
        registration.addInitParameter(SsoWebFilter.KEY_SSO_EXCLUDED_PATHS, ssoExcludedPaths);
        registration.addInitParameter(SsoWebFilter.KEY_SSO_REST_BASE_PATH,restBasePath);

        return registration;
    }
}
