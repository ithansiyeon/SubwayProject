package com.subway;

import java.util.ArrayList;

public class StationEx {
	
	public static void main(String[] args) {
		
		m1();
		
	}//main
	
	
	
	public static void m1() {
		
		
		
		class Station {
			public int line;		//호선
			public String name;		//역이름
			public Station next;		//다음역
			public Station prev;		//이전역
			public boolean transfer;	//환승역
			
			public String[] name1;
		}

		
//		
//		Station sta2 = new Station();	
//
//		sta2.name1[0] = "아니왜안돼?";
//		
//		System.out.println(sta2.name1[0]);
		
//		Station sta[] = new Station[10]();
//		for(int i=0; i<29; i++) {
//			sta[i] = new Station();
//			
//		}
		
		
		
		
		
		//마천-까치산
		Station sta200 = new Station();	
		sta200.line = 5;
		sta200.name = "마천";
		sta200.transfer = false;
		
		Station sta201 = new Station();	
		sta201.line = 5;
		sta201.name = "거여";
		sta201.transfer = false;
		
		Station sta202 = new Station();	
		sta202.line = 5;
		sta202.name = "개롱";
		sta202.transfer = false;
		
		Station sta203 = new Station();	
		sta203.line = 5;
		sta203.name = "오금";
		sta203.transfer = true;
		
		Station sta204 = new Station();	
		sta204.line = 5;
		sta204.name = "오금";
		sta204.transfer = false;
		
		Station sta205 = new Station();	
		sta205.line = 5;
		sta205.name = "방이";
		sta205.transfer = false;
		
		Station sta206 = new Station();	
		sta206.line = 5;
		sta206.name = "올림픽공원";
		sta206.transfer = false;
		
		Station sta207 = new Station();	
		sta207.line = 5;
		sta207.name = "둔촌동";
		sta207.transfer = false;
		
		Station sta208 = new Station();	
		sta208.line = 5;
		sta208.name = "강동";
		sta208.transfer = false;
		
		Station sta209 = new Station();	
		sta209.line = 5;
		sta209.name = "천호";
		sta209.transfer = false;
		
		Station sta210 = new Station();	
		sta210.line = 5;
		sta210.name = "광나루";
		sta210.transfer = false;
		
		Station sta211 = new Station();	
		sta211.line = 5;
		sta211.name = "아차산";
		sta211.transfer = false;

		
		Station sta212 = new Station();	
		sta212.line = 5;
		sta212.name = "군자";
		sta212.transfer = false;
		
		Station sta213 = new Station();	
		sta213.line = 5;
		sta213.name = "장한평";
		sta213.transfer = false;
		
		Station sta214 = new Station();	
		sta214.line = 5;
		sta214.name = "답십리";
		sta214.transfer = false;
		
		Station sta215 = new Station();	
		sta215.line = 5;
		sta215.name = "마장";
		sta215.transfer = false;
		
		Station sta216 = new Station();	
		sta216.line = 5;
		sta216.name = "왕십리";
		sta216.transfer = false;
		
		Station sta217 = new Station();	
		sta217.line = 5;
		sta217.name = "행당";
		sta217.transfer = false;
		
		Station sta218 = new Station();	
		sta218.line = 5;
		sta218.name = "신금호";
		sta218.transfer = false;
		
		Station sta219 = new Station();	
		sta219.line = 5;
		sta219.name = "청구";
		sta219.transfer = false;
		
		Station sta220 = new Station();	
		sta220.line = 5;
		sta220.name = "동대문역사문화공원";
		sta220.transfer = false;
		
		Station sta221 = new Station();	
		sta221.line = 5;
		sta221.name = "을지로4가";
		sta221.transfer = false;
		
		Station sta222 = new Station();	
		sta222.line = 5;
		sta222.name = "종로3가";
		sta222.transfer = false;
		
		Station sta223 = new Station();	
		sta223.line = 5;
		sta223.name = "종로3가";
		sta223.transfer = true;
		
		Station sta224 = new Station();	
		sta224.line = 5;
		sta224.name = "광화문";
		sta224.transfer = false;
		
		Station sta225 = new Station();	
		sta225.line = 5;
		sta225.name = "서대문";
		sta225.transfer = false;
		
		Station sta226 = new Station();	
		sta226.line = 5;
		sta226.name = "충정로";
		sta226.transfer = false;
		
		Station sta227 = new Station();	
		sta227.line = 5;
		sta227.name = "애오개";
		sta227.transfer = false;
		
		Station sta228 = new Station();	
		sta228.line = 5;
		sta228.name = "공덕";
		sta228.transfer = false;
		
		Station sta229 = new Station();	
		sta229.line = 5;
		sta229.name = "마포";
		sta229.transfer = false;
		
		Station sta230 = new Station();	
		sta230.line = 5;
		sta230.name = "여의나루";
		sta230.transfer = false;
		
		Station sta231 = new Station();	
		sta231.line = 5;
		sta231.name = "여의도";
		sta231.transfer = false;
		
		Station sta232 = new Station();	
		sta232.line = 5;
		sta232.name = "신길";
		sta232.transfer = true;
		
		Station sta233 = new Station();	
		sta233.line = 5;
		sta233.name = "신길";
		sta233.transfer = false;
		
		Station sta234 = new Station();	
		sta234.line = 5;
		sta234.name = "영등포시장";
		sta234.transfer = false;
		
		Station sta235 = new Station();	
		sta235.line = 5;
		sta235.name = "영등포구청";
		sta235.transfer = false;
		
		Station sta236 = new Station();	
		sta236.line = 5;
		sta236.name = "영등포구청";
		sta236.transfer = false;
		
		Station sta237 = new Station();	
		sta237.line = 5;
		sta237.name = "양평";
		sta237.transfer = false;
		
		Station sta238 = new Station();	
		sta238.line = 5;
		sta238.name = "오목교";
		sta238.transfer = false;
		
		Station sta239 = new Station();	
		sta239.line = 5;
		sta239.name = "목동";
		sta239.transfer = false;
		
		Station sta240 = new Station();	
		sta240.line = 5;
		sta240.name = "신정";
		sta240.transfer = false;
		
		Station sta241 = new Station();	
		sta241.line = 5;
		sta241.name = "까치산";
		sta241.transfer = false;
		
		//다음역
		sta200.next = sta201;
		sta201.next = sta202;
		sta202.next = sta203;
		sta203.next = sta204;
		sta204.next = sta205;
		sta205.next = sta206;
		sta206.next = sta207;
		sta207.next = sta208;
		sta208.next = sta209;
		sta209.next = sta210;
		sta210.next = sta211;
		sta211.next = sta212;
		sta212.next = sta213;
		sta213.next = sta214;
		sta214.next = sta215;
		sta215.next = sta216;
		sta216.next = sta217;
		sta217.next = sta218;
		sta218.next = sta219;
		sta219.next = sta220;
		sta220.next = sta221;
		sta221.next = sta222;
		sta222.next = sta223;
		sta223.next = sta224;
		sta224.next = sta225;
		sta225.next = sta226;
		sta226.next = sta227;
		sta227.next = sta228;
		sta228.next = sta229;
		sta229.next = sta230;
		sta230.next = sta231;
		sta231.next = sta232;
		sta232.next = sta233;
		sta233.next = sta234;
		sta234.next = sta235;
		sta235.next = sta236;
		sta236.next = sta237;
		sta237.next = sta238;
		sta238.next = sta239;
		sta239.next = sta240;
		sta240.next = sta241;

		
		
		
		//이전역
		sta201.prev = sta200;
		sta202.prev = sta201;
		sta203.prev = sta202;
		sta204.prev = sta203;
		sta205.prev = sta204;
		sta206.prev = sta205;
		sta207.prev = sta206;
		sta208.prev = sta207;
		sta209.prev = sta208;
		sta210.prev = sta209;
		sta211.prev = sta210;
		sta212.prev = sta211;
		sta213.prev = sta212;
		sta214.prev = sta213;
		sta215.prev = sta214;
		sta216.prev = sta215;
		sta217.prev = sta216;
		sta218.prev = sta217;
		sta219.prev = sta218;
		sta220.prev = sta219;
		sta221.prev = sta220;
		sta222.prev = sta221;
		sta223.prev = sta222;
		sta224.prev = sta223;
		sta225.prev = sta224;
		sta226.prev = sta225;
		sta227.prev = sta226;
		sta228.prev = sta227;
		sta229.prev = sta228;
		sta230.prev = sta229;
		sta231.prev = sta230;
		sta232.prev = sta231;
		sta233.prev = sta232;
		sta234.prev = sta233;
		sta235.prev = sta234;
		sta236.prev = sta235;
		sta237.prev = sta236;
		sta238.prev = sta237;
		sta239.prev = sta238;
		sta240.prev = sta239;
		
		   ArrayList<Station> line52 = new ArrayList<Station>();
		      //127 ~ 165
//		      for(int i=200;i<=240;i++) {
//		         String m = "sta"+i;
//		         System.out.println("line52.add("+m+");");
////		         System.out.println();
//		         
//		      }
		      
		      line52.add(sta200);
		      line52.add(sta201);
		      line52.add(sta202);
		      line52.add(sta203);
		      line52.add(sta204);
		      line52.add(sta205);
		      line52.add(sta206);
		      line52.add(sta207);
		      line52.add(sta208);
		      line52.add(sta209);
		      line52.add(sta210);
		      line52.add(sta211);
		      line52.add(sta212);
		      line52.add(sta213);
		      line52.add(sta214);
		      line52.add(sta215);
		      line52.add(sta216);
		      line52.add(sta217);
		      line52.add(sta218);
		      line52.add(sta219);
		      line52.add(sta220);
		      line52.add(sta221);
		      line52.add(sta222);
		      line52.add(sta223);
		      line52.add(sta224);
		      line52.add(sta225);
		      line52.add(sta226);
		      line52.add(sta227);
		      line52.add(sta228);
		      line52.add(sta229);
		      line52.add(sta230);
		      line52.add(sta231);
		      line52.add(sta232);
		      line52.add(sta233);
		      line52.add(sta234);
		      line52.add(sta235);
		      line52.add(sta236);
		      line52.add(sta237);
		      line52.add(sta238);
		      line52.add(sta239);
		      line52.add(sta240);
		      
		      
//		      System.out.println(line52.get(0).transfer);
		      
		      //정보 찾기 
		      for(int i=3; i<line52.size(); i++) {
		    	  System.out.println(line52.get(i).name 
		    			   				+ line52.get(i).line 
		    			   						+ line52.get(i).next.name 
		    			   							+ line52.get(i).prev.name
		    			   								+ line52.get(i).transfer
		    			   								);
		      }
		      
		      

		      
		      
		
		
		//이름찾기 
		
//		for(int i=0; i<2; i++) {
//			//객체의 name멤버 뒤지기
////			String temp = ("sta" + i) + "";
////			System.out.println(temp);
//			System.out.println(sta2.name1);
//
//		}
		
//		System.out.println(sta200.next.name);


//		if(sta200.name.equals("아차산")) {
//			
//		}else if(sta200.next.name.equals("아차산")) {
//			
//		};


	}//m1

		
	}



