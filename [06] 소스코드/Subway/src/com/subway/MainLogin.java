package com.subway;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.subway.admin.AdminMain;
import com.subway.customer.CustomerMainMenu;

public class MainLogin {
	
	private static ArrayList<String> cuslist = new ArrayList<String>();
	private static ArrayList<String> adminlist = new ArrayList<String>();
	private static Scanner scan = new Scanner(System.in);
	
	private static String host = "";

	public static void main(String[] args) {
		
		while(true) {
			
			//멋진 화면
			
			loadAcount(); //계정 정보 불러오기
			System.out.println("\t\t\t============================");
			System.out.println("\t\t\t\t[로그인]");
			System.out.println("\t\t\t============================");
			System.out.printf("\t\t\tID : ");
			String id = scan.nextLine();
			System.out.printf("\t\t\tPW : ");
			String pw = scan.nextLine();
			
			
			checkID(id,pw);
			
		}
		
	}

	private static void checkID(String id, String pw) {
		
		int flag = 0;
		int j=0;
		int max = adminlist.size();
		
		for(int i=0; i<cuslist.size(); i++) {
			
			if (cuslist.get(i).contains(id)) {
				//고객 아이디 맞음
				checkpw(pw);
				break;
			} else if (adminlist.get(j).contains(id)) {
				//관리자 아이디 맞음
				checkpw(pw);
				break;
			} else { //아이디 안맞음
				
				flag++;
				
			}
			
			j++;
			if (j == max) {
				j = 0;
			}
			
		}//for
//		System.out.println(flag+";;"+cuslist.size());
		
		if(flag == cuslist.size()) {
			pause("id");
		}
		
	}
	
	private static void checkpw(String pw) {
		
		
		int flag = 0;
		int j=0;
		int max = adminlist.size();
		
		for(int i=0; i<cuslist.size(); i++) {
			
			if (cuslist.get(i).contains(pw)) {
				//고객 비밀번호 맞음
				//고객 메뉴 이동
				System.out.println("\t\t\t고객으로 로그인되었습니다.");
				System.out.println();
				CustomerMainMenu c = new CustomerMainMenu();
				c.mainMenu();
				
				break;
				
			} else if (adminlist.get(j).contains(pw)) {
				//관리자 비밀번호 맞음
				//관리자 메뉴 이동
				System.out.println("\t\t\t관리자로 로그인되었습니다.");
				System.out.println();
				AdminMain am = new AdminMain();
				am.adminMain("1");
				
				break;
				
			} else { //비밀번호 안맞음
				
				flag++;
			}
			
			j++;
			if (j == max) {
				j = 0;
			}
			
		}//for
		
		if(flag == cuslist.size()) {
			pause("pw");
		}
		
	}

	private static void pause(String result) {
		
		if(result.equals("id")) {
			System.out.println("\t\t\t아이디가 옳지 않습니다.");
		}else {
			System.out.println("\t\t\t비밀번호가 옳지 않습니다.");
		}
		System.out.println();
		System.out.println("\t\t\t계속 하려면 엔터를 입력하시오.");

		scan.nextLine();
	}

	private static void loadAcount() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {

			conn = util.open(host,"subway","java1234");
			stat = conn.createStatement();

			String sql = String.format("select * from tblCustomer order by seq");
			
			rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				cuslist.add(rs.getString("id") + "\t" + rs.getString("pw"));
			}

			sql = String.format("select * from tblAdmin order by seq");

			rs = stat.executeQuery(sql);

			while (rs.next()) {
				adminlist.add(rs.getString("id") + "\t" + rs.getString("pw"));
			}

			rs.close();
	
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
