<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>관리자페이지 - Login</title>

  <!-- Custom fonts for this template-->
  <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template-->
  <link href="resources/css/sb-admin.css" rel="stylesheet">
<style>
#forlogo {
   text-align: center;
}
img {
   width: 200px;
   height: auto;
   margin-right : 200px;
   margin-top : 50px;
   margin-bottom : 10px;
}
.card{
   margin-top : 0px;
}
.btn .btn-primary{
   width
}
</style>
</head>

<body class="bg-dark">
   <div id="forlogo" style="margin-top:100px;">
      <img alt="" src="resources/imgs/logo.png">
   </div>
  <div class="container" style="margin-top:-50px;">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">관리자 페이지</div>
      <div class="card-body">
        <form method="post" action="/login">
          <div class="form-group">
            <div class="form-label-group">
              <input type="text" id="inputId" name="username" class="form-control" placeholder="Email address" required="required" autofocus="autofocus">
              <label for="inputId">관리자 아이디</label>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
              <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="required">
              <label for="inputPassword">관리자 비밀번호</label>
            </div>
          </div>
          <div class="form-group">
          </div>
          <!--  로그인시 넘어갈 페이지  -->
          <button type="submit" class="btn btn-primary">로그인</button>
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="resources/vendor/jquery/jquery.min.js"></script>
  <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

</body>

</html>







