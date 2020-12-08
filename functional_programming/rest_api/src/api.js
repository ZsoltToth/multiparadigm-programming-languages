const axios = require('axios');
const winston = require('winston');

const logger = winston.createLogger({
    level: 'info',
    format: winston.format.json(),
    defaultMeta: { service: 'main' },
    transports: [
        //
        // - Write all logs with level `error` and below to `error.log`
        // - Write all logs with level `info` and below to `combined.log`
        //
        new winston.transports.Console({level : 'info'}),
    ],
});

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

const scoreWeather = ({temp, humidity}) => {
    const expectedHummidity = 80;
    const expectedTemperature = 20 + 273.15;
    return Math.abs(humidity - expectedHummidity) + Math.abs(temp - expectedHummidity);
}

module.exports = {
    dummy_function : dummy_function,
    fetchWeatherInfo : fetchWeatherInfo,
    scoreWeather : scoreWeather
}