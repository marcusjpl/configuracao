app.controller("propriedadeController", function($scope, $http, growl, URL) {
	
	var config = { headers : {'Content-Type': 'application/json'}}
	
	$scope.init = function () {
		$scope.ambiente = {};
		$scope.sistema = {};
		
		$scope.ambientes = [];
		$scope.sistemas = [];
		
		$scope.carregarAmbientes();
		$scope.carregarSistemas();
	}
	
	$scope.limpar = function() {
		$scope.ambiente= {};
	}
	
	$scope.carregarAmbientes = function() {
		$http.get(URL + "/ambiente/ambientes")
	    .then(
	        function (response) {
	        	$scope.ambientes = response.data;
	        },
	        function (errResponse) {
	        	$scope.ambientes = response.statusText;
	        	growl.error("Erro ao carregar ambientes", {});
	        }
	    );
    }
	
	$scope.carregarSistemas = function() {
		$http.get(URL + "/sistema/sistemas")
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