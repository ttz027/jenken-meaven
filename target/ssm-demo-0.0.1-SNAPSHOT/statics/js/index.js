

$(function(){
	$("form").submit(function(){
		alert(2);
		$.ajax({
			type:"GET",
			url:"sss/index", 
			dataType:"json",
			success:function(data){ 
				alert(data.address);
			} 
		});
		/*$.ajax({
			type:"GET",
			url:path+"/sys/user/view.json",
			data:{id:2},
			url:path+"/user/view",
			data:{id:obj.attr("userid"),format:"json"},
			dataType:"json",
			success:function(result){
				alert(3);
				//alert(result.userName);
				if("failed" == result){
					alert("操作超时！");
				}else if("nodata" == result){
					alert("没有数据！");
				}else{
					$("#v_userCode").val(result.userCode);
					$("#v_userName").val(result.userName);
					if(result.gender == "1"){
						$("#v_gender").val("女");
					}else if(result.gender == "2"){
						$("#v_gender").val("男");
					}
					$("#v_birthday").val(result.birthday);
					$("#v_phone").val(result.phone);
					$("#v_address").val(result.address);
					$("#v_userRoleName").val(result.userRoleName);
					$("#v_creationDate").val(result.creationDate);
				}
				
			},
			error:function(data){
				alert("error!");
			}
		});*/
		alert(33);
		return false;
	});
	
})
