app.controller("propriedadeController", function($scope, $http, growl, URL) {
	
	var config = { headers : {'Content-Type': 'application/json'}}
	
	$scope.init = function () {
		$scope.ambiente = {};
		$scope.ambientes = {};
		
		$scope.sistema = {};
		$scope.sistemas = [];
		
		$scope.propriedades = [];
		
		$scope.carregarSistemas();
	}
	
	$scope.carregarPropriedadesPorIdAmbiente = function(id) {
		$http.get(URL + "/api/propriedade/ambiente/"+id, config)
	    .then(
	        function (response) {
	        	$scope.propriedades = response.data;
	        },
	        function (response) {
	        	$scope.propriedades = response.statusText;
	        	growl.error("Erro ao carregar propriedades", {});
	        }
	    );
    }
	
	$scope.carregarAmbientesPorIdSistema = function(id) {
		$http.get(URL + "/api/ambiente/sistema/"+id, config)
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
	
	$scope.addPropriedade = function() {
		if (angular.isUndefined($scope.sistema) || angular.isUndefined($scope.ambiente) 
				|| $scope.sistema.id == null || $scope.ambiente.id == null) {
			growl.warning("Escolha um Sistema e um Ambiente", {});
		} else {
			$scope.propriedades.push({nome:"",valor:"",descricao:""});
		}
	}
	
	$scope.limpar = function() {
		$scope.ambiente = {};
		$scope.ambientes = {};
		$scope.sistema = {};
		$scope.propriedades = [];
	}
    
});