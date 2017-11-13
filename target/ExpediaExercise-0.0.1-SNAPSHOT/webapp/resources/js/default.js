$(document).ready(function() {
	$(".datepickerMax").attr("disabled", "disabled");
	$(".datepickerMin").datepicker({
		dateFormat : 'yy-mm-dd',
		minDate : 0,
		onSelect : function() {
			$(".datepickerMax").removeAttr("disabled");
			$(".travelStartDate").attr("disabled", "disabled");
			$(".travelEndDate").attr("disabled", "disabled");
		}

	});

	$(".datepickerMax").focus(function() {
		$(this).datepicker({
			showOn : 'button',
			dateFormat : 'yy-mm-dd',
			minDate : $('.datepickerMin').datepicker('getDate')
		});
	});
	
	$(".travelStartDate").datepicker({
		dateFormat : 'yy-mm-dd',
		minDate : 0,
		onSelect : function() {
			$(".datepickerMax").attr("disabled", "disabled");
			$(".datepickerMin").attr("disabled", "disabled");
		}

	});
	
	$(".travelEndDate").focus(function() {
		$(this).datepicker({
			showOn : 'button',
			dateFormat : 'yy-mm-dd',
			minDate : $('.travelStartDate').datepicker('getDate')
		});
	});
	

});