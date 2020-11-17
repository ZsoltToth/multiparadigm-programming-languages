
const dummy_function = () => {
    return true;
}

const _greetins = (name = 'World') => {
    console.log(`Hello ${name}!`);
}

module.exports = {
    dummy_function : dummy_function,
    welcome : _greetins
}