package com.example.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo1.dto.MemberDTO;
import com.example.demo1.mapper.MemberMapper;


@Service
public class MemberServiceImpl implements MemberService {
@Autowired
private MemberMapper memberMapper;

@Override
public List<MemberDTO> findMemberList() {
// TODO Auto-generated method stub
return memberMapper.selectMemberList();
}

@Override
public MemberDTO findMemberDetail(String id) {
// TODO Auto-generated method stub
return memberMapper.selectMemberDetail(id);
}

@Override
public void registerMember(MemberDTO memberDTO) {
	// TODO Auto-generated method stub
	memberMapper.insertMember(memberDTO);
}

@Override
public void removeMember(String id) {
	// TODO Auto-generated method stub
	memberMapper.deleteMember(id);
}
}