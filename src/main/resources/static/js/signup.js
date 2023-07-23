$(document).ready(function () {

    const modal = $('#modal');
    const modalBody = $('#modal-body');

    let checkEmail = false;
    let checkNickname = false;

    $('#email').on('keyup', function () {
        checkEmail = false;
    })

    $('#email-check-button').on('click', function () {
        const email = $('#email').val();

        if(email.length < 3) {
            modalBody.text('이메일을 입력해주세요.');
            modal.modal('show');
            return;
        }

        $.ajax({
            url: '/api/members/duplication',
            type: 'get',
            dataType: 'text',
            data: {email: email},
            success: function (data) {
                console.log(data);
                if(data === "true") {
                    modalBody.text('해당 이메일은 사용중입니다.');
                } else {
                    checkEmail = true;
                    modalBody.text('해당 이메일은 사용할 수 있습니다.');
                }
                modal.modal('show');
            }
        })
    })

    const confirmPassword = $('#confirm-password');
    confirmPassword.on('keyup', function () {

        const passwordAlert = $('#password-alert');
        const password = $('#password').val();

        if(confirmPassword.val().length === 0) {
            passwordAlert.text('');
            return;
        }

        if(confirmPassword.val() !== password) {
            passwordAlert.text('비밀번호가 일치하지 않습니다.');
            passwordAlert.addClass('text-danger');
            return;
        }
        passwordAlert.removeClass('text-danger');
        passwordAlert.text('비밀번호가 일치합니다.')
        passwordAlert.addClass('text-success');
    })

    $('#nickname').on('keyup', function () {
        checkNickname = false;
    })
    $('#nickname-check-button').on('click', function () {
        const nickname = $('#nickname').val();

        if(nickname.length < 3) {
            modalBody.text('닉네임을 3글자 이상 입력해주세요.');
            modal.modal('show');
            return;
        }

        $.ajax({
            url: '/api/members/duplication',
            type: 'get',
            dataType: 'text',
            data: {nickname: nickname},
            success: function (data) {
                if(data === true) {
                    modalBody.text('해당 닉네임은 사용중입니다.');
                } else {
                    checkNickname = true;
                    modalBody.text('해당 닉네임은 사용할 수 있습니다.');
                }
                modal.modal('show');
            }
        })
    })

    $('#submit-button').on('click', function () {
        if(!checkEmail) {
            modalBody.text('이메일을 사용할 수 있는지 확인해 주세요.');
            modal.modal('show');
            return;
        }
        if(!checkNickname) {
            modalBody.text('닉네임을 사용할 수 있는지 확인해 주세요.');
            modal.modal('show');
            return;
        }
        if($('#password').val() !== confirmPassword.val()) {
            modalBody.text('비밀번호가 일치하지 않습니다.');
            modal.modal('show');
            return;
        }
        if(!confirm('회원가입 하시겠습니까?')) {
            return;
        }
        $.ajax({
            url: '/api/members/signup',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify({
                email: $('#email').val(),
                password: $('#password').val(),
                nickname: $('#nickname').val()
            }),
            success: function () {
                location.href = '/members/login'
            }
        })
    })
})