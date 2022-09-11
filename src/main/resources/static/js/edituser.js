$(document).ready(function(){
	
	$('.edit').on('click', 
	function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		//fill by data from model
		$.get(href,function(user,status){
			$('.userForm #id').val(user.id);
			$('.userForm #name').val(user.name);
			$('.userForm #role').val(user.roles);
			$('.userForm #active').val(user.active);
		});
		//Call modal by id
		$('#userModal').modal({backdrop: true});//do not change addModal name!!!
	});
	
	$('.delete').on('click', 
	function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		//fill by data from model
		$.get(href,function(user,status){
			$('.userDeleteForm #id').val(user.id);
		});
		//Call modal by id
		$('#userDeleteModal').modal({backdrop: true});//do not change addModal name!!!
	});
	
	$('#adduser').on('click', 
	function(event){
		event.preventDefault();
		$('#userAddModal').modal({backdrop: true});//do not change addModal name!!!
		});
		
});


















