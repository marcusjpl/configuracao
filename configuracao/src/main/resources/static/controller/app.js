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
    .when("/teste", {
        template : "<h1>testeeeEEEEE 222222222</h1>"
    })
    .otherwise({
        template : "<h1>Pagina inicial</h1><p></p>"
    });
    
});