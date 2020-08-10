package com.subway.admin;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.subway.DBUtil;

import oracle.jdbc.OracleTypes;
/**
 * 
 * @author 정희수
 * 관리자 답변 클래스
 *
 */
public class AdminAnswer {
	static String ad =""+1;
		
//	public static void main(String[] args) {
//		//aAnswer(ad); //답변하기
//		//aModify(); //답변 수정하기
//		//aDelete(); //답변 삭제하기
//		
//		
//		//한번 더 물어보기 만들기
//		
//		
//		
//	}//main


	/**
	 * 답변 삭제하는 메소드
	 */
	public static void aDelete() {
		//답변 삭제하기
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		Statement stat1 = null;
		CallableStatement stat3 = null;
		DBUtil util = new DBUtil();
		Scanner scan = new Scanner(System.in);
		
		try {
			
			conn = util.open("211.63.89.57","subway","java1234");
			
			System.out.println("\t\t\t불편사항 삭제하기 페이지입니다. ");
			System.out.println("\t\t\t[번호]\t[불편사항 내용]\t\t[답변 내용]\t\t[날짜]\t\t[고객번호]\t\t[답변 유무]\n");
			
			String sql = "select a.seq as \"seq\", c.content as \"CustomerSay\",a.content as \"AdminSay\" ,to_char(c.comdate,'yyyy-mm-dd')as \"date\", c.cusseq as \"cusseq\",decode(c.answer,'0','답변완료','1','답변대기')as \"answer\"\r\n" + 
					"from tblcomplain c left outer join tblanswer a on c.seq = a.comseq where a.delflag = 0";
			
			stat1=conn.createStatement();
			
			rs = stat1.executeQuery(sql);
			
			ArrayList<String>list = new ArrayList<String>();
			while (rs.next()) {
				String result =String.format("%s.%s\t\t%s\t\t%s\t\t%s\t\t%s\n", rs.getString("seq"),rs.getString("CustomerSay"),rs.getString("AdminSay"),
						rs.getString("date"),rs.getString("cusseq"),rs.getString("answer"));
//				System.out.printf("\t\t\t%s.\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n",
//						rs.getString("seq"),rs.getString("CustomerSay"),rs.getString("AdminSay"),
//						rs.getString("date"),rs.getString("cusseq"),rs.getString("answer"));
			list.add(result);	
			}
			
			Pagingfile file= new Pagingfile();
			file.pageNonum(list);
			
			System.out.println("\t\t\t========================================");
			System.out.print("\t\t\t불편사항 번호 입력:");
			
			String num = scan.nextLine();
			System.out.println("\t\t\t========================================");
			
			
			 	stat1.close();
			 	rs.close();
			 	
			 	
			 	sql = "{ callprocAnswer_delete( ? ) }";
				//수정하기 프로시저 호출
				
				stat = conn.prepareCall(sql);
				
				
				
				stat.setString (1, num);			//불편사항 번호
		

				System.out.println("\t\t\t완료");
				
				
				stat.executeUpdate();
				
				
				rs.close();
				stat.close();
				conn.close();
				
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}//aDelete

	/**
	 * 답변 수정하는 메소드
	 */
	public static void aModify() {
		//답변 수정하기
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		Statement stat1 = null;
		CallableStatement stat3 = null;
		DBUtil util = new DBUtil();
		Scanner scan = new Scanner(System.in);
		
		try {
			
			conn = util.open("211.63.89.57","subway","java1234");
			
			System.out.println("\t\t\t불편사항 답변 수정하기 페이지입니다. ");
			System.out.println("\t\t\t[번호]\t[불편사항 내용]\t\t[답변 내용]\t\t[날짜]\t\t[고객번호]\t\t[답변 유무]\n");
			
			
			ArrayList<String> list = new ArrayList<String>();
			String sql = "select * from vwadmincomplain ";
			
			stat1=conn.createStatement();
			
			rs = stat1.executeQuery(sql);
			
			while (rs.next()) {
				String result = String.format("%s.%s\t\t%s\t\t%s\t\t%s\t\t%s\n", rs.getString("seq"),rs.getString("CustomerSay"),rs.getString("AdminSay"),
						rs.getString("date"),rs.getString("cusseq"),rs.getString("answer"));
//				System.out.printf("\t\t\t%s.\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n",
//						rs.getString("seq"),rs.getString("CustomerSay"),rs.getString("AdminSay"),
//						rs.getString("date"),rs.getString("cusseq"),rs.getString("answer"));
				list.add(result);
				
			}
			
			Pagingfile file= new Pagingfile();
			file.pageNonum(list);
			
			
			System.out.println("\t\t\t========================================");
			System.out.print("\t\t\t불편사항 번호 입력:");
			String num = scan.nextLine();
			System.out.println("\t\t\t========================================");
			System.out.print("\t\t\t답변:");
			String say = scan.nextLine();
			System.out.println();
			
			 	stat1.close();
			 	rs.close();
			 	
			 	
			 	sql = "{ call procAnswer_Clean(?,?,?) }";
				//수정하기 프로시저 호출
				
				stat = conn.prepareCall(sql);
				
				
				stat.setString (1, say);			//답변 번호
				stat.setString (2, num);			//불편사항 번호
				stat.setString (3, ad);				//관리자번호

				System.out.println("\t\t\t완료되었습니다.");
				AdminMain.pause();
				
				
				stat.executeUpdate();
				
				
				rs.close();
				stat.close();
				conn.close();
				
				
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}//aModify

	
	/**
	 * 답변하는 메소드
	 * @param ad
	 */
	public static void aAnswer(String ad) {
		//답변하기
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		Statement stat1 = null;
		CallableStatement stat3 = null;
		DBUtil util = new DBUtil();
		Scanner scan = new Scanner(System.in);
		
		try {
			
			conn = util.open("211.63.89.57","subway","java1234");
			
			System.out.println("\t\t\t불편사항 답변하기 페이지입니다. ");
			System.out.println("\t\t\t[번호]\t[불편사항 내용]\t\t[답변 내용]\t\t[날짜]\t\t[고객번호]\t\t[답변 유무]\n");
			
//			String sql = "select * from vwadmincomplain where ";
			String sql = "select * from vwadmincomplain ";
			
			stat1=conn.createStatement();
			
			rs = stat1.executeQuery(sql);
			
			ArrayList<String> list = new ArrayList<String>();
			while (rs.next()) {
				String result = String.format("%s.%s\t\t%s\t\t%s\t\t%s\t\t%s\n", rs.getString("seq"),rs.getString("CustomerSay"),rs.getString("AdminSay"),
						rs.getString("date"),rs.getString("cusseq"),rs.getString("answer"));
//				System.out.printf("\t\t\t%s.\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n",
//						rs.getString("seq"),rs.getString("CustomerSay"),rs.getString("AdminSay"),
//						rs.getString("date"),rs.getString("cusseq"),rs.getString("answer"));
				list.add(result);
				
			}
			Pagingfile file= new Pagingfile();
			file.pageNonum(list);
			
			System.out.println("\t\t\t========================================");
			System.out.print("\t\t\t불편사항 번호 입력:");
			String num = scan.nextLine();
			System.out.println("\t\t\t========================================");
			System.out.print("\t\t\t답변:");
			String say = scan.nextLine();
			System.out.println();
			
			 	stat1.close();
			 	rs.close();
			
			
			sql = "{ call procAnswer(?,?,?) }";
			//답변하기 프로시저 호출
			
			stat = conn.prepareCall(sql);
			
			
			stat.setString (1, num);			//불편사항 번호
			stat.setString (2, say);			//답변 번호
			stat.setString (3, ad);				//관리자번호

			System.out.println("\t\t\t완료되었습니다.");
			
			AdminMain.pause();
			
			stat.executeUpdate();
			
			
			rs.close();
			stat.close();
			conn.close();
			
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}//aAnswer
}//class
