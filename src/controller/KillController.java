package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	public String getOS() {
		String os = System.getProperty("os.name");
		return os;
	}
		
	public void listProcess(String os) {
		String process;
		if (os.contains("Windows")) {
			process = "TASKLIST /FO TABLE";
			readProcess(process);
		}else {
			process = "ps -ef";
			readProcess(process);
		}
	
	}
	
	public void killpid(String os,int pid){
		String process;
		if (os.contains("Windows")) {
			process = "TASKKILL /PID "+ pid;
			readProcess(process);
		}else {
			process = "kill -9 "+ pid;
			readProcess(process);
		}
	}

	public void killpidbyname(String os, String name){
		String process;
		if (os.contains("Windows")) {
			process = "TASKKILL /PID "+ name;
			readProcess(process);
		}else {
			process = "pkill -f "+ name;
			readProcess(process);
		}
	}
	
	public void readProcess(String process) {
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				linha = buffer.readLine();
				System.out.println(linha);
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
	}

}