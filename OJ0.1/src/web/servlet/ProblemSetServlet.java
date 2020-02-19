package web.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.TestDataBase;
import entity.Problem;


@WebServlet("/problemSet")
public class ProblemSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Vector<Problem> problemSet = new Vector<Problem>();
		problemSet = TestDataBase.readProblemSet();
		//System.out.println("problemSet:" + problemSet);
		request.setAttribute("problemSet", problemSet);
		request.getRequestDispatcher("problemSet.jsp").forward(request, response);
	}

}
