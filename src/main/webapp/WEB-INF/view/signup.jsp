<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" href="${path}/bootstrap/css/bootstrap.min.css">
    <script src="${path}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${path}/jquery/jquery.min.js" type="text/javascript"></script>
    <script src="${path}/js/login.js"></script>
</head>
<body>
<div class="container">
    <div class="mb-3">
        <label for="email" class="form-label">E-mail</label>
        <div class="input-group">
            <input type="email" id="email" class="form-control">
            <button type="button" id="email-check-button" class="btn btn-outline-success">Check Use</button>
        </div>
    </div>

    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" id="password" class="form-control">
    </div>

    <div class="mb-3">
        <label for="confirm-password" class="form-label">Confirm Password</label>
        <input type="password" id="confirm-password" class="form-control">
        <div class="form-text" id="password-alert"></div>
    </div>

    <div class="mb-3">
        <label for="nickname" class="form-label">Nickname</label>
        <div class="input-group">
            <input id="nickname" class="form-control">
            <button id="nickname-check-button" class="btn btn-outline-success">Check Use</button>
        </div>
    </div>

    <button id="submit-button" class="btn btn-primary">회원가입</button>
</div>

<!-- Modal -->
<div class="modal fade" id="modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">경고</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div id="modal-body" class="modal-body">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>