<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/" var="root" />
<!-- Sticky Footer -->
<footer class="sticky-footer">
	<div class="container my-auto">
		<div class="copyright text-center my-auto">
			<span>Copyright © Ktraceadmin 2019</span>
		</div>
	</div>
</footer>

</div>
<!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top"> <i
	class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">Select "Logout" below if you are ready
				to end your current session.</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
				<a class="btn btn-primary" href="login.html">Logout</a>
			</div>
		</div>
	</div>
</div>

<!-- Bootstrap core JavaScript-->

<script
	src="${root}resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${root}resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Page level plugin JavaScript-->
<script src="${root}resources/vendor/chart.js/Chart.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${root}resources/js/sb-admin.min.js"></script>

 <!-- Page level plugin JavaScript-->
  <script src="${root}resources/vendor/datatables/jquery.dataTables.js"></script>
  <script src="${root}resources/vendor/datatables/dataTables.bootstrap4.js"></script>

<!-- Demo scripts for this page 테이블 js 파일 -->

	<script src="${root}resources/js/demo/datatables-demo.js"></script>
	<!-- Demo scripts for this page 차트 예시-->
	<script src="${root}resources/js/demo/chart-area-demo.js"></script>
	<script src="${root}resources/js/demo/chart-bar-demo.js"></script>
	<script src="${root}resources/js/demo/chart-pie-demo.js"></script>





</body>

</html>