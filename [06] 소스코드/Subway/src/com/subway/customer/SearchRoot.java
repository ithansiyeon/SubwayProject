package com.subway.customer;

import java.util.ArrayList;
import java.util.Scanner;

import com.subway.CreateStation;
import com.subway.Station;

public class SearchRoot {

	private static Scanner scan = new Scanner(System.in);
	
	public static ArrayList<Station> line11 = new ArrayList<Station>(); // 구로-도봉산
	public static ArrayList<Station> line12 = new ArrayList<Station>(); // 도봉산-구로
	public static ArrayList<Station> line31 = new ArrayList<Station>(); // 연신내-오금
	public static ArrayList<Station> line32 = new ArrayList<Station>(); // 오금-연신내
	public static ArrayList<Station> line51 = new ArrayList<Station>(); // 까치산-마천
	public static ArrayList<Station> line52 = new ArrayList<Station>(); // 마천-까치산

	public static ArrayList<Station> translist = new ArrayList<Station>(); //환승역 후보 list
	
	private static Station staStart = new Station(); //출발역 
	private static Station staEnd = new Station(); //도착역 
	private static Station statransfer = new Station(); //환승역 
	
	private static int cnt = 0; //지나치는 역 개수
	
	private static ArrayList<String> resultlist = new ArrayList<String>(); //탐색 결과를 담을 list
	private static String totalResult = new String(); //가장 짧은 환승 구간
	
	 public static void main(String[] args) {
	 	inputStation();
	 }
	
	
	
	private static void inputStation() {
		//고객에게 출발역,도착역 입력 받기
		
		CreateStation.create();
		
		line11 = CreateStation.line11;
		line12 = CreateStation.line12;
		line31 = CreateStation.line31;
		line32 = CreateStation.line32;
		line51 = CreateStation.line51;
		line52 = CreateStation.line52;
		
		System.out.print("\t\t\t호선,출발역을 입력하세요 : ");
		String start = scan.nextLine();
		System.out.print("\t\t\t호선,도착역을 입력하세요 : ");
		String end = scan.nextLine();
		
		//호선, 역 유효성검사
		if(exist(start,1)) {
			if(exist(end,2)) {
				//역 둘다 있음
				//호선 같은지 확인하기
				compareLine();
			} else {
				//도착역 없음
				System.out.println("\t\t\t도착역을 잘못 입력하셨습니다.");
			}
		} else {
			//출발역 없음
			System.out.println("\t\t\t출발역을 잘못 입력하셨습니다.");
		}
		
		
		

	}//inputStation()



	private static void compareLine() {
		// 출발역, 도착역 호선 같은지 비교
		
		if(staStart.line == staEnd.line) {
			//같은 호선에서 경로 탐색
			sameRoot();
			
		}else {
			//환승역 찾기
			searchTransfer();
		}
		
		
	}//compareLine()

	private static void searchTransfer() {
		//환승역 찾기
	
		int sline = staStart.line; //1
		int eline = staEnd.line; //3
		
		ArrayList<String> names = new ArrayList<String>();//출발역 호선의 모든 역 이름
		
		//1. 우선 출발역 호선의 모든 역 이름을 저장한다.
		
		if(sline == 1) {
			for(int i=0; i<line11.size(); i++) {
				names.add(line11.get(i).name);
			}			
		} else if(sline == 3) {
			for(int i=0; i<line31.size(); i++) {
				names.add(line31.get(i).name);
			}
		}else if(sline == 5) {
			for(int i=0; i<line51.size(); i++) {
				names.add(line51.get(i).name);
			}
		}
		
//		System.out.println("names : " + names.toString());
		
		//2. 도착역 호선의 모든 역이름과 1에서 저장한 이름을 비교해서 맞으면 환승역list에 객체로 저장한다.
		if(eline == 1) {
			for(int i=0; i<line11.size();i++) {
				for(int j=0; j<names.size(); j++) {
					if(line11.get(i).name.equals(names.get(j))) {

						translist.add(line11.get(i));
					}
				}
			}
		} else if(eline == 3) {
			for(int i=0; i<line31.size();i++) {
				for(int j=0; j<names.size(); j++) {
					if(line31.get(i).name.equals(names.get(j))) {
						translist.add(line31.get(i));
					}
				}
			}
		} else if(eline == 5) {
			for(int i=0; i<line51.size();i++) {
				for(int j=0; j<names.size(); j++) {
					if(line51.get(i).name.equals(names.get(j))) {
						translist.add(line51.get(i));

					}
				}
			}
		}
		
		
//		System.out.println("translist : " + translist.toString());
		
			
		//3. 출발역에서 모든 환승역까지의 역 카운트를 센다.
		boolean flag = true;
		Station sta = staStart;
		int c  = 0;
		while(flag) {
			sta = sta.next;
			for(int i=0; i<translist.size(); i++) {
				if(sta.name.equals(translist.get(i).name)) {
					//4. 모든 환승역에서 도착역까지의 역 카운트를 센다.
//					System.out.println(translist.get(i).toString());
					
					transToEnd(translist.get(i),cnt);
					c++;
				}
			}
			cnt++;
			
			if(c == translist.size()) {
				flag = false;
			}
		}//while
		
		
		//5. 그렇게 나온 경우의 수들 중에 제일 카운트가 낮은 것을 출력한다.
		int num = 100;
		int index = 0;
		
//		System.out.println(resultlist.size());
		
		for(int i=0; i<resultlist.size(); i++) {
			String[] arr = resultlist.get(i).split("!");
			
			if(num > Integer.parseInt(arr[1])) {
				
				num = Integer.parseInt(arr[1]);
				index = i;
			}
		}
		
//		System.out.println(resultlist.get(index));
		String[] arr = resultlist.get(index).split("!");
		totalResult = arr[0];
		
		//6. 출력하기
		printRoot(2);
		
		
	}//searchTransfer()



