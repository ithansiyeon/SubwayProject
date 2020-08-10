package com.subway.customer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.subway.DBUtil;

/**
 * 
 * @author 전혜원
 * 고객의 즐겨찾기 기능 구현 클래스 
 */
public class Bookmark {
	
	private static Scanner sc = new Scanner(System.in);
	private static int cusseq = 2;
	private static int trainNum = 0;
	private static int stnum = 23;
	private static int bun = -1;
	
	
	private static ArrayList<String> bmlist = new ArrayList<String>();
	private static ArrayList<String> numlist = new ArrayList<String>();
	private static ArrayList<String> stalist = new ArrayList<String>();
	private static ArrayList<String> imglist = new ArrayList<String>();
	private static ArrayList<String> namelist = new ArrayList<String>();
	
	
	
	public static void main(String[] args) {
		
		bmMain();
		
	}
	
	
	/**
	 * 즐겨찾기 메뉴 출력 메소드
	 */
	public static void bmMain() {
		
		while(true) {
			System.out.println("\t\t\t[즐겨찾기]");
			System.out.println("\t\t\t=============================");
			System.out.println("\t\t\t1. 즐겨찾기 조회");
			System.out.println("\t\t\t2. 즐겨찾기 추가");
			System.out.println("\t\t\t3. 즐겨찾기 삭제");
			System.out.println();
			System.out.println("\t\t\t. 뒤로가기");
			System.out.println("\t\t\t=============================");
			System.out.print("\t\t\t입력 : ");
			String input = sc.nextLine();
			
			loadBookmark(); //즐겨찾기 정보 불러오기
			
			if(input.equals("1")) {
				//조회
				loadBookmark();
				loadTrain();
			}else if(input.equals("2")) {
				//추가
				searchBookmark();
			}else if(input.equals("3")) {
				 //삭제
				loadBookmark();
				deleteBookmark();
			}else if(input.equals("b")) {
				//뒤로가기
				break;
			}
			
		}//while
		
	}//bmMain()
	
	private static void printBookmark(int loc) {
		// 즐겨찾기 출력 클래스

//		boolean flag = true;
		loadTrainImg();
		
//		while(flag) {
			System.out.println("\t\t\t[즐겨찾기 조회]");
			System.out.println("\t\t\t=============================");
			
			if(loc == 0) { //영등포
				System.out.println("\t\t\t열차진입중");
				bun = 0;
				printTrain(loc, 0);
				
			} else if(loc == 1) {//신도림
				System.out.println("\t\t\t열차 2분 후 도착");
				bun = 2;
				printTrain(loc, 1);
				
			} else if(loc==2) {//구로
				System.out.println("\t\t\t열차 4분 후 도착");
				bun = 4;
				printTrain(loc, 2);
			}else {
				//다음 열차 위치 확인하기
				nextTrain();
				System.out.printf("\t\t\t열차 %d분 후 도착\n",bun);
				printTrain(-1, 2);
				
			}
			
			
//		}//while
		
	}
	

