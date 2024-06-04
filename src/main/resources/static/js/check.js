function check() {
    // 예약번호
    var resvNo = document.getElementById("resv_no").value.trim();
    // 주민번호
    var jumin = document.getElementById("jumin").value.trim();
    // 예약시간
    var resvTime = document.getElementById("resv_time").value.trim();
    // 병원코드
    var hospCode = document.querySelector('input[name="hosp_code"]:checked');
    // 예약날짜
    var resvDate = document.getElementById("resv_date").value.trim();

    var errorMessage = "";

    // 예약번호 유효성 검사
    if (resvNo === "") {
        errorMessage += "예약번호를 입력하세요.\n";
    }

    // 주민번호 유효성 검사
    if (jumin === "") {
        errorMessage += "주민번호를 입력하세요.\n";
    } else if (!validateJumin(jumin)) {
        errorMessage += "올바른 주민번호 형식이 아닙니다.\n";
    }

    // 예약시간 유효성 검사
    if (resvTime === "") {
        errorMessage += "예약시간을 입력하세요.\n";
    } else if (!validateTime(resvTime)) {
        errorMessage += "올바른 시간 형식이 아닙니다. (ex: 09:30)\n";
    }

    // 병원코드 유효성 검사
    if (hospCode === null) {
        errorMessage += "병원코드를 선택하세요.\n";
    }

    // 예약날짜 유효성 검사
    if (resvDate === "") {
        errorMessage += "예약날짜를 입력하세요.\n";
    } else if (!validateDate(resvDate)) {
        errorMessage += "올바른 날짜 형식이 아닙니다. (ex: 2021-01-01)\n";
    }

    if (errorMessage !== "") {
        alert(errorMessage);
        return false;
    } else {
        // 폼 제출
        document.getElementById("frm").submit();
    }
}

// 주민번호 유효성 검사 함수
function validateJumin(jumin) {
    var regex = /^[0-9]{6}-[0-9]{7}$/;
    return regex.test(jumin);
}

// 시간 유효성 검사 함수
function validateTime(time) {
    var regex = /^([01]?[0-9]|2[0-3]):[0-5][0-9]$/;
    return regex.test(time);
}

// 날짜 유효성 검사 함수
function validateDate(date) {
    var regex = /^\d{4}-\d{2}-\d{2}$/;
    return regex.test(date);
}

// 취소 버튼 클릭 시 폼 리셋
function res() {
    if (confirm('모든 정보를 지우고 처음부터 다시 입력하시겠습니까?')) {
        document.getElementById("frm").reset();
    }
}
