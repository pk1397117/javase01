package com.se.string;

public class StringAPI {

	public static void main(String[] args) {
		String s = "hello2@♣你好$侃你𝕆";
		int i = s.indexOf("你");
		int i1 = s.lastIndexOf("你");
		System.out.println(i);
		System.out.println(i1);
		int cpCount = s.codePointCount(0, s.length());
		System.out.println("length: "+s.length());//代码单元数量(𝕆占两个代码单元)
		System.out.println("cpCount: "+cpCount);//码点数(实际长度)
		int [] lastCP = {s.codePointAt(cpCount-1)};
		System.out.println(new String(lastCP,0,lastCP.length));//1𝕆
		System.out.println(Integer.toHexString(57813));
		System.out.println('\ue1d5');
		System.out.println('\u03C0');
		System.out.println("\ud835\udd46");//1𝕆
		var intStream = s.codePoints();
		int [] codePoints = intStream.toArray();
		intStream.close();
		System.out.println(codePoints[codePoints.length - 1]);
		System.out.println(Integer.toHexString(120134));
		
	}
}
