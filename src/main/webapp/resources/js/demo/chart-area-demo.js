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
				if(data.visit[i].indexOf("9 오전")!=-1){
					
					am_9++;
				}else if(data.visit[i].indexOf("10 오전")!=-1){
					am_10++;
					console.log(am_10+"am 10");
				}else if(data.visit[i]=="11 오전"){
					consol.elog(am_11);
					am_11++;
				}else if(data.visit[i]=="12 오후"){
					pm_12++;
				}else if(data.visit[i]=="01 오후"){
					pm_1++;
				}else if(data.visit[i]=="02 오후"){
					pm_2++;
				}else if(data.visit[i]=="03 오후"){
					pm_3++;
				}else if(data.visit[i]=="04 오후"){
					pm_4++;
				}else if(data.visit[i]=="05 오후"){
					pm_5++;
				}else if(data.visit[i]=="06 오후"){
					pm_6++;
				}else if(data.visit[i]=="07 오후"){
					pm_7++;
				}else if(data.visit[i]=="08 오후"){
					pm_8++;
				}else if(data.visit[i]=="09 오후"){
					pm_9++;
				}
			}
		}
	});
	var ctx = document.getElementById("myAreaChart");
	var myLineChart = new Chart(ctx, {
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
	      data: [am_9,am_10,am_11,pm_12,pm_1,pm_2,pm_3,pm_4,pm_5,pm_6,pm_7,pm_8,pm_9],
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
	          max: 100,
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
});
// Area Chart Example

