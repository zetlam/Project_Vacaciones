package com.praticas.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoUtility {


		private static final String URL = "java:comp/env/jdbc/Vacaciones";
		
		public static Connection getConnection() throws SQLException {
			DataSource ds = null;
			try {
				Context context = new InitialContext();
				ds = (DataSource)context.lookup(URL);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ds.getConnection();
			
		}

	
	}

