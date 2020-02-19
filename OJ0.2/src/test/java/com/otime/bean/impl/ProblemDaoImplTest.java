package com.otime.bean.impl;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.otime.bean.Problem;
import com.otime.dao.impl.ProblemDaoImpl;

@SuppressWarnings("all")
public class ProblemDaoImplTest{
	ProblemDaoImpl problemDaoImpl = new ProblemDaoImpl();

	@Test
	public void test_getProblem() {
		System.out.println("test_getProblem()------------------------------");
		Problem problem = problemDaoImpl.getProblem(1);
		System.out.println(problem);
	}

	@Test
	public void test_getProblemWithSampleJudgeData() {
		System.out.println("test_getProblemWithSampleJudgeData()-----------");
		Problem problem = problemDaoImpl.getProblemWithSampleJudgeData(1);
		System.out.println(problem);
		problem.getSampleJudgeDataList().forEach(System.out::println);
	}

	@Test
	public void test_getProblemWithActualJudgeData() {
		System.out.println("test_getProblemWithActualJudgeData()-----------");
		Problem problem = problemDaoImpl.getProblemWithActualJudgeData(1);
		System.out.println(problem);
		problem.getActualJudgeDataList().forEach(System.out::println);
	}

	@Test
	public void test_getProblemWithJudgeData() {
		
	}

	@Test
	public void test_getProblems() {
		System.out.println("test_getProblems()------------------------------");
		List<Problem> problems = problemDaoImpl.getProblems();
		problems.forEach(System.out::println);
	}

	@Test
	public void test_getProblemsWthMap() {

	}

	@Test
	public void test_addProblem() {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void test_removeProblem() {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void test_updataProblem() {
		// TODO Auto-generated method stub
		
	}
}
