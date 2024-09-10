package org.exam.model;

public class QuestionModel {
	     private String qid;
         public String getqid() {
			return qid;
		}
		public void setQid(String qid) {
			qid = qid;
		}
		private String question;
         private String Op1;
         private String Op2;
         private String Op3;
         private String Op4;
         private int Answer;
		public String getquestion() {
			return question;
		}
		public void setquestion(String question) {
			question = question;
		}
		public String getOp1() {
			return Op1;
		}
		public void setOp1(String op1) {
			Op1 = op1;
		}
		public String getOp2() {
			return Op2;
		}
		public void setOp2(String op2) {
			Op2 = op2;
		}
		public String getOp3() {
			return Op3;
		}
		public void setOp3(String op3) {
			Op3 = op3;
		}
		public String getOp4() {
			return Op4;
		}
		public void setOp4(String op4) {
			Op4 = op4;
		}
		public int getAnswer() {
			return Answer;
		}
		public void setAnswer(int answer) {
			Answer = answer;
		}
	public QuestionModel(){
		
	}
	public QuestionModel(String question,String Op1,String Op2,String Op3,String Op4,int Answer){
		this.question=question;
		this.Op1=Op1;
		this.Op2=Op2;
		this.Op3=Op3;
		this.Op4=Op4;
		this.Answer=Answer;
		
	}
}
