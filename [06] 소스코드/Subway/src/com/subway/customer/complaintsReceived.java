package com.subway.customer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

import com.subway.DBUtil;

/**
 * 
 * @author siyeon
 * 고객불편사항과 관련된 클래스입니다.
 */
public class complaintsReceived {
	static Random rnd;
	static Scanner scan;
	static {
		rnd = new Random();
		scan = new Scanner(System.in);
	}
/*
	public static void main(String[] args) {
		complaintsReceived m = new complaintsReceived();
		m.mainmenu(17);
		
	}
*/
	/**
	 * 메인 메뉴 메소드입니다.
	 * @param cusseq 고객번호입니다.
	 */
	public void mainmenu(int cusseq) {
		while(true) {
		System.out.println("\t\t\t====================");
		System.out.println("\t\t\t        MENU");
		System.out.println("\t\t\t====================");
		System.out.println("\t\t\t1. 조회");
		System.out.println("\t\t\t2. 접수");
		System.out.println("\t\t\t3. 삭제");
		System.out.println("\t\t\t4. 수정");
		System.out.println("\t\t\tb. 뒤로가기");
		System.out.println("\t\t\t====================");
		System.out.print("\t\t\t▶입력 :");
		String sel = scan.nextLine();
		if(sel.equals("1")) {
			complainSelect(cusseq);
		} else if(sel.equals("2")) {
			complainRegister(cusseq);
		} else if(sel.equals("3")) {
			complainDelect(cusseq);
		} else if(sel.equals("4")) {
			complainUpdate(cusseq);
		} else if(sel.equals("b")) {
			break;
		} else {
			System.out.println("\t\t\t번호를 다시 입력해주세요.");
		}
		}
	}

	/**
	 *  불편사항을 수정하는 메소드입니다.
	 * @param cusseq 고객 번호 메소드입니다.
	 */
	public void complainUpdate(int cusseq) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		String sql = null;
		CallableStatement stat1 = null;
		