	private static void transToEnd(Station staTrans,int cnt2) {
		// 환승역에서 도착역까지의 역 카운트를 센다.
		
		boolean flag = true;
		
		Station sta = staTrans;
		
		while(flag) {
			sta = sta.next;
//			System.out.println(sta.name + ", " + staEnd.name);
			if(sta.name.equals(staEnd.name)) {
				flag = false;
			}
			cnt2++;
		}
		
		String result = String.format("\t\t\t%3d\t%4s   ---> %3d\t%4s  ---> %3d\t%4s\t  %d분!%d"
								,staStart.line,staStart.name,staTrans.line,staTrans.name,staEnd.line,staEnd.name,(cnt2*2)+8,cnt2);
		resultlist.add(result);
		
	}//transToEnd()



	private static void sameRoot() {
		//같은 호선일 경우, 호선 가려내기
		Station sta = staStart;
		boolean flag = true;
		while(flag) {
			sta = sta.next;
//			System.out.println(sta.name + "," + staEnd.name);
			if(sta.name.equals(staEnd.name)) {
				//도착역 찾음
				flag=false;
			}
			cnt++;
		}
		
		//경로 출력하기
		printRoot(1);
		
	}//sameRoot()



	private static void printRoot(int num) {
		//경로 출력하기
		
		if(num == 1) {
			System.out.println("\t\t\t[호선]\t[출발역] ---> [호선]\t[도착역]\t[총 소요시간]");
			System.out.printf("\t\t\t%3d\t%4s   --->  %2d\t%4s \t  %d분\n",staStart.line, staStart.name,staEnd.line,staEnd.name,(cnt*2));
		} else {
			System.out.println("\t\t\t[호선]\t[출발역] ---> [호선]\t[환승역] ---> [호선]\t[도착역] [총 소요시간]");
			System.out.printf("%s\n",totalResult);
		}
		
	}//printRoot



	private static boolean exist(String str, int num) {
		//호선, 역 유효성검사
		String[] st = str.split(",");
		int line = Integer.parseInt(st[0]);
		String name = st[1];
		
		
		if(line == 1 || line == 3 || line == 5) {
			if(num == 1) {
				saveStation(line,name,staStart);	
			} else if(num == 2){
				saveStation(line,name,staEnd);									
			}
			return true;
		} else {
			return false;			
		}

	}//exist()


	private static void saveStation(int line, String name, Station sta) {
		//호선과 이름에 맞는 객체 찾아서 변수에 저장
		
		if (line == 1) {
			for (Station s : line11) {
				if (s.name.equals(name)) {
					sta.line = s.line;
					sta.name = s.name;
					sta.next = s.next;
					sta.prev = s.prev;
				}
			}
		} else if (line == 3) {
			for (Station s : line31) {
				if (s.name.equals(name)) {
					sta.line = s.line;
					sta.name = s.name;
					sta.next = s.next;
					sta.prev = s.prev;
				}
			}
		} else if (line == 5) {
			for (Station s : line51) {
				if (s.name.equals(name)) {
					sta.line = s.line;
					sta.name = s.name;
					sta.next = s.next;
					sta.prev = s.prev;
				}
			}
		} // if_line
	}// saveStation()

}
