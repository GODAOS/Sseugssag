package com.sseugssag.main.login;

import java.util.List;

import com.sseugssag.main.reserve.Reserve;

public interface MemberMapper {
// 회원가입 - 고객
public abstract int join(Customer c);
// 회원가입 - 업체
public abstract int com_join(Company com);

// 아이디 중복확인 - 고객
// paramtype,resulttype
public abstract List<Customer> idCheck(Customer c);

// 로그인-고객
public abstract List<Customer> getCustomerById(Customer c);

//로그인-업체
public abstract List<Company>getCompanyById(Company c);

//정보수정하기 - 고객
public abstract int update(Customer c);

//탈퇴하기 - 고객
public abstract int bye(Customer c);

//정보수정하기 - 업체
public abstract int update_company(Company c);

//탈퇴하기 - 업체
public abstract int bye_company(Company c);

}
