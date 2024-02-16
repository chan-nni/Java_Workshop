package workshop4.grade.view;

import workshop4.grade.entity.Student;

public class GradeManager {
	
	private static Student [] stu ; 

	public static void main(String[] args) {
		
		// final Student [] stu;
		
		stu = new Student[] {
				new Student("kim", "10000", 22, 100, 100, 100),
				new Student("lee", "10001", 23, 20, 20, 20),
				new Student("park", "10002", 24, 30, 30, 30),
				new Student("choi", "10003", 25, 40, 40, 40),
				new Student("steve", "10004", 26, 50, 50, 50)
				
		} ;
		
		System.out.println("번호 이름 오라클 자바 서블릿 총점 평균");
		System.out.println("===============================");
		for(int i = 0; i < stu.length; i++) {
			System.out.print(i + 1 + " ");
			System.out.println(stu[i]);
		}
		int oracleSum = 0;
		int javaSum = 0;
		int servletSum = 0;
		for (int i = 0; i < stu.length; i++) {
			oracleSum += stu[i].getOracle();
			javaSum += stu[i].getJava();
			servletSum += stu[i].getServlet();
		}
		System.out.println("===============================");
		System.out.println("총점(오라클, 자바, 서블릿) : " + oracleSum + " " + javaSum + " " + servletSum);	

	}

}
