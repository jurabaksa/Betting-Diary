(function ($) {
 "use strict";
	 /*----------------------------------------*/
	/*  1.  Bar Chart
	/*----------------------------------------*/

	var ctx = document.getElementById("barchart1");
	var chart11 = document.getElementById("chart11");
    var chart12 = document.getElementById("chart12");
    var chart13 = document.getElementById("chart13");
    var chart14 = document.getElementById("chart14");
	var barchart1 = new Chart(ctx, {
		type: 'bar',
		data: {
			labels: ["< 10 kn", "10-30 kn", "30-100 kn", "> 100 kn"],
			datasets: [{
				label: 'Dobitni listići po ulozima',
				data: [chart11.value, chart12.value, chart13.value, chart14.value],
				backgroundColor: [
					'rgba(255, 99, 132, 0.2)',
					'rgb(50,205,50, 0.2)',
					'rgba(255, 206, 86, 0.2)',
					'rgba(75, 192, 192, 0.2)'
				],
				borderColor: [
					'rgba(255,99,132,1)',
					'rgba(54, 162, 235, 1)',
					'rgba(255, 206, 86, 1)',
					'rgba(75, 192, 192, 1)'
				],
				borderWidth: 1
			}]
		},
		options: {
			scales: {
				yAxes: [{
					ticks: {
						beginAtZero:true
					}
				}]
			}
		}
	});
	/*----------------------------------------*/
	/*  2.  Bar Chart vertical
	/*----------------------------------------*/
	var ctx = document.getElementById("barchart2");
	var chart21 = document.getElementById("chart21");
    var chart22 = document.getElementById("chart22");
    var chart23 = document.getElementById("chart23");
    var chart24 = document.getElementById("chart24");
	var barchart2 = new Chart(ctx, {
		type: 'bar',
		data: {
			labels: ["< 50 kn", "50-200 kn", "200-1000 kn", "> 1000 kn"],
            			datasets: [{
            				label: 'Dobitni listići po dobitcima',
            				data: [chart21.value, chart22.value, chart23.value, chart24.value],
            				backgroundColor: [
            					'rgba(255, 99, 132, 0.2)',
            					'rgb(50,205,50, 0.2)',
            					'rgba(255, 206, 86, 0.2)',
            					'rgba(75, 192, 192, 0.2)'
            				],
            				borderColor: [
            					'rgba(255,99,132,1)',
            					'rgba(54, 162, 235, 1)',
            					'rgba(255, 206, 86, 1)',
            					'rgba(75, 192, 192, 1)'
            				],
            				borderWidth: 1
            			}]
            		},
            		options: {
            			scales: {
            				yAxes: [{
            					ticks: {
            						beginAtZero:true
            					}
            				}]
            			}
            		}
            	});
	/*----------------------------------------*/
	/*  3.  Bar Chart Horizontal
	/*----------------------------------------*/
	var ctx = document.getElementById("barchart3");
	var chart31 = document.getElementById("chart31");
    var chart32 = document.getElementById("chart32");
    var chart33 = document.getElementById("chart33");
    var chart34 = document.getElementById("chart34");
    var barchart3 = new Chart(ctx, {
    		type: 'bar',
    		data: {
    			labels: ["< 10 kn", "10-30 kn", "30-100 kn", "> 100 kn"],
    			datasets: [{
    				label: 'Gubitni listići po ulozima',
            		data: [chart31.value, chart32.value, chart33.value, chart34.value],
    				backgroundColor: [
    					'rgba(255, 99, 132, 0.2)',
    					'rgb(50,205,50, 0.2)',
    					'rgba(255, 206, 86, 0.2)',
    					'rgba(75, 192, 192, 0.2)'
    				],
    				borderColor: [
    					'rgba(255,99,132,1)',
    					'rgba(54, 162, 235, 1)',
    					'rgba(255, 206, 86, 1)',
    					'rgba(75, 192, 192, 1)'
    				],
    				borderWidth: 1
    			}]
    		},
    		options: {
    			scales: {
    				yAxes: [{
    					ticks: {
    						beginAtZero:true
    					}
    				}]
    			}
    		}
    	});
	/*----------------------------------------*/
	/*  4.  Bar Chart Multi axis
	/*----------------------------------------*/
	var ctx = document.getElementById("barchart4");
	var chart41 = document.getElementById("chart41");
    var chart42 = document.getElementById("chart42");
    var chart43 = document.getElementById("chart43");
    var chart44 = document.getElementById("chart44");
    var barchart4 = new Chart(ctx, {
    		type: 'bar',
    		data: {
			labels: ["< 50 kn", "50-200 kn", "200-1000 kn", "> 1000 kn"],
    			datasets: [{
    				label: 'Gubitni listići po dobitcima',
            		data: [chart41.value, chart42.value, chart43.value, chart44.value],
    				backgroundColor: [
    					'rgba(255, 99, 132, 0.2)',
    					'rgb(50,205,50, 0.2)',
    					'rgba(255, 206, 86, 0.2)',
    					'rgba(75, 192, 192, 0.2)'
    				],
    				borderColor: [
    					'rgba(255,99,132,1)',
    					'rgba(54, 162, 235, 1)',
    					'rgba(255, 206, 86, 1)',
    					'rgba(75, 192, 192, 1)'
    				],
    				borderWidth: 1
    			}]
    		},
    		options: {
    			scales: {
    				yAxes: [{
    					ticks: {
    						beginAtZero:true
    					}
    				}]
    			}
    		}
    	});
		
})(jQuery); 