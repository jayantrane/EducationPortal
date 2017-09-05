var doctor = document.getElementById("selectdoctor");
	function onLoad(){
		var doctor = document.getElementById("selectdoctor");
		$(doctor).hide(); 
		
	}
	function validateRadio() {
		var doctor = document.getElementById("selectdoctor");

	    if (document.getElementById("patient").checked == true) {
	    	$(doctor).show();
	        
	    }
	    else if (document.getElementById("doctor").checked == true) {
	    	$(doctor).hide();

	    }
	    
	    }
	$(document).ready(onLoad);