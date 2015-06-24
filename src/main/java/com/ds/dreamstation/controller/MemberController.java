package com.ds.dreamstation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ds.dreamstation.dto.AuthorityForm;
import com.ds.dreamstation.dto.MailType;
import com.ds.dreamstation.dto.MemberInfo;
import com.ds.dreamstation.dto.MemberSession;
import com.ds.dreamstation.dto.Pages;
import com.ds.dreamstation.po.Authority;
import com.ds.dreamstation.po.Member;
import com.ds.dreamstation.service.IMailService;
import com.ds.dreamstation.service.IMemberService;
import com.ds.dreamstation.util.FileUpload;

/**
 * @author phn
 * @date 2015-5-20
 * @email 1016593477@qq.com
 * @TODO
 */
@RequestMapping(value = "member")
@Controller
public class MemberController {
	@Resource
	private IMemberService memberService;
	@Resource
	private IMailService mailService;

	@RequestMapping(value = "")
	public String member(HttpServletRequest req) {
		return "show/members";
	}

	@RequestMapping(value = "/teacher/list")
	public String teacher(
			@RequestParam(required = false, defaultValue = "1") int current,
			HttpServletRequest req) {
		int size = 12;
		// 导师的类别为3
		int category = 3;
		Map<String, Object> map = this.memberService.paging(current, size,
				category);
		List<MemberInfo> listTeacherInfo = (ArrayList<MemberInfo>) map
				.get("listMemberInfo");
		req.setAttribute("listTeacherInfo", listTeacherInfo);
		req.setAttribute("pageBean", (Pages) map.get("pageBean"));
		return "show/teacher";
	}

	@RequestMapping(value = "/programmer/list")
	public String programmer(
			@RequestParam(required = false, defaultValue = "1") int current,
			HttpServletRequest req) {
		int size = 12;
		// 程序员的类别为1
		int category = 1;
		Map<String, Object> map = this.memberService.paging(current, size,
				category);
		List<MemberInfo> listProgrammerInfo = (ArrayList<MemberInfo>) map
				.get("listMemberInfo");
		req.setAttribute("listProgrammerInfo", listProgrammerInfo);
		req.setAttribute("pageBean", (Pages) map.get("pageBean"));
		return "show/programmer";
	}

	@RequestMapping(value = "/designer/list")
	public String designer(
			@RequestParam(required = false, defaultValue = "1") int current,
			HttpServletRequest req) {
		int size = 12;
		// 设计师的类别为2
		int category = 2;
		Map<String, Object> map = this.memberService.paging(current, size,
				category);
		List<MemberInfo> listDesignerInfo = (ArrayList<MemberInfo>) map
				.get("listMemberInfo");
		req.setAttribute("listDesignerInfo", listDesignerInfo);
		req.setAttribute("pageBean", (Pages) map.get("pageBean"));
		return "show/designer";
	}

	@RequestMapping(value = "/look")
	public String sLook(int id, HttpServletRequest req) {
		MemberInfo memberInfo = new MemberInfo(this.memberService.find(id));
		req.setAttribute("memberInfo", memberInfo);
		return "show/member";
	}

	@RequestMapping(value = "/go-register")
	public String goRegister() {
		return "show/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(MemberInfo memberInfo) {
		Member member = new Member();
		member.setmName(memberInfo.getName());
		member.setmGrade(memberInfo.getGradeNumber());
		member.setmCategory(memberInfo.getCategoryNumber());
		member.setmLoginEmail(memberInfo.getLoginEmail());
		member.setmLoginPass(memberInfo.getLoginPass());
		member.setmPhone(memberInfo.getPhone());
		member.setmQq(memberInfo.getQq());
		member.setmIntroduction(memberInfo.getIntroduction());
		Authority authority = new Authority();
		member.setmUserAuthority(authority);
		boolean flag = this.memberService.register(member);
		if (flag) {
			return "redirect:/manage/register-succeeded";
		} else {
			return "redirect:/manage/register-failed";
		}

	}

