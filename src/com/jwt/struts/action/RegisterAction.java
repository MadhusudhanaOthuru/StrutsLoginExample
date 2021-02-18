package com.jwt.struts.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
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
    
    public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception{
    	
    	
		RegisterUser registeruser=(RegisterUser)form;
		
		
		Connection con = null;
		Statement stmt = null;
		//int result=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@10.140.46.56:1521:TRACKER", "TRAINING", "training2021");
	         stmt = con.createStatement();
	         System.out.println("Employee ID: "+registeruser.getEmpid());
	         System.out.println("First Name: "+registeruser.getFname());
	         System.out.println("Last Name: "+registeruser.getLname());
	         System.out.println("Age: "+registeruser.getAge());
	         System.out.println("Date Of Birth: "+registeruser.getDob1());
	         System.out.println("Role: "+registeruser.getRole());
	         String sqlinsert="INSERT INTO register_user VALUES ("+registeruser.getEmpid()+", '"+registeruser.getFname()+"', '"+registeruser.getLname()+"', "+registeruser.getAge()+", TO_DATE('"+registeruser.getDob1()+"', 'DD/MM/YYYY'), '"+registeruser.getRole()+"')";
	         stmt.executeUpdate(sqlinsert);
	         System.out.println("SUCCESSFULLY Inserted a row "); 
	            return mapping.findForward(SUCCESS);
	         
		 } catch (Exception e) {
		     System.err.println("ERROR: failed to load Oracle JDBC driver.");
		     e.printStackTrace();
		     return mapping.findForward(FAILURE);
		     
		 } finally {
				con.close();
				
			}

		
/*    	if(registeruser.getEmpid()!=0 || registeruser.getEmpid()!=' ' || registeruser.getFname().equalsIgnoreCase(registeruser.getFname())|| registeruser.getLname().equalsIgnoreCase(registeruser.getLname())||registeruser.getAge()!=0 ||registeruser.getAge()!=' '||registeruser.getDob()!=null||registeruser.getRole().equalsIgnoreCase(registeruser.getRole()) ) {
    		System.out.println("SUCCESS: Employee ID="+registeruser.getEmpid()+"    First Name: ="+registeruser.getFname()+"   Last Name: ="+registeruser.getLname()+"   Age: ="+registeruser.getAge()+"   Date Of Birth: ="+registeruser.getDob()+"   Role: ="+registeruser.getRole()); 
            return mapping.findForward(SUCCESS);
    	}else {
        	System.out.println("FAILURE: Employee ID="+registeruser.getEmpid()+"    First Name: ="+registeruser.getFname()+"   Last Name: ="+registeruser.getLname()+"   Age: ="+registeruser.getAge()+"   Date Of Birth: ="+registeruser.getDob()+"   Role: ="+registeruser.getRole()); 
            return mapping.findForward(FAILURE);
        }*/
    }
}
