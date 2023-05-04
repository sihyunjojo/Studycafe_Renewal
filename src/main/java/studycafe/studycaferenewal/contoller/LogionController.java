package studycafe.studycaferenewal.contoller;

import lombok.Generated;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import studycafe.studycaferenewal.domain.Member;
import studycafe.studycaferenewal.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.lang.annotation.Retention;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LogionController {
    private final LoginService loginService;

    //@ModelAttribute가 form에서 loginForm객체 내부의 필드와 이름이 같은 값을 가져와서 객체에 넣어줌
    @PostMapping("/login")
    public String loginForm(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult,
                            @RequestParam(defaultValue = "/") String redirectURL,
                            HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "home";
        }

        Member loginMember = loginService.login(form.getUserId(), form.getUserPassword());

        if (loginMember == null) {
            // 클라이언트에 에러 보여줄 때 사용하자!!!!
//            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다");
            return "home";
        }

        HttpSession session = request.getSession();
        session.setAttribute("loginMember", loginMember);

        return "redirect:" + redirectURL;
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
