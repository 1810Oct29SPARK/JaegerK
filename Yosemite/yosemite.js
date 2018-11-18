var slideIndex = 0;
function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none"; 
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1} 
    slides[slideIndex-1].style.display = "block"; 
    setTimeout(showSlides, 2000); // Change image every 2 seconds
}

//OpenWeatherMap API
const apiUrl = "http://api.openweathermap.org/data/2.5/weather?zip=95389,us&units=imperial&appid=de87fea203d5128c1b10e513a7dad648"

let getWeather = function() {
    fetch(apiUrl, {method: "GET", headers:{"Accept":"application/json"}})
    .then((response) => {
        return response.json();
    })
    .then((data) => {
        yosemiteWeather = data;
        console.log(data);
        console.log(data.clouds)

            var temperatureIcon = document.createElement('IMG');
            temperatureIcon.src = 'https://www.raspberrypi.org/documentation/configuration/images/over_temperature_80_85.png';
            var temperature = document.createElement('td');
            var temperatureContent = document.createTextNode('Temperature:' + ' ' + yosemiteWeather.main.temp.toFixed(2) + String.fromCharCode(176) + 'F');
            temperature.appendChild(temperatureContent);
            document.getElementById('weatherTable').appendChild(temperature).appendChild(temperatureIcon)

            
            var humidityIcon = document.createElement('IMG');
            humidityIcon.src = 'https://cdn.iconscout.com/icon/free/png-256/humidity-forecast-hydration-precipitation-temperature-weather-38924.png';
            var humidity = document.createElement('td');
            var humidityContent = document.createTextNode("Humidity: " + yosemiteWeather.main.humidity + "%");
            humidity.appendChild(humidityContent);
            document.getElementById('weatherTable').appendChild(humidity).appendChild(humidityIcon)

            var pressureIcon = document.createElement('IMG');
            pressureIcon.src = 'https://www.quicklogic.com/assets/Uploads/al3s2/sensor-icon-pressure.png';
            var pressure = document.createElement('td');
            var pressureContent = document.createTextNode("Pressure: " + yosemiteWeather.main.pressure + "hPa");
            pressure.appendChild(pressureContent);
            document.getElementById('weatherTable').appendChild(pressure).appendChild(pressureIcon)
            var windIcon = document.createElement('IMG');
            windIcon.src = 'https://cdn2.iconfinder.com/data/icons/lovely-weather-icons/32/wind1-512.png';
            var windspeed = document.createElement('td');
            var windspeedContent = document.createTextNode("Windspeed: " + yosemiteWeather.wind.speed + 'mph');
            windspeed.appendChild(windspeedContent);
            document.getElementById('weatherTable').appendChild(windspeed).appendChild(windIcon)
        
            var conditionIcon = document.createElement('IMG');
            conditionIcon.src = 'https://ubisafe.org/images/transparent-icons-weather-4.png';
            document.getElementById('weatherTable').appendChild(conditionIcon)
            var condition = document.createElement('td');
            var conditionContent = document.createTextNode('Conditions:' + ' ' + yosemiteWeather.weather[0].description);
            condition.appendChild(conditionContent);
            document.getElementById('weatherTable').appendChild(condition).appendChild(conditionIcon)

           
        }
    )};

getWeather();

const NPSAlertURL = 'https://developer.nps.gov/api/v1/alerts?parkCode=yose&api_key=ST20MBOOcrZHBBZXij1k6THaDDQN2JJpDY4eyf6H'

let getNPSalertdata = function() {
    fetch(NPSAlertURL, {method: "GET", headers:{"Accept":"application/json"}})
    .then((response) => {
        return response.json()
    })
    .then((data) => {
        NPSalert = data;
        console.log(NPSalert.data[0].title)
    for (i=0; i < NPSalert.data.length; i++) {
            var alerts = document.createElement('li');
            var alertsContent = document.createTextNode(NPSalert.data[i].title);
            alerts.appendChild(alertsContent);
            document.getElementById("alertList").appendChild(alerts);
            console.log(NPSalert.data[i].title);
    }
    })
};

getNPSalertdata();

//NPS API
const NPSapikey = 'ST20MBOOcrZHBBZXij1k6THaDDQN2JJpDY4eyf6H' 
const NPSCampingUrl = 'https://developer.nps.gov/api/v1/campgrounds?parkCode=yose&api_key=ST20MBOOcrZHBBZXij1k6THaDDQN2JJpDY4eyf6H'

let getNPSdata = function() {
    fetch(NPSCampingUrl, {method: "GET", headers:{"Accept":"application/json"}})
    .then((response) => {
        return response.json();
    })
    .then((data) => {
    NPSdata = data;
    console.log(data)
    for (i=0; i < NPSdata.data.length; i++) {
        var campsite = document.createElement('li');
        var campsiteContent = document.createTextNode(NPSdata.data[i].description);
        campsite.appendChild(campsiteContent);
        document.getElementById("campingList").appendChild(campsite)
        var lineBreak = document.createElement('br');
        document.getElementById("campingList").appendChild(lineBreak);
    } 
})
};

getNPSdata();



//Zoom Modal 

// Get the modal

window.onload = function() {
    var modal1 = document.getElementById('glacierPointModal');
    var modalImg1 = document.getElementById("img01");
    document.getElementById('glacierPoint').addEventListener("click", function() {
        modal1.style.display = "block";
        modalImg1.src = this.src;
        console.log("modal clicked");
    })

   
    var modal2 = document.getElementById('tunnelViewModal');
    var modalImg2 = document.getElementById("img02");
    document.getElementById('tunnelView').addEventListener("click", function() {
        modal2.style.display = "block";
        modalImg2.src = this.src;
        console.log("modal clicked");
    })

    var modal3 = document.getElementById('olmsteadPointModal');
    var modalImg3 = document.getElementById("img03");
    document.getElementById('olmsteadPoint').addEventListener("click", function() {
        modal3.style.display = "block";
        modalImg3.src = this.src;
        console.log("modal clicked");
    })

    var modal4 = document.getElementById('elCapitanMeadowModal');
    var modalImg4 = document.getElementById("img04");
    document.getElementById('elCapitanMeadow').addEventListener("click", function() {
        modal4.style.display = "block";
        modalImg4.src = this.src;
        console.log("modal clicked");
    })

    var modal5 = document.getElementById('valleyViewModal');
    var modalImg5 = document.getElementById("img05");
    document.getElementById('valleyView').addEventListener("click", function() {
        modal5.style.display = "block";
        modalImg5.src = this.src;
        console.log("modal clicked");
    })

    var modal6 = document.getElementById('lowerYosemiteFallsModal');
    var modalImg6 = document.getElementById("img06");
    document.getElementById('lowerYosemiteFalls').addEventListener("click", function() {
        modal6.style.display = "block";
        modalImg6.src = this.src;
        console.log("modal clicked");
    })

    
    // When the user clicks on <span> (x), close the modal
    document.getElementById('close1').addEventListener("click", function() { 
        modal1.style.display = "none";
    })

    document.getElementById('close2').addEventListener("click", function() { 
        modal2.style.display = "none";
    })
    
    document.getElementById('close3').addEventListener("click", function() { 
        modal3.style.display = "none";
    })

    document.getElementById('close4').addEventListener("click", function() { 
        modal4.style.display = "none";
    })

    document.getElementById('close5').addEventListener("click", function() { 
        modal5.style.display = "none";
    })

    document.getElementById('close6').addEventListener("click", function() { 
        modal6.style.display = "none";
    })

    




}