var app = angular.module("app", ['ngRoute', 'angular-growl']);

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
        template : "<h1>Pagina inicial</h1><p></p>"
    });
    
});

app.config(['growlProvider', function (growlProvider) {
	growlProvider.globalTimeToLive(3000);
}]);

