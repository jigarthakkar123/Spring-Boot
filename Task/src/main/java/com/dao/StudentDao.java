package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Standard;
import com.bean.Student;
import com.util.StudentUtil;

public class StudentDao {

	public static void insertStandard(Standard s)
	{
		try {
			Connection conn=StudentUtil.createConnection();
			String sql="insert into tblstandard(name,status) values(?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setString(2, s.getStatus());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void insertStudent(Student s)
	{
		try {
			Connection conn=StudentUtil.createConnection();
			String sql="insert into tblstudent(sid,fname,lname,dob,created_date,image) values(?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, s.getSid());
			pst.setString(2, s.getFname());
			pst.setString(3, s.getLname());
			pst.setString(4, s.getDob());
			pst.setString(5, s.getCreated_date());
			pst.setString(6, s.getImage());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Standard> getAllStandard()
	{
		List<Standard> list=new ArrayList<Standard>();
		try {
			Connection conn=StudentUtil.createConnection();
			String sql="select * from tblstandard";
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Standard s=new Standard();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setStatus(rs.getString("status"));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static Standard getStandard(int id)
	{
		Standard s=null;
		try {
			Connection conn=StudentUtil.createConnection();
			String sql="select * from tblstandard where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				s=new Standard();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setStatus(rs.getString("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	public static List<Student> getAllStudent()
	{
		List<Student> list=new ArrayList<Student>();
		try {
			Connection conn=StudentUtil.createConnection();
			String sql="select * from tblstudent";
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Student s=new Student();
				s.setId(rs.getInt("id"));
				s.setSid(rs.getInt("sid"));
				s.setFname(rs.getString("fname"));
				s.setLname(rs.getString("lname"));
				s.setDob(rs.getString("dob"));
				s.setCreated_date(rs.getString("created_date"));
				s.setImage(rs.getString("image"));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
