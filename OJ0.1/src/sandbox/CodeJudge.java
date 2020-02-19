package sandbox;

import java.util.Vector;

import exception.MyException;

public interface CodeJudge {
	Vector<String> judgeCode(int problemId, int userId, String code) throws MyException;
}
