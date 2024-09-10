package org.exam.service;

import java.util.List;

import org.exam.model.ExamModel;

import org_exam_repository.ExamRepository;

public class ExamService {
        ExamRepository examRepo=new ExamRepository();
        public int  isAddExam(ExamModel model) {
        	return (examRepo.isExamPresent(model.getName()))?-1:(examRepo.isAddExam(model))?1:0;
 }
        public List<ExamModel> getAllExams(){
        	return examRepo.getAllExams();
        }
        //Today
        public int getExamIdByName(String name) {
        	return examRepo.getExamIdByName(name);
        }
}
