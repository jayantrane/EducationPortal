function onLoad(){
	var bol=$('#isdoctor').val();
	var doc1 = document.getElementById("patients-div");
	var doc2 = document.getElementById("reports-div");
	var pat1= document.getElementById("myreports-div");
	$(doc1).hide();
	$(doc2).hide();
	$(pat1).hide();
	if(bol==='true'){
		$(doc1).show();
		$(doc2).show();
	}
	else if(bol==='false'){
		$(pat1).show();
	}
	else{
		
	}
}

$(document).ready(onLoad);