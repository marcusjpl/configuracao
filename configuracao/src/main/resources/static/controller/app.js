var app = angular.module("app", ["ngRoute"]);

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