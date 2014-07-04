var app = angular.module("geektic", ['ngRoute']);

app.controller('MainCtrl', function($scope, $http) {
    $http.get('/api/interetsList').success(function(interets) {
        $scope.interets = interets;
    });
    
	$scope.search = function() {
		$http.get('/api/search?sexe='+$scope.sexe+'&interet='+$scope.interet.libelle).success(function(results) {
	        $scope.results= results;
	    });
	}; 
	
	$scope.profile = function($id) {
		$http.get('/api/search?sexe='+$scope.sexe+'&interet='+$scope.interet.libelle).success(function(results) {
	        $scope.results= results;
	    });
	};
});

app.config(function($routeProvider){
	  $routeProvider
	    .when('/', {
	      templateUrl: 'main.html',
	      controller: 'MainCtrl'
	    })
		.when('/profile/:id', {
	      templateUrl: '/profile.html?:id',
	      controller: 'ProfileCtrl'
	    })
	    .otherwise('/');
	});

app.controller('ProfileCtrl', function($scope, $http, $routeParams) {
    $http.get('/api/geek/'+$routeParams.id).success(function(geek) {
        $scope.geekProfile = geek;
    });
});