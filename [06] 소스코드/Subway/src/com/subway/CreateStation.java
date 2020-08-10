package com.subway;

import java.util.ArrayList;

public class CreateStation {

	public static ArrayList<Station> line11 = new ArrayList<Station>(); // 구로-도봉산
	public static ArrayList<Station> line12 = new ArrayList<Station>(); // 도봉산-구로
	public static ArrayList<Station> line31 = new ArrayList<Station>(); // 연신내-오금
	public static ArrayList<Station> line32 = new ArrayList<Station>(); // 오금-연신내
	public static ArrayList<Station> line51 = new ArrayList<Station>(); // 까치산-마천
	public static ArrayList<Station> line52 = new ArrayList<Station>(); // 마천-까치산

	public static void main(String[] args) {
		
//		create();
		
		for(int i=1; i<59; i++) {
			System.out.println("sta"+i+".line=1;");
		}

	}
	
	//1,3,5호선 객체 생성 + list에 담기
	public static void create() {

		// 1호선
		Station sta1 = new Station();
		sta1.name = "구로";
		sta1.transfer = false;

		Station sta2 = new Station();
		sta2.name = "신도림";
		sta2.transfer = false;

		Station sta3 = new Station();
		sta3.name = "영등포";
		sta3.transfer = false;

		Station sta4 = new Station();
		sta4.name = "신길";
		sta4.transfer = false;

		Station sta5 = new Station();
		sta5.name = "대방";
		sta5.transfer = false;

		Station sta6 = new Station();
		sta6.name = "노량진";
		sta6.transfer = false;

		Station sta7 = new Station();
		sta7.name = "용산";
		sta7.transfer = false;

		Station sta8 = new Station();
		sta8.name = "남영";
		sta8.transfer = false;

		Station sta9 = new Station();
		sta9.name = "서울역";
		sta9.transfer = false;

		Station sta10 = new Station();
		sta10.name = "시청";
		sta10.transfer = false;

		Station sta11 = new Station();
		sta11.name = "종각";
		sta11.transfer = false;

		Station sta12 = new Station();
		sta12.name = "종로3가";
		sta12.transfer = true;

		Station sta13 = new Station();
		sta13.name = "종로5가";
		sta13.transfer = false;

		Station sta14 = new Station();
		sta14.name = "동대문";
		sta14.transfer = false;

		Station sta15 = new Station();
		sta15.name = "동묘앞";
		sta15.transfer = false;

		Station sta16 = new Station();
		sta16.name = "신설동";
		sta16.transfer = false;

		Station sta17 = new Station();
		sta17.name = "제기동";
		sta17.transfer = false;

		Station sta18 = new Station();
		sta18.name = "청량리";
		sta18.transfer = false;

		Station sta19 = new Station();
		sta19.name = "회기";
		sta19.transfer = false;

		Station sta20 = new Station();
		sta20.name = "외대앞";
		sta20.transfer = false;

		Station sta21 = new Station();
		sta21.name = "신이문";
		sta21.transfer = false;

		Station sta22 = new Station();
		sta22.name = "석계";
		sta22.transfer = false;

		Station sta23 = new Station();
		sta23.name = "광운대";
		sta23.transfer = false;

		Station sta24 = new Station();
		sta24.name = "월계";
		sta24.transfer = false;

		Station sta25 = new Station();
		sta25.name = "녹천";
		sta25.transfer = false;

		Station sta26 = new Station();
		sta26.name = "창동";
		sta26.transfer = false;

		Station sta27 = new Station();
		sta27.name = "방학";
		sta27.transfer = false;

		Station sta28 = new Station();
		sta28.name = "도봉";
		sta28.transfer = false;

		Station sta29 = new Station();
		sta29.name = "도봉산";
		sta29.transfer = false;

		sta1.next = sta2;
		sta2.next = sta3;
		sta3.next = sta4;
		sta4.next = sta5;
		sta5.next = sta6;
		sta6.next = sta7;
		sta7.next = sta8;
		sta8.next = sta9;
		sta9.next = sta10;
		sta10.next = sta11;
		sta11.next = sta12;
		sta12.next = sta13;
		sta13.next = sta14;
		sta14.next = sta15;
		sta15.next = sta16;
		sta16.next = sta17;
		sta17.next = sta18;
		sta18.next = sta19;
		sta19.next = sta20;
		sta20.next = sta21;
		sta21.next = sta22;
		sta22.next = sta23;
		sta23.next = sta24;
		sta24.next = sta25;
		sta25.next = sta26;
		sta26.next = sta27;
		sta27.next = sta28;
		sta28.next = sta29;

		sta2.prev = sta1;
		sta3.prev = sta2;
		sta4.prev = sta3;
		sta5.prev = sta4;
		sta6.prev = sta5;
		sta7.prev = sta6;
		sta8.prev = sta7;
		sta9.prev = sta8;
		sta10.prev = sta9;
		sta11.prev = sta10;
		sta12.prev = sta11;
		sta13.prev = sta12;
		sta14.prev = sta13;
		sta15.prev = sta14;
		sta16.prev = sta15;
		sta17.prev = sta16;
		sta18.prev = sta17;
		sta19.prev = sta18;
		sta20.prev = sta29;
		sta21.prev = sta20;
		sta22.prev = sta21;
		sta23.prev = sta22;
		sta24.prev = sta23;
		sta25.prev = sta24;
		sta26.prev = sta25;
		sta27.prev = sta26;
		sta28.prev = sta27;
		sta29.prev = sta28;
		
		

		Station sta58 = new Station();
		sta58.name = "구로";
		sta58.transfer = false;

		Station sta57 = new Station();
		sta57.name = "신도림";
		sta57.transfer = false;

		Station sta56 = new Station();
		sta56.name = "영등포";
		sta56.transfer = false;

		Station sta55 = new Station();
		sta55.name = "신길";
		sta55.transfer = false;

		Station sta54 = new Station();
		sta54.name = "대방";
		sta54.transfer = false;

		Station sta53 = new Station();
		sta53.name = "노량진";
		sta53.transfer = false;

		Station sta52 = new Station();
		sta52.name = "용산";
		sta52.transfer = false;

		Station sta51 = new Station();
		sta51.name = "남영";
		sta51.transfer = false;

		Station sta50 = new Station();
		sta50.name = "서울역";
		sta50.transfer = false;

		Station sta49 = new Station();
		sta49.name = "시청";
		sta49.transfer = false;

		Station sta48 = new Station();
		sta48.name = "종각";
		sta48.transfer = false;

		Station sta47 = new Station();
		sta47.name = "종로3가";
		sta47.transfer = true;

		Station sta46 = new Station();
		sta46.name = "종로5가";
		sta46.transfer = false;

		Station sta45 = new Station();
		sta45.name = "동대문";
		sta45.transfer = false;

		Station sta44 = new Station();
		sta44.name = "동묘앞";
		sta44.transfer = false;

		Station sta43 = new Station();
		sta43.name = "신설동";
		sta43.transfer = false;

		Station sta42 = new Station();
		sta42.name = "제기동";
		sta42.transfer = false;

		Station sta41 = new Station();
		sta41.name = "청량리";
		sta41.transfer = false;

		Station sta40 = new Station();
		sta40.name = "회기";
		sta40.transfer = false;

		Station sta39 = new Station();
		sta39.name = "외대앞";
		sta39.transfer = false;

		Station sta38 = new Station();
		sta38.name = "신이문";
		sta38.transfer = false;

		Station sta37 = new Station();
		sta37.name = "석계";
		sta37.transfer = false;

		Station sta36 = new Station();
		sta36.name = "광운대";
		sta36.transfer = false;

		Station sta35 = new Station();
		sta35.name = "월계";
		sta35.transfer = false;

		Station sta34 = new Station();
		sta34.name = "녹천";
		sta34.transfer = false;

		Station sta33 = new Station();
		sta33.name = "창동";
		sta33.transfer = false;

		Station sta32 = new Station();
		sta32.name = "방학";
		sta32.transfer = false;

		Station sta31 = new Station();
		sta31.name = "도봉";
		sta31.transfer = false;

		Station sta30 = new Station();
		sta30.name = "도봉산";
		sta30.transfer = false;

		sta30.next = sta31;
		sta31.next = sta32;
		sta32.next = sta33;
		sta33.next = sta34;
		sta34.next = sta35;
		sta35.next = sta36;
		sta36.next = sta37;
		sta37.next = sta38;
		sta38.next = sta39;
		sta39.next = sta40;
		sta40.next = sta41;
		sta41.next = sta42;
		sta42.next = sta43;
		sta43.next = sta44;
		sta44.next = sta45;
		sta45.next = sta46;
		sta46.next = sta47;
		sta47.next = sta48;
		sta48.next = sta49;
		sta49.next = sta50;
		sta50.next = sta51;
		sta51.next = sta52;
		sta52.next = sta53;
		sta53.next = sta54;
		sta54.next = sta55;
		sta55.next = sta56;
		sta56.next = sta57;
		sta57.next = sta58;

		sta31.prev = sta30;
		sta32.prev = sta31;
		sta33.prev = sta32;
		sta34.prev = sta33;
		sta35.prev = sta34;
		sta36.prev = sta35;
		sta37.prev = sta36;
		sta38.prev = sta37;
		sta39.prev = sta38;
		sta40.prev = sta39;
		sta41.prev = sta40;
		sta42.prev = sta41;
		sta43.prev = sta42;
		sta44.prev = sta43;
		sta45.prev = sta44;
		sta46.prev = sta45;
		sta47.prev = sta46;
		sta48.prev = sta47;
		sta49.prev = sta48;
		sta50.prev = sta49;
		sta51.prev = sta50;
		sta52.prev = sta51;
		sta53.prev = sta52;
		sta54.prev = sta53;
		sta55.prev = sta54;
		sta56.prev = sta55;
		sta57.prev = sta56;
		sta58.prev = sta57;
		
		sta1.line=1;
		sta2.line=1;
		sta3.line=1;
		sta4.line=1;
		sta5.line=1;
		sta6.line=1;
		sta7.line=1;
		sta8.line=1;
		sta9.line=1;
		sta10.line=1;
		sta11.line=1;
		sta12.line=1;
		sta13.line=1;
		sta14.line=1;
		sta15.line=1;
		sta16.line=1;
		sta17.line=1;
		sta18.line=1;
		sta19.line=1;
		sta20.line=1;
		sta21.line=1;
		sta22.line=1;
		sta23.line=1;
		sta24.line=1;
		sta25.line=1;
		sta26.line=1;
		sta27.line=1;
		sta28.line=1;
		sta29.line=1;
		sta30.line=1;
		sta31.line=1;
		sta32.line=1;
		sta33.line=1;
		sta34.line=1;
		sta35.line=1;
		sta36.line=1;
		sta37.line=1;
		sta38.line=1;
		sta39.line=1;
		sta40.line=1;
		sta41.line=1;
		sta42.line=1;
		sta43.line=1;
		sta44.line=1;
		sta45.line=1;
		sta46.line=1;
		sta47.line=1;
		sta48.line=1;
		sta49.line=1;
		sta50.line=1;
		sta51.line=1;
		sta52.line=1;
		sta53.line=1;
		sta54.line=1;
		sta55.line=1;
		sta56.line=1;
		sta57.line=1;
		sta58.line=1;

		// 5호선
		Station sta127 = new Station();
		Station sta128 = new Station();
		Station sta129 = new Station();
		Station sta130 = new Station();
		Station sta131 = new Station();
		Station sta132 = new Station();
		Station sta133 = new Station();
		Station sta134 = new Station();
		Station sta135 = new Station();
		Station sta136 = new Station();
		Station sta137 = new Station();
		Station sta138 = new Station();
		Station sta139 = new Station();
		Station sta140 = new Station();
		Station sta141 = new Station();
		Station sta142 = new Station();
		Station sta143 = new Station();
		Station sta144 = new Station();
		Station sta145 = new Station();
		Station sta146 = new Station();
		Station sta147 = new Station();
		Station sta148 = new Station();
		Station sta149 = new Station();
		Station sta150 = new Station();
		Station sta151 = new Station();
		Station sta152 = new Station();
		Station sta153 = new Station();
		Station sta154 = new Station();
		Station sta155 = new Station();
		Station sta156 = new Station();
		Station sta157 = new Station();
		Station sta158 = new Station();
		Station sta159 = new Station();
		Station sta160 = new Station();
		Station sta161 = new Station();
		Station sta162 = new Station();
		Station sta163 = new Station();
		Station sta164 = new Station();
		Station sta165 = new Station();

		sta127.line = 5;
		sta127.name = "까치산";
		sta127.next = sta128;
		sta127.transfer = false;

		sta128.line = 5;
		sta128.name = "신정";
		sta128.next = sta129;
		sta128.prev = sta128;
		sta128.transfer = false;

		sta129.line = 5;
		sta129.name = "목동";
		sta129.next = sta130;
		sta129.prev = sta128;
		sta129.transfer = false;

		sta130.line = 5;
		sta130.name = "오목교";
		sta130.next = sta131;
		sta130.prev = sta129;
		sta130.transfer = false;

		sta131.line = 5;
		sta131.name = "양평";
		sta131.next = sta132;
		sta131.prev = sta130;
		sta131.transfer = false;

		sta132.line = 5;
		sta132.name = "영등포구청";
		sta132.next = sta133;
		sta132.prev = sta131;
		sta132.transfer = false;

		sta133.line = 5;
		sta133.name = "영등포구청";
		sta133.next = sta134;
		sta133.prev = sta132;
		sta133.transfer = false;

		sta134.line = 5;
		sta134.name = "영등포시장";
		sta134.next = sta135;
		sta134.prev = sta133;
		sta134.transfer = false;

		sta135.line = 5;
		sta135.name = "신길";
		sta135.next = sta136;
		sta135.prev = sta134;
		sta135.transfer = false;

		sta136.line = 5;
		sta136.name = "여의도";
		sta136.next = sta137;
		sta136.prev = sta135;
		sta136.transfer = false;

		sta137.line = 5;
		sta137.name = "여의나루";
		sta137.next = sta138;
		sta137.prev = sta136;
		sta137.transfer = false;

		sta138.line = 5;
		sta138.name = "마포";
		sta138.next = sta139;
		sta138.prev = sta137;
		sta138.transfer = false;

		sta139.line = 5;
		sta139.name = "공덕";
		sta139.next = sta140;
		sta139.prev = sta138;
		sta139.transfer = false;

		sta140.line = 5;
		sta140.name = "애오개";
		sta140.next = sta141;
		sta140.prev = sta139;
		sta140.transfer = false;

		sta141.line = 5;
		sta141.name = "충정로";
		sta141.next = sta142;
		sta141.prev = sta141;
		sta141.transfer = false;

		sta142.line = 5;
		sta142.name = "서대문";
		sta142.next = sta143;
		sta142.prev = sta141;
		sta142.transfer = false;

		sta143.line = 5;
		sta143.name = "광화문";
		sta143.next = sta144;
		sta143.prev = sta142;
		sta143.transfer = false;

		sta144.line = 5;
		sta144.name = "종로3가";
		sta144.next = sta145;
		sta144.prev = sta143;
		sta144.transfer = false;

		sta145.line = 5;
		sta145.name = "을지로4가";
		sta145.next = sta146;
		sta145.prev = sta144;
		sta145.transfer = false;

		sta146.line = 5;
		sta146.name = "동대문역사문화공원";
		sta146.next = sta147;
		sta146.prev = sta145;
		sta146.transfer = false;

		sta147.line = 5;
		sta147.name = "청구";
		sta147.next = sta148;
		sta147.prev = sta146;
		sta147.transfer = false;

		sta148.line = 5;
		sta148.name = "신금호";
		sta148.next = sta149;
		sta148.prev = sta147;
		sta148.transfer = false;

		sta149.line = 5;
		sta149.name = "행당";
		sta149.next = sta150;
		sta149.prev = sta148;
		sta149.transfer = false;

		sta150.line = 5;
		sta150.name = "왕십리";
		sta150.next = sta151;
		sta150.prev = sta149;
		sta150.transfer = false;

		sta151.line = 5;
		sta151.name = "마장";
		sta151.next = sta152;
		sta151.prev = sta150;
		sta151.transfer = false;

		sta152.line = 5;
		sta152.name = "답십리";
		sta152.next = sta153;
		sta152.prev = sta151;
		sta152.transfer = false;

		sta153.line = 5;
		sta153.name = "장한평";
		sta153.next = sta154;
		sta153.prev = sta152;
		sta153.transfer = false;

		sta154.line = 5;
		sta154.name = "군자";
		sta154.next = sta155;
		sta154.prev = sta153;
		sta154.transfer = false;

		sta155.line = 5;
		sta155.name = "아차산";
		sta155.next = sta156;
		sta155.prev = sta154;
		sta155.transfer = false;

		sta156.line = 5;
		sta156.name = "광나루";
		sta156.next = sta157;
		sta156.prev = sta155;
		sta156.transfer = false;

		sta157.line = 5;
		sta157.name = "천호";
		sta157.next = sta158;
		sta157.prev = sta156;
		sta157.transfer = false;

		sta158.line = 5;
		sta158.name = "강동";
		sta158.next = sta159;
		sta158.prev = sta157;
		sta158.transfer = true;

		sta159.line = 5;
		sta159.name = "둔촌동";
		sta159.next = sta160;
		sta159.prev = sta158;
		sta159.transfer = false;

		sta160.line = 5;
		sta160.name = "올림픽공원";
		sta160.next = sta161;
		sta160.prev = sta159;
		sta160.transfer = false;

		sta161.line = 5;
		sta161.name = "방이";
		sta161.next = sta162;
		sta161.prev = sta160;
		sta161.transfer = false;

		sta162.line = 5;
		sta162.name = "오금";
		sta162.next = sta163;
		sta162.prev = sta161;
		sta162.transfer = false;

		sta163.line = 5;
		sta163.name = "개롱";
		sta163.next = sta164;
		sta163.prev = sta162;
		sta163.transfer = false;

		sta164.line = 5;
		sta164.name = "거여";
		sta164.next = sta165;
		sta164.prev = sta163;
		sta164.transfer = false;

		sta165.line = 5;
		sta165.name = "마천";
		sta165.prev = sta164;
		sta165.transfer = false;

		// 마천-까치산
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

		// 다음역
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

		// 이전역
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

		line51.add(sta127);
		line51.add(sta128);
		line51.add(sta129);
		line51.add(sta130);
		line51.add(sta131);
		line51.add(sta132);
		line51.add(sta133);
		line51.add(sta134);
		line51.add(sta135);
		line51.add(sta136);
		line51.add(sta137);
		line51.add(sta138);
		line51.add(sta139);
		line51.add(sta140);
		line51.add(sta141);
		line51.add(sta142);
		line51.add(sta143);
		line51.add(sta144);
		line51.add(sta145);
		line51.add(sta146);
		line51.add(sta147);
		line51.add(sta148);
		line51.add(sta149);
		line51.add(sta150);
		line51.add(sta151);
		line51.add(sta152);
		line51.add(sta153);
		line51.add(sta154);
		line51.add(sta155);
		line51.add(sta156);
		line51.add(sta157);
		line51.add(sta158);
		line51.add(sta159);
		line51.add(sta160);
		line51.add(sta161);
		line51.add(sta162);
		line51.add(sta163);
		line51.add(sta164);
		line51.add(sta165);

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

		// 3호선
		Station sta61 = new Station();

		// 호선
		sta61.line = 3;

		// 역이름
		sta61.name = "연신내";

//		sta61.transfer = true;  //환승역이라면
		sta61.transfer = false; // 아니라면

		// station 객체 생성
		Station sta62 = new Station();

		// 호선
		sta62.line = 3;

		// 역이름
		sta62.name = "불광";

//			sta61.transfer = true;  //환승역이라면
		sta62.transfer = false; // 아니라면

		// station 객체 생성
		Station sta63 = new Station();

		// 호선
		sta63.line = 3;

		// 역이름
		sta63.name = "녹번";

//			sta61.transfer = true;  //환승역이라면
		sta63.transfer = false; // 아니라면

		// station 객체 생성
		Station sta64 = new Station();

		// 호선
		sta64.line = 3;

		// 역이름
		sta64.name = "홍제";

//			sta61.transfer = true;  //환승역이라면
		sta64.transfer = false; // 아니라면

		// station 객체 생성
		Station sta65 = new Station();

		// 호선
		sta65.line = 3;

		// 역이름
		sta65.name = "무악재";

//			sta61.transfer = true;  //환승역이라면
		sta65.transfer = false; // 아니라면

		// station 객체 생성
		Station sta66 = new Station();

		// 호선
		sta66.line = 3;

		// 역이름
		sta66.name = "독립문";

//			sta61.transfer = true;  //환승역이라면
		sta66.transfer = false; // 아니라면

		// station 객체 생성
		Station sta67 = new Station();

		// 호선
		sta67.line = 3;

		// 역이름
		sta67.name = "경복궁";

//			sta61.transfer = true;  //환승역이라면
		sta67.transfer = false; // 아니라면

		// station 객체 생성
		Station sta68 = new Station();

		// 호선
		sta68.line = 3;

		// 역이름
		sta68.name = "안국";

//			sta61.transfer = true;  //환승역이라면
		sta68.transfer = false; // 아니라면

		// station 객체 생성
		Station sta69 = new Station();

		// 호선
		sta69.line = 3;

		// 역이름
		sta69.name = "종로3가";

		sta69.transfer = true; // 환승역이라면
//			sta67.transfer = false; //아니라면

		// station 객체 생성
		Station sta70 = new Station();

		// 호선
		sta70.line = 3;

		// 역이름
		sta70.name = "을지로3가";

//			sta61.transfer = true;  //환승역이라면
		sta70.transfer = false; // 아니라면

		// station 객체 생성
		Station sta71 = new Station();

		// 호선
		sta71.line = 3;

		// 역이름
		sta71.name = "충무로";

//			sta61.transfer = true;  //환승역이라면
		sta71.transfer = false; // 아니라면

		// station 객체 생성
		Station sta72 = new Station();

		// 호선
		sta72.line = 3;

		// 역이름
		sta72.name = "동대입구";

//			sta61.transfer = true;  //환승역이라면
		sta72.transfer = false; // 아니라면

		// station 객체 생성
		Station sta73 = new Station();

		// 호선
		sta73.line = 3;

		// 역이름
		sta73.name = "약수";

//					sta61.transfer = true;  //환승역이라면
		sta73.transfer = false; // 아니라면

		// station 객체 생성
		Station sta74 = new Station();

		// 호선
		sta74.line = 3;

		// 역이름
		sta74.name = "금호";

//					sta61.transfer = true;  //환승역이라면
		sta74.transfer = false; // 아니라면

		// station 객체 생성
		Station sta75 = new Station();

		// 호선
		sta75.line = 3;

		// 역이름
		sta75.name = "옥수";

//					sta61.transfer = true;  //환승역이라면
		sta75.transfer = false; // 아니라면

		// station 객체 생성
		Station sta76 = new Station();

		// 호선
		sta76.line = 3;

		// 역이름
		sta76.name = "압구정";

//					sta61.transfer = true;  //환승역이라면
		sta76.transfer = false; // 아니라면

		// station 객체 생성
		Station sta77 = new Station();

		// 호선
		sta77.line = 3;

		// 역이름
		sta77.name = "신사";

//					sta61.transfer = true;  //환승역이라면
		sta77.transfer = false; // 아니라면

		// station 객체 생성
		Station sta78 = new Station();

		// 호선
		sta78.line = 3;

		// 역이름
		sta78.name = "잠원";

//					sta61.transfer = true;  //환승역이라면
		sta78.transfer = false; // 아니라면

		// station 객체 생성
		Station sta79 = new Station();

		// 호선
		sta79.line = 3;

		// 역이름
		sta79.name = "고속터미널";

//					sta61.transfer = true;  //환승역이라면
		sta79.transfer = false; // 아니라면

		// station 객체 생성
		Station sta80 = new Station();

		// 호선
		sta80.line = 3;

		// 역이름
		sta80.name = "교대";

//					sta61.transfer = true;  //환승역이라면
		sta80.transfer = false; // 아니라면

		// station 객체 생성
		Station sta81 = new Station();

		// 호선
		sta81.line = 3;

		// 역이름
		sta81.name = "남부터미널";

//					sta61.transfer = true;  //환승역이라면
		sta81.transfer = false; // 아니라면

		// station 객체 생성
		Station sta82 = new Station();

		// 호선
		sta82.line = 3;

		// 역이름
		sta82.name = "양재";

//					sta61.transfer = true;  //환승역이라면
		sta82.transfer = false; // 아니라면

		// station 객체 생성
		Station sta83 = new Station();

		// 호선
		sta83.line = 3;

		// 역이름
		sta83.name = "매봉";

//					sta61.transfer = true;  //환승역이라면
		sta83.transfer = false; // 아니라면

		// station 객체 생성
		Station sta84 = new Station();

		// 호선
		sta84.line = 3;

		// 역이름
		sta84.name = "도곡";

//					sta61.transfer = true;  //환승역이라면
		sta84.transfer = false; // 아니라면

		// station 객체 생성
		Station sta85 = new Station();

		// 호선
		sta85.line = 3;

		// 역이름
		sta85.name = "대치";

//					sta61.transfer = true;  //환승역이라면
		sta85.transfer = false; // 아니라면

		// station 객체 생성
		Station sta86 = new Station();

		// 호선
		sta86.line = 3;

		// 역이름
		sta86.name = "학여울";

//					sta61.transfer = true;  //환승역이라면
		sta86.transfer = false; // 아니라면

		// station 객체 생성
		Station sta87 = new Station();

		// 호선
		sta87.line = 3;

		// 역이름
		sta87.name = "대청";

//					sta61.transfer = true;  //환승역이라면
		sta87.transfer = false; // 아니라면

		// station 객체 생성
		Station sta88 = new Station();

		// 호선
		sta88.line = 3;

		// 역이름
		sta88.name = "일원";

//					sta61.transfer = true;  //환승역이라면
		sta88.transfer = false; // 아니라면

		// station 객체 생성
		Station sta89 = new Station();

		// 호선
		sta89.line = 3;

		// 역이름
		sta89.name = "수서";

//					sta61.transfer = true;  //환승역이라면
		sta89.transfer = false; // 아니라면

		// station 객체 생성
		Station sta90 = new Station();

		// 호선
		sta90.line = 3;

		// 역이름
		sta90.name = "가락시장";

//					sta61.transfer = true;  //환승역이라면
		sta90.transfer = false; // 아니라면

		// station 객체 생성
		Station sta91 = new Station();

		// 호선
		sta91.line = 3;

		// 역이름
		sta91.name = "경찰병원";

//					sta61.transfer = true;  //환승역이라면
		sta91.transfer = false; // 아니라면

		// station 객체 생성
		Station sta92 = new Station();

		// 호선
		sta92.line = 3;

		// 역이름
		sta92.name = "오금";

		sta92.transfer = true; // 환승역이라면
//					sta92.transfer = false; //아니라면

		// ------61번~92번 연신내 -> 오금행 끝

		// station 객체 생성
		Station sta93 = new Station();

		// 호선
		sta93.line = 3;

		// 역이름
		sta93.name = "오금";

		sta93.transfer = true; // 환승역이라면
//					sta93.transfer = false; //아니라면

		// station 객체 생성
		Station sta94 = new Station();

		// 호선
		sta94.line = 3;

		// 역이름
		sta94.name = "경찰병원";

//					sta61.transfer = true;  //환승역이라면
		sta94.transfer = false; // 아니라면

		// station 객체 생성
		Station sta95 = new Station();

		// 호선
		sta95.line = 3;

		// 역이름
		sta95.name = "가락시장";

//					sta61.transfer = true;  //환승역이라면
		sta95.transfer = false; // 아니라면

		// station 객체 생성
		Station sta96 = new Station();

		// 호선
		sta96.line = 3;

		// 역이름
		sta96.name = "수서";

//					sta61.transfer = true;  //환승역이라면
		sta96.transfer = false; // 아니라면

		// station 객체 생성
		Station sta97 = new Station();

		// 호선
		sta97.line = 3;

		// 역이름
		sta97.name = "일원";

//					sta61.transfer = true;  //환승역이라면
		sta97.transfer = false; // 아니라면

		// station 객체 생성
		Station sta98 = new Station();

		// 호선
		sta98.line = 3;

		// 역이름
		sta98.name = "대청";

//					sta61.transfer = true;  //환승역이라면
		sta98.transfer = false; // 아니라면

		// station 객체 생성
		Station sta99 = new Station();

		// 호선
		sta99.line = 3;

		// 역이름
		sta99.name = "학여울";

//					sta61.transfer = true;  //환승역이라면
		sta99.transfer = false; // 아니라면

		// station 객체 생성
		Station sta100 = new Station();

		// 호선
		sta100.line = 3;

		// 역이름
		sta100.name = "대치";

//					sta61.transfer = true;  //환승역이라면
		sta100.transfer = false; // 아니라면

		// station 객체 생성
		Station sta101 = new Station();

		// 호선
		sta101.line = 3;

		// 역이름
		sta101.name = "도곡";

//					sta61.transfer = true;  //환승역이라면
		sta101.transfer = false; // 아니라면

		// station 객체 생성
		Station sta102 = new Station();

		// 호선
		sta102.line = 3;

		// 역이름
		sta102.name = "매봉";

//					sta61.transfer = true;  //환승역이라면
		sta102.transfer = false; // 아니라면

		// station 객체 생성
		Station sta103 = new Station();

		// 호선
		sta103.line = 3;

		// 역이름
		sta103.name = "양재";

//					sta61.transfer = true;  //환승역이라면
		sta103.transfer = false; // 아니라면

		// station 객체 생성
		Station sta104 = new Station();

		// 호선
		sta104.line = 3;

		// 역이름
		sta104.name = "남부터미널";

//					sta61.transfer = true;  //환승역이라면
		sta104.transfer = false; // 아니라면

		// station 객체 생성
		Station sta105 = new Station();

		// 호선
		sta105.line = 3;

		// 역이름
		sta105.name = "교대";

//					sta61.transfer = true;  //환승역이라면
		sta105.transfer = false; // 아니라면

		// station 객체 생성
		Station sta106 = new Station();

		// 호선
		sta106.line = 3;

		// 역이름
		sta106.name = "고속터미널";

//					sta61.transfer = true;  //환승역이라면
		sta106.transfer = false; // 아니라면

		// station 객체 생성
		Station sta107 = new Station();

		// 호선
		sta107.line = 3;

		// 역이름
		sta107.name = "잠원";

//					sta61.transfer = true;  //환승역이라면
		sta107.transfer = false; // 아니라면

		// station 객체 생성
		Station sta108 = new Station();

		// 호선
		sta108.line = 3;

		// 역이름
		sta108.name = "신사";

//					sta61.transfer = true;  //환승역이라면
		sta108.transfer = false; // 아니라면

		// station 객체 생성
		Station sta109 = new Station();

		// 호선
		sta109.line = 3;

		// 역이름
		sta109.name = "압구정";

//					sta61.transfer = true;  //환승역이라면
		sta109.transfer = false; // 아니라면

		// station 객체 생성
		Station sta110 = new Station();

		// 호선
		sta110.line = 3;

		// 역이름
		sta110.name = "옥수";

//					sta61.transfer = true;  //환승역이라면
		sta110.transfer = false; // 아니라면

		// station 객체 생성
		Station sta111 = new Station();

		// 호선
		sta111.line = 3;

		// 역이름
		sta111.name = "금호";

//					sta61.transfer = true;  //환승역이라면
		sta111.transfer = false; // 아니라면

		// station 객체 생성
		Station sta112 = new Station();

		// 호선
		sta112.line = 3;

		// 역이름
		sta112.name = "약수";

//					sta61.transfer = true;  //환승역이라면
		sta112.transfer = false; // 아니라면

		// station 객체 생성
		Station sta113 = new Station();

		// 호선
		sta113.line = 3;

		// 역이름
		sta113.name = "동대입구";

//					sta61.transfer = true;  //환승역이라면
		sta113.transfer = false; // 아니라면

		// station 객체 생성
		Station sta114 = new Station();

		// 호선
		sta114.line = 3;

		// 역이름
		sta114.name = "충무로";

//					sta61.transfer = true;  //환승역이라면
		sta114.transfer = false; // 아니라면

		// station 객체 생성
		Station sta115 = new Station();

		// 호선
		sta115.line = 3;

		// 역이름
		sta115.name = "을지로3가";

//					sta115.transfer = true;  //환승역이라면
		sta115.transfer = false; // 아니라면

		// station 객체 생성
		Station sta116 = new Station();

		// 호선
		sta116.line = 3;

		// 역이름
		sta116.name = "종로3가";

		sta116.transfer = true; // 환승역이라면
//					sta116.transfer = false; //아니라면

		// station 객체 생성
		Station sta117 = new Station();

		// 호선
		sta117.line = 3;

		// 역이름
		sta117.name = "안국";

//					sta61.transfer = true;  //환승역이라면
		sta117.transfer = false; // 아니라면

		// station 객체 생성
		Station sta118 = new Station();

		// 호선
		sta118.line = 3;

		// 역이름
		sta118.name = "경복궁";

//					sta61.transfer = true;  //환승역이라면
		sta118.transfer = false; // 아니라면

		// station 객체 생성
		Station sta119 = new Station();

		// 호선
		sta119.line = 3;

		// 역이름
		sta119.name = "독립문";

//					sta61.transfer = true;  //환승역이라면
		sta119.transfer = false; // 아니라면

		// station 객체 생성
		Station sta120 = new Station();

		// 호선
		sta120.line = 3;

		// 역이름
		sta120.name = "무악재";

//					sta61.transfer = true;  //환승역이라면
		sta120.transfer = false; // 아니라면

		// station 객체 생성
		Station sta121 = new Station();

		// 호선
		sta121.line = 3;

		// 역이름
		sta121.name = "홍제";

//					sta61.transfer = true;  //환승역이라면
		sta121.transfer = false; // 아니라면

		// station 객체 생성
		Station sta122 = new Station();

		// 호선
		sta122.line = 3;

		// 역이름
		sta122.name = "녹번";

//					sta61.transfer = true;  //환승역이라면
		sta122.transfer = false; // 아니라면

		// station 객체 생성
		Station sta123 = new Station();

		// 호선
		sta123.line = 3;

		// 역이름
		sta123.name = "불광";

//					sta61.transfer = true;  //환승역이라면
		sta123.transfer = false; // 아니라면

		// station 객체 생성
		Station sta124 = new Station();

		// 호선
		sta124.line = 3;

		// 역이름
		sta124.name = "연신내";

//					sta61.transfer = true;  //환승역이라면
		sta124.transfer = false; // 아니라면

		// ----93번~124번 오금 -> 연신내행 끝

		// 다음역
		sta61.next = sta62;
		sta62.next = sta63;
		sta63.next = sta64;
		sta64.next = sta65;
		sta65.next = sta66;
		sta66.next = sta67;
		sta67.next = sta68;
		sta68.next = sta69;
		sta69.next = sta70;
		sta70.next = sta71;
		sta71.next = sta72;
		sta72.next = sta73;
		sta73.next = sta74;
		sta74.next = sta75;
		sta75.next = sta76;
		sta76.next = sta77;
		sta77.next = sta78;
		sta78.next = sta79;
		sta79.next = sta80;
		sta80.next = sta81;
		sta81.next = sta82;
		sta82.next = sta83;
		sta83.next = sta84;
		sta84.next = sta85;
		sta85.next = sta86;
		sta86.next = sta87;
		sta87.next = sta88;
		sta88.next = sta89;
		sta89.next = sta90;
		sta90.next = sta91;
		sta91.next = sta92;
//		sta92.next = sta93;
		
		sta93.next = sta94;
		sta94.next = sta95;
		sta95.next = sta96;
		sta96.next = sta97;
		sta97.next = sta98;
		sta98.next = sta99;
		sta99.next = sta100;
		sta100.next = sta101;
		sta101.next = sta102;
		sta102.next = sta103;
		sta103.next = sta104;
		sta104.next = sta105;
		sta105.next = sta106;
		sta106.next = sta107;
		sta107.next = sta108;
		sta108.next = sta109;
		sta109.next = sta110;
		sta110.next = sta111;
		sta111.next = sta112;
		sta112.next = sta113;
		sta113.next = sta114;
		sta114.next = sta115;
		sta115.next = sta116;
		sta116.next = sta117;
		sta117.next = sta118;
		sta118.next = sta119;
		sta119.next = sta120;
		sta120.next = sta121;
		sta121.next = sta122;
		sta122.next = sta123;
		sta123.next = sta124;

		sta124.prev = sta123;
		sta123.prev = sta122;
		sta122.prev = sta121;
		sta121.prev = sta120;
		sta120.prev = sta119;
		sta119.prev = sta118;
		sta118.prev = sta117;
		sta117.prev = sta116;
		sta116.prev = sta115;
		sta115.prev = sta114;
		sta114.prev = sta113;
		sta113.prev = sta112;
		sta112.prev = sta111;
		sta111.prev = sta110;
		sta110.prev = sta109;
		sta109.prev = sta108;
		sta108.prev = sta107;
		sta107.prev = sta106;
		sta106.prev = sta105;
		sta105.prev = sta104;
		sta104.prev = sta103;
		sta103.prev = sta102;
		sta102.prev = sta101;
		sta101.prev = sta100;
		sta100.prev = sta99;
		sta99.prev = sta98;
		sta98.prev = sta97;
		sta97.prev = sta96;
		sta96.prev = sta95;
		sta95.prev = sta94;
		sta94.prev = sta93;
//		sta93.prev = sta92;
		
		sta92.prev = sta91;
		sta91.prev = sta90;
		sta90.prev = sta89;
		sta89.prev = sta88;
		sta88.prev = sta87;
		sta87.prev = sta86;
		sta86.prev = sta85;
		sta85.prev = sta84;
		sta84.prev = sta83;
		sta83.prev = sta82;
		sta82.prev = sta81;
		sta81.prev = sta80;
		sta80.prev = sta79;
		sta79.prev = sta78;
		sta78.prev = sta77;
		sta77.prev = sta76;
		sta76.prev = sta75;
		sta75.prev = sta74;
		sta74.prev = sta73;
		sta73.prev = sta72;
		sta72.prev = sta71;
		sta71.prev = sta70;
		sta70.prev = sta69;
		sta69.prev = sta68;
		sta68.prev = sta67;
		sta67.prev = sta66;
		sta66.prev = sta65;
		sta65.prev = sta64;
		sta64.prev = sta63;
		sta63.prev = sta62;
		sta62.prev = sta61;
		
		line11.add(sta1);
		line11.add(sta2);
		line11.add(sta3);
		line11.add(sta4);
		line11.add(sta5);
		line11.add(sta6);
		line11.add(sta7);
		line11.add(sta8);
		line11.add(sta9);
		line11.add(sta10);
		line11.add(sta11);
		line11.add(sta12);
		line11.add(sta13);
		line11.add(sta14);
		line11.add(sta15);
		line11.add(sta16);
		line11.add(sta17);
		line11.add(sta18);
		line11.add(sta19);
		line11.add(sta20);
		line11.add(sta21);
		line11.add(sta22);
		line11.add(sta23);
		line11.add(sta24);
		line11.add(sta25);
		line11.add(sta26);
		line11.add(sta27);
		line11.add(sta28);
		line12.add(sta30);
		line12.add(sta31);
		line12.add(sta32);
		line12.add(sta33);
		line12.add(sta34);
		line12.add(sta35);
		line12.add(sta36);
		line12.add(sta37);
		line12.add(sta38);
		line12.add(sta39);
		line12.add(sta40);
		line12.add(sta41);
		line12.add(sta42);
		line12.add(sta43);
		line12.add(sta44);
		line12.add(sta45);
		line12.add(sta46);
		line12.add(sta47);
		line12.add(sta48);
		line12.add(sta49);
		line12.add(sta50);
		line12.add(sta51);
		line12.add(sta52);
		line12.add(sta53);
		line12.add(sta54);
		line12.add(sta55);
		line12.add(sta56);
		line12.add(sta57);
		line12.add(sta58);
		
		line31.add(sta61);
		line31.add(sta62);
		line31.add(sta63);
		line31.add(sta64);
		line31.add(sta65);
		line31.add(sta66);
		line31.add(sta67);
		line31.add(sta68);
		line31.add(sta69);
		line31.add(sta70);
		line31.add(sta71);
		line31.add(sta72);
		line31.add(sta73);
		line31.add(sta74);
		line31.add(sta75);
		line31.add(sta76);
		line31.add(sta77);
		line31.add(sta78);
		line31.add(sta79);
		line31.add(sta80);
		line31.add(sta81);
		line31.add(sta82);
		line31.add(sta83);
		line31.add(sta84);
		line31.add(sta85);
		line31.add(sta86);
		line31.add(sta87);
		line31.add(sta88);
		line31.add(sta89);
		line31.add(sta90);
		line31.add(sta91);
		line31.add(sta92);
		line32.add(sta93);
		line32.add(sta94);
		line32.add(sta95);
		line32.add(sta96);
		line32.add(sta97);
		line32.add(sta98);
		line32.add(sta99);
		line32.add(sta100);
		line32.add(sta101);
		line32.add(sta102);
		line32.add(sta103);
		line32.add(sta104);
		line32.add(sta105);
		line32.add(sta106);
		line32.add(sta107);
		line32.add(sta108);
		line32.add(sta109);
		line32.add(sta110);
		line32.add(sta111);
		line32.add(sta112);
		line32.add(sta113);
		line32.add(sta114);
		line32.add(sta115);
		line32.add(sta116);
		line32.add(sta117);
		line32.add(sta118);
		line32.add(sta119);
		line32.add(sta120);
		line32.add(sta121);
		line32.add(sta122);
		line32.add(sta123);
		line32.add(sta124);
	}

}
//
//class Station {
//
//	public int line; //호선
//	public String name; //이름
//	public Station next; //다음역
//	public Station prev; //이전역
//	public boolean transfer; //환승여부
//}
