const fs = require('fs');

const readDatafile = (filePath, callback) => {
   fs.readFile(filePath,{encoding: "utf-8", flag: 'r'}, (err, data) => {
       callback(JSON.parse(data));
   })
}

const gradeStudents = (exam_results, minimum_score = 50) =>{
    return exam_results.map(n=> ({...n,result: (n.score>=minimum_score?'PASSED':'FAILED')}));
}

const meanScoreOfExamResults = (exam_results = []) => { return 0.0;}
const stdScoreOfExamResults = (exam_results = []) => { return 0.0;}

module.exports = {
    readDatafile : readDatafile,
    gradeStudents  :gradeStudents,
    meanScoreOfExamResults : meanScoreOfExamResults,
    stdScoreOfExamResults : stdScoreOfExamResults
}