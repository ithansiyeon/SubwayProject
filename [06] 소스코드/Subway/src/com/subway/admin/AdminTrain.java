package com.subway.admin;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.subway.DBUtil;

	
/**
 * 열차위치 조회하기 클래스
 * @author 정희수
 *
 */
public class AdminTrain {
	
	
	private static ArrayList<String> trainNum = new ArrayList<String>();
	
			
			
			
	public static void main(String[] args) {
		
		whereTrain();
		chaosRoom();
	}//main
	
	
	/**
	 * 혼잡도 조회 메소드
	 */
	public static void chaosRoom() {
		//혼잡도 조회
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		Statement stat1 = null;
		CallableStatement stat3 = null;
		DBUtil util = new DBUtil();
		Scanner scan = new Scanner(System.in);
		
		try {
			
			conn = util.open("211.63.89.57","subway","java1234");
			System.out.println("\t\t\t========================================");
			System.out.println("\t\t\t열차 위치 조회하기 페이지입니다. ");
			System.out.println("\t\t\t열차를 선택하세요. ");
			System.out.println("\t\t\t========================================");
			
			
			String sql = "select rownum,a.* from(select distinct name from vwTrainPosition ORDER by name)a";  //호선번호 출력 
			
			stat1=conn.createStatement();
			
			rs = stat1.executeQuery(sql);
			
			System.out.println("\t\t\t[번호]\t\t[호선]\n");
			while (rs.next()) {	
				System.out.printf("\t\t\t%s\t\t%s\n",
						rs.getString("rownum"),rs.getString("name"));
				
			}
			
			System.out.println("\t\t\t========================================");
			System.out.print("\t\t\t입력:");
			String hosun = scan.nextLine();
			
			
			
			
			
			System.out.println("\t\t\t========================================");
			System.out.println("\t\t\t열차를 선택하세요. ");
			System.out.println("\t\t\t========================================");
			
			sql = "select rownum,a.* from(select distinct  name, destination,lrseq  from vwTrainPosition  where liseq =" + hosun + " ORDER by name)a"; //열차 방면 출력
			
			 
			stat1 = conn.createStatement();
			
			rs = stat1.executeQuery(sql);
			
			System.out.println("\t\t\t[번호]\t\t[호선]\t\t[방면]");
			while (rs.next()) {
				System.out.printf("\t\t\t%s\t\t%s\t\t%s\n",rs.getString("rownum"),rs.getString("name"),rs.getString("destination"));
				trainNum.add(rs.getString("lrseq"));
			}
			 stat1.close();
			 
			 System.out.println("\t\t\t============================================================================");
			System.out.print("\t\t\t입력:");
			String bangmyeon= scan.nextLine();
			
			System.out.println("\t\t\t============================================================================");
			System.out.println("\t\t\t열차 번호를 입력하세요.");
			System.out.println();
			
//			System.out.println(roomNum.get(Integer.parseInt(bangmyeon)-1));

				sql = "select rownum,a.* from(  select DISTINCT tr.seq, ld.destination, li.name,li.seq as liseq,tr.seq as trainNum, lr.seq as lrseq from" + 
					"            tbltrain tr inner join tbllineroute lr on tr.linerouteseq = lr.seq" + 
					"                        inner join tbllinedirec ld on lr.linedirecseq = ld.seq" + 
					"                            inner join tblline li on ld.lineseq = li.seq" + 
					"                                inner join tblTrainseat ts on ts.trseq = tr.seq" + 
					"                                    where li.seq= "+ hosun + "and lr.seq =" + trainNum.get(Integer.parseInt(bangmyeon)-1) +
					"                                    order by li.name, tr.seq)a";
			//열차 번호 출력
			
			 
			stat1 = conn.createStatement();
			
			rs = stat1.executeQuery(sql);
			
			System.out.println("\t\t\t[호선]\t\t[기차번호]\t\t[방면]");
			
			while (rs.next()) {
				System.out.printf("\t\t\t%s\t\t%s\t\t\t%s\n",rs.getString("name"),rs.getString("lrseq"),rs.getString("destination"));
				
			}
			 	stat1.close();
			 	
			 	System.out.println("\t\t\t============================================================================");
				System.out.print("\t\t\t입력:");
				String tNum= scan.nextLine();
			
			
			 	stat1.close();
			 	rs.close();
			 	
			 	System.out.println("\t\t\t선택하신 열차의 혼잡도입니다.");
			 	
			 	sql = " select  ts.seq as roomnum," + 
			 			" case   when  c.peoplenum < ts.avgnum then '원활'" + 
			 			"         when  c.peoplenum > ts.avgnum then '혼잡'" + 
			 			"          when  c.peoplenum <= ts.avgnum then '보통'" + 
			 			" end as chaos" + 
			 			"       from tbltrain tr inner join tbllineroute lr on tr.linerouteseq = lr.seq " + 
			 			"                                                 inner join tbllinedirec ld on lr.linedirecseq = ld.seq     " + 
			 			"                                                     inner join tblline li on ld.lineseq = li.seq  " + 
			 			"                                                         inner join tblTrainlocation tl on tl.trseq= tr.seq " + 
			 			"                                                            inner join tblLineStation ls on ls.seq = tl.lsseq" + 
			 			"                                                                inner join tblStation st on st.seq = ls.staseq   " + 
			 			"                                                                    inner join tblCongestion c on c.locseq = tl.seq" + 
			 			"                                                                        inner join tblTrainSeat ts on ts.seq = c.tsseq " + 
			 			"                                                                         where tr.seq ="+tNum;
				//선택한 1번 기차의 1~10번 칸의 혼잡도 출력하기
			 	
			 	
			 	stat1 = conn.createStatement();
				
				rs = stat1.executeQuery(sql);
				
				ArrayList<String> yamea = new ArrayList<String>();
				
				
				System.out.println("\t\t\t[칸번호]\t\t[혼잡도]");
				
				while (rs.next()) {
//					System.out.printf("\t\t\t%s\t\t%s\t\t\t%s\n",hosun,tNum,rs.getString("stname"));
					yamea.add(String.format("\t\t\t%s\t\t\t%s\n",rs.getString("roomnum"),rs.getString("chaos")));
				}
				
				for(int i=0; i<10; i++) {
				System.out.println(yamea.get(i));
				}
				
				System.out.println("\t\t\t완료");
				AdminMain.pause();
				
				
			 	stat1.close();
			
			
			 	stat1.close();
			 	rs.close();
			 	
				conn.close();
				
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
				
	}//chaos
	
	
	
	
	
	/**
	 * 기차 위치 알기 메소드
	 */
	public static void whereTrain() {
		//기차 위치알기
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		Statement stat1 = null;
		CallableStatement stat3 = null;
		DBUtil util = new DBUtil();
		Scanner scan = new Scanner(System.in);
		
		try {
			
			conn = util.open("211.63.89.57","subway","java1234");
			System.out.println("\t\t\t========================================");
			System.out.println("\t\t\t열차 위치 조회하기 페이지입니다. ");
			System.out.println("\t\t\t열차를 선택하세요. ");
			System.out.println("\t\t\t========================================");
			
			
			String sql = "select rownum,a.* from(select distinct name from vwTrainPosition ORDER by name)a";  //호선번호 출력 
			
			stat1=conn.createStatement();
			
			rs = stat1.executeQuery(sql);
			
			System.out.println("\t\t\t[번호]\t\t[호선]\n");
			while (rs.next()) {
				System.out.printf("\t\t\t%s\t\t%s\n",
						rs.getString("rownum"),rs.getString("name"));
				
			}
							
			System.out.println("\t\t\t========================================");
			System.out.print("\t\t\t입력:");
			String hosun = scan.nextLine();
			
			
			
			
			
			System.out.println("\t\t\t========================================");
			System.out.println("\t\t\t열차를 선택하세요. ");
			System.out.println("\t\t\t========================================");
			
			sql = "select rownum,a.* from(select distinct  name, destination,lrseq  from vwTrainPosition  where liseq =" + hosun + " ORDER by name)a"; //열차 방면 출력
			
			 
			stat1 = conn.createStatement();
			
			rs = stat1.executeQuery(sql);
			
			System.out.println("\t\t\t[번호]\t\t[호선]\t\t[방면]");
			while (rs.next()) {
				System.out.printf("\t\t\t%s\t\t%s\t\t%s\n",rs.getString("rownum"),rs.getString("name"),rs.getString("destination"));
				trainNum.add(rs.getString("lrseq"));
			}
			 stat1.close();
			 
			 System.out.println("\t\t\t============================================================================");
			System.out.print("\t\t\t입력:");
			String bangmyeon= scan.nextLine();
			
			System.out.println("\t\t\t============================================================================");
			System.out.println("\t\t\t열차 번호를 입력하세요.");
			System.out.println();
			
//			System.out.println(roomNum.get(Integer.parseInt(bangmyeon)-1));

			sql = "select rownum,a.* from(  select DISTINCT tr.seq, ld.destination, li.name,li.seq as liseq,tr.seq as trainNum, lr.seq as lrseq from" + 
					"            tbltrain tr inner join tbllineroute lr on tr.linerouteseq = lr.seq" + 
					"                        inner join tbllinedirec ld on lr.linedirecseq = ld.seq" + 
					"                            inner join tblline li on ld.lineseq = li.seq" + 
					"                                inner join tblTrainseat ts on ts.trseq = tr.seq" + 
					"                                    where li.seq= "+ hosun + "and lr.seq =" + trainNum.get(Integer.parseInt(bangmyeon)-1) +
					"                                    order by li.name, tr.seq)a";
			//열차 번호 출력  1호선 기차의 인천->소요산행 방면의 1번기차 선택하기
			
			 
			stat1 = conn.createStatement();
			
			rs = stat1.executeQuery(sql);
			
			System.out.println("\t\t\t[호선]\t\t[기차번호]\t\t[방면]");
			
			while (rs.next()) {
				System.out.printf("\t\t\t%s\t\t%s\t\t\t%s\n",rs.getString("name"),rs.getString("lrseq"),rs.getString("destination"));
				
			}
			 	stat1.close();
			 	
			 	System.out.println("\t\t\t============================================================================");
				System.out.print("\t\t\t입력:");
				String tNum= scan.nextLine();
			
			
			 	stat1.close();
			 	rs.close();
			 	
			 	System.out.println("\t\t\t선택하신 열차의 현재 위치입니다.");
			 	
			 	sql = "   select rownum,a.* from(  select  tr.seq, ld.destination, li.name,li.seq as liseq,tr.seq as trainNum , lr.seq as lrseq, st.name as stName," + 
			 			"        ls.staorder as 순서, to_char(tl.time,'hh24:mi') as 시간" + 
			 			"       from tbltrain tr inner join tbllineroute lr on tr.linerouteseq = lr.seq" + 
			 			"                                                 inner join tbllinedirec ld on lr.linedirecseq = ld.seq " + 
			 			"                                                     inner join tblline li on ld.lineseq = li.seq" + 
			 			"                                                         inner join tblTrainlocation tl on tl.trseq= tr.seq " + 
			 			"                                                            inner join tblLineStation ls on ls.seq = tl.lsseq" + 
			 			"                                                                inner join tblStation st on st.seq = ls.staseq" + 
			 			"                                                                    where tr.seq =" +  tNum +
			 			"                                                                        order by tl.time desc)a";
			 	//선택한 1번 기차의 현재 위치 출력하기, 제일 마지막으로 등록된 rownum을 출력한다.
				
			 	
			 	stat1 = conn.createStatement();
				
				rs = stat1.executeQuery(sql);
				
				ArrayList<String> dlist = new ArrayList<String>();
				
				
				System.out.println("\t\t\t[호선]\t\t[기차번호]\t\t[현재위치]\n");
				
				while (rs.next()) {
//					System.out.printf("\t\t\t%s\t\t%s\t\t\t%s\n",hosun,tNum,rs.getString("stname"));
					dlist.add(String.format("\t\t\t%s\t\t%s\t\t\t%s\n",hosun,tNum,rs.getString("stname")));
				}

				System.out.println(dlist.get(0));
				
				System.out.println("\t\t\t완료");
				AdminMain.pause();
				
			 	stat1.close();
			
			
			 	stat1.close();
			 	rs.close();
			 	
				conn.close();
				
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}//where

	
}//class
