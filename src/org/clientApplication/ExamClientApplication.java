package org.clientApplication;
import java.util.*;

import org.exam.model.ExamModel;
import org.exam.model.QuestionModel;
import org.exam.model.SubjectModel;
import org.exam.service.ExamService;
import org.exam.service.QuestionService;
import org.exam.service.SubjectService;
import org_exam_repository.*;
//import java.util.List.iterator;

public class ExamClientApplication {

	public static void main(String[] args) {
		SubjectService sv=new SubjectService();
		QuestionService qService=new QuestionService();
		ExamService examService=new ExamService();
		do {
			System.out.println("1.Add New Subject");
			System.out.println("2.Add Single Question");
			System.out.println("3.Add Bulk Question");
			System.out.println("4.Add Exam");
			System.out.println("5.Create Exam Schedule");
			System.out.println("Enter your choice");
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				   sc.nextLine();
				   System.out.println("Enter subject Name");
				   String sname=sc.nextLine();
				   SubjectModel model=new SubjectModel();
				   model.setName(sname);
				   int result=sv.addSubject(model);
				   System.out.println((result==1)?"Subject Added Sucess.....":(result==-1)?"Subject already present":"Some error is there");
				   break;
				   
			case 2:
				  sc.nextLine();
				  System.out.println("Enter Question");
				  String question=sc.nextLine(); 
				  System.out.println("Enter Option1");
				  String Op1=sc.nextLine();
				  System.out.println("Enter Option2");
				  String Op2=sc.nextLine(); 
				  System.out.println("Enter Option3");
				  String Op3=sc.nextLine(); 
				  System.out.println("Enter Option4");
				  String Op4=sc.nextLine(); 
				  System.out.println("Enter Option as Answer");
				  int Answer =sc.nextInt(); 
				  sc.nextLine();
				  System.out.println("Enter subject name");
				  String subjectname=sc.nextLine();
				  QuestionModel qModel=new QuestionModel(question,Op1,Op2,Op3,Op4,Answer);
				  boolean b=qService.isAddQuestion(qModel,subjectname);
				  if(b) {
					  System.out.println("Question Added Sucessfully");
				  }
				  else {
					  System.out.println("Some problem is there");
				  }
				  break;
				  
		  case 3: sc.nextLine();
				   System.out.println("Enter subject name for store bulk question");
			       String subjectname1=sc.nextLine();
				   qService.uploadBulkQuestion(subjectname1);
				   break;
				   
		  case 4:sc.nextLine();
		          System.out.println("Enter Examname,total marks,passing marks");
		          String examName=sc.nextLine();
		          int totalMarks=sc.nextInt();
		          int passingMarks=sc.nextInt();
		          ExamModel examModel=new ExamModel(examName,totalMarks,passingMarks);
		         //ExamService examService;
				  result=examService.isAddExam(examModel);
				  String str=(result==1)?"Exam Added Sucessfully":(result==-1)?"Exam Already Present":"Some problem is there";
				  System.out.println(str);
			      break;
			  
		  case 5:sc.nextLine();
			  List<ExamModel> list=examService.getAllExams();
			  System.out.println("Hey user you have list of exams and select one for schedule");
			  System.out.println("===================================================================");
			  for(ExamModel m:list) {
				  System.out.println(m.getId()+"\t"+m.getName()+"\t"+m.getTotalMarks()+"\t"+m.getPassingMarks());
			  }
			  System.out.println("====================================================================");
			  System.out.println("enter exam name for schedule");
			  examName=sc.nextLine();
			  int examId=examService.getExamIdByName(examName);
			  System.out.println("Exam id is"+examId);
			  break;
				  
		    default:
		    	    System.out.println("Wrong choice");
		    	    break;
			}
			
		}while(true);
		

	}

}
