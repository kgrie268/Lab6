/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.cprg352;

import com.sun.xml.internal.ws.api.policy.PolicyResolver.ServerContext;
import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author 742227
 */
public class Debug extends TagSupport {
//
//    private String debug;
//    
//
//    public void setDebug(String debug) {
//        this.debug = null;
//    }

    @Override
    public int doStartTag() throws JspException {
        ServletRequest request = pageContext.getRequest();
        String domain = request.getServerName();
        
        String debug = this.pageContext.getRequest().getParameter("debug");
        //String domain = this.pageContext.getServletContext().getVirtualServerName();
        if (debug != null) {
        if (domain.startsWith("test") || domain.equals("localhost")) {
               
                return EVAL_BODY_INCLUDE;
            }
            else {
                
                return SKIP_BODY;
            }
        }
        
        return SKIP_BODY;
    }
       
}
