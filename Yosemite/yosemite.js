var slideIndex = 0;
window.onload = function showSlides() {
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
            console.log(yosemiteWeather.main.temp)
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

//NPS API
const NPSapikey = 'ST20MBOOcrZHBBZXij1k6THaDDQN2JJpDY4eyf6H' 

let getNPSdata = function() {
    fetch('https://developer.nps.gov/api/v1/campgrounds?parkCode=acad&api_key=ST20MBOOcrZHBBZXij1k6THaDDQN2JJpDY4eyf6H')
    .then((response) => {
        return response.json
    })
    .then((data) => {NPSdata = data})
}