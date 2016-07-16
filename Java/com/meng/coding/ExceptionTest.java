package com.meng.coding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.TreeSet;

public class ExceptionTest implements Comparable
{
	public static <T> void print(T t)
	{

	}

	public static void main(String[] args) throws IOException
	{

Path source = Paths.get("/data/december/log.txt"); 
Path destination = Paths.get("/data");
Files.copy(source, destination);

		ZonedDateTime depart = ZonedDateTime.of(2015, 1, 15, 3, 0, 0, 0, ZoneId.of("UTC-7")); 
		ZonedDateTime arrive = ZonedDateTime.of(2015, 1, 15, 9, 0, 0, 0, ZoneId.of("UTC-5")); 
		long hrs = ChronoUnit.HOURS.between(depart, arrive); //line n1 
		System.out.println("Travel time is" + hrs + "hours");
		
		try (Connection conn = DriverManager.getConnection("jdbc:derby:zoo"); Statement stmt = conn.createStatement())
		{
			ResultSet rs = stmt.executeQuery("select count(*) from species");
			int num = stmt.executeUpdate("INSERT INTO species VALUES (3, 'Ant', .05)");
			rs.next();
			System.out.println(rs.getInt(1));
		}
		catch (SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try
		{
			int[][] arr = new int[5][];
			Set<String> set = new TreeSet<>();
			set.add("h20");
			set.add("H20");
			set.add("@#");
			set.add(" ");
			set.add("123");
			System.out.println(set);

			ExceptionTest.<Integer> print(1);

		}
		catch (RuntimeException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int compareTo(Object o)
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
