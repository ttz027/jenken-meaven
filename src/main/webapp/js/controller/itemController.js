app.controller("itemController",function($scope,$http,$location,itemService){
	
	$scope.allId=["frist","second","Third"];
	$scope.findAll=function(){
		itemService.findItemByGoodsId().success(function(response){
			$scope.list = response;
		})
	}
});