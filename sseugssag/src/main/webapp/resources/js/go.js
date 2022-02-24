function reviewPageChange(page) {
	location.href = "review.page.change?p=" + page;
}

function reviewDelete(no){
	if (confirm("진짜 삭제하시겠습니까?")) {
		location.href = "review.delete?r_no=" + no;
	}
}

function reviewUpdate(no, txt){
	txt = prompt("고칠 내용을 입력하세요.", txt);
	if (txt != null && txt.length > 0 && txt.length < 500) {
		location.href = "review.update?r_no=" + no + "&r_txt=" + txt;
	}
}





