package com.test.jdbc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class DummyData {
	
	private static File f1 = new File("/Volumes/Untitled/1호선 역 순서/소요산-인천.txt");
	private static File f2 = new File("/Volumes/Untitled/1호선 역 순서/소요산-광명.txt");
	private static File f3 = new File("/Volumes/Untitled/1호선 역 순서/소요산-서동탄.txt");
	private static File f4 = new File("/Volumes/Untitled/1호선 역 순서/소요산-신창.txt");
	
	private static File f5 = new File("/Volumes/Untitled/1호선 역 순서/용산~동인천.txt");
	private static File f6 = new File("/Volumes/Untitled/1호선 역 순서/용산~동인천 특급.txt");
	private static File f7 = new File("/Volumes/Untitled/1호선 역 순서/소요산~인천.txt");
	private static File f8 = new File("/Volumes/Untitled/1호선 역 순서/청량리~신창.txt");

//	private static File f1 = new File("F:\\1호선 역 순서\\소요산-인천.txt");
//	private static File f2 = new File("F:\\1호선 역 순서\\소요산-광명.txt");
//	private static File f3 = new File("F:\\1호선 역 순서\\소요산-서동탄.txt");
//	private static File f4 = new File("F:\\1호선 역 순서\\소요산-신창.txt");
//	
//	private static File f5 = new File("F:\\1호선 역 순서\\용산~동인천.txt");
//	private static File f6 = new File("F:\\1호선 역 순서\\용산~동인천 특급.txt");
//	private static File f7 = new File("F:\\1호선 역 순서\\소요산~인천.txt");
//	private static File f8 = new File("F:\\1호선 역 순서\\청량리~신창.txt");
	
	private static ArrayList<String> numList = new ArrayList<String>();
	private static ArrayList<String> nameList = new ArrayList<String>();
	private static ArrayList<String> insertList = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		//데이터 생성 
		
		//1. 지하철 역 , tblStation
		//station();
		
		//2. 호선 , tblLine
		//line();
		
		//3. 호선+역 , tblLineStation
		//lineStation();
		
		//역 순서에 맞춰 역의 seq 순서대로 저장하기
		
		//인천-소요산 80
		loadStationNumber(f1);
		lineStation("80", 1); //line_Seq, flag : 1 인천(신창)~, 0 (소요산~)
		lineStation("98", 0); //line_Seq, flag : 1 인천(신창)~, 0 (소요산~)
		
		//소요산-인천 84
		loadStationNumber(f1);
		lineStation("84", 0);
		
		//광명-소요산 81
		loadStationNumber(f2);
		lineStation("81", 1);

//		//소요산-광명 85
		loadStationNumber(f2);
		lineStation("85", 0);
		
//		//서동탄-소요산 82
		loadStationNumber(f3);
		lineStation("82", 1);
//		//소요산-서동탄 86
		loadStationNumber(f3);
		lineStation("86", 0);
		
//		//신창-소요산 83
		loadStationNumber(f4);
		lineStation("83", 1);
		
//		//소요산-신창 87
		loadStationNumber(f4);
		lineStation("87", 0);
		
//		//급행
//		//용산-동인천 급 88
		loadStationNumber(f5);
		lineStation("88", 0);
//		//동인천-용산 92
		loadStationNumber(f5);
		lineStation("92", 1);
		
//		//용산-동인천 특급 89
		loadStationNumber(f6);
		lineStation("89", 0);
//		//동인천-용산 특 93
		loadStationNumber(f6);
		lineStation("93", 1);
		
//		//소요산-인천 90
		loadStationNumber(f7);
		lineStation("90", 0);
//		//인천-소요산 94
		loadStationNumber(f7);
		lineStation("94", 1);
		
//		//청량리-신창 91
		loadStationNumber(f8);
		lineStation("91", 0);
//		//신창-청량리 95
		loadStationNumber(f8);
		lineStation("95", 1);
		
		
		writeFile();
		
	}

	private static void writeFile() {
		
		try {
			BufferedWriter  writer = new BufferedWriter(new FileWriter("/Volumes/Untitled/1호선 역 순서/insert1.txt"));
//			BufferedWriter  writer = new BufferedWriter(new FileWriter("F:\\1호선 역 순서\\insert1호선.txt"));
			
			for(String s: insertList) {
				writer.write(s);
				writer.newLine();
			}
			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void loadStationNumber(File file) {
		
		numList.clear();
		nameList.clear();
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String line = null;
			
			ArrayList<String> list = new ArrayList<String>();

//			ArrayList<String> nameList = new ArrayList<String>();
//			ArrayList<String> numList = new ArrayList<String>();
			
			while((line=reader.readLine())!=null) {
				nameList.add(line);
			}

			conn = util.open();
			stat = conn.createStatement();

			String sql = String.format("select * from tblStation order by seq");
			
			rs = stat.executeQuery(sql);

			while(rs.next()) {
					
				list.add(rs.getString("seq")+"\t"+rs.getString("name"));
			}
			
			for(int i=0; i<nameList.size(); i++) {
				
				for(String str : list) {
					String[] array = str.split("\t");
					
					if(array[1].equals(nameList.get(i))) {
						System.out.printf("%s %s \n",nameList.get(i),array[1]);
						numList.add(array[0]);
						break;
					}
				}
				
//				
//				if(rs.getString("name").equals(nameList.get(i))) {
//					System.out.printf("%s %s %d\n",rs.getString("name"), nameList.get(i), i);
//					numList.add(rs.getString("seq"));
//					break;
//				}
				
			}//for	

			
			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void lineStation(String lineNum, int flag) {
		
		Connection conn = null;
		PreparedStatement stat = null;
		DBUtil util = new DBUtil();
		

		
		try {
			Random rnd = new Random();

			//a. 문위치
//			String[] door = {"왼쪽","오른쪽"};
			String[] door = {"1","2"};
			
			//b. 환승구간
			String[] trans = {"1-1","1-2","1-3","1-4","1-5","1-6","1-7","1-8","1-9"
					,"2-1","2-2","2-3","2-4","2-5","2-6","2-7","2-8","2-9"
					,"3-1","3-2","3-3","3-4","3-5","3-6","3-7","3-8","3-9"
					,"4-1","4-2","4-3","4-4","4-5","4-6","4-7","4-8","4-9"
					,"5-1","5-2","5-3","5-4","5-5","5-6","5-7","5-8","5-9"};
			
			conn = util.open();
			
			if(flag == 0) {
				for(int i=0; i<numList.size(); i++) {

					String sql = ("insert into tblLineStation (seq, door, staorder, transdoor, lineseq, staseq) values (lineStation_seq.nextVal , ?, ?, ?, ?, ?)");
					String result = ("insert into tblLineStation (seq, door, staoder, transdoor, lineseq, staseq) values (lineStation_seq.nextVal, ");
					
					stat=conn.prepareStatement(sql);
					
					//door : 왼쪽 , 오른쪽 랜덤 지정 
					stat.setString(1, door[rnd.nextInt(door.length)]);
					result += door[rnd.nextInt(door.length)] + ",";
					
					//turn : 역 순서
					stat.setString(2, (i+1)+"");
					result += (i+1) + ",";
					
					//transdoor : 환승구간 랜덤 지정
					stat.setString(3, trans[rnd.nextInt(trans.length)]);
					result += trans[rnd.nextInt(trans.length)] + ",";
					
					//lineseq : 호선 번호 (FK)
					//14개 호선 
					//직접 입력
					stat.setString(4, lineNum);
					result += lineNum + ",";
					
					//staseq : 역 번호 (FK)
					//직접 입력
					stat.setString(5, numList.get(i));
					result += numList.get(i) + ");";
					
					System.out.println(i + "\t" + numList.get(i));
//					stat.executeUpdate();
					insertList.add(result);
				}
			}else {
				int j=1;
				
				for(int i=numList.size()-1; i>=0; i--) {
					
					String sql = ("insert into tblLineStation (seq, door, staoder, transdoor, lineseq, staseq) values (lineStation_seq.nextVal , ?, ?, ?, ?, ?)");
					String result = ("insert into tblLineStation (seq, door, staoder, transdoor, lineseq, staseq) values (lineStation_seq.nextVal ,");
					
					stat=conn.prepareStatement(sql);
					
					//door : 왼쪽 , 오른쪽 랜덤 지정 
					stat.setString(1, door[rnd.nextInt(door.length)]);
					result += door[rnd.nextInt(door.length)] + ",";
					
					//turn : 역 순서
					stat.setString(2, j+"");
					result += j + ",";
					
					//transdoor : 환승구간 랜덤 지정
					stat.setString(3, trans[rnd.nextInt(trans.length)]);
					result += trans[rnd.nextInt(trans.length)] + ",";
					
					//lineseq : 호선 번호 (FK)
					//14개 호선 
					//직접 입력
					stat.setString(4, lineNum);
					result += lineNum + ",";
					
					//staseq : 역 번호 (FK)
					//직접 입력
					stat.setString(5, numList.get(i));
					result += numList.get(i) + ");";
					
					System.out.println(i + "\t" + numList.get(i));
//					stat.executeUpdate();
					insertList.add(result);
					j++;
				}
			}
			
			stat.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}//lineStation
	

}
