package web.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.TestDataBase;
import entity.JudgeData;
import entity.Problem;


@WebServlet("/problemSubmit")
public class ProblemSubmitServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = "";
		try{
			Vector<JudgeData> sampleData = new Vector<JudgeData>();
			Vector<JudgeData> testData = new Vector<JudgeData>();
			
			
			String title = req.getParameter("title");
			String description = req.getParameter("description");
			String inputFormat = req.getParameter("inputFormat");
			String outputFormat = req.getParameter("outputFormat");
			String timeLimit = req.getParameter("timeLimit");
			String memoryLimit = req.getParameter("memoryLimit");
			
			try{
				for(int i = 1; true; i++){
					String sampleDataIn = req.getParameter("sampleData" + i + "In");
					String sampleDataOut = req.getParameter("sampleData" + i + "Out");
					if(sampleDataIn.isEmpty())
						break;
					sampleData.add(new JudgeData(sampleDataIn, sampleDataOut));
				}
			}catch(Exception e){
			}
			
			try{
				for(int i = 1; true; i++){
					String testDataIn = req.getParameter("testData" + i + "In");
					String testDataOut = req.getParameter("testData" + i + "Out");
					if(testDataIn.isEmpty())
						break;
					testData.add(new JudgeData(testDataIn, testDataOut));
				}
			}catch(Exception e){
			}
			
			Problem problem = new Problem();
			problem.setTitle(title);
			problem.setDescription(description);
			problem.setInputFormat(inputFormat);
			problem.setOutputFormat(outputFormat);
			problem.setTimeLimit(Integer.valueOf(timeLimit));
			problem.setMemoryLimit(Integer.valueOf(memoryLimit));
			problem.setSampleData(sampleData);
			problem.setTestData(testData);
			TestDataBase.writeProblem(problem);
			System.out.println("PB Sub:" + problem);
			msg = "提交成功";
		}catch(Exception e){
			msg = "输入数据有误";
		}
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("msg.jsp").forward(req, resp);
	}
}
