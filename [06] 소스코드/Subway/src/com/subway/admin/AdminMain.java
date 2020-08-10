package com.subway.admin;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.subway.DBUtil;
import com.subway.admin.Pagingfile;

/**
 * 
 * @author 정희수
 * 관리자 메인 클래스
 *
 */
public class AdminMain {
	static String ad ="" +1;
	static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		adminMain(ad);
	}
	
	/**
	 * 관리자 로그인 후 메인화면 메소드
	 * @param ad
	 * 
	 */
	public static void adminMain(String ad) {  //관리자 로그인 후 처음화면
		

		
		try {
			
			boolean loop = true;
			
			while (loop) {
				
				System.out.println("\t\t\t=============================================");
				System.out.println("\t\t\t======관리자 메뉴에 들어오셨습니다.======");
				System.out.println("\t\t\t1.불편사항관리"); //상세로 들어가서 불편사항 답변/수정/삭제 가능
				System.out.println("\t\t\t2. 기차관리"); //기차 현재 위치,혼잡도 보러가기
				System.out.println("\t\t\tb. 뒤로가기");
				System.out.println("\t\t\t==============================================");
				System.out.print("\t\t\t입력 : ");
				
				String num = scan.nextLine();
				
				
				if (num.equals("1")) { //불편사항 상세 페이지로가기
					adminMain2(ad);
				} else if (num.equals("2")) {  //기차위치, 혼잡도 확인하기
					adminMain3(ad);
				} else if (num.equals("b")) { //뒤로가기 처음 메뉴화면으로가기
					break;
				} else { //그 외 번호 입력 시
					System.out.println("잘못된 번호입니다.");
					continue;
					
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	/**
	 * 관리자 메인에서 1번 눌렀을 시 넘어가는 메소드
	 * @param ad
	 */
	public static void adminMain2(String ad) {  //관리자 메인 (1) 답변 눌럿을때 
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		Statement stat1 = null;
		CallableStatement stat3 = null;
		DBUtil util = new DBUtil();
		Scanner scan = new Scanner(System.in);
		
		try {
			
			conn = util.open("211.63.89.57","subway","java1234");
			
			System.out.println("\t\t\t=============================================");
			System.out.println("\t\t\t불편사항 관리 페이지입니다. ");
			System.out.println("\t\t\t=============================================");
			System.out.println("\t\t\t[번호]\t[불편사항 내용]\t\t[답변 내용]\t\t[날짜]\t\t[고객번호]\t\t[답변 유무]\n");
			
			
			String sql = "select * from vwadmincomplain ";
			
			stat1=conn.createStatement();
			
			rs = stat1.executeQuery(sql);
			
			ArrayList<String> list = new ArrayList<String>();
			while (rs.next()) {
				String result = String.format("%s.%s\t\t%s\t\t\t%s\t\t%s\t\t%s\n", rs.getString("seq"),rs.getString("CustomerSay"),rs.getString("AdminSay"),
						rs.getString("date"),rs.getString("cusseq"),rs.getString("answer"));
//				System.out.printf("\t\t\t%s.\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n",
//						rs.getString("seq"),rs.getString("CustomerSay"),rs.getString("AdminSay"),
//						rs.getString("date"),rs.getString("cusseq"),rs.getString("answer"));
				
				list.add(result);

				
			}
			
			Pagingfile file= new Pagingfile();
			file.pageNonum((list));
			
//			file.pageNonum(file.save(list));  "%s.,%s,%s,%s,%s,%s" ,를 기준으로tap치고 싶을때
//			file.pageNonum((list));  "%s.\t%s\t%s\t%s\t%s\t%s" \t를 기준으로tap치고 싶을때
			
			
			System.out.println();
			boolean loop = true;
			
			while (loop) {
				
				
				System.out.println("\t\t\t=============================================");
				System.out.println("\t\t\t======불편사항 관리 페이지입니다.======");
				
				
				//불편사항 목록들 출력하기
				//페이징 1.이전 2.다음 0.메뉴입력
				System.out.println("\t\t\t3. 답변하기"); //상세로 들어가서 불편사항 답변/수정/삭제 가능
				System.out.println("\t\t\t4. 수정하기"); //기차 현재 위치,혼잡도 보러가기
				System.out.println("\t\t\t5. 삭제하기");
				System.out.println("\t\t\tb. 뒤로가기");
				System.out.println("\t\t\t==============================================");
				System.out.print("\t\t\t입력 : ");
				
				String num = scan.nextLine();
				
				AdminAnswer admin = new AdminAnswer();
				if (num.equals("3")) { //답변 페이지로가기
					admin.aAnswer(ad);
					
				} else if (num.equals("4")) {  //답변수정하기
					admin.aModify();
					
				}else if (num.equals("5")) {  //답변 삭제하기
					admin.aDelete();
					
				} else if (num.equals("b")) { //뒤로가기 관리자 메뉴화면으로가기
					break;
				} else { //그 외 번호 입력 시
					System.out.println("잘못된 번호입니다.");
					continue;
					
				}
				
			}
			
			stat1.close();
			rs.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	
	/**
	 * 관리자 메인 (2) 기차관리 눌럿을때
	 * @param ad
	 */
		public static void adminMain3(String ad) {  //관리자 메인 (2) 기차관리 눌럿을때 
				

		
		try {
			
			boolean loop = true;
			
			while (loop) {
				
				System.out.println("\t\t\t=============================================");
				System.out.println("\t\t\t======기차 관리 페이지입니다.======");
				
				System.out.println("\t\t\t1. 열차 현재 역 위치 조회하기"); //상세로 들어가서 불편사항 답변/수정/삭제 가능
				System.out.println("\t\t\t2. 혼잡도 조회하기"); //기차 현재 위치,혼잡도 보러가기
				System.out.println("\t\t\tb. 뒤로가기");
				System.out.println("\t\t\t==============================================");
				System.out.print("\t\t\t입력 : ");
				
				String num = scan.nextLine();
				
				AdminTrain admin2 = new AdminTrain();
				if (num.equals("1")) { //열차 조회 페이지로가기
					admin2.whereTrain();
				} else if (num.equals("2")) {  //혼잡도 조회하기
					admin2.chaosRoom();
				} else if (num.equals("b")) { //뒤로가기 관리자 메뉴화면으로가기
					break;
				} else { //그 외 번호 입력 시
					System.out.println("잘못된 번호입니다.");
					continue;
					
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	
		
		public static void pause() {
		      System.out.println();
		      System.out.println("\t\t\t계속 하시려면 엔터를 누르세요.");
		      scan.nextLine();
		   }
		
}//class
