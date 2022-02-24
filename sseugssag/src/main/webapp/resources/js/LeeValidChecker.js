//<input>을 넣었을 때, 
//아무것도 쓰여있지 않으면 true, 뭐라도 썼으면 false
function isEmpty(input) {//parameter이름:input
	return (!input.value); //input에 쓴 내용이 없으면 이걸 리턴
}

// <input>,글자수를 세어봤을 때
//	그 글자수보다 적으면 true, 그 글자수이상이면 false
function lessThan(input, len){
	return(input.value.leng < len);//input.에 쓴내용.길이.가 len보다 작을 때
	}

	
// <input>에 뭔가를 썼을 때
//	한글/특수문자가 있으면 true, 없으면 false
function contains(input){
	const ok="0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM@._";//영어알파벳,숫자 담을 변수
	const iv=inpt.value;//input에 담아있는 내용
	for(let i =0; i<iv.length ;i++){//ok뜯어서 확인할 수 있도록 for문//input박스에 쓴거 다 확인하기위해
		if(ok.indexOf[i]==-1){//하나라도 있으면 trueflxjs
			return true;
		}
	}
	return false;
}

//비번 ,비번확인 
//<input>박스 두개 비교했을 때
//내용이 다르면 true, 같으면 false

function notEquals(input1,input2){//input박수 두개 비교
	return (input1.value != input2.value);
}

//<input>에 문자열세트 넣엇을 때
//없으면 true, 있으면 false
function notContains(input,okset){
	const iv=input.value;//input에 있는 내용
	for(let i =0; i<okset.length;i++){
		if(iv.indexOf(okset[i] != -1)){
			return false;//intput에 내용이 없을 때
		}
	}
	return true;
}

//<input>에 뭔가를 썼을대
// 숫자가 아니면 true, 숫자만 있으면 false
//NaN:Not a number,숫자가 아닌것
//isNaN():NAN인지 아닌지 판단하는 함수
function isNotNumber(input){
	return isNaN(input.value);//NaN:not a number , isNaN:숫자가 아닌것
}

// <input> 확장자 넣었을 때
// 원하는 확장자면 false, 아니면 true
function isNotType(input,type){
	type = "."+type;
	return (input.value.indexOf(type) == -1);
}






