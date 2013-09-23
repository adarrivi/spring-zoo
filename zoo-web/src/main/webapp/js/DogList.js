$(document).ready(
		function() {
			loadDogList();

			$("#submitButton").click(function() {
				$.post("saveDog", {
					breed : $('#breed').val(),
					age : $('#age').val()
				}, function(){
					loadDogList();
				});
			});
		});

function loadDogList(){
	$("#dogPanel").mask("Loading...");
	$.get("getDogList", {}, function(data) {
		$("#dogList").empty();
		$.each(data, function(i, element) {			
			$("#dogList").append(
					"<li><span>" + element.name + "</span>  <span>"
							+ element.age + "</span></li>");
		});
		$("#dogPanel").unmask();
	});
};
