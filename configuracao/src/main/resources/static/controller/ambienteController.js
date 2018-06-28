app.controller("ambienteController", function($scope, $http, growl, URL) {
	
	var config = {
        headers : {
        	'Content-Type': 'application/json'
        }
    }
	
	$scope.init = function () {
		$scope.ambiente = {};
	}
    
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
    
    
    $scope.limpar = function() {
    	$scope.ambiente= {};
    }
    
    $scope.salvar = function() {
    	
    	$http.post(URL + "/ambiente/salvar", $scope.ambiente, config)
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
    
    $scope.remover = function(index) {
    	$scope.ambientes.splice(index, 1);
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