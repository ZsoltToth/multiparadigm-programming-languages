const api = require('./api');
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

const cities = ['Eger', 'Debrecen', 'Budapest', 'Szeged','Bari'];

Promise.all(cities.map(city => api.fetchWeatherInfo(city))).then( (weatherInfos) => {
        weatherInfos.forEach(logger.info);
        weatherInfos.map( ({name : city, main}) => {return {city : city, score : api.scoreWeather(main)}})
            .filter((current, index, array)=> {
                return current.score === array.reduce((total, curr) => total <= curr.score ? total : curr.score, Math.inf);
            })
            .forEach(bestCity => console.log(` ${bestCity.city} (${bestCity.score})`));
    });

