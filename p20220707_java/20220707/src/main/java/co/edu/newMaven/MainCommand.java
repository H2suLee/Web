package co.edu.newMaven;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.newMaven.comm.Command;

public class MainCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 구냥 시작페이지를 보여주는..
		return "main/main";
	}

}
