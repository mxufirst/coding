package com.meng.coding;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Sparrow extends Bird{}
class LittleSparrow extends Sparrow{}
class Bird{}

public class EnumTest
{

	class Inner {
		public String toString(){
			return "C";
		}
		
	}
	
	enum Type {
		A(1){
			public void print(){
				System.out.println("A");
			}
			
		}, B(2) {
			@Override
			public void print()
			{
				// TODO Auto-generated method stub
				
			}
		};
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
		
		public void setO(int i) {
			o = i;
		}
		
		public abstract void print();
	}
	
	
	
	public static void main(String[] args) throws IOException
	{
		System.out.println(Type.A.getS());
		Type.A.print();
		Type.B.setO(3);
		Inner inner;
		new EnumTest().new Inner().toString();
		System.out.println(Type.B.getO());
		System.out.println();
		int num = 16;
		System.out.println((num & num - 1) == 0 && (num & 0x55555555) == 0);
		List<? super Bird> list = new ArrayList<>();
		list.add(new Bird());
		list.add(new Sparrow());
		
		Path f1 = Paths.get("/home");
		
		try (InputStream in = new FileInputStream(""); InputStream in2 = new FileInputStream("")) {
			
		}
		
		Integer i;
		Stream<Integer> s = Stream.of(1,2,3);
		OptionalInt o = IntStream.range(1,5).max();
		

	}

}
