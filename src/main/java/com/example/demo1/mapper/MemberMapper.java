package com.example.demo1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo1.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	List<MemberDTO> selectMemberList();
	MemberDTO selectMemberDetail(@Param("paramId") String id);
	void insertMember (MemberDTO memberDTO);
	void deleteMember (@Param("paramId") String id);
}