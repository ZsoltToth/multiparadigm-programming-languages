const axios = require('axios');

const dummy_function = () => {
    return true;
}

const fetchWeatherInfo = (city) => {
    const api_key = process.env.OPEN_WEATHER_API_KEY;
    axios.get(`http://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${api_key}`)
        .then(resp => console.log(resp.data))
        .catch(err => console.error(resp));
}

module.exports = {
    dummy_function : dummy_function,
    fetchWeatherInfo : fetchWeatherInfo
}