const axios = require('axios');

const dummy_function = () => {
    return true;
}

const fetchWeatherInfo = (city) => {
    const api_key = process.env.OPEN_WEATHER_API_KEY;
    return new Promise((resolve, reject) => {
        axios.get(`http://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${api_key}`)
            .then(resp => resolve(resp.data))
            .catch(err => reject({}));
    });
}

module.exports = {
    dummy_function : dummy_function,
    fetchWeatherInfo : fetchWeatherInfo
}