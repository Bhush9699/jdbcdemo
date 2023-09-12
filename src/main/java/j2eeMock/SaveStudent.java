package j2eeMock;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;

@WebServlet("/saveStudent")
public class SaveStudent extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		long mobilenumber=Long.parseLong(req.getParameter("mobilenumber"));
		int yop =Integer.parseInt(req.getParameter("yop"));
		String stream=req.getParameter("stream");
	
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eemock", "root", "MySql");
			PreparedStatement ps=cn.prepareStatement("insert into admin(id,name,age,mobilenumber,yop,stream) values(?,?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2,name);
			ps.setInt(3,age);
			ps.setLong(4,mobilenumber);
			ps.setInt(5, yop);
			ps.setString(6, stream);
			ps.execute();
			RequestDispatcher rd=req.getRequestDispatcher("operation.jsp");
			rd.forward(req, res);
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
