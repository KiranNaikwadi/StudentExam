package org_exam_repository;

import java.util.ArrayList;

import java.util.List;

import org.exam.model.SubjectModel;

public class SubjectRepository extends DBConfig {
	List<String>list=new ArrayList<String>();
	public boolean isAddSubject(SubjectModel model) {
		try {
			stmt=conn.prepareStatement("insert into subject value('0',?)");
			stmt.setString(1,model.getName());
			return stmt.executeUpdate()>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Error is ex"+ex);
			return false;
		}
	}
	public boolean isSubjectPresent(String sname) {
		try {
			stmt=conn.prepareStatement("select  * from Subject where subjectname=?");
			stmt.setString(1,sname);
			rs=stmt.executeQuery();
			return rs.next();
		}
		catch(Exception ex) {
			return false;
		}
	}
	public List<String>getAllSubject(){
		try {
			stmt=conn.prepareStatement("select subjectname from Subject");
			rs=stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("subjectname"));
				
			}return list.size()>0?list:null;
			
		}
		catch(Exception ex) {
			System.out.println("Error is "+ex);
			return null;
		}
		
	}

	

	

}
