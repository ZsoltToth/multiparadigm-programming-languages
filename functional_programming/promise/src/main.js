const api = require('./api');

let john = { name : 'John', age : 42};
let jimmy = { name : 'Jimmy', age : 12};

api.welcomePromise(john)
    .then((msg)=>{console.log(msg)})
    .catch((msg=>{console.warn(msg.toUpperCase())}));
api.welcomePromise(jimmy,5000)
    .then((msg)=>{console.log(msg)})
    .catch((msg=>{console.warn(msg.toUpperCase())}));

const {Scheduler} = require('./scheduler');

const tasks = [
    {name : 'task1', cost: 1},
    {name : 'task2', cost: 2},
    {name : 'task3', cost: 3},
    {name : 'task4', cost: 4}
]

let scheduler = new Scheduler(tasks);

scheduler.schedule();
