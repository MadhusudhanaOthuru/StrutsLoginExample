package com.jwt.struts.action;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jwt.struts.form.RegisterUser;

public class RegisterAction extends Action{
	private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    
    public ActionForward RegisterUser(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception{
		RegisterUser registeruser=(RegisterUser)form;
		
		Connection con = null;
		try {
		     Class.forName("org.hsqldb.jdbc.JDBCDriver" );
		     con=DriverManager.getConnection("jdbc:hsqldb:http://localhost/xdb", "SA", "");
		 } catch (Exception e) {
		     System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
		     e.printStackTrace();
		     
		 } finally {
				con.close();
			}

		 
		
    	if(registeruser.getEmpid()!=0 || registeruser.getEmpid()!=' ' || registeruser.getFname().equalsIgnoreCase(registeruser.getFname())|| registeruser.getLname().equalsIgnoreCase(registeruser.getLname())||registeruser.getAge()!=0 ||registeruser.getAge()!=' '||registeruser.getDob()!=null||registeruser.getRole().equalsIgnoreCase(registeruser.getRole()) ) {
    		System.out.println("SUCCESS: Employee ID="+registeruser.getEmpid()+"    First Name: ="+registeruser.getFname()+"   Last Name: ="+registeruser.getLname()+"   Age: ="+registeruser.getAge()+"   Date Of Birth: ="+registeruser.getDob()+"   Role: ="+registeruser.getRole()); 
            return mapping.findForward(SUCCESS);
    	}else {
        	System.out.println("FAILURE: Employee ID="+registeruser.getEmpid()+"    First Name: ="+registeruser.getFname()+"   Last Name: ="+registeruser.getLname()+"   Age: ="+registeruser.getAge()+"   Date Of Birth: ="+registeruser.getDob()+"   Role: ="+registeruser.getRole()); 
            return mapping.findForward(FAILURE);
        }
    }
}
