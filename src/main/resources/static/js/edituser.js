/**
 * 
 */


$(document).ready(function(){
	$('.editUser').on('click', function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(user, status){
			$('.userForm #id').val(user.id);
			$('.userForm #name').val(user.name);
			
			
			$('.userForm #active').val(user.active);
			$('.userForm #activeString').val(user.activeString);
		});
		$('#userModal').modal();//do not change addModal name!!!
	});
	
	
	
	
	
});


















