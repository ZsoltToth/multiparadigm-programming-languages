import grading from '../grading';

describe('Grading Tests', ()=>{

    var scores = [
        {
            name : 'Alice',
            score : 32
        },
        {
            name : 'Bob',
            score : 39
        },
        {
            name : 'Charlie',
            score : 98
        },
        {
            name : 'Denis',
            score : 78
        },
        {
            name : 'Eve',
            score : 56
        },
        {
            name : 'Frank',
            score : 14
        },
        {
            name : 'Gabe',
            score : 49
        },
        {
            name : 'Hugo',
            score : 39
        },
        {
            name : 'Ivan',
            score : 100
        },
        {
            name : 'John',
            score : 43
        },
        {
            name : 'Kevin',
            score : 65
        },
        {
            name : 'Lousie',
            score : 54
        },
        {
            name : 'Maria',
            score : 63
        },
        {
            name : 'Nate',
            score : 65
        },
        {
            name : 'Oliver',
            score : 12
        },
        {
            name : 'Pedro',
            score : 87
        },
        {
            name : 'Rebeca',
            score : 83
        },
        {
            name : 'Sarah',
            score : 29
        },
        {
            name : 'Tamara',
            score : 73
        },
        {
            name : 'Wade',
            score : 5
        },
    ]

    it('compares the read json', ()=>{
        grading.readDatafile('../../data/exam_results.json', (data)=>{
            expect(data).toEqual(scores);
        })
    });

    it('grade a single student who failed', ()=>{
        const FAILED_STUDENT = {...scores[0],result : 'FAILED'};
        expect(grading.gradeStudents(scores)[0]).toEqual(FAILED_STUDENT);
    });

    it('grade a single student who passed', ()=>{
        const PASSED_STUDENT = {...scores[2],result : 'PASSED'};
        expect(grading.gradeStudents(scores)[2]).toEqual(PASSED_STUDENT);
    });
});