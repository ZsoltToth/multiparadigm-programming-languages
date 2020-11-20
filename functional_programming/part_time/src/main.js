const grading = require('./grading');

grading.readDatafile('../data/exam_results.json', (exam_results) => {
    grading.gradeStudents(exam_results).forEach( ({name, score, result}) => {
        console.log(`${name},${score},${result}`);
    });
});