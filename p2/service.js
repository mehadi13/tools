app.service('myService', function () {
    this.message = '';
    this.setMessage = function (newMessage) {
        this.message = newMessage;
        return this.message;
    };
});

app.service('urlService', function ($http) {
    
});