	@RequestMapping(value = "/go-login")
	public String goLogin() {
		return "show/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String loginEmail, String loginPass,
			HttpServletRequest req) {
		Member member = this.memberService.login(loginEmail, loginPass);
		if (null == member) {
			return "redirect:/manage/login-failed";
		} else {
			MemberSession memberSession = new MemberSession(member.getmId(),
					member.getmLoginEmail(), member.getmName(),
					member.getmUserAuthority());
			HttpSession session = req.getSession();
			session.setAttribute("memberSession", memberSession);
			session.setMaxInactiveInterval(15 * 60);
			// 暂时这么写，还要改用session的
			// req.setAttribute("member", member);
			return "redirect:/manage/main";
		}
	}

	@RequestMapping(value = "/self/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if (session.getAttribute("memberSession") != null) {
			session.removeAttribute("memberSession");
		}
		return "redirect:/index";
	}

	@RequestMapping(value = "/self/go-edit-info")
	public String goEditInfo(int id, HttpServletRequest req) {
		Member member = this.memberService.find(id);
		MemberInfo selfInfo = new MemberInfo(member);
		req.setAttribute("selfInfo", selfInfo);
		return "manage/selfInfoEdit";
	}

	@RequestMapping(value = "/self/edit-info")
	public String editInfo(MemberInfo memberInfo, HttpServletRequest req) {
		HttpSession session = req.getSession();
		MemberSession memberSession = (MemberSession) session
				.getAttribute("memberSession");
		Member member = this.memberService.find(memberSession.getId());
		member.setmQq(memberInfo.getQq());
		member.setmPhone(memberInfo.getPhone());
		member.setmCategory(memberInfo.getCategoryNumber());
		member.setmGrade(memberInfo.getGradeNumber());
		member.setmIntroduction(memberInfo.getIntroduction());
		member.setmDetails(memberInfo.getDetails());
		this.memberService.edit(member);
		return "redirect:/member/self/selfInfo";
	}

	@RequestMapping(value = "/self/go-edit-pic")
	public String goEditPic() {
		return "manage/selfPicEdit";
	}

	@RequestMapping(value = "/self/edit-pic")
	public String editPic(HttpServletRequest request,
			@RequestParam("fileUpload") MultipartFile fileUpload) {
		// 调用工具类FileUpload的静态方法来进行图书上传
		StringBuffer picSite = FileUpload.upload(request, fileUpload, "member",
				true);
		HttpSession session = request.getSession();
		MemberSession memberSession = (MemberSession) session
				.getAttribute("memberSession");
		if (null == picSite) {
			return "manage/selfPicEditError";
		}
		if ("keepOld".equals(picSite.toString())) {
			return "manage/selfPicEdit";
		}
		this.memberService.editPicture(memberSession.getId(),
				picSite.toString());
		return "redirect:/member/self/selfInfo";
	}

	@RequestMapping(value = "/self/go-edit-pass")
	public String goEditPass() {
		return "manage/selfPassEdit";
	}

	@RequestMapping(value = "/self/edit-pass")
	public String editPass(String oldPass, String newPass,
			String repeatNewPass, HttpServletRequest req) {
		StringBuffer message = new StringBuffer();
		if (!newPass.equals(repeatNewPass)) {
			message.append("两次密码输入不一致！请重新输入！");
		} else {
			HttpSession session = req.getSession();
			MemberSession memberSession = (MemberSession) session
					.getAttribute("memberSession");
			message.append(this.memberService.editPass(memberSession.getId(),
					oldPass, newPass));
		}
		req.setAttribute("message", message);
		return "manage/selfPassEdit";
	}

	@RequestMapping(value = "/manage/list")
	public String list(
			@RequestParam(required = false, defaultValue = "1") int current,
			HttpServletRequest req) {
		HttpSession session = req.getSession();
		MemberSession memberSession = (MemberSession) session
				.getAttribute("memberSession");
		int size = 9;
		Map<String, Object> map = new HashMap<String, Object>();

		if (memberSession.isManageAdmin()) {
			map = this.memberService.paging(current, size, false);
		} else if (memberSession.isManageMember()) {
			map = this.memberService.paging(current, size, false, false);
		}

		req.setAttribute("listMemberInfo",
				(ArrayList<MemberInfo>) map.get("listMemberInfo"));
		req.setAttribute("pageBean", (Pages) map.get("pageBean"));
		return "manage/memberList";
	}

	@RequestMapping(value = "/manage/go-authoriting")
	public String goAuthoriting(int id, HttpServletRequest req) {
		Member member = this.memberService.find(id);
		MemberInfo memberInfo = new MemberInfo(member);
		req.setAttribute("memberInfo", memberInfo);
		return "manage/memberAuthoriting";
	}

	@RequestMapping(value = "/manage/authoriting", method = RequestMethod.POST)
	public String authoriting(AuthorityForm authorityForm,
			HttpServletRequest request) {
		Member member = this.memberService.find(authorityForm.getMemberId());
		boolean oldAllowLogin = member.getmUserAuthority().isaAllowLogin();
		boolean newAllowLogin = authorityForm.isAllowLogin();
		if (!member.getmUserAuthority().isaManageAdmin()) {
			Authority authority = new Authority(authorityForm);
			authority.setaId(member.getmUserAuthority().getaId());
			member.setmUserAuthority(authority);
			this.memberService.edit(member);
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+  request.getContextPath() + "/";
			MailType mailType = new MailType();
			mailType.setUrl(basePath);
			mailType.setEmail(member.getmLoginEmail());
			mailType.setUsername(member.getmName());
			// 如果之前是禁止登录状态，修改为允许登录状态，则发邮件通知用户
			if ((!oldAllowLogin) && newAllowLogin) {
				mailType.setType(MailType.REGISTER_TYPE_ALLOW_MAIL);
				this.mailService.sendSingleMail(mailType);
			}
			// 如果之前是允许登录状态，修改为禁止登录状态，则发邮件通知用户
			if (oldAllowLogin && (!newAllowLogin)) {
				mailType.setType(MailType.REGISTER_TYPE_FORBIDDEN_MAIL);
				this.mailService.sendSingleMail(mailType);
			}
			return "redirect:/member/manage/list";
		} else {
			return "redirect:/manage/not-have-authority";
		}
	}

	@RequestMapping(value = "/manage/remove")
	public String remove(int id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberSession memberSession = (MemberSession) session
				.getAttribute("memberSession");
		if (memberSession.isManageMember() || memberSession.isManageAdmin()) {
			Member member = this.memberService.find(id);
			if (!member.getmUserAuthority().isaManageMember()
					&& !member.getmUserAuthority().isaManageAdmin()) {
				String basePath = request.getScheme() + "://"
						+ request.getServerName() + ":" + request.getServerPort()
						+  request.getContextPath() + "/";
				MailType mailType = new MailType();
				mailType.setUrl(basePath);
				mailType.setEmail(member.getmLoginEmail());
				mailType.setUsername(member.getmName());
				mailType.setType(MailType.REMOVE_MEMBER_MAIL);
				this.memberService.remove(id,member.getmUserAuthority().getaId());
				this.mailService.sendSingleMail(mailType);
			}
		} else {
			return "redirect:/manage/not-have-authority";
		}
		return "redirect:/member/manage/list";
	}

	@RequestMapping(value = "/manage/look")
	public String mLook(int id, HttpServletRequest req) {
		MemberInfo memberInfo = new MemberInfo(this.memberService.find(id));
		req.setAttribute("memberInfo", memberInfo);
		return "manage/memberLook";
	}

	// @RequestMapping(value = "/manage/search")
	// public String search(MemberSearchForm memberSearchForm,
	// HttpServletRequest req) {
	// StringBuffer category = new StringBuffer("");
	// if(memberSearchForm.getCategoryNumber()!=-1){
	// category.append(memberSearchForm.judgeCategory(memberSearchForm.getCategoryNumber()));
	// }
	// StringBuffer grade = new StringBuffer("");
	// if(memberSearchForm.getGradeNumber()!=-1){
	// grade.append(memberSearchForm.judgeGrade(memberSearchForm.getGradeNumber()));
	// }
	// if(memberSearchForm.getMemberName().trim()!=null &&
	// "".equals(memberSearchForm.getMemberName().trim())){
	// req.setAttribute("message", "请输入筛选信息！");
	// }
	// req.setAttribute("memberInfo", 0);
	// return "manage/memberLook";
	// }
	@RequestMapping(value = "/self/selfInfo")
	public String selfInfo(HttpServletRequest req) {
		HttpSession session = req.getSession();
		MemberSession memberSession = (MemberSession) session
				.getAttribute("memberSession");
		Member member = this.memberService.find(memberSession.getId());
		MemberInfo selfInfo = new MemberInfo(member);
		req.setAttribute("selfInfo", selfInfo);
		return "manage/selfInfo";
	}
}
