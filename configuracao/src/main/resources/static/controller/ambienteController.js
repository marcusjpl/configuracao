app.controller("ambienteController", function($scope, $http, growl, URL) {
	
	var config = {
        headers : {
        	'Content-Type': 'application/json'
        }
    }
	
	$scope.init = function () {
		$scope.ambiente = {};
		$scope.carregar();
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
    	
    	if (valido) {
    		$http.post(URL + "/ambiente/ambiente", $scope.ambiente, config)
    		.then(
    			function(response){
    				growl.success("Ambiente salvo com sucesso", {});
    				$scope.ambientes.push(response.data);
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