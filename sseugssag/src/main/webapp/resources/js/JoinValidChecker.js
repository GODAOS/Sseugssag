// 고객 유효성검사
function joinCheck(){
	const c_name=document.cusjoin.c_name;
	const c_phone=document.cusjoin.c_phone;
	const c_id=document.cusjoin.c_id;
	const c_pw=document.cusjoin.c_pw;
	const c_pwCheck=document.cusjoin.c_pwCheck;
	const c_addr3=document.cusjoin.c_addr3;
	if (isEmpty(c_name)) {
		alert("이름을 입력하세요");
		c_name.value="";
		c_name.focus();
		return false;
	}
	
	if (isEmpty(c_phone)) {
		alert("전화번호를 입력하세요");
		c_phone.value="";
		c_phone.focus();
		return false;
	}
	
	if (isEmpty(c_id)) {
		alert("아이디를 입력하세요");
		c_id.value="";
		c_id.focus();
		return false;
	}
	if (isEmpty(c_pw)) {
		alert("비밀번호를 입력하세요");
		c_pw.value="";
		c_pw.focus();
		return false;
	}
	
	if (c_pw.value.length < 8) {
		alert("8자 이상 입력하세요");
		c_pw.value="";
		c_pw.focus();
		return false;
	}
	if(notEquals(c_pw, c_pwCheck)) {
		alert("비밀번호를 다시 입력하세요");
		c_pwCheck.focus();
		return false;
	}
	if(!c_addr3.value) {
		alert("주소를 입력하세요");
		c_addr3.focus();
		return false;
	}
	 
	return true;
}

//업체유효성검사
function joinCheck2(){
	const com_id=document.comjoin.com_id;
	const com_pw=document.comjoin.com_pw;
	const com_phone=document.comjoin.com_phone;
	const com_pwCheck=document.comjoin.com_pwCheck;
	const com_name=document.comjoin.com_name;
	const com_addr1=document.comjoin.com_addr1;
	const com_addr2=document.comjoin.com_addr2;
	const com_addr3=document.comjoin.com_addr3;
	if (isEmpty(com_id)) {
		alert("아이디를 입력하세요");
		com_id.value="";
		com_id.focus();
		return false;
	}
	if (isEmpty(com_phone)) {
		alert("전화번호를 입력하세요");
		com_phone.value="";
		com_phone.focus();
		return false;
	}
	if (isEmpty(com_pw)) {
		alert("비밀번호를 입력하세요");
		com_pw.value="";
		com_pw.focus();
		return false;
	}
	
	if (com_pw.value.length < 8) {
		alert("8자 이상 입력하세요");
		com_pw.value="";
		com_pw.focus();
		return false;
	}
	if(notEquals(com_pw, com_pwCheck)) {
		alert("비밀번호를 다시 입력하세요");
		com_pwCheck.focus();
		return false;
	}
	if(isEmpty(com_name)) {
		alert("회사명을 입력하세요");
		com_name.focus();
		return false;
	}
	
	if(!com_addr3.value) {
		alert("주소를 입력하세요");
		com_addr3.focus();
		return false;
	}
	
	return true;
}











