package co.micol.prj.member.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberDao; // dao 자동 주입

	@RequestMapping("/memberSerlectList.do")
	public String memberSelectList(Model model) {
		model.addAttribute("members", memberDao.memberSelectList());
		return "member/memberSelectList";
	}

	@RequestMapping("/memberLoginForm.do")
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}

	
	@PostMapping("/memberLogin.do")
	public String memberLogin(MemberVO member, Model model, HttpSession session) {
		member = memberDao.memberSelect(member);
		if(member != null) {
			session.setAttribute("id", member.getId()); // 세션에 아이디값 담는다.
			session.setAttribute("author", member.getAuthor()); // 세션에 권한을 담는다.
			model.addAttribute("message", member.getName() + "님 환영합니다.");
		} else {
			model.addAttribute("message", "아이디 또는 패스워드가 틀립니다.");
		}
		return "member/memberLogin";
	}
	
	@RequestMapping("/memberLogout.do")
	public String memberLogout(HttpSession session, Model model ) {
		session.invalidate(); // 세션을 서버에서 삭제한다.
		model.addAttribute("message", "로그아웃이 정상적으로 처리 되었습니다.");
		return "member/memberLogout";
	}
}
