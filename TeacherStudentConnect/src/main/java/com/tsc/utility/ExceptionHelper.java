package com.tsc.utility;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/** Global exception Handler class to format the exception stacktrace 
 * and display it in the frontend
 * @author Arpita Datta
 *
 */
@ControllerAdvice
public class ExceptionHelper {
	
	
	@ExceptionHandler(value = { Exception.class })
	public ModelAndView showError(Exception exception, HttpServletRequest req) {
		ModelAndView model = new ModelAndView("error");
		model.addObject("errorMsg", exception.getMessage());
		
		
		StringWriter writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter( writer );
		exception.printStackTrace( printWriter );
		printWriter.flush();

		model.addObject("errorTrace",writer.toString());
		
		model.addObject("user",req.getSession().getAttribute("user"));
		
		return model;
		
	}

}
