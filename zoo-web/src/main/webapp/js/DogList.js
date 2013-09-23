$(document).ready(function() {
	$.get("getDogList", {}, function(data) {
		alert("Dog list retrieved");
	});
});
