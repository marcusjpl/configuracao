app.controller("ambienteController", function($scope, $http) {
	
    $scope.sistema= {};
    
    $scope.sistemas = [{nome:'SGA', descricao:'descricao sga'}, 
    				   {nome:'SGI', descricao:'descricao sgi'}];
    
    
    $scope.limpar = function() {
    	$scope.sistema= {};
    }
    
    $scope.salvar = function() {
    	$scope.sistemas.push($scope.sistema);
    	$scope.sistema= {};
    }
    
    $scope.remover = function(index) {
    	$scope.sistemas.splice(index, 1);
    }
    
    
});