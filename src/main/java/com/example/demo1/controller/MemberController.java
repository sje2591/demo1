package com.example.demo1.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo1.dto.MemberDTO;
import com.example.demo1.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // Simple Logging Facade for Java

public class MemberController {

@Autowired
private MemberService memberService;

@RequestMapping("/")
public ModelAndView main() {
log.info("========================== MemberController(/) ==================================");
ModelAndView mv=new ModelAndView("/main");
return mv;
}

@RequestMapping("/member/list")
public ModelAndView memberList() {
log.info("========================== MemberController(/member/list) ==================================");
ModelAndView mv=new ModelAndView("/member/list");
List<MemberDTO> list=memberService.findMemberList();
mv.addObject("list", list);
return mv;
}

@RequestMapping("/member/register-form")
public ModelAndView registerForm() {
log.info("========================== MemberController(/member/register-form) ==================================");
ModelAndView mv=new ModelAndView("/member/addForm");
return mv;
}

@RequestMapping("/member/register")
public ModelAndView registerMember(
MemberDTO memberDTO, HttpServletRequest request
) {
log.info("========================== MemberController(/member/register) ==================================");
memberService.registerMember(memberDTO);
ModelAndView mv=new ModelAndView("redirect:" + request.getContextPath() + "/member/list");
return mv;
}

@RequestMapping("/member/detail")
public ModelAndView memberDetail(String id
) {
log.info("========================== MemberController(/member/detail) ==================================");
ModelAndView mv=new ModelAndView("/member/detail");
MemberDTO member=memberService.findMemberDetail(id);
mv.addObject("member", member);
return mv;
}
@RequestMapping("/member/delete")    
public ModelAndView memberDelete(@RequestParam String id) {
   log.info("========================== MemberController(/member/delete) ==================================");
   memberService.removeMember(id);
   ModelAndView mv=new ModelAndView("redirect:/member/list");
   List<MemberDTO> list=memberService.findMemberList();
   mv.addObject("list", list);
   return mv;
}
}