package com.subway;

public class Station {

	public int line; //호선
	public String name; //이름
	public Station next; //다음역
	public Station prev; //이전역
	public boolean transfer; //환승여부
	
	@Override
	public String toString() {
		String str = String.format("line: %d\tname: %s\tnext.name: %s\t prev.name: %s", line,name,next.name,prev.name);
		return str;
	}
	
}
