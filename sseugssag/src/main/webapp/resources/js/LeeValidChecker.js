//<input>�� �־��� ��, 
//�ƹ��͵� �������� ������ true, ���� ������ false
function isEmpty(input) {//parameter�̸�:input
	return (!input.value); //input�� �� ������ ������ �̰� ����
}

// <input>,���ڼ��� ������� ��
//	�� ���ڼ����� ������ true, �� ���ڼ��̻��̸� false
function lessThan(input, len){
	return(input.value.leng < len);//input.�� ������.����.�� len���� ���� ��
	}

	
// <input>�� ������ ���� ��
//	�ѱ�/Ư�����ڰ� ������ true, ������ false
function contains(input){
	const ok="0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM@._";//������ĺ�,���� ���� ����
	const iv=inpt.value;//input�� ����ִ� ����
	for(let i =0; i<iv.length ;i++){//ok�� Ȯ���� �� �ֵ��� for��//input�ڽ��� ���� �� Ȯ���ϱ�����
		if(ok.indexOf[i]==-1){//�ϳ��� ������ trueflxjs
			return true;
		}
	}
	return false;
}

//��� ,���Ȯ�� 
//<input>�ڽ� �ΰ� ������ ��
//������ �ٸ��� true, ������ false

function notEquals(input1,input2){//input�ڼ� �ΰ� ��
	return (input1.value != input2.value);
}

//<input>�� ���ڿ���Ʈ �־��� ��
//������ true, ������ false
function notContains(input,okset){
	const iv=input.value;//input�� �ִ� ����
	for(let i =0; i<okset.length;i++){
		if(iv.indexOf(okset[i] != -1)){
			return false;//intput�� ������ ���� ��
		}
	}
	return true;
}

//<input>�� ������ ������
// ���ڰ� �ƴϸ� true, ���ڸ� ������ false
//NaN:Not a number,���ڰ� �ƴѰ�
//isNaN():NAN���� �ƴ��� �Ǵ��ϴ� �Լ�
function isNotNumber(input){
	return isNaN(input.value);//NaN:not a number , isNaN:���ڰ� �ƴѰ�
}

// <input> Ȯ���� �־��� ��
// ���ϴ� Ȯ���ڸ� false, �ƴϸ� true
function isNotType(input,type){
	type = "."+type;
	return (input.value.indexOf(type) == -1);
}






