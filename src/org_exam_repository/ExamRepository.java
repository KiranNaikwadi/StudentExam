package org_exam_repository;

import org.exam.model.ExamModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ExamRepository extends DBConfig {
	List<ExamModel> listExams=new ArrayList<ExamModel>();
    public boolean isExamPresent(String examName) {
    	try {
    		stmt=conn.prepareStatement("select * from exam where examname=?");
    		stmt.setString(1, examName);
    		rs=stmt.executeQuery();
    		return rs.next();
    	}
    	catch(Exception ex) {
    		System.out.println("Error is"+ex);
    		return false;
    	}
    }
	public boolean isAddExam(ExamModel model) {
		try {
			stmt=conn.prepareStatement("insert into exam values('0',?,?,?)");
			stmt.setString(1,model.getName());
			stmt.setInt(2,model.getTotalMarks());
			stmt.setInt(3,model.getPassingMarks());
			int value=stmt.executeUpdate();
			if(value>0) {
				return true;
			}
			
			else {
				return false;
			}
		}
		catch(Exception ex) {
			System.out.println("Error is"+ex);
			return false;
		}
	}
	public List<ExamModel>getAllExams(){
		try {
			stmt=conn.prepareStatement("select * from exam");
			rs=stmt.executeQuery();
			while(rs.next()) {
				ExamModel model=new ExamModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				model.setTotalMarks(rs.getInt(3));
				model.setPassingMarks(rs.getInt(4));
				listExams.add(model);
			}
			 return listExams.size()>0?listExams:null;
		}
		catch(Exception ex) {
			System.out.println("Error is"+ex);
			return null;
		}
		
	}//Today
	public int getExamIdByName(String name) {
		try {
			stmt=conn.prepareStatement("select examid from exam where examname='"+name+"'");
			rs=stmt.executeQuery();
			return rs.next()?rs.getInt(1):-1;
			
			//stmt=conn.prepared
			}
		catch(Exception ex) {
			System.out.println("Error is"+ex);
		    return -1;
		
		
		
		
		
		}
	}

}
