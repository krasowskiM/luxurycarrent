carRentApp.controller('mainController', function ($scope, $state, $http) {
    $scope.notLoggedIn = true;
    $scope.regData = undefined;
    $scope.loginData = undefined;
    $scope.registerClicked = false;
    $scope.loginClicked = true;
    $scope.loginError = undefined;
    $scope.registerOK = undefined;
    $scope.registerError = undefined;

    $scope.panelRegister = function () {
        $scope.registerClicked = true;
        $scope.loginClicked = false;
    };

    $scope.panelLogin = function () {
        $scope.loginClicked = true;
        $scope.registerClicked = false;
    };

    $scope.register = function () {
        $http.put('/register', $scope.regData).then(function (response) {
            $scope.registerOK = response.data;
        }, function (response) {
            $scope.registerError = response.data;
        });
    };

    $scope.login = function () {
        $scope.notLoggedIn = false;
        $http.post('/login', $scope.loginData).then(function (response) {
            $state.go('userpanel');
        }, function (response) {
            $scope.loginError = response.data;
        });
    };
});