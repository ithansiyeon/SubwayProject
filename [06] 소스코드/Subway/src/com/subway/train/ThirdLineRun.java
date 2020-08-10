package com.subway.train;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.subway.DBUtil;

//public class ThirdLine {
//	public static void main(String[] args) {
//		ThirdLineRun tr = new ThirdLineRun();
//		tr.start();
//		
//	}
//}


public class ThirdLineRun extends Thread{
	
	//3호선 운행 스케줄테이블 기준으로 현재시간 부터 끝나는 시간까지 쭈욱 데이터 넣기 
	@Override
	public void run() {
		Connection conn = null;
		Statement stat = null;

		DBUtil util = new DBUtil();
		
		ResultSet rs = null;
		//3호선에 무슨 행이 있는지 찾아서 저장
		String sql = "select ld.destination from tblline li inner join tbllinedirec ld on li.seq = ld.lineseq\r\n" ; 
//				 + "where li.name = '3호선'";
		
		try {
			
			conn= util.open();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			List<String> dlist = new ArrayList<String>();
			while(rs.next()) {
				String d = rs.getString("destination");
				dlist.add(d);
			}
			
//			System.out.println(dlist); //대화행, 오금행
			
			//시간 확인 먼저
			while(true) {
				
				Calendar c1 = Calendar.getInstance();
				int hr = c1.get(Calendar.HOUR_OF_DAY);
				int mi = c1.get(Calendar.MINUTE);
				
//				String td = hr+""+mi;

			
			for(int i = 0; i< dlist.size(); i++) { //행 나누기
				sql = "select seq from vwseeorder where destination = '" + dlist.get(i) + "'";
		
				rs = stat.executeQuery(sql);
				
				List<String> stlist = new ArrayList<String>();
				
				//역 순서 보기
				while(rs.next()) {
					stlist.add(String.format("%s"
							, rs.getString(1)));
				}

//				System.out.println(stlist);    //역순서 저장
				
				sql = "select distinct seq from vwseetrainschedule where destination = '" + dlist.get(i) + "'";
				rs = stat.executeQuery(sql);
				
				List<String> trlist = new ArrayList<String>();//해당 행의 기차 시퀀스 저장
				if(rs.next()) {
					trlist.add(rs.getString(1));

					while(rs.next()) {
						
						trlist.add(rs.getString(1));
					}
				}
				for(int j = 0; j < trlist.size() ; j++) {
				
					//*********************바꿔야하는것
					sql = "select * from vwseetrainschedule where seq = " + trlist.get(j) + " AND " + 
							"to_date(starttime, 'hh24:mi') <= to_date('" + hr+":" + mi + "','hh24:mi') \r\n" + 
							"and to_date(endtime, 'hh24:mi') >= to_date('" + hr + ":" + mi + "','hh24:mi') "
							+ "and days = '20-07-10'"; //지금은 임의로 날짜 지정 나중에 sysdate로 변경
					
					rs = stat.executeQuery(sql);
					List<String> trinfolist = new ArrayList<String>();
					
					//시간 저장
					if(rs.next()) {
						trinfolist.add(String.format("%s,%s,%s,%s,%s,%s,%s,%s"
								,rs.getString(1)
								,rs.getString(2)
								,rs.getString(3)
								,rs.getString(4)
								,rs.getString(5)
								,rs.getString(6)
								,rs.getString(7)
								,rs.getString(8)
								));
					}

//					1	1호선	인천-소요산행	20/07/10	10:15	12:19	31	일반
					if(trinfolist.size() != 0) {
						int nowcal = 60*hr + mi;
						
						int newcal = Integer.parseInt(trinfolist.get(0).split(",")[4].split(":")[0])*60 
								+ Integer.parseInt(trinfolist.get(0).split(",")[4].split(":")[1]);
						int countst = nowcal - newcal;
						
						if(trinfolist.size() != 0 ) {
							//일반 열차 ----> 나중에 1로 바꾸던가 할것
						if(trinfolist.get(0).split(",")[7].equals("일반")) {
							if(countst % 2 == 0) {
								sql = "insert into tbltrainlocation values (trainlocation_seq.nextVal, sysdate," + 
										stlist.get(countst/2) + "," + trlist.get(j) +")";
								stat.executeUpdate(sql); //쿼리 업데이트
//								System.out.println(sql);
								sql = "select max(seq) from tbltrainlocation where lsseq = " + stlist.get(countst/2) + "and"
										+ " trseq = " + trlist.get(j);
								rs = stat.executeQuery(sql);
								 
								String locseq = "";
								if(rs.next()) {
									locseq = rs.getString(1);
								}
								
								sql = "select seq from tbltrainseat where trseq = "+ trlist.get(j);
								rs = stat.executeQuery(sql);
								
								List<String> seatlist = new ArrayList<String>();
								
							while(rs.next()) {
								seatlist.add(rs.getString(1));
								}
								
								//혼잡도는 확인해볼것!
								for(int k = 0; k < seatlist.size(); k++) {
								sql = "insert into tblcongestion values (congestion_seq.nextVal," +
								(int)(Math.random()*50+ 50) + ","+ locseq + "," + seatlist.get(k) + " )";
//								System.out.println(sql);
								stat.executeUpdate(sql); //쿼리 업데이트
								

								}
							}
						}
					}
					}//trinfolist
					
				}//for(trlist)
				
				rs.close();
				stat.close();
				conn.close();
				
			}
			
			ThirdLineRun.sleep(60000); //1분에 한대씩 운행
			}//while
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}