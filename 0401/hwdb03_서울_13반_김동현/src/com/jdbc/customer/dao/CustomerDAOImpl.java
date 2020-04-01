package com.jdbc.customer.dao;
//dao(data access object: Create(insert),Read(select),Update,Delete)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jdbc.customer.vo.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/harry?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String user = "ssafy";
	String password = "ssafy";

	public CustomerDAOImpl() {
//		1. Driver 등록
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() { // Connection 생성해서 리턴
//		2. Connection 연결
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public void close(Connection con, Statement stat, PreparedStatement pst) { // Connectio close
		try {
			if (pst != null)
				pst.close();
			if (stat != null)
				stat.close();
			if (con != null)
				con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Customer> findAll() {
		Connection con = getConnection();
		String sql = "select * from customer";
		ArrayList<Customer> list = new ArrayList<>();
		Statement st = null;

		try {
//			3. Statement 생성 (Query 한 개 담을 수 있는 그릇)
			st = con.createStatement();

//			4. Query 실행(Statement의 담아서 실행, 결과 리턴)
			ResultSet rs = st.executeQuery(sql); // 실행 쿼리문이 select 일때

//			5. 결과처리
			while (rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);

				list.add(new Customer(Integer.parseInt(num), name, address));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, st, null);
		}
		return list;
	}

	@Override
	public Customer findByNum(String num) {
		Connection con = getConnection();
		String sql = "select * from customer where num= ?";
		PreparedStatement pst = null;
		Customer customer = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(num));

			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
				int temp_num = Integer.parseInt(rs.getString(1));
				String temp_name = rs.getString(2);
				String temp_address = rs.getString(3);
				customer = new Customer(temp_num, temp_name, temp_address);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("num검색 pst 에러");
		} finally {
			close(con, null, pst);
		}
		return customer;
	}

	@Override
	public ArrayList<Customer> findByAddress(String address) {
		Connection con = getConnection();
		PreparedStatement pst=null;
		ResultSet rs= null;
		ArrayList<Customer> list= new ArrayList<>();
		String sql="select * from customer where address=?";
		
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, address);
			
			rs=pst.executeQuery();
			
			while(rs.next()) {
				int temp_num=Integer.parseInt(rs.getString(1));
				String temp_name=rs.getString(2);
				String temp_address=rs.getString(3);
				list.add(new Customer(temp_num,temp_name,temp_address));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con, null, pst);
		}
			
		return list;
	}

	@Override
	public int insert(Customer c) {
		Connection con = getConnection();
		PreparedStatement pst=null;
		String sql="insert into customer(num,name,address) values(?,?,?)";
		int num=0;
		
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, c.getNum());
			pst.setString(2, c.getName());
			pst.setString(3, c.getAddress());
			
			num=pst.executeUpdate();
			System.out.println(c+"추가 완료");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}

	@Override
	public int delete(String num) {
		Connection con = getConnection();
		PreparedStatement pst=null;
		String sql="delete from customer where num=?";
		int delete_num=0;
		
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(num));
			delete_num=pst.executeUpdate();
			System.out.println("삭제 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con, null, pst);
		}
		
		return delete_num;
	}

	@Override
	public int update(Customer c) {
		Connection con = getConnection();
		PreparedStatement pst= null;
		String sql="update customer set name=?,address=? where num=?";
		int update_num=0;
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, c.getName());
			pst.setString(2, c.getAddress());
			pst.setInt(3, c.getNum());
			
			update_num=pst.executeUpdate();
			System.out.println(c+"수정 완료");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return update_num;
	}

}
