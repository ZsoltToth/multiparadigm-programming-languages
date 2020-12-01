import api from '../api';

describe('Dummy Test Suite', ()=>{
    it('is a dummy test', ()=>{
        let expected = true;
        let actual = api.dummy_function();
        expect(actual).toBe(expected);
    })
})