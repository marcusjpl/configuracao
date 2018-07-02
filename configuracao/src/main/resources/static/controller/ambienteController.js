app.controller("ambienteController", function($scope, $http, growl, URL) {
	
	var config = { headers : {'Content-Type': 'application/json'}}
	
	$scope.init = function () {
		$scope.ambiente = {};
		$scope.carregar();
		$scope.sistemas = {};
		$scope.carregarSistemas();
	}
	
	$scope.limpar = function() {
		$scope.ambiente= {};
	}
	
	$scope.carregar = function() {
		$http.get(URL + "/ambiente/ambientes")
	    .then(
	        function (response) {
	        	$scope.ambientes = response.data;
	        },
	        function (errResponse) {
	        	$scope.ambientes = response.statusText;
	        	growl.error("Erro ao carregar listagem", {});
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
		        $scope.sistemas = response.statusText;
		        growl.error("Erro ao carregar sistemas", {});
	        }
	    );
    }
	
    $scope.salvar = function() {
    	var valido = true;
	    if ($scope.ambiente.nome == null) {
	    	growl.error("Campo nome obrigatorio", {});
	    	valido = false;
	    }
	    if ($scope.ambiente.descricao == null) {
	    	growl.error("Campo descricao obrigatorio", {});
	    	valido = false;
	    }
	    if ($scope.ambiente.sistema == null) {
	    	growl.error("Campo sistema obrigatorio", {});
	    	valido = false;
	    }
	    
	    if (valido) {
	    	$scope.ambiente.sistema = angular.fromJson($scope.ambiente.sistema);
	    	
	    	$http.post(URL + "/ambiente/ambiente", $scope.ambiente, config)
	    	.then(
	    		function(response){
	    			growl.success("Ambiente salvo com sucesso", {});
	    			//$scope.ambientes.push(response.data);
	    			$scope.carregar();
	    			$scope.ambiente= {};
	    		}, 
	    		function(response){
	    			growl.error("Erro ao salvar Ambiente", {});
	    		}
	    	);
	    }
    }
    
    $scope.remover = function(id) {
    	$http.delete(URL + "/ambiente/ambiente/" + id, config)
    	.then(
             function(response){
              	growl.success("Ambiente removido com sucesso", {});
              	$scope.carregar();
             }, 
             function(errResponse){
               	growl.error("Erro ao remover Ambiente", {});
             }
        );
    }
    
    $scope.editar = function(entity) {
    	$http.get(URL + "/ambiente/ambiente/" + entity.id, config)
    	.then(
             function(response){
            	 $scope.ambiente = response.data;
             }, 
             function(errResponse){
               	growl.error("Erro ao buscar por Ambiente", {});
             }
        );
    }
    
    $scope.basicUsage = function (type) {
        var config = {};
        switch (type) {
          case "success":
            growl.success("<b>I'm</b> a success message", config);
            break;
          case "info":
            growl.info("I'm an info message", config);
            break;
          case "warning":
            growl.warning("I'm the warning message", config);
            break;
          default: 
            growl.error("Ups, error message here!", config);
        }
      };
    
});