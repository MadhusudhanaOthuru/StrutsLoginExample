package com.jwt.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jwt.structs.dao.DaoImpl;
import com.jwt.struts.form.RegisterUser;

public class RegisterAction extends Action {
	private final static String SUCCESS = "success";
	private final static String FAILURE = "failure";
	static Logger logger = Logger.getLogger(RegisterAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		RegisterUser registeruser = (RegisterUser) form;
		DaoImpl daoimpl = new DaoImpl();
		String insert = daoimpl.insertUser(registeruser.getEmpid(), registeruser.getFname(), registeruser.getLname(),
				registeruser.getAge(), registeruser.getDob1(), registeruser.getRole());
		if (insert.equalsIgnoreCase(SUCCESS)) {
			return mapping.findForward(SUCCESS);
		} else {
			return mapping.findForward(FAILURE);
		}

	}
}
