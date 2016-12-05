
 

package com.snaplync.controller;

import java.security.AuthProvider;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.brickred.socialauth.Profile;
import org.brickred.socialauth.SocialAuthConfig;
import org.brickred.socialauth.SocialAuthManager;
import org.brickred.socialauth.util.SocialAuthUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.snaplync.entity.Session;
import com.snaplync.entity.User;
import com.snaplync.repository.SessionRepository;
import com.snaplync.repository.UserRepository;
import com.snaplync.util.CookieUtil;

@Controller
public class AuthenticationController {
	private final Logger log;
	public UserRepository userRepository;
	public SessionRepository sessionRepository;

	@Autowired
	public AuthenticationController(UserRepository userRepository, SessionRepository sessionRepository) {
		this.log = LoggerFactory.getLogger(this.getClass());
		this.userRepository = userRepository;
		this.sessionRepository = sessionRepository;
	}

	@RequestMapping(value={"/auth/social"})
	public String social(@RequestParam(value="provider") String provider, HttpServletRequest request, HttpSession session) throws Exception {
		SocialAuthConfig config = SocialAuthConfig.getDefault();
		config.load("oauth.properties");
		SocialAuthManager manager = new SocialAuthManager();
		manager.setSocialAuthConfig(config);
		String successUrl = AuthenticationController.getURL(request) + "/auth/social_return?provider=" + provider;
		String url = manager.getAuthenticationUrl(provider, successUrl);
		session.setAttribute("authManager", (Object)manager);
		System.out.println("success " + successUrl);
		System.out.println("redirect " + url);
		return "redirect:" + url;
	}

	@RequestMapping(value={"/auth/social_return"})
	@Transactional
	public String oauthReturn(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		Map paramsMap;
		SocialAuthManager manager = (SocialAuthManager)session.getAttribute("authManager");
		AuthProvider provider = manager.connect(paramsMap = SocialAuthUtil.getRequestParametersMap((HttpServletRequest)request));
		Profile p = provider.getUserProfile();
		User user = this.userRepository.findByEmail(p.getEmail());
		if (user == null) {
			user = new User();
			user.setCreated(new Date());
			user.setEmail(p.getEmail());
			user.setActive('Y');
			user.setFirstName(p.getFirstName());
			user.setLastName(p.getLastName());
			user.setPic(p.getProfileImageURL());
			user.setUpdated(new Date());
			System.out.println("user created is  " + session.getAttribute("user_type"));
			if (session.getAttribute("user_type") == null || session.getAttribute("user_type").equals("jobseeker")) {
				user.setIsRecruiter('N');
			} else {
				user.setIsRecruiter('Y');
			}
			this.userRepository.save((Object)user);
		}
		session.setAttribute("user", (Object)user);
		Session sess = new Session();
		String sessionId = UUID.randomUUID().toString();
		sess.setToken(sessionId);
		sess.setCreatedTime(new Date());
		sess.setLastRequestTime(new Date());
		sess.setUser(user);
		sess.setActive('Y');
		sess.setCreatedTime(new Date());
		sess.setLastRequestTime(new Date());
		this.sessionRepository.save((Object)sess);
		CookieUtil.setCookie(response, "sess_id", sessionId);
		session.setAttribute("session", (Object)sess);
		return "redirect:/dashboard/pro";
	}

	@RequestMapping(value={"/auth/logout"})
	@Transactional
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		String sessionId = CookieUtil.getCookie("sess_id", request);
		if (sessionId == null) {
			sessionId = request.getParameter("sess_id");
		}
		if (sessionId == null) {
			sessionId = request.getHeader("sess_id");
		}
		if (sessionId == null) {
			return "redirect:/";
		}
		Session sess = this.sessionRepository.findByToken(sessionId);
		if (sess != null && sess.getActive() == 'Y') {
			session.setAttribute("jobseeker_hike", (Object)20);
			session.setAttribute("jobseeker_salary", (Object)120);
			sess.setActive('N');
			sess.setLastRequestTime(new Date());
			this.sessionRepository.save((Object)sess);
		}
		return "redirect:/";
	}

	public static String getURL(HttpServletRequest req) {
		String scheme = req.getScheme();
		String serverName = req.getServerName();
		int serverPort = req.getServerPort();
		String contextPath = req.getContextPath();
		StringBuffer url = new StringBuffer();
		url.append(scheme).append("://").append(serverName);
		if (serverPort != 80 && serverPort != 443) {
			url.append(":").append(serverPort);
		}
		url.append(contextPath);
		return url.toString();
	}
}
