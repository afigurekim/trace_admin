<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>관리자페이지 - Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="resources/imgs/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/loginv2/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/loginv2/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resources/loginv2/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/loginv2/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/loginv2/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resources/loginv2/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/css/util.css">
	<link rel="stylesheet" type="text/css" href="resources/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" method="post" action="/login">
                    <span class="login100-form-title">
                        <img alt="" src="resources/imgs/logo-t-s-b.png" width="70%"/>
                    </span>
					<span class="login100-form-title p-b-26">
						관리자 페이지
					</span>
                    <div class="div-gap-50"></div>

					<div class="wrap-input100 validate-input" data-validate = "아이디를 입력하세요">
						<input class="input100" type="text" name="username" id="inputId">
						<span class="focus-input100" data-placeholder="아이디"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="비밀번호를 입력하세요">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<input class="input100" type="password" name="password" id="inputPassword">
						<span class="focus-input100" data-placeholder="비밀번호"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button type="submit" class="login100-form-btn">
								로그인
							</button>
						</div>
					</div>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="resources/loginv2/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/loginv2/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/loginv2/bootstrap/js/popper.js"></script>
	<script src="resources/loginv2/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/loginv2/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/loginv2/daterangepicker/moment.min.js"></script>
	<script src="resources/loginv2/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="resources/loginv2/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="resources/js/main.js"></script>

</body>
</html>