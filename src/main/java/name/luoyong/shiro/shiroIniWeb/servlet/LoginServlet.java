package name.luoyong.shiro.shiroIniWeb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

@WebServlet(urlPatterns="/login")
public class LoginServlet extends HttpServlet {
	
	private static final String loginJspUrl = "/login.jsp";
	private static final String loginSuccessJspUrl = "/loginSuccess.jsp";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Subject subject = SecurityUtils.getSubject();
		
		if(subject.isAuthenticated()) {
			request.getRequestDispatcher(loginSuccessJspUrl).forward(request, response);
			return;
		}
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		
		String loginErrorMsg = null;
		
		try {
			subject.login(token);
		} catch(UnknownAccountException e) {
			loginErrorMsg = "查无此人！";
		} catch(IncorrectCredentialsException e) {
			loginErrorMsg = "密码错误！";
		} catch(AuthenticationException e) {
			loginErrorMsg = "登陆失败！";
		}
		
		request.setAttribute("loginErrorMsg", loginErrorMsg);
		
		if(subject.isAuthenticated()) {
			request.getRequestDispatcher(loginSuccessJspUrl).forward(request, response);
			return;
		} else {
			request.getRequestDispatcher(loginJspUrl).forward(request, response);
			return;
		}
	}

}
