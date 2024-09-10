package org.exam.service;

import java.util.List;

import org.exam.model.SubjectModel;

import org_exam_repository.SubjectRepository;
import java.util.*;
public class SubjectService {
SubjectRepository subRepo=new SubjectRepository();

public int addSubject(SubjectModel model) {
	return (subRepo.isSubjectPresent(model.getName()))?-1:subRepo.isAddSubject(model)?1:0;
}
public List<String> getAllSubject(){
	return this.subRepo.getAllSubject();
}
}