	private static void nextTrain() {
		// 다음 열차 찾기
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {

			conn = util.open();
			stat = conn.createStatement();

			String sql = String.format("select tl.seq, to_char(tl.time,'yyyy-mm-dd-hh24-mi') as now, ls.staorder,tl.trseq, s.name " + 
					" from tblTrainLocation tl inner join tblLineStation ls on tl.lsseq=ls.seq " + 
					" inner join tblStation s on ls.staseq=s.seq " + 
					" where tl.trseq = %d and to_char(tl.time,'yyyy-mm-dd') = '2020-07-16'" + 
					" order by tl.seq desc", trainNum);

			rs = stat.executeQuery(sql);
			
			rs.next();
			String nextTrain = rs.getString("staorder") + "\t" + rs.getString("name");
			
			String[] tt = nextTrain.split("\t");
					
			int staorder = Integer.parseInt(tt[0]);
			
			bun = (stnum - staorder) * 2;
	
			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private static void printTrain(int loc, int cnt) {
		// 기차 위치에 맞춰 프린트하기
		//기차 위치, \t수
		
		if(loc != -1) {
			String tab = "";
			
			for(int i=cnt; i<=0; i--) {
				tab += "\t\t\t";
			}
			
			for(String s:imglist) {
				System.out.println(tab+s);
			}
			
		}else { //열차가 없을 경우
			
			for(int i=0; i<imglist.size(); i++) {
				System.out.println();
			}
			
		}
		
		System.out.println("==============================================================================================================");
		System.out.printf("%s\t\t\t\t\t\t%s\t\t\t\t\t\t\t%s\n",namelist.get(2),namelist.get(1),namelist.get(0));
				
	}

	private static void loadTrainImg() {
		//기차 이미지 불러오기
		String timg = 
			"                wZZZZ9                                   EZZZZy                 \r\n" + 
			"             ,ZZZZ  DZZZD                             DZZZ8  ZZZZw              \r\n" + 
			"            yZZZ      zZZZ                           ZZZE      ZZZj             \r\n" + 
			"               EZZBwZZZW                               ,ZZZwDZZE                \r\n" + 
			"   ,WWWWWWWWW    EZZZ    wWWWWWWWWWWWWWWWWWWWWWWWWWWWw    ZZZ9    WWWWWWWWW     \r\n" + 
			"  ZZZZZZZZZZZZZZZZ88EZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZE88EZZZZZZZZZZZZZZZ,  \r\n" + 
			" 8Z8888888888888888888888888888888888888888888888888888888888888888888888888Z8  \r\n" + 
			" BZ888EZZZZZZZZZZZ98ZZZZZZZZZZZE89ZZZZZZZZZZZ98EZZZZZZZZZZZ99ZZZZZZZZZZZE888ZB  \r\n" + 
			" BZ888ZDyDDDDDDDj8Z9ZWDDDDDDD5WZ9ZzjDDDDDDDyBZ9ZW5DDDDDDDjZEZ8jDDDDDDDyDZ888ZB  \r\n" + 
			" BZ888Z           ZEZ          ZEZ           Z9Z          BZZ           Z888ZB  \r\n" + 
			" BZ888Z           ZZZ          ZEZ           Z9Z          EZZ           Z888ZB  \r\n" + 
			" BZ888Z           ZZZ          ZEZ           Z9Z          EZZ           Z888ZB  \r\n" + 
			" BZ888Z           ZZZ          ZEZ           Z9Z          zZZ           Z888ZB  \r\n" + 
			" BZ888Zy,WWWWWWW BZEZ wWWWWWWw Z9ZD WWWWWWW 5Z9Z wWWWWWWw ZEZB WWWWWWW,jZ888ZB  \r\n" + 
			" BZ888EZZZZZZZZZZZ99ZZZZZZZZZZZZ8EZZZZZZZZZZZE8ZZZZZZZZZZZZ99ZZZZZZZZZZZE888ZB  \r\n" + 
			" BZ8888888888888888888888888888888888888888888888888888888888888888888888888ZB  \r\n" + 
			" BZ8888888888888888888888888888888888888888888888888888888888888888888888888ZB  \r\n" + 
			" BZ8888888888888888888888888888888888888888888888888888888888888888888888888ZB  \r\n" + 
			" zZ8888888888888888888888888888888888888888888888888888888888888888888888888ZB  \r\n" + 
			" ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ  \r\n" + 
			"                                                                                \r\n" + 
			" WDWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWDW  \r\n" + 
			" ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ  \r\n" + 
			"  ZZZZZZZE88888889ZZE88888889ZZZZZZZZZZZZZZZZZZZZZ98888888EZZ98888888EZZZZZZZ   \r\n" + 
			"        zZZ88888EZZwZZ988889ZZ                   ZZ988889ZZw9ZE88888EZB         \r\n" + 
			"         zZZZZZZZZ  WZZZZZZZZ                     ZZZZZZZZD  ZZZZZZZZ9          \r\n";
		
		String[] arr = timg.split("\r\n");
		
		for(String s:arr) {
			imglist.add(s);
		}
		
	}

	private static void loadTrain() {
		//현재 고객의 즐겨찾기 역+호선 번호 불러오기
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		String bmlsseq = new String();
		
		try {
			conn = util.open();
			stat = conn.createStatement();
			
			//현재 고객의 즐겨찾기 역+호선 번호 불러오기
			String sql = String.format("select * from tblBookmark where cusseq = %s and delflag=0", cusseq);
			
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				bmlsseq = rs.getString("lsseq");
			}
			
//			cntLocation(Integer.parseInt(bmlsseq));
			
			rs.close();
			stat.close();
			conn.close();
			
			while(true) {
//				cntLocation(Integer.parseInt(bmlsseq));
				trainLocate(bmlsseq);
				
				if (bun == 0) {
					break;
				}
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void trainLocate(String bmlsseq) throws SQLException {
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		DBUtil util = new DBUtil();
		
		conn = util.open();
		stat = conn.createStatement();
		
		

		String sql;
		//시간 맞춰 오는 열차위치 구하기
		ArrayList<String> tlist = new ArrayList<String>();
//		String time = new String();
		
		sql = String.format("select to_char(tl.time,'yyyy-mm-dd-hh24-mi') as now, tl.trseq, tl.lsseq, s.name" + 
				"                from tblTrainLocation tl inner join tblLineStation ls on tl.lsseq=ls.seq" + 
				"                inner join tblStation s on ls.staseq = s.seq" + 
				"                where ls.seq in (%s,%d,%d) order by ls.seq desc", bmlsseq, Integer.parseInt(bmlsseq)-1, Integer.parseInt(bmlsseq)-2);
	
		rs = stat.executeQuery(sql);
		
		while(rs.next()) {
//			time = rs.getString("now"); //yyyy-mm-dd-hh24-mi
			tlist.add(rs.getString("now") + "\t" + rs.getString("lsseq") + "\t" + rs.getString("name"));
			namelist.add(rs.getString("name"));
		}

		Calendar now = Calendar.getInstance();
//		now.set(2020, 6, 10);
		Calendar tnow = Calendar.getInstance();

		for (int i = 0; i < 3; i++) { // i : 0~2
			String[] arr = tlist.get(i).split("\t");
			String[] tarr = arr[0].split("-");// yyyy-mm-dd-hh24-mi

			tnow.set(2020, 6, 10, Integer.parseInt(tarr[3]), Integer.parseInt(tarr[4]));

			if (now.get(Calendar.HOUR_OF_DAY) == tnow.get(Calendar.HOUR_OF_DAY)
					&& now.get(Calendar.MINUTE) == tnow.get(Calendar.MINUTE)) {
				printBookmark(i); // 0~2
			} else {
				printBookmark(i + 3); // 3~5
			}
		} // for
		
		rs.close();
		stat.close();
		conn.close();
	}
	

	private static void cntLocation(int bmlsseq) {	//시간 맞춰 오는 열차위치 구하기
		//시간 맞춰 오는 열차위치 구하기
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {
			conn = util.open();
			stat = conn.createStatement();

			//시간 맞춰 오는 열차위치 구하기
			ArrayList<String> tlist = new ArrayList<String>();
//			String time = new String();

			Calendar now = Calendar.getInstance();
//			now.set(2020, 6, 10);
			
			String sql = String.format("select tl.seq, to_char(tl.time,'yyyy-mm-dd-hh24-mi') as now, ls.staorder,tl.trseq, s.name" + 
					" from tblTrainLocation tl inner join tblLineStation ls on tl.lsseq=ls.seq" + 
					" inner join tblStation s on ls.staseq=s.seq" + 
					" where tl.trseq in (select seq from tblTrain where linerouteseq = 1) and ls.seq in (23,22,21) and to_char(tl.time,'yyyy-mm-dd') = '2020-07-16'" + 
					" order by tl.seq desc");
//					"order by tl.seq desc",bmlsseq, 2020, 07, 16);
//					" order by tl.seq desc",bmlsseq, now.get(Calendar.YEAR), now.get(Calendar.MONTH)+1, now.get(Calendar.DATE));
			
			rs = stat.executeQuery(sql);
			
			int i=0;
			
			while(rs.next()) {
//				time = rs.getString("now"); //yyyy-m-m-dd-hh24-mi
				tlist.add(rs.getString("now"));
				
				if(i == 0) {
					trainNum = rs.getInt("trseq");	
				}
				i++;
			}
			
			String[] tarr = tlist.get(0).split("-");//yyyy-mm-dd-hh24-mi
			
			rs.close();
			stat.close();
			conn.close();
			
			Connection conn1 = null;
			Statement stat1 = null;
			ResultSet rs1 = null;
			conn1 = util.open();
			stat1 = conn1.createStatement();

			Calendar tnow = Calendar.getInstance();
			tnow.set(Calendar.MONTH,Integer.parseInt(tarr[3])-1);
			tnow.set(Calendar.DATE,Integer.parseInt(tarr[4]));
			
			long diff = now.getTimeInMillis() - tnow.getTimeInMillis();
			
//			if(bmlsseq < 0) {
//				//검색결과 X
//				System.out.println("검색결과가 없습니다.");
//				
//			} else {
				if(diff < 0) { //지나감. 다음 열차 찾기
					
				} else if(diff == 0) { //정차
					printBookmark(0);
					sql = String.format("select to_char(time,'yyyy-mm-dd-hh24-mi') as now, trseq" + 
							"from tblTrainLocation where lsseq = %s order by seq desc", bmlsseq);
					
					rs1 = stat1.executeQuery(sql);
					
				} else if(diff > 0 ) { //아직 오는 중
					cntLocation(bmlsseq-1);
				}
//			}
			
			rs1.close();
			stat1.close();
			conn1.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void addBookmark(String select) {
		// 즐겨찾기 추가
		Connection conn = null;
		CallableStatement stat = null;

		DBUtil util = new DBUtil();
		
		String[] arr = select.split("\t");
				
		String stname = arr[1];
		String line = arr[2];

		try {
			conn = util.open();
			String sql = " call procaddbookmark (?,?,?) ";
			stat = conn.prepareCall(sql);

			stat.setString(1, cusseq + "");
			stat.setString(2, stname);
			stat.setString(3, line);

			stat.executeUpdate();
			System.out.println("\t\t\t=========================================");
			System.out.printf("\t\t\t[%s]역을 즐겨찾기에 추가하였습니다.\n", stname);

			System.out.println("\t\t\t=========================================");

			conn.close();
			stat.close();

			pause();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("\t\t\t역 추가에 실패하였습니다.");
//	         e.printStackTrace();
		}
	}

	private static void pause() {
		System.out.println();
		System.out.println("\t\t\t계속 하려면 엔터를 입력하시오.");

		sc.nextLine();
	}
	
	private static void searchBookmark() {
		// 즐겨찾기 추가할 역 검색
		
		ArrayList<String> slist = new ArrayList<String>();
		
		System.out.println("\t\t\t=============================");
		System.out.println("\t\t\t즐겨찾기에 추가할 역 이름을 입력하세요.");
		System.out.println();
		System.out.print("\t\t\t입력 : ");
		String sname = sc.nextLine();
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {

			conn = util.open();
			stat = conn.createStatement();
			
			//번호 역이름 호선이름 방면
			String sql = String.format("select rownum, ss.name as sname, ll.name as lname, ld.destination as des " + 
					"from tblLineStation ls inner join tblStation ss on ls.staseq=ss.seq " + 
					"inner join tblLineRoute lr on ls.linerouteseq=lr.seq " + 
					"inner join tblLineDirec ld on lr.linedirecseq=ld.seq " + 
					"inner join tblLine ll on ld.lineseq=ll.seq " + 
					"where ss.name = '%s'",sname);
			
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				slist.add(rs.getString("rownum") + "\t" + rs.getString("sname") + "\t" + rs.getString("lname") + "\t" + rs.getString("des"));
			}

			
			rs.close();
			stat.close();
			conn.close();
			
			System.out.println("\t\t\t=============================");
			System.out.println("\t\t\t[번호]\t[이름]\t\t[호선]\t[방면]");
			for(String s : slist) {
				if (s.contains(sname)) {
					String[] arr = s.split("\t");
					System.out.printf("\t\t\t%s\t%s\t\t%s\t%s\n",arr[0],arr[1],arr[2],arr[3]);
				}
			}
			System.out.println("\t\t\t=============================");
			System.out.print("\t\t\t추가할 번호를 입력하세요 : ");
			String num = sc.nextLine();
			
			addBookmark(slist.get(Integer.parseInt(num)+1));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void deleteBookmark() {
		// 즐겨찾기 삭제
		
		//bmlist : rownum, ll.name as lname, ld.destination, s.name as sname, bm.seq as bseq
		
		System.out.println("\t\t\t=============================");
		System.out.println("\t\t\t삭제할 즐겨찾기 번호를 선택하세요.");
		System.out.println();
		System.out.println("\t\t\t[번호]\t[호선]\t[역명]");
		
		for(String str:bmlist) {
//			System.out.println(str);
			String[] arr = str.split("\t");
			System.out.printf("\t\t\t%s\t%s\t\t%s\n",arr[0],arr[1],arr[3]);
		}
		System.out.println("\t\t\t=============================");
		System.out.print("\t\t\t입력 : ");
		String input = sc.nextLine();
		
		for(String num: numlist) {
			if(num.equals(input)) {
				updatebm(input);
				System.out.println("\t\t\t삭제가 완료되었습니다.");
			}else {
				System.out.println("\t\t\t잘못 입력하셨습니다.");
			}
		}
		System.out.println("\t\t\t=============================");
	
		
	}

	private static void updatebm(String input) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {

			conn = util.open();
			stat = conn.createStatement();

			String sql = String.format("update tblBookmark set delflag=1 where seq=%s",input);
			
			stat.executeUpdate(sql);

			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private static void loadBookmark() {
		//즐겨찾기 내역 저장
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		bmlist.clear();
		try {

			
			conn = util.open();
			stat = conn.createStatement();

			String sql = String.format(
					"select rownum, ll.name as lname, ld.destination, s.name as sname, bm.seq as bseq " + 
					"from tblBookmark bm inner join tblLinestation ls on bm.lsseq=ls.seq " + 
					"inner join tblStation s on ls.staseq=s.seq " + 
					"inner join tblLineRoute lr on ls.linerouteseq=lr.seq " + 
					"inner join tblLineDirec ld on lr.linedirecseq=ld.seq " + 
					"inner join tblLine ll on ld.lineseq=ll.seq " + 
					"where bm.cusseq=%d and bm.delflag=0 " + 
					"order by rownum, bm.cusseq,bm.seq", cusseq);
			
//			System.out.println(sql);

			rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				String bm = "";
				bm += rs.getString("rownum")+"\t" +rs.getString("lname")+"\t"+rs.getString("destination")+"\t"+rs.getString("sname");
				numlist.add(rs.getString("bseq"));
//				System.out.println(bm); //**
				bmlist.add(bm);	
			}//while

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
