var app = angular.module("geektic", ['ngRoute']);

app.controller('MainCtrl', function($scope, $http) {
    $http.get('/api/interetsList').success(function(interets) {
        $scope.interets = interets;
        $scope.selected = {};
    });
    
	$scope.ShowSelected = function() {
		alert($scope.selected);
		$scope.interets = $.grep($scope.interets, function( interet ) {
			return $scope.selected[ interet.id ];
		});
	}; 
});