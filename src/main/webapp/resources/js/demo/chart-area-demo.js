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
var am_9=0;
var am_10=0;
var am_11=0;
var pm_12=0;
var pm_1=0;
var pm_2=0;
var pm_3=0;
var pm_4=0;
var pm_5=0;
var pm_6=0;
var pm_7=0;
var pm_8=0;
var pm_9=0;
$(function(){
	$.ajax({
		url:"/allVisitor",
		type:'get',
		async:false,
		success:function(data){
			for(var i=0;i<data.visit.length;i++){
				console.log(data.visit[i]);
				if(data.visit[i].indexOf("09 AM")!=-1){
					
					am_9++;
				}else if(data.visit[i].indexOf("10 AM")!=-1){
					am_10++;
				}else if(data.visit[i]=="11 AM"){
					am_11++;
				}else if(data.visit[i]=="12 PM"){
					pm_12++;
				}else if(data.visit[i]=="01 PM"){
					pm_1++;
				}else if(data.visit[i]=="02 PM"){
					pm_2++;
				}else if(data.visit[i]=="03 PM"){
					pm_3++;
				}else if(data.visit[i]=="04 PM"){
					pm_4++;
				}else if(data.visit[i]=="05 PM"){
					pm_5++;
				}else if(data.visit[i]=="06 PM"){
					pm_6++;
				}else if(data.visit[i]=="07 PM"){
					pm_7++;
				}else if(data.visit[i]=="08 PM"){
					pm_8++;
				}else if(data.visit[i]=="09 PM"){
					pm_9++;
				}
			}
	

	var ctx = document.getElementById("myAreaChart");
	var myAreaChart = new Chart(ctx, {
	  type: 'line',
	  data: {
	    labels: ["9시", "10시", "11시", "12시", "13시", "14시", "15시", "16시", "17시", "18시", "19시", "20시", "21시"],
	    datasets: [{
	      label: "방문자수",
	      lineTension: 0.3,
	      backgroundColor: "rgba(2,117,216,0.2)",
	      borderColor: "rgba(2,117,216,1)",
	      pointRadius: 5,
	      pointBackgroundColor: "rgba(2,117,216,1)",
	      pointBorderColor: "rgba(255,255,255,0.8)",
	      pointHoverRadius: 5,
	      pointHoverBackgroundColor: "rgba(2,117,216,1)",
	      pointHitRadius: 50,
	      pointBorderWidth: 2,
	      data: [am_9.toString(),am_10.toString(),am_11.toString(),pm_12.toString(),pm_1.toString(),pm_2.toString(),pm_3.toString(),pm_4.toString(),pm_5.toString(),pm_6.toString(),pm_7.toString(),pm_8.toString(),pm_9.toString()],
	    }],
	  },
	  options: {
	    scales: {
	      xAxes: [{
	        time: {
	          unit: 'date'
	        },
	        gridLines: {
	          display: false
	        },
	        ticks: {
	          maxTicksLimit: 7
	        }
	      }],
	      yAxes: [{
	        ticks: {
	          min: 0,
	          max: 300,
	          maxTicksLimit: 5
	        },
	        gridLines: {
	          color: "rgba(0, 0, 0, .125)",
	        }
	      }],
	    },
	    legend: {
	      display: false
	    }
	  }
	});
		}
	});
	
});
// Area Chart Example

