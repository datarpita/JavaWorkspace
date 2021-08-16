package com.tsc.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tsc.dao.LoginDao;
import com.tsc.entity.User;
import com.tsc.service.LoginFuncIntService;

/** This class is used to authenticate the user 
 * 
 * @author Arpita Datta
 *
 */

@Controller
public class LoginController {
	
	@Autowired
	private LoginDao loginDao;
	
	/** To redirect to the login page 
	 * 
	 * @param model
	 * @return : Login page
	 */
	@GetMapping(path="/")
	public String showIndex(Model model) {
		User sessionuser = new User();
		model.addAttribute("user",sessionuser);
		return "index";
		
	}

	/** To validate the user, retrieve the password
	 * of the user and check the correctness
	 * @param user
	 * @param req
	 * @param result
	 * @return : Home page if authentication is successful otherwise Login page with appropriate error message
	 */
	@PostMapping(path="/login")
	public String validate(@ModelAttribute @Valid User user, HttpServletRequest req, BindingResult result) {
		
		System.out.println("Username-->" + user.getUsername());
		System.out.println("Password-->" + user.getPassword());
		if (!result.hasErrors()) {
			
			LoginFuncIntService service = (loginuser, loginDao) -> {
				
				Optional<User> loggedInUser =  loginDao.findByUsername(loginuser.getUsername());
				if (loggedInUser.isPresent() && loggedInUser.get().getPassword().equalsIgnoreCase(loginuser.getPassword())) {
					return true;
				}
				return false;
			};
			
			if (user.getUsername() != null && !user.getUsername().isEmpty()					
					&& user.getPassword() != null && !user.getPassword().isEmpty()) {
				if (service.isValid(user, loginDao)) {	
					req.getSession().setAttribute("user", user);
					return "home";
				}else {
					result.addError(new ObjectError("user.username", "Invalid authentication"));
				}
					
			}else {
				result.addError(new ObjectError("user.username", "Either username/password is empty"));
			}
		}		
		return "index";
	}
	
	
	/** To log the user out and redirect back 
	 *  to Login page
	 * @param req
	 * @param model
	 * @return : Login page
	 */
	@GetMapping(path="/logout")
	public String logout(HttpServletRequest req, Model model) {
		req.getSession().invalidate();		
		User sessionuser = new User();
		model.addAttribute("user",sessionuser);
		return "index";
		
	}

}
