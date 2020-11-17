
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
    return _filter_positives(array).length;
}

const _filter_positives = (array = []) => {
    return array.filter(num => num >= 0.0);
}

const _power = (array = []) => {
    return array.map(num => num * num);
}

const _grade_students = (exam_results, threshold = 50) => {
    return [{name : 'Alice', score: 32, result : 'FAILED'}];
}

const _avg_score = (exam_results) => {
    return 0;
}

const _std_score = (exam_results) => {
    return 1.0;
}

const _fit_results_to_curve = (exam_results, standard_mean = 50, standard_std = 10) => {
    const student_score = 32;
    let standard_score = (((_avg_score(exam_results) - student_score) / _std_score(exam_results)) * standard_std) + standard_mean;
    return [{name : 'Alice', score: student_score, standard_score : standard_score}];
}

module.exports = {
    dummy_function : dummy_function,
    greetins : _greetins,
    sum_of_array : _sum_of_array,
    count_positives : _count_positives,
    filter_positives : _filter_positives,
    power : _power,
    grade_students : _grade_students,
    avg_score : _avg_score,
    std_score : _std_score
}