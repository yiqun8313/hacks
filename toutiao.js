// var quickSort = function(arr) {

//     　　if (arr.length <= 1) { return arr; }
    
//     　　var pivotIndex = Math.floor(arr.length / 2);
    
//     　　var pivot = arr.splice(pivotIndex, 1)[0];
    
//     　　var left = [];
    
//     　　var right = [];
    
//     　　for (var i = 0; i < arr.length; i++){
    
//     　　　　if (arr[i] < pivot) {
    
//     　　　　　　left.push(arr[i]);
    
//     　　　　} else {
    
//     　　　　　　right.push(arr[i]);
    
//     　　　　}
    
//     　　}
    
//     　　return quickSort(left).concat([pivot], quickSort(right));
    
//     };

//     Function.prototype.bind=function(oThis){
//         var self=this;
//         var args=Array.prototype.slice.call(arguments,1);
//         var result=function(){
//             return self.apply(oThis,args.concat(Array.prototype.slice.call(arguments)));
//         };
    
//         var temp=function(){};
//         temp.prototype=this.prototype;
//         result.prototype=new temp();
//         return result;
//     };


//     function t2() {
//         var b=100;
//         function t3() {
//             console.log(b);
//         }
//         return t3();
//     }
//     t2();

//     function f1(){
//         　　　　var n=999;
//         　　　　nAdd=function(){n+=1}
//         　　　　function f2(){
//         　　　　　　alert(n);
//         　　　　}
//         　　　　return f2;
//         　　}
        //999
        //1000


        // console.log('Hello World!');


// setTimeout(function() {
//     setTimeout(function() { console.log(1) }, 100)
//     console.log(2)
//     setTimeout(function() { console.log(3) }, 0)
// },0)

//     setTimeout(function () {console.log(4)}, 100)
//     console.log(5)
    
//5 2 3 4 1




// function printing() {
//     console.log(1); 
//     setTimeout(function() { console.log(2); }, 1000); 
//     setTimeout(function() { console.log(3); }, 0); 
//     console.log(4);
//  }
//  printing();


// (function() {
//     console.log(1); 
//     setTimeout(function(){console.log(2)}, 100); 
//     setTimeout(function(){console.log(3)}, 200); 
//     console.log(4);
// })();





function maxCount(){
    if(array.length == 0 ){
     return null;
    }
    var  map={};
    var count=1,max=arr[0];
   
    for(let i=0;i<arr.length;i++){
        if(map[arr[i]]== null){
           map[arr[i]]=1
        }
        else{
           map[arr[i]]++;
        }
        if(map[arr[i]] > count){
             max=arr[i];
             count=map[arr[i]];
        }
    }
    var res={item:max,count:count};
    return res;
}




// 检查 数组中的最大最小值
// var maxInNumbers = Math.max.apply(Math, numbers);

// var minInNumbers = Math.min.apply(Math, numbers);

// setTimeout(function() {
//     setTimeout(function() { console.log(1) }, 0)
//     console.log(2)
//     setTimeout(function() { console.log(3) }, 0)
// },0)

//     setTimeout(function () {console.log(4)}, 0)
//     console.log(5)

    //5，2，4，1，3


    // for (var i = 0; i < 5; i++) {
    //     (function (i) {
    //         setTimeout(function () {
    //             console.log(i)
    //         }, 1000);
    //     })(i);
    // }

    //01234

    // for (let i = 0; i < 4; i++) {
    //     (function (i) {
    //       setTimeout( ()=>console.log(i), 0)
    //     })(i)
    //     }


//     const arr = [10, 12, 15, 21];
// for (var i = 0; i < arr.length; i++) {
//   setTimeout(function() {
//     console.log('Index: ' + i + ', element: ' + arr[i]);
//   }, 3000);
// }


