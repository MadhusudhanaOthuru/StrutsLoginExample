package com.jwt.struts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jwt.struts.form.RegisterUser;

public class DaoImpl {
	static Logger logger = Logger.getLogger(DaoImpl.class);

	public String insertUser(int empid, String f_name, String l_name, int age, String dob, String rolenm)
			throws SQLException {
		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.140.46.56:1521:TRACKER", "TRAINING",
					"training2021");
			stmt = con.createStatement();
			String sqlinsert = "INSERT INTO register_user VALUES (" + empid + ", '" + f_name + "', '" + l_name + "', "
					+ age + ", TO_DATE('" + dob + "', 'DD/MM/YYYY'), '" + rolenm + "')";
			stmt.executeUpdate(sqlinsert);
			logger.info("SUCCESSFULLY Inserted a row ");
			return "SUCCESS";

		} catch (Exception e) {
			e.printStackTrace();
			return "FAILURE";

		} finally {
			con.close();

		}
	}

	public List<RegisterUser> getUsers() throws SQLException {
		List<RegisterUser> userlist= new ArrayList<RegisterUser>();
		Connection con = null;
		Statement stmt = null;
		RegisterUser registeruser= null;
		try { logger.info("Entered into try block ");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			logger.info("After Class for Name ");
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.140.46.56:1521:TRACKER", "TRAINING",
					"training2021");
			logger.info("Got Connection"+con);
			stmt = con.createStatement();
			String sqlselect = "select * from register_user";
			ResultSet rs = stmt.executeQuery(sqlselect);
			logger.info("After Result Set simply rs"+rs);
			logger.info("After Result Set"+rs.getRow());
			while (rs.next()) {
				registeruser=new RegisterUser();
				registeruser.setEmpid(Integer.parseInt(rs.getString("EMP_ID")));
				registeruser.setFname(rs.getString("FIRST_NAME"));
				registeruser.setLname(rs.getString("LAST_NAME"));
				registeruser.setAge(Integer.parseInt(rs.getString("AGE")));
				registeruser.setDob1(rs.getString("DOB"));
				registeruser.setRole(rs.getString("ROLE_NM"));
				userlist.add(registeruser);
				System.out.println(rs.getString("EMP_ID") + " " + rs.getString("FIRST_NAME") + " "
						+ rs.getString("LAST_NAME") + " " + rs.getString("AGE") + " " + rs.getString("DOB") + " "
						+ rs.getString("ROLE_NM"));
			}
			logger.info("SUCCESSFULLY retrieved the rows");
			return userlist;

		} catch (Exception e) {
			e.printStackTrace();
			return userlist;

		} finally {
			con.close();

		}
	}
}
