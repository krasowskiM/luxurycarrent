var carRentApp = angular.module('carRentApp', ['ui.router']);

carRentApp.config(function ($urlRouterProvider, $stateProvider) {
    $urlRouterProvider.otherwise('/');

    $stateProvider
        .state('login', {
            url: '/login',
            templateUrl: 'views/login.html',
            controller: 'loginController'
        })
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
        })
        .state('userpanel.payments', {
            url: '/payments',
            templateUrl: 'views/payments.html',
            controller: 'paymentController'
        })
        .state('logout', {
            url: '/logout',
            templateUrl: 'views/logout.html'
        });
});