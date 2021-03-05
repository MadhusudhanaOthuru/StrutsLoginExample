package com.jwt.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import com.jwt.struts.dao.DaoImpl;
import com.jwt.struts.form.LoginForm;
import com.jwt.struts.form.RegisterUser;

public class LoginAction extends Action {

	private final static String FAILURE = "failure";
	private final static String RETRIEVE= "retrieve"; 
	static Logger logger = Logger.getLogger(LoginAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm loginForm = (LoginForm) form;
		// logger.info("Info Logger Successful");
		// logger.debug("Debug Logger Successful");
		// logger.error("Error Logger Successful");

		if (loginForm.getUserName().equals(loginForm.getPassword())) {

			logger.info("SUCCESS 23: UN=" + loginForm.getUserName() + "    Password: =" + loginForm.getPassword());
			DaoImpl daoimpl = new DaoImpl();
			//daoimpl.getUsers();
			logger.info("Before Set Attribute in request");
			List<RegisterUser> userlist1=daoimpl.getUsers();
			request.setAttribute("users", userlist1);
			logger.info("After Set Attribute in request");
			//request.getRequestDispatcher("retrieve.jsp").forward(request, response);
			logger.info("Before findForward  Attribute in request");
			return mapping.findForward(RETRIEVE);
		    
		} else {
			logger.error("FAILURE: UN=" + loginForm.getUserName() + "    Password: =" + loginForm.getPassword());
			return mapping.findForward(FAILURE);
		}
	}
}
