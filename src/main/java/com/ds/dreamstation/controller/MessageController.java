package com.ds.dreamstation.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ds.dreamstation.dto.MemberSession;
import com.ds.dreamstation.dto.MessageInfo;
import com.ds.dreamstation.dto.Pages;
import com.ds.dreamstation.po.Message;
import com.ds.dreamstation.service.IMessageService;

/**
 * @author phn
 * @date 2015-5-28
 * @email 1016593477@qq.com
 * @TODO
 */
@RequestMapping(value = "message/")
@Controller
public class MessageController {

	@Resource
	private IMessageService messageService;

	@RequestMapping(value = "list")
	public String sList(
			@RequestParam(required = false, defaultValue = "1") int current,
			HttpServletRequest req) {
		Map<String, Object> map = this.messageService.paging(current, 10,
				(byte) 1);
		req.setAttribute("listMessageInfo",
				(ArrayList<MessageInfo>) map.get("listMessageInfo"));
		req.setAttribute("pageBean", (Pages) map.get("pageBean"));
		return "show/messageList";
	}
	@RequestMapping(value = "manage/go-reply")
	public String goReply(
			@RequestParam(required = false, defaultValue = "1") int current,@RequestParam(required=false,defaultValue="3")byte status,
			HttpServletRequest req) {
		Map<String, Object> map = this.messageService.paging(current, 10,
				status);
		req.setAttribute("listMessageInfo",
				(ArrayList<MessageInfo>) map.get("listMessageInfo"));
		req.setAttribute("pageBean", (Pages) map.get("pageBean"));
		req.setAttribute("status",status);
		return "manage/messageReply";
	}
	@RequestMapping(value = "manage/list")
	public String mList(
			@RequestParam(required = false, defaultValue = "1") int current,@RequestParam(required=false,defaultValue="3")byte status,
			HttpServletRequest req) {
		Map<String, Object> map = this.messageService.paging(current, 10,
				status);
		req.setAttribute("listMessageInfo",
				(ArrayList<MessageInfo>) map.get("listMessageInfo"));
		req.setAttribute("pageBean", (Pages) map.get("pageBean"));
		req.setAttribute("status",status);
		return "manage/messageList";
	}
	@RequestMapping(value = "add")
	public String add(MessageInfo messageInfo) {
		Message message = new Message();
		message.setmCommentName(messageInfo.getCommentName());
		message.setmCommentContent(messageInfo.getCommentContent());
		message.setmCommentEmail(messageInfo.getCommentEmail());
		message.setmCommentTime(new Date());
		boolean flag = this.messageService.add(message);
		if(flag){
			return "redirect:/message/list";
		}else{
			return "redirect:/manage/fail";
		}
	}
	@RequestMapping(value = "manage/reply")
	public String reply(MessageInfo messageInfo,HttpServletRequest req){
		HttpSession session = req.getSession();
		MemberSession memberSession = (MemberSession) session
				.getAttribute("memberSession");
		Message message = this.messageService.find(messageInfo.getId());
		message.setmReplyContent(messageInfo.getReplyContent());
		message.setmReplyName(memberSession.getName());
		message.setmStatus(messageInfo.getStatusNumber());
		message.setmReplyTime(new Date());
		boolean flag  = this.messageService.reply(message);
		if(flag){
			return "redirect:/message/manage/list";
		}else{
			return "redirect:/manage/fail";
		}
	}
	@RequestMapping(value="manage/remove")
	public String remove(int id){
		this.messageService.remove(id);
		return "redirect:/message/manage/list";
	}
	@RequestMapping(value="manage/removes")
	public String removes(int[] ids){
		for(int id : ids){
			this.messageService.remove(id);
		}
		return "redirect:/message/manage/list";
	}
}
