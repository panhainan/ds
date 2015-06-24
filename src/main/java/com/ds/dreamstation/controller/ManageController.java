package com.ds.dreamstation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author phn
 * @date 2015-5-20
 * @email 1016593477@qq.com
 * @TODO
 */
@RequestMapping(value = "manage/")
@Controller
public class ManageController {
	@RequestMapping(value = "main/top")
	public String top() {
		return "manage/top";
	}

	@RequestMapping(value = "main/left")
	public String left() {
		return "manage/left";
	}

	@RequestMapping(value = "main")
	public String main() {
		return "manage/main";
	}

	@RequestMapping(value = "register-succeeded")
	public String registerSuccess() {
		return "show/registerSuccess";
	}

	@RequestMapping(value = "register-failed")
	public String registerFail(HttpServletRequest req) {
		req.setAttribute("message", "该邮箱已经被注册，请更换邮箱，或者直接登录！");
		return "show/register";
	}

	@RequestMapping(value = "login-failed")
	public String loginFail(HttpServletRequest req) {
		req.setAttribute("message", "用户名或密码错误，请重新输入！");
		return "show/login";
	}

	@RequestMapping(value = "not-have-authority")
	public String operateFail() {
		return "manage/notHaveAuthority";
	}

	@RequestMapping(value = "fail")
	public String fail() {
		return "show/fail";
	}

	@RequestMapping(value = "off-line")
	public String offLine() {
		return "manage/offLine";
	}
	@RequestMapping(value = "mail")
	public String mail(){
		return "manage/mail";
	}
}
