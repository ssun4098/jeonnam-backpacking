$(document).ready(function () {
    $('#signup-button').on('click', function () {
        location.href = '/members/signup';
    })

    $(`#login-button`).on('click', function () {
        const email = $('#email').val();
        const password = $('#password').val();
        const modal = $('#modal');
        const modalBody = $('#modal-body');

        if(email.length < 1) {
            modalBody.text('이메일을 입력해주세요.');
            modal.modal('show');
            return;
        }

        if(password < 1) {
            modalBody.text('비밀번호를 입력해주세요.');
            modal.modal('show');
            return;
        }

        $.ajax({
            url: '/login',
            type: 'post',
            data: {
                email: email,
                password: password
            },
            success: function (data, textStatus, xhr) {
                if(xhr.status === 200) {
                    location.href = '/test';
                }
            },
            error: function (request) {
                const message = JSON.parse(request.responseText);
                modalBody.text(message.message);
                modal.modal('show');
            }
        })
    })
})