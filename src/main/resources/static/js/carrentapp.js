var carRentApp = angular.module('carRentApp', ['ui.router']);

carRentApp.config(function ($urlRouterProvider, $stateProvider) {
    $urlRouterProvider.otherwise('/');
    $urlRouterProvider.when('/logout', '/');

    $stateProvider
        .state('userpanel', {
            url: '/userpanel',
            templateUrl: 'views/userpanel.html',
            controller: 'userPanelController'
        })
        .state('userpanel.cars', {
            url: '/cars',
            templateUrl: 'views/cars.html',
            controller: 'carController'
        })
        .state('userpanel.rentals', {
            url: '/rentals',
            templateUrl: 'views/rentals.html',
            controller: 'rentalController'
        });
});