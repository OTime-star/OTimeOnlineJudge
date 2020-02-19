package web.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.MyException;
import sandbox.JavaCodeJudge;

@WebServlet("/codeSubmit")
public class CodeSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JavaCodeJudge codeJudge = new JavaCodeJudge();   
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String problemIdS = request.getParameter("problemId");
		String code = request.getParameter("code");
		int problemId = Integer.valueOf(problemIdS);
		
		try{
			Vector<String> resultVec = codeJudge.judgeCode(problemId, 1, code);
			System.out.println("servlet:" + resultVec);
			
			request.setAttribute("resultVec", resultVec);
			
			request.getRequestDispatcher("runResult.jsp").forward(request, response);
		}catch(MyException e){
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

}
