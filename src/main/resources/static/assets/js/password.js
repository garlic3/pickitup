let emailPass=false; // 인증성공시 true(테스트중)


//FindPessword js
function chkEM() {

 

		var text = document.getElementById('PWemail').value;
		var regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
		if ($("#PWemail").val().length < 1) {
			alert('입력이 되지 않았습니다.');
		} else if (regEmail.test(text) === true) {
			alert('이메일로 전송되었습니다.');
		} else {
			alert('올바른 이메일을 입력해주세요.');
		}
    emailPass=true; // 테스트용 클릭시 화면전환 조건 true

    if (!emailPass) {
        alert("이메일 인증이 완료되지 않았습니다");
        return false;
    } else {
        $("#password-firststep").hide();
        $("#password-secondstep").show();
    }

}


function checkFilled() {
    var text = document.getElementById('PWemail').value;
    var regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;    

    if (regEmail.test(text) === true) {
        $("#herror").hide();
    }
    else {
        $("#herror").show();
    }
}
//PatchPassword js
function chkPW() {
    emailPass=true; // 테스트용 클릭시 화면전환 조건 true
    // if ($("#ChangePW").val().length < 8) {
    //     alert("8자리이상으로 입력해주세요.");
    //     return false;
    // } else if ($("#ChangePW").val() != $("#ChagePWCheck").val()) {
    //     alert("비밀번호가 일치하지 않습니다.");
    //     return false;
    // } else if ($("#ChangePW").val() == $("#ChagePWCheck").val()) {
    //     alert("비밀번호 변경 완료되었습니다.");
    //     return true;
    // }
    if (!emailPass) {
        alert("이메일 인증이 완료되지 않았습니다");
        return false;
    } else {
        $("#password-firststep").hide();
        $("#password-secondstep").show();
    }

}
function PcheckFilled() {
    if ($("#ChangePW").val().length < 8) {
        $("#herror1").show();
        $("#Pherror1").hide();
    }
    else {
        $("#herror1").hide();
        $("#Pherror1").show();
    }
}
function PPcheckFilled(){
    if ($("#ChagePWCheck").val().length < 8) {
        $("#herror2").show();
        $("#correct").hide();
        $("#Ncorrect").hide();

        return false;
    }
    else if($("#ChagePWCheck").val().length >= 8){
        $("#herror2").hide();
        $("#correct").hide();
            if($("#ChagePWCheck").val() == $("#ChangePW").val()){
                  $("#correct").show();
                  $("#Ncorrect").hide();
                  return false;
                }
            else if($("#ChagePWCheck").val() != $("#ChangePW").val()){
                $("#correct").hide();
                $("#Ncorrect").show();
                return false;
            }
            return true;
                    
    }
    
}


//
// // 인증시 화면 전환
// (".hpasswordEnter").on("click", function (e) {
//     if (!emailPass) {
//         alert("이메일 인증이 완료되지 않았습니다");
//         return false;
//     } else {
//         $("#password-firststep").hide();
//         $("#password-secondstep").show();
//     }
// });
