var carRentApp = angular.module('carRentApp', ['ui.router'])
    .factory('TokenInterceptor', function ($q) {
        return {
            request: function (config) {
                var authToken = localStorage.getItem('auth_token');
                if(authToken){
                    config.headers['X-AUTH-TOKEN'] = authToken;
                }
                return config;
            },
            responseError: function (error) {
                if(error.status === 401 || error.status === 403){
                    localStorage.clear();
                }
                return $q.reject(error);
            }
        };
    }).config(function ($httpProvider) {
        $httpProvider.interceptors.push('TokenInterceptor');
    });

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