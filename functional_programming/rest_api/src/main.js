const api = require('./api');

const cities = ['Eger', 'Debrecen', 'Budapest', 'Szeged','Bari'];

Promise.all(cities.map(city => api.fetchWeatherInfo(city))).then( (weatherInfos) => {
        weatherInfos.map( ({name : city, main}) => {return {city : city, temp : main.temp}})
            .filter((current, index, array)=> {
                return current.temp === array.reduce((total,curr) => total >= curr.temp ? total : curr.temp, Math.ninf);
            })
            .forEach(bestCity => console.log(` ${bestCity.city} (${bestCity.temp - 273.15})`));
    });

