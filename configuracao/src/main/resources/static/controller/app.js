var app = angular.module("app", ['ngRoute', 'angular-growl']);

app.constant('URL', 'http://10.50.13.15:7070');

app.config(function($routeProvider) {
    $routeProvider
    .when("/configuracao", {
        templateUrl : "configuracao.html"
    })
    .when("/sistema", {
        templateUrl : "view/sistema.html",
        controller: "sistemaController"
    })
    .when("/ambiente", {
        templateUrl : "view/ambiente.html",
        controller: "ambienteController"
    })
    .otherwise({
        template : "<h1>Pagina não existente</h1><p></p>"
    });
    
});

app.config(['growlProvider', function (growlProvider) {
	growlProvider.globalTimeToLive(3000);
}]);