function addPrefix(prefix, ...words) {
    const prefixedWords = [];
    for (let i=0; i<words.length; i++) {
    prefixedWords[i] = prefix + words[i];
    }
    return prefixedWords; 
    }
    
    var r=addPrefix("con", "verse", "vex");


    // function getSentence([ subject, verb, object ]) {
    //     return `${subject} ${verb} ${object}`;
    //     }
    //     const arr = [ "I", "love", "JavaScript"];
        
    //    var r= getSentence(arr);


    var s1= sum(2)(3);
    var s2=sum(2,3);
    function sum(a,b){
        if( b == undefined){
            return function(c){
                return parseInt(a) + parseInt(c);
            }
        }
        return parseInt(a)+ parseInt(b);
        
    }

const isIntger=function(x){
    let t=parseInt(x,10);
    if( t == x ) return true;
    else return false;
} 
let t1=isIntger(2.3);
let t2=isIntger(4);







    // var Singleton = (
    //     function () {
    //     var instance;
     
    //     function createInstance() {
    //         var object = new Object("I am the instance");
    //         return object;
    //     }
     
    //     return {
    //         getInstance: function () {
    //             if (!instance) {
    //                 instance = createInstance();
    //             }
    //             return instance;
    //         }
    //     };
    // })();
     
    // function run() {
     
    //     var instance1 = Singleton.getInstance();
    //     var instance2 = Singleton.getInstance();
     
    //     console.log("Same instance? " + (instance1 === instance2));  
    // }




    var Singleton=(function(){
        var instance;
        const createItem=function(){
            var obj=new Object("I am chris");
            return obj;
        }
        return {  //返回一个结构体里面写着一个函数
         getItem:function(){
             if(!instance){
                instance = createItem();
             }
             return instance;
         }
        }
    })();

    var simple1=new Singleton.getItem();
    var simple12=new Singleton.getItem();
    if(simple1 == simple12 ) console.log("yes!!!baby")












class Emitter {
  constructor(){
    this.subEvents = new Map();
  }

  subscribe(eventName, callback) {
    this.subEvents.set(eventName, callback);
  }

  unsubscribe(eventName) {
    this.subEvents.delete(eventName);
  }

  emit(eventName){
      const callback = this.subEvents.get(eventName);
      if(callback){
        const args = Array.from(arguments);
        args.splice(0, 1);
        callback.apply(this, args);
      }
  }
}

const emmiter = new Emitter();
emmiter.subscribe("event1", (name, surname)=&gt;{alert[name + " " + surname)});
emmiter.emit("event1", "Hello", "World");
emmiter.unsubscribe("event1");
emmiter.emit("event1", "Hello", "World");









function printDiagnally(input){
    let n = input.length       // 3
    let lines = 2*(n-1) + 1     // 5

    // determine how many diagonal lines
    for( let sum = 0; sum < lines; sum++ ){

        // determine the starting x-coord, and starting y-coord
        let x0 = sum < n ? sum : n-1
        let y0 = sum - x0
        let num = Math.abs(x0 - y0) +1   // how many elements in this line
        let str = ""

        // concat all elements in this line
        for( let x = x0; x > x0-num; x-- ){
            let y = sum - x
            str = input[x][y] + " "+str
        }
        console.log(str)
    }
}




//todo list example

import React, {Component} from 'react';
const Filter = props => {
  return (
    <div className="Filter">
      <button
        onClick={() => {
          props.setFilter('all');
        }}
        disabled={props.currentFilter === 'all'}>
        All
      </button>
      <button
        onClick={() => {
          props.setFilter('active');
        }}
        disabled={props.currentFilter === 'active'}>
        Active
      </button>
      <button
        onClick={() => {
          props.setFilter('completed');
        }}
        disabled={props.currentFilter === 'completed'}>
        Completed
      </button>
    </div>
  );
};
const TodoList = props => {
  // props.todos will be the todo array
  // from App component
  const {currentFilter} = props;
  const todosToShow = props.todos.filter(todo => {
    if (currentFilter === 'all') {
      return true;
    } else if (currentFilter === 'active') {
      return !todo.completed;
    } else {
      return todo.completed;
    }
  });
  return (
    <ul>
      {todosToShow.map((todo, index) => {
        return (
          <li
            key={index}
            style={{textDecoration: todo.completed ? 'line-through' : 'none'}}
            onClick={() => {
              props.toggleTodo(index);
            }}>
            {todo.text}
          </li>
        );
      })}
    </ul>
  );
};
class AddTodo extends Component {
  state = {input: ''};

