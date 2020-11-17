
const dummy_function = () => {
    return true;
}

const _greetins = (callback, name = "World") => {
    callback(`Hello ${name}!`);
}

const _sum_of_array = (array = []) => {
    return array.reduce((total, current) => { return total  +current}, 0);
}

const _count_positives = (array = []) => {
    return 0;
}

const _filter_positives = (array = []) => {
    return [];
}

const _power = (array = []) => {
    return [];
}


module.exports = {
    dummy_function : dummy_function,
    greetins : _greetins,
    sum_of_array : _sum_of_array,
    count_positives : _count_positives,
    filter_positives : _filter_positives,
    power : _power
}