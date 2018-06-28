app.controller("ambienteController", function($scope, $http, growl) {
	
    $scope.sistema= {};
    
    $scope.sistemas = [{nome:'SGA', descricao:'descricao sga'}, 
    				   {nome:'SGI', descricao:'descricao sgi'}];
    
    
    $scope.limpar = function() {
    	$scope.sistema= {};
    }
    
    $scope.salvar = function() {
    	$scope.sistemas.push($scope.sistema);
    	$scope.sistema= {};
    	growl.success("Sistema cadastrado com sucesso", {});
    }
    
    $scope.remover = function(index) {
    	$scope.sistemas.splice(index, 1);
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