
const dummy_function = () => {
    return true;
}

const greetings = (name, callback) => {
    callback(`Hello ${name}!`);
}

const welcomeCustomer = ({name, age}, resolve, reject) => {
    age >= 18 ? resolve(`Welcome ${name}!`) : reject('You shall no pass!');
}

const welcomePromise = ({name, age}, delay=10000) => {
    return new Promise((resolve, reject)=>{
        setTimeout(()=>{
            age >= 18 ? resolve(`Welcome ${name}!`) : reject('You shall no pass!');
        },delay)
    })
}

module.exports = {
    dummy_function : dummy_function,
    greetings : greetings,
    welcomeCustomer : welcomeCustomer,
    welcomePromise : welcomePromise
}