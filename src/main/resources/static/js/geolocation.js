geolocation();

function geolocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);

    } else {
        console.log("Cannot read current position!")
    }
}

function showPosition(position) {
    console.log(position.coords.latitude + " " + position.coords.longitude);
}