package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.LinkedList;
import java.util.List;

import dao.UserDao;
import dao.DaoException;  // ← これを追加！

import entity.User;

@WebServlet("/users/show-all")
public class ShowAllUserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/users/show-allのdogetを実行しています");
		try {

			
			UserDao test = new UserDao();
            List<User> users = test.getAll();

			/*
			String userName = users.get(0).getName();
			String userId = users.get(0).getId();
			*/

			request.setAttribute("users",users);


			
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServletException("DB処理中にエラーが発生しました", e);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/users/show-all.jsp");
		dispatcher.forward(request, response);
	}
}