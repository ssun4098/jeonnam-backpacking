<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>전남 캠핑촌</title>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/common.css">

    <script src="../bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../jquery/jquery.min.js" type="text/javascript"></script>
    <script src="../js/main.js" type="text/javascript"></script>
</head>
<body>
    <div class="container" id="main-container">
        <div class="mb-3">
            <div class="input-group">
                <input id="input-tent" class="form-control" placeholder="텐트촌 이름을 입력해주세요.">
                <button type="button" class="btn btn-outline-secondary">Search</button>
            </div>
        </div>

        <div class="m-auto">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">
                        제목
                    </th>
                </tr>
                </thead>
                <tbody id="tent-table-body">

                </tbody>
            </table>
        </div>
        <div class="m-auto">
            <nav>
                <ul id="pagination" class="pagination">
                </ul>
            </nav>
        </div>
    </div>
    <div id="modal" class="modal" tabindex="-1">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 id="tent-title" class="modal-title"></h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Modal body text goes here.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>