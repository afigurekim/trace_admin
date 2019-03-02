// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';
function loadJQuery() {
    var oScript = document.createElement("script");
    oScript.type = "text/javascript";
    oScript.charset = "utf-8";		  
    oScript.src = "http://code.jquery.com/jquery-1.6.2.min.js";	
    document.getElementsByTagName("head")[0].appendChild(oScript);
}
// Pie Chart Example
var star1=0;
var star2=0;
var star3=0;
var star4=0;
var star5=0;
$(function(){
	$.ajax({
		url:"/userStar",
		type:"get",
		async:false,
		success:function(data){
	
			for(var i=0;i<data.list.length;i++){
				console.log(data.list[i].star);
				if(data.list[i].star==1){
					star1++;
				}else if(data.list[i].star==2){
					star2++;
				}else if(data.list[i].star==3){
					star3++;
				}else if(data.list[i].star==4){
					star4++;
				}else if(data.list[i].star==5){
					star5++;
				}
			}
		}
	});
});
var ctx = document.getElementById("myPieChart");
var myPieChart = new Chart(ctx, {
  type: 'pie',
  data: {
    labels: ["1점", "2점", "3점", "4점",'5점'],
    datasets: [{
      data: [star1,star2,star3,star4,star5],
      backgroundColor: ['#007bff', '#dc3545', '#ffc107', '#28a745','#f18973'],
    }],
  },
});

