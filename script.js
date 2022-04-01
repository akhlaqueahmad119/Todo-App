let btn = document.getElementById("plus1");
let mainbox = document.querySelector(".input-box");
let rmainbox = document.querySelector(".cross-2")
let todoContainer = document.querySelector(".main");
let title = document.querySelector(".text-1");
let add_new = document.querySelector(".text-2");
let error = document.querySelector(".error");


btn.addEventListener("click", fn)

function fn(){
    mainbox.style.display = "flex"
}

  rmainbox.addEventListener("click", fnn)

  function fnn(){
     mainbox.style.display = "none"
     error.classList.add("vanish")
 }

 function addTodo() {
     if(title.value !== "" && add_new !== ""){
    let todotext = `<div class="box">
    <div class="box-1">
        <div class="todo">${title.value}</div>
        <div class="minus-1">-</div>
        <div class="cross-1">x</div>
    </div>
    <div class="ta">
   ${add_new.value}
</div>
</div>`;
      
 todoContainer.innerHTML += todotext;
 mainbox.style.display = "none"
 title.value = ""
 add_new.value= ""
 crossandMinimise()
  }else{
     error.classList.remove("vanish")
 }
}
 function crossandMinimise(){
 let CrossbtnArr = document.querySelectorAll(".cross-1")
 let MinusbtnArr = document.querySelectorAll(".minus-1")
 for(let i = 0;i< CrossbtnArr.length;i++){
     CrossbtnArr[i].addEventListener("click",closeTicket)
 }

 function closeTicket(e){
     console.log(e.target.closest(".box"))
     let box = e.target.closest(".box")
     box.style.display = "none"
  }
  for(let i = 0;i< MinusbtnArr.length;i++){
    MinusbtnArr[i].addEventListener("click",Minimize)
}
function Minimize(e){
  let boxx = e.target.closest(".box")
  let minusss = boxx.querySelector(".ta")
  console.log(minusss)
  if(minusss.style.display!="none"){
    minusss.style.display="none"
  }else{
    minusss.style.display ="flex"
  }
}
 }

//  let obj = [
//      {
//          title:"task1",
//          task:"this is task1"
//      },
//      {
//         title:"task2",
//         task:"this is task2"
//     },
//     {
//         title:"task3",
//         task:"this is task3"
//     },
//  ];
//  for(let i = 0;i<obj.length;i++){
//     let todotext = `<div class="box">
//     <div class="box-1">
//         <div class="todo">${obj[i].title}</div>
//         <div class="minus-1">-</div>
//         <div class="cross-1">x</div>
//     </div>
//     <div class="ta">
//    ${obj[i].task}
// </div>
// </div>`;
// todoContainer.innerHTML += todotext;
//  }