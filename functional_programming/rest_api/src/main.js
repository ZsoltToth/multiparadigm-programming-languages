const axios = require('axios');

const api_key = process.env.OPEN_WEATHER_API_KEY;
const city_name = 'Eger';

axios.get(`http://api.openweathermap.org/data/2.5/weather?q=${city_name}&appid=${api_key}`)
    .then(resp => console.log(resp.data))
    .catch(err => console.error(resp));