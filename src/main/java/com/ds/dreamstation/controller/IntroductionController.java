package com.ds.dreamstation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author phn
 * @date 2015-6-2
 * @email 1016593477@qq.com
 * @TODO 
 */
@Controller("introductionController")
@RequestMapping("introduction")
public class IntroductionController {
	@RequestMapping(value="")
	public String introduction(){
		return "show/introduction";
	}
}
