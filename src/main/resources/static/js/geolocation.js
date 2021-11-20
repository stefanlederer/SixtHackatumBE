geolocation();

async function geolocation() {
    while(true) {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition);

        } else {
            console.log("Cannot read current position!")
        }
        //sleep 10 sec
        await new Promise(r => setTimeout(r, 10000));
    }
}

function showPosition(position) {
    console.log(position.coords.latitude + " " + position.coords.longitude);
    $.ajax({
        type: 'GET',
        url: "/sendCurrentLocation/" + position.coords.latitude + "-" + position.coords.longitude
        });
}