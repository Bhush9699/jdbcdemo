package j2eeMock;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveAdmin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Cookie cookie1=new Cookie("email",email);
		Cookie cookie2=new Cookie("password", password);
		resp.addCookie(cookie2);
		resp.addCookie(cookie1);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eemock", "root", "MySql");
			PreparedStatement ps=cn.prepareStatement("insert into admin(id,email,password) values(?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.execute();
			RequestDispatcher rd=req.getRequestDispatcher("operation.jsp");
			rd.forward(req, resp);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
