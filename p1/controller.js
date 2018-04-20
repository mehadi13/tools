
app.controller('studentController', function ($scope, $http,$log, myService, urlService) {
        $scope.serviceMsg = myService.setMessage("Hello, I'm From Service");

        var promise = urlService.getAll();
        promise.then(
                function (payload) {
                        console.log(payload);
                        $scope.students = payload.data;
                },
                function (errorPayload) {
                        $log.error('failure loading movie', errorPayload);
                });

        $scope.edit = function(student){
                $scope.student = student;
                console.log(student);
        }


});