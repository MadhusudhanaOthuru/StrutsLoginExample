package com.jwt.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import com.jwt.struts.form.LoginForm;

public class LoginAction extends Action {

    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    //static Logger logger = Logger.getLogger(LoginAction.class);
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LoginForm loginForm = (LoginForm) form;
        
        if (loginForm.getUserName().equals(loginForm.getPassword())) {
        	System.out.println("SUCCESS: UN="+loginForm.getUserName()+"    Password: ="+loginForm.getPassword()); 
            return mapping.findForward(SUCCESS);
           
        } else {
        	System.out.println("FAILURE: UN="+loginForm.getUserName()+"    Password: ="+loginForm.getPassword()); 
            return mapping.findForward(FAILURE);
        }
    }
}
