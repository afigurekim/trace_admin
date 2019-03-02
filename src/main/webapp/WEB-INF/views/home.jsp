<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="template/header.jsp"%>




<div id="content-wrapper">

	<div class="container-fluid">

		<!-- Area Chart Example-->
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-chart-area"></i> 시간대 별 방문자 수
			</div>
			<div class="card-body">
				<canvas id="myAreaChart" width="100%" height="30"></canvas>
			</div>
			
		</div>

		<div class="row">
			<div class="col-lg-8">
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-chart-bar"></i> 조회수 Top 5 유적지
					</div>
					<div class="card-body">
						<canvas id="myBarChart" width="100%" height="50"></canvas>
					</div>

				</div>
			</div>
			<div class="col-lg-4">
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-chart-pie"></i> 사용자 별점 비율
					</div>
					<div class="card-body">
						<canvas id="myPieChart" width="100%" height="100"></canvas>
					</div>
		
				</div>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->
	


	<%@ include file="template/footer.jsp"%>