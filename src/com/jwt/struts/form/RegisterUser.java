package com.jwt.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RegisterUser extends org.apache.struts.action.ActionForm{
	
	private int empid;
	private String fname;
	private String lname;
	private int age;
	private String dob1;
	private String role;
	
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) {
		System.out.println("RegisterUser");
		ActionErrors errors=new ActionErrors();
		if ((empid==0)||empid==' ') {
			errors.add("empid",new ActionMessage("error.empid.required"));
			
		}
		if (fname==null || fname.length()<1) {
			errors.add("fname", new ActionMessage("error.fname.required"));
		}
		if (lname==null || lname.length()<1) {
			errors.add("lname", new ActionMessage("error.lname.required"));
		}
		if ((age==0)||age==' ') {
			errors.add("age", new ActionMessage("error.age.required"));
		}
		if ((dob1==null || dob1.length()<1)) {
			errors.add("dob", new ActionMessage("error.dob.required"));
		}
		if (role==null||role.length()<1) {
			errors.add("role", new ActionMessage("error.role.required"));
		}
		return errors;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDob1() {
		
		return dob1;
	}
	public void setDob1(String dob1) {
		this.dob1 = dob1;
		
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
