package com.example.demo1.service;

import java.util.List;
import com.example.demo1.dto.MemberDTO;

public interface MemberService {
List<MemberDTO> findMemberList();
MemberDTO findMemberDetail(String id);
void registerMember (MemberDTO memberDTO);
void removeMember(String id);
}