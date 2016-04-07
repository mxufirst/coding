package com.meng.coding;

public class EnumTest
{

	enum Type {
		A(1), B(2);
		Type(int n) {
			s = n == 1 ? "A" : "B";
			o = n;
		}
		private String s;
		private Integer o;
		public String getS(){
			return s;
		}
		public Integer getO() {
			return o;
		}
	}
	
	
	
	public static void main(String[] args)
	{
		System.out.println(Type.A.getS());
		System.out.println(Type.B.getO());

	}

}
