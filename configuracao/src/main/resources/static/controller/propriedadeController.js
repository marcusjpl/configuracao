app.controller("propriedadeController", function($scope, $http, growl, URL) {
	
	var config = { headers : {'Content-Type': 'application/json'}}
	
	$scope.init = function () {
		$scope.ambiente = {};
		$scope.ambientes = {};
		
		$scope.sistema = {};
		$scope.sistemas = [];
		
		$scope.carregarSistemas();
	}
	
	$scope.carregarPorIdSistema = function(id) {
		$http.get(URL + "/api/ambientes/sistema/"+id, config)
	    .then(
	        function (response) {
	        	$scope.ambientes = response.data;
	        },
	        function (response) {
	        	$scope.ambientes = response.statusText;
	        	growl.error("Erro ao carregar ambientes", {});
	        }
	    );
    }
	
	$scope.carregarSistemas = function() {
		$http.get(URL + "/api/sistemas")
	    .then(
	        function (response) {
	        	$scope.sistemas = response.data;
	        },
	        function (errResponse) {
	        	$scope.ambientes = response.statusText;
	        	growl.error("Erro ao carregar sistemas", {});
	        }
	    );
    }
    
});