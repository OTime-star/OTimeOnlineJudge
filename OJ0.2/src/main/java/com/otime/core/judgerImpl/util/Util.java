package com.otime.core.judgerImpl.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Util {
	private static String RootPath = "D:/OnlineJudgeFile";
	public static String sourceCodeFilePath = RootPath + "/SourceFile/";
	public static String ObjectCodeFilePath = RootPath + "/ClassFile";
	public static String inputFilePath = RootPath + "/InputFile/";
	public static String outputFilePath = RootPath + "/OutputFile/";

	public static String readFile(String file) {
		String data = "";
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			while ((line = br.readLine()) != null) {
				data += line + "\n";
			}
		} catch (IOException e) {
			System.out.println("Util: " + file + "not Found");
		}
		return data;
	}

	public static void writeFile(String data, String file) {
		writeFile(data, file, false);
	}

	public static void writeFile(String data, String file, boolean append) {
		try (Writer writer = new FileWriter(file, append)) {
			BufferedWriter out = new BufferedWriter(writer);
			out.write(data);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
