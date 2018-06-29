app.controller("sistemaController", function($scope, $http, growl, URL) {
	
	var config = { headers : {'Content-Type': 'application/json'}}
	
	$scope.init = function () {
		$scope.ambientes = {};
		$scope.sistema = {};
		$scope.carregar();
		$scope.carregarAmbientes();
	}
	
	$scope.limpar = function() {
		$scope.sistema= {};
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
	
	$scope.carregar = function() {
		$http.get(URL + "/sistema/sistemas")
	    .then(
	        function (response) {
	        	$scope.sistemas = response.data;
	        },
	        function (errResponse) {
	        	$scope.sistemas = response.statusText;
	        	growl.error("Erro ao carregar listagem", {});
	        }
	    );
    }
	
    $scope.salvar = function() {
    	var valido = true;
    	if ($scope.sistema.nome == null) {
    		growl.error("Campo nome obrigatorio", {});
    		valido = false;
    	}
    	if ($scope.sistema.descricao == null) {
    		growl.error("Campo descricao obrigatorio", {});
    		valido = false;
    	}
    	if ($scope.sistema.ambiente == null) {
    		growl.error("Campo ambiente obrigatorio", {});
    		valido = false;
    	}
    	
    	if (valido) {
    		$http.post(URL + "/sistema/sistema", $scope.sistema, config)
    		.then(
    			function(response){
    				growl.success("Sistema salvo com sucesso", {});
    				$scope.sistemas.push(response.data);
    				$scope.sistema= {};
    			}, 
    			function(response){
    				growl.error("Erro ao salvar Sistema", {});
    			}
    		);
    	}
    }
    
    $scope.remover = function(id) {
    	$http.delete(URL + "/sistema/sistema/" + id, config)
    	.then(
             function(response){
              	growl.success("Sistema removido com sucesso", {});
              	$scope.carregar();
             }, 
             function(errResponse){
               	growl.error("Erro ao remover Sistema", {});
             }
        );
    }
    
});