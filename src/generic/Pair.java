package generic;

import java.util.ArrayList;
import java.util.List;

//ºÚµ•∑∫–Õ¿‡
public class Pair<T> {

	private T first;
	private T second;
	
	Pair(){
		first = null;
		second = null;
	}
	
	Pair(T first,T second){
		this.first = first;
		this.second = second;
	}
	
	public T getFirst() {
		return first;
	}
	
	public void setFirst(T first) {
		this.first = first;
	}
	
	public T getSecond() {
		return second;
	}
	
	public void setSecond(T second) {
		this.second = second;
	}
}
