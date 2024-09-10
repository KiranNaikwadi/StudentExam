package org_exam_repository;
import java.nio.file.FileSystems;

import java.nio.file.Path;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.exam.helper.PathHelper;

public class DBConfig {
     protected Connection conn;
     protected PreparedStatement stmt;
     protected ResultSet rs;
     public DBConfig() {
    	 try {
    		 PathHelper phelp=new PathHelper();
    		 
;    		 Class.forName(PathHelper.p.getProperty("driver"));
    		 conn=DriverManager.getConnection(PathHelper.p.getProperty("url"),PathHelper.p.getProperty("user"),PathHelper.p.getProperty("pass"));
    	 }
    	 catch(Exception ex) {
    		 System.out.println("Error is"+ex);
    	 }
     }

}
