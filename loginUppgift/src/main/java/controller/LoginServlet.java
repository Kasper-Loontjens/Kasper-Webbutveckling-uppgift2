package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginBean;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//HttpSession httpSession = request.getSession();

		LoginBean loginBean = (LoginBean) request.getSession().getAttribute("isLoggedIn");
		String food = request.getParameter("food");
		
		loginBean.setFood(food);
		
		//httpSession.setAttribute("isLoggedIn", loginBean);
		request.setAttribute("isLoggedIn", loginBean);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/ShowLogin.jsp");
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			HttpSession httpSession = request.getSession();
			LoginBean loginBean=null;
			
			loginBean = new LoginBean();
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			loginBean.setUsername(userName);
			loginBean.checkLogin(userName, password);
			httpSession.setMaxInactiveInterval(60);
			if (loginBean.isLoggedIn()) {
				
			httpSession.setAttribute("isLoggedIn", loginBean);
			request.setAttribute("isLoggedIn", loginBean);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/ShowLogin.jsp");
			requestDispatcher.forward(request, response);
			}else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
				requestDispatcher.forward(request, response);
			}
			
	
		
		
		
		
	}

}
