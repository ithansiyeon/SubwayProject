package com.test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Random;

public class dummy_schedule {

	public static void main(String[] args) {
		//기차번호 1호선 1~30 출발 - 
		//기차번호 3호선 91~120 출발 - 
		//기차번호 5호선 151~180 출발 - 
		//시퀀스, 날짜(20/07/10), 출발시간, 운행종료시간, 운행순서, 기차번호
		//insert into tblSchedule (seq, days, starttime, endtime, runorder, trainseq) values (Schedule_seq.nextVal, ?, ?, ?, ?, ?)
		
		//62개
//		insertSchedule(1, );
//		insertSchedule(16, );
		
		//44개
//		insertSchedule(91, );
//		insertSchedule(106, );
		
		//46개
//		insertSchedule(151, );
//		insertSchedule(165, );
		
	}

	private static void insertSchedule(int trainNum, String startTime, String endTime) {

		Connection conn = null;
		PreparedStatement stat = null;
		DBUtil util = new DBUtil();

		try {
			Random rnd = new Random();
			int max = trainNum + 15;
			int order = 1;
			for (int i = trainNum; i < max; i++) {

				conn = util.open();

				String sql = ("insert into tblSchedule (seq, days, starttime, endtime, runorder, trainseq) values (Schedule_seq.nextVal, ?, ?, ?, ?, ?)");

				stat = conn.prepareStatement(sql);

				// 날짜(20/07/10)
				stat.setString(1, "to_date('2020-07-10','yyyy-mm-dd')");

				// 출발시간
				stat.setString(2, String.format("to_date('2020-07-10 %s','yyyy-mm-dd hh24:mi')", startTime));

				// 운행종료시간
				stat.setString(3, String.format("to_date('2020-07-10 %s','yyyy-mm-dd hh24:mi')", endTime));

				// 운행순서
				stat.setString(4, order+"");

				// 기차번호(FK) : trainNum (한 방향 15개씩)
				stat.setString(5, i+"");

				stat.executeUpdate();
				
				order++;
			}

			stat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// lineStation
}
