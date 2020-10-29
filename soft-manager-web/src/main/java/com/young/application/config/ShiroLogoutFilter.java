package com.young.application.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Locale;

@Slf4j
public class ShiroLogoutFilter extends LogoutFilter {


    @Override
    public boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = this.getSubject(request, response);
        if (this.isPostOnlyLogout() && !WebUtils.toHttp(request).getMethod().toUpperCase(Locale.ENGLISH).equals("POST")) {
            return this.onLogoutRequestNotAPost(request, response);
        } else {
            String redirectUrl = this.getRedirectUrl(request, response, subject);

            //此处用户可以清除缓存
            try {
                subject.logout();
            } catch (SessionException e) {
                log.debug("Encountered session exception during logout.  This can generally safely be ignored.", e);
            }

            this.issueRedirect(request, response, redirectUrl);
            return false;
        }
    }


}
