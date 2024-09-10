package org.exam.service;
import java.util.*;

import org.exam.helper.PathHelper;
import org.exam.model.QuestionModel;

import org_exam_repository.QuestionRepository;
import java.io.*;
import java.util.List;
public class QuestionService {
	QuestionRepository qRepo=new QuestionRepository();
	SubjectService ss=new SubjectService();
	public boolean isAddQuestion(QuestionModel qModel,String subjectname) {
		return qRepo.isAddQuestion(qModel,subjectname);
	}
	public boolean createFiles() {
		try {
			String path="F:\\JULY2023\\ADVJAVA\\questionbank";
			File f=new File(path);
			if(!f.exists()) {
				f.mkdir(); 
			}
			List<String>subList=ss.getAllSubject();
			if(subList!=null) {
			  	for(String subjectname:subList) {
			  		
			  		f=new File(path+"\\"+subjectname+".csv");
			  		
			  		if(!f.exists()) {
			  			f.createNewFile();	
			  		}
			  	}
			}
			else {
				System.out.println("Subject not found");
			}
		}
		catch(Exception ex){
			System.out.println("Error is" +ex);
		}
		return true;
		
	}
	public boolean uploadBulkQuestion(String subjectname) {
		boolean b=this.createFiles();
		if(b) {
			 File f=new File("F:\\JULY2023\\ADVJAVA\\questionbank");
			 File[]fileList=f.listFiles();
			 boolean flag=false;
			 for(File file:fileList) {
				 if(file.isFile()) {
					 //System.out.println(file);
					int index=file.toString().indexOf(subjectname);
					if(index!=-1) {
						flag=true;
						break;
					}
				}
			 }
			 if(flag) {
				 try {
					FileReader fr=new FileReader(PathHelper.filePath+"\\"+subjectname+".csv");
					BufferedReader br=new BufferedReader(fr);
					String question;
					flag=false;
					while((question=br.readLine())!=null) {
							String qwithop[]=question.split(",");
							flag=qRepo.uploadBulkQuestion(qwithop,subjectname);
						}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			 else {
				 System.out.println("Subject file Not Found");
			 }
			return true;
		}
		else {
			return false;
		}
		
	}

}

