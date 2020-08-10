package com.subway.train;

import java.lang.annotation.Documented;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.subway.DBUtil;
import com.subway.SearchRoot;

import oracle.jdbc.OracleTypes;

public class SearchMenu {
	
	//고객 
	//2.검색 내역 조회 
	
	public static void main(String[] args) {
		
		//메뉴
		Menu();
		
		//특정 경로 번호 선택시 
		//Choice();

	}//main
	


	/**
	 * 
	 * @param start 출발역 이름
	 * @param arrival 도착역 이름
	 * @param lineNum 출발역 호선 , 도착역 호선 
	 */
	private static void Choice(String start , String arrival , ArrayList<String> lineNum) {
		
		SearchRoot searchRoot = new SearchRoot();
		
		
		System.out.println();
		System.out.println("\t\t\t" + "=========================================");
		System.out.printf("\t\t\t" + "<%s - %s> 경로를 선택하였습니다.\n", start , arrival);
		System.out.println();
		System.out.println("\t\t\t" + "1. 현재 시각으로 재검색");
		System.out.println("\t\t\t" + "b. 뒤로가기");
		System.out.println("\t\t\t" + "=========================================");
		System.out.print("\t\t\t" + "메뉴를 선택하세요: ");

		
		
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		int inputNum = Integer.parseInt(input);
		
		System.out.println();
		
		//출발 루트 찾을 "호선,역이름"
		String sResult = "";
		//도착 루트 찾을 "호선,역이름"
		String aResult = "";

		
		
		//split으로 나눠 담아놓을 배열
		if(lineNum.size() != 0) {
			
			String[] temp = lineNum.get(0).split(",");
			
			//출발역 호선
			sResult = temp[0] + "," + start;
			//도착역 호선 
			aResult = temp[1] + "," + arrival;
			
				
		} else {
			return;
		}
		
		
		
		
		
		
		
		if(input.toUpperCase().equals("B")) {
			//뒤로가기
			//2번메뉴 화면으로 
			return;
			
		} else if (inputNum == 1) {
			
			//재검색 선택시
			searchRoot.inputStation(sResult, aResult);
		}
		
		
	}



	private static void Menu() {
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		DBUtil util = new DBUtil();
		
		//출발역 담을 변수 
		String start = "";
		//도착역 담을 변수 
		String arrival = "";
		//호선 담을 변수 
		String line = "";
		
		//로그인 한 고객 번호 
		int cusNum = 0;
		
		//넘버링
		int num = 0; 
		


		
		System.out.println();
		System.out.println("\t\t\t" + "2. 검색 내역 조회");
		System.out.println("\t\t\t" + "=========================================");
		
		
		try {
			
			//DB연결
			conn = util.open("localhost","subway","java1234");
			
			
			
			//출발역 
			
			//sql문 작성
			//procStart : 특정 고객이 입력한 출발역.
			String sql = "{ call procStart(?,?) }";
			
			
			//반환값 있는 쿼리 날리기.
			stat = conn.prepareCall(sql);
			
			//1번 고객 
			cusNum = 10;

			//매개변수 지정.
			stat.setInt(1, cusNum); //로그인 한 고객번호 받아서 넣기.
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			//쿼리 날림
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(2); //반환값으로 커서 가져오기 (object로 받아옴) > rs에 저장
			
			
			//도착역
			
			//procArr 
			sql = "{ call procArr(?,?) }";
			
			//반환값 있는 쿼리 날리기
			stat = conn.prepareCall(sql);
			
			stat.setInt(1,cusNum); //로그인 한 고객번호 받아서 넣기.
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			//쿼리 날림
			stat.executeQuery();
			
			rs2 = (ResultSet)stat.getObject(2);
			
			//번호 + 출발역 , 도착역 담을 어레이리스트
			ArrayList<String> list = new ArrayList<String>();
			
			//출발역 호선 , 도착역 호선 담을 어레이리스트
			ArrayList<String> linelist = new ArrayList<String>();
			
			while(rs.next() && rs2.next()) {
				//rs와 rs2 내용 모두 읽어올 때 까지
				
				num++;
				
				//고객이 조회했던 경로 (출발역 - 도착역)
				System.out.print("\t\t\t" + num + ". " + rs.getString("name") + " - " + rs2.getString("name"));

				//출발역 , 도착역 이름 담은 arraylist
				list.add(num + "," + rs.getNString("name") + "," + rs2.getString("name"));
				
				//출발역 호선 , 도착역 호선 ArrayList에 담기. 
				linelist.add(rs.getString("lineseq") + "," + rs2.getString("lineseq"));

				
				
			}//while
			

			
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t" + "b.뒤로가기");
			System.out.println("\t\t\t" + "=========================================");
			System.out.print("\t\t\t" + "메뉴를 선택하세요: ");
			
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			

			int inputNum = Integer.parseInt(input);
			

			
			if(input.toUpperCase().equals("B")) {
				//뒤로가기
				//고객 메뉴 화면 
				System.out.println("뒤로가기선택");
				
				
			} else if(list.get(inputNum-1).contains(input)){	
				//선택 잘 했는지 , 메뉴에 출력된 번호만 입력했는지.
				
				
				//입력한 숫자가 어레이리스트에 존재할 때 
				//선택한 숫자 = 어레이리스트에 1번째 값.
				//선택한 숫자가 n-1번째 어레이리스트 요소에 1번째 값.
				if(inputNum == Integer.parseInt( list.get(inputNum-1).substring(0 ,list.get(inputNum-1).indexOf(",")))) {
					//이제 잘 찾았으면 출발역,도착역 가지고 루트찾기로 가기.

					//출발역 역이름
					start = list.get(inputNum-1).substring(list.get(inputNum-1).indexOf(",") + 1 , list.get(inputNum-1).lastIndexOf(","));

					//도착역 역이름
					arrival = list.get(inputNum-1).substring(list.get(inputNum-1).lastIndexOf(",") + 1 );

					//line > ArrayList 
					//검색 메뉴로 이동.
					Choice(start, arrival , linelist);
					
					

					
					
				} else {
					System.out.println("입력하신 번호에 해당하는 루트정보가 없습니다.");
				}
				
				
				
			} else {
				System.out.println("\t\t\t" + "잘못 입력하였습니다.");
				System.out.println("\t\t\t" + "다시 입력해 주세요.");
				return;
			}

			
			
			rs.close();
			stat.close();
			conn.close();
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
	

}
