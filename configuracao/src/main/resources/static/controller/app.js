var app = angular.module("app", ["ngRoute"]);

app.config(function($routeProvider) {
    $routeProvider
    .when("/configuracao", {
        templateUrl : "configuracao.html"
    })
    .when("/sistema", {
        templateUrl : "templates/view/sistema.html",
        controller: "sistemaController"
    })
    .when("/teste", {
        templateUrl : "welcome.html",
        controller: "sistemaController"
    })
    .otherwise({
        template : "<h1>None</h1><p>Nothing has been selected</p>"
    });
    
});