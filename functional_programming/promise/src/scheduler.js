class Scheduler{

    tasks = [];

    constructor(tasks = []) {
        this.tasks = tasks.map((task, index) => {return  {...task,id : index }});
    }

    schedule = () =>{
        this._runTask(0);
    }

    _runTask = (taskId) =>{
       new Promise((resolve, reject)=> {
           if(taskId >= this.tasks.length) reject();
           const {name, cost,id} = this.tasks[taskId];
           console.log(`Task ${id}: ${name} has started! Cost: ${cost}`);
           setTimeout(()=>{
               resolve({name : name, id : taskId});
           }, cost * 1000);
       }).then(({name, id})=>{
           console.log(`Task ${id}: ${name} has finished!`);
           this._runTask(taskId+1)
       }).catch(()=>{console.log('Scheduling has finished!')});
    }
}

module.exports = {
    Scheduler : Scheduler
}