		String seq = "";
		String content = "";
		String comdate = "";
		String delflag = "";
		String locseq = "";
		String cusseq1 = "";
		try {
//			conn = util.open("211.63.89.57","subway","java1234");
		//	conn = util.open("localhost","subway","java1234");
			conn = util.open();
			stat = conn.createStatement();
			sql = String.format("select * from vwcomplain where cusseq = %d and stat=1",cusseq);
			rs = stat.executeQuery(sql);
			System.out.println();
			System.out.println("\t\t\t====================");
			System.out.println("\t\t\t[번호]\t[고유번호]\t[답변 유무]\t[날짜]\t\t[불편 사항 내용]\t\t[답변내용]");
			System.out.println("\t\t\t====================");
			int count=0;
			while (rs.next()) {
				count++;
				System.out.printf("\t\t\t%s\t",count+"");
				System.out.printf("%s\t",rs.getString("seq"));
				System.out.printf("%s\t",rs.getString("state"));
				System.out.printf("%s\t",rs.getString("date"));
				System.out.printf("%s\t\t",rs.getString("content"));
				if(rs.getString("answer")==null) {
					String answer1="아직 답변 없습니다.";
					System.out.printf("%s\t\t",answer1);
				} else {
					System.out.printf("%s",rs.getString("answer"));
				}
				System.out.println();	
				}	
			System.out.println();
			System.out.print("\t\t\t수정할 고유번호(종료 번호: -1): ");
			String rseq = scan.nextLine();
			if(!rseq.equals(-1)) {
			System.out.print("\t\t\t불편사항 내용:");
			String rcontent = scan.nextLine();
			sql = String.format("select * from vwcomplainSelect where seq = %s",rseq);
			rs = stat.executeQuery(sql);
			if(rs.next()) {
			seq = rs.getString("seq");
			content = rs.getString("content");
			comdate = rs.getString("comdate");
			delflag = rs.getString("delflag");
			locseq = rs.getString("locseq");
			cusseq1 = rs.getString("cusseq");
			}
			sql = "{call proccomplainUpdate(?,?)}";
			stat1 = conn.prepareCall(sql);
			stat1.setString(1,rseq);
			stat1.setString(2, rcontent);
			stat1.executeUpdate();
			stat1.close();
			} 
			stat.close();
			conn.close();
			rs.close();
			
			
		} catch (Exception e) {
			System.out.println("complaintsReceived.complainUpdate()");
			e.printStackTrace();
		}
		
		
	}


	/**
	 * 불편사항을 삭제하는 메소드입니다. 
	 * @param cusseq 고객번호 매개변수입니다.
	 */
	public void complainDelect(int cusseq) {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		String sql = null;
		try {
//			conn = util.open("211.63.89.57","subway","java1234");
		//	conn = util.open("localhost","subway","java1234");
			conn = util.open();
			sql = "{call proccomplainDelect(?)}";
			stat = conn.prepareCall(sql);
			complainSelect(cusseq);
			System.out.print("\t\t\t삭제할 고유번호(종료 번호: -1):");
			String rseq = scan.nextLine();
			if(!rseq.equals("-1")) {
				stat.setString(1, rseq);
			} 
			stat.executeUpdate();
			stat.close();
			conn.close();
			pause();
		} catch (Exception e) {
			System.out.println("complaintsReceived.complainDelect()");
			e.printStackTrace();
		}
		
		
	}

	/**
	 * 불편사항을 접수하는 메소드입니다. 
	 * @param cusseq 고객번호 매개변수입니다.
	 */
	public void complainRegister(int cusseq) {
		Connection conn = null;
		CallableStatement stat = null;
		Statement stat1 = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		String sql = null;
		ArrayList <Long> time = new ArrayList<Long>();
		ArrayList <Long> addtime = new ArrayList<Long>();
		ArrayList <String> lseq = new ArrayList<String>();
		String get_lseq = null;
		Calendar c = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		pause();
		try {
			
//			conn = util.open("211.63.89.57","subway","java1234");
		//	conn = util.open("localhost","subway","java1234");
			conn = util.open();
			sql = "{ call proccomplainRegister(?,?,?) }";
			System.out.print("\t\t\t불편사항 내용:");
			String pcontent = scan.nextLine();
			stat = conn.prepareCall(sql);
			stat.setString(1,pcontent);
			stat.setInt(2, cusseq);
			stat1 = conn.createStatement();
			sql = "select to_char(tl.time,'hh24:mi:ss') as time,tl.seq from tblStart s" + 
					"        inner join tblCustomer c on c.seq = s.cusseq" + 
					"            inner join tblLineStation ls" + 
					"					 on ls.seq = s.lsseq " + 
					"                        inner join tblTrainlocation tl" + 
					"                            on tl.lsseq = ls.seq where c.seq = 12"; //and  to_char(tl.time,'yy-mm-dd')='20-07-10'";
					
			
			rs = stat1.executeQuery(sql);
//			now.set(Calendar.HOUR, 5);
//			now.set(Calendar.MINUTE, 43);
//			now.set(Calendar.SECOND, 13);
//			now.set(Calendar.DATE, 10);
		
			while(rs.next()) {
				String time1 = rs.getString("time");
				int hour = Integer.parseInt(time1.substring(0,2));
				int min = Integer.parseInt(time1.substring(3,5));
				int sec = Integer.parseInt(time1.substring(6));
				
//				c.set(Calendar.DATE, 10);
				c.set(Calendar.HOUR, hour);
				c.set(Calendar.MINUTE, min);
				c.set(Calendar.SECOND, sec);
				time.add(c.getTimeInMillis());
				lseq.add(rs.getString("seq"));
				c.add(Calendar.MINUTE,2);
				addtime.add(c.getTimeInMillis());
			}

			for(int i=0;i<time.size();i++) {
				for(int j=0;j<addtime.size();j++) {
					if(time.get(i) <= now.getTimeInMillis() && addtime.get(j) > now.getTimeInMillis()) {
						get_lseq = lseq.get(i);

					}
				}
			}

			stat.setString(3,get_lseq);
			stat.executeUpdate();
			stat.close();
			rs.close();
			stat1.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("complaintsReceived.complainRegister()");
			e.printStackTrace();
		}
		
	}

	/**
	 *  불편사항을 조회하는 메소드입니다.
	 * @param cusseq 고객번호 매개변수입니다.
	 */
	public void complainSelect(int cusseq) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		String sql = null;
		pause();
		try {
//			conn = util.open("211.63.89.57","subway","java1234");
		//	conn = util.open("localhost","subway","java1234");
			conn = util.open();
			stat = conn.createStatement();
			sql = String.format("select * from vwcomplain where cusseq = %d",cusseq);
			rs = stat.executeQuery(sql);
			System.out.println();
			System.out.println("\t\t\t====================");
			System.out.println("\t\t\t[번호]\t[고유번호]\t[답변 유무]\t[날짜]\t\t[불편 사항 내용]\t\t[답변내용]");
			System.out.println("\t\t\t====================");
			int count=0;
			while (rs.next()) {
				count++;
				System.out.printf("\t\t\t%s\t",count+"");
				System.out.printf("%s\t",rs.getString("seq"));
				System.out.printf("%s\t",rs.getString("state"));
				System.out.printf("%s\t",rs.getString("date"));
				System.out.printf("%s\t\t",rs.getString("content"));
				if(rs.getString("answer")==null) {
					String answer1="아직 답변 없습니다.";
					System.out.printf("%s\t\t",answer1);
				} else {
					System.out.printf("%s",rs.getString("answer"));
				}
				System.out.println();	
				}	
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("complaintsReceived.complainSelect()");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 엔터를 누르면 계속 진행하는 메소드입니다.
	 */
	public void pause() {
		System.out.println();
		System.out.println("\t\t\t계속 하실려면 엔터를 누르세요...");
		scan.nextLine();
	}
	
}