  render() {
    return (
      <div className="AddTodo">
        <input
          value={this.state.input}
          onChange={e => {
            this.setState({input: e.target.value});
          }}
        />
        <button
          onClick={() => {
            this.props.addTodo(this.state.input);
            this.setState({input: ''});
          }}>
          Add New
        </button>
      </div>
    );
  }
}

class App extends Component {
  // for every single todo
  // {text: <String>, completed: <Bool>}
  state = {todos: [], filter: 'all'};

  addTodo = text => {
    this.setState({
      todos: [...this.state.todos, {text, completed: false}],
    });
  };

  toggleTodo = index => {
    this.setState({
      todos: [
        ...this.state.todos.slice(0, index),
        {
          ...this.state.todos[index],
          completed: !this.state.todos[index].completed,
        },
        ...this.state.todos.slice(index + 1),
      ],
    });
  };

  setFilter = filter => {
    this.setState({filter: filter});
  };
  render() {
    return (
      <div className="App">
        <AddTodo addTodo={this.addTodo} />
        <TodoList
          todos={this.state.todos}
          toggleTodo={this.toggleTodo}
          currentFilter={this.state.filter}
        />
        <Filter setFilter={this.setFilter} currentFilter={this.state.filter} />
      </div>
    );
  }
}

export default App;








var names = ['Alice', 'Bob', 'Tiff', 'Bruce', 'Alice'];
let res = names.reduce((accum, item)=>{
  if( accum[item] ){
    accum[item]++
  }else{
    accum[item] = 1
  }
  return accum
},{})
console.log(res)


function sum(x, y) {
 if (y !== undefined) {
 return x + y;
 } else {
 return function(y) { return x + y; };
 }
}





class EventEmitter {
  constructor() {
    this.events = {};
  }
  
  on(event, listener) {
      if (typeof this.events[event] !== 'object') {
          this.events[event] = [];
      }
      this.events[event].push(listener);
      return () => this.removeListener(event, listener);
  }
    
  removeListener(event, listener) {
    if (typeof this.events[event] === 'object') {
        const idx = this.events[event].indexOf(listener);
        if (idx > -1) {
          this.events[event].splice(idx, 1);
        }
    }
  }
  
  emit(event, ...args) {
    if (typeof this.events[event] === 'object') {
      this.events[event].forEach(
        listener => {
            if(typeof listener === 'function') listener.apply(null, args)}
      );
    }
  }
  
  once(event, listener) {
    const remove = this.on(event, (...args) => {
        remove();
        listener.apply(null, args);
    });
  }
};


let emitter = new EventEmitter()
// Test 1: invalid callback function
console.log("Test 1: Nothing should be print out")
emitter.on("a", 1);
emitter.emit("a");
console.log()





public List<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();    
    Stack<TreeNode> stack = new Stack<>();
 
    TreeNode p = root;
    while(p!=null){
        stack.push(p);
        p=p.left;
    }
 
    while(!stack.isEmpty()){            
        TreeNode t = stack.pop();
        result.add(t.val);
 
        t = t.right;
        while(t!=null){
            stack.push(t);
            t = t.left;
        }
    }
 
    return result;
}





$.ajax({
    url : url,
    dataType : 'json'
})
.done(function(data, statusText, resObject) {
   var jsonData = resObject.responseJSON
})
