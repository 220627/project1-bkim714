
const url = "http://localhost:3000"

let reamount = document.getElementById("reamount");
let restatus = document.getElementById("restatus");
let reid = document.getElementById("reid");

//when the user clicks the button, execute the fetchData function
document.getElementById("btn").onclick = submitFunction
document.getElementById("btn2").onclick = viewFunction
//this is a cleaner way to add an event listener to an element

//compare this function to the ajaxFunc() in HelloAjax...this is much cleaner



 async function submitFunction(){


    let userAmount = document.getElementById("userAmount").value;
    let userType = document.getElementById("userType").value;
    console.log(typeof(userType))
    let submit = {
        amount: userAmount,
        type_id_fk: userType,
    };

    let post = {
        method: "POST",
        body: JSON.stringify(submit),
        credentials: "include",
    };
    
    let response = await fetch(url + "/submit", post) 
    console.log(response)
    //now we need to check if the promise returned successfully
    if(response.status === 202) {
        let data = await response.json() //turn the JSON data into JS
        console.log(data);
        document.getElementById("header").innerHTML = "Submit Successful"
        

        } else {
            document.getElementById("header").innerHTML = "Did Not Submit"
        }
   
    }





async function viewFunction() {

   
 

    let response = await fetch(url + "/view");
    
    if(response.status === 200) {
        let data = await response.json() //turn the JSON data into JS
        
        renderHTML(data)  //send it to the renderHTML() function to get rendered
        
    } else {
        document.getElementById("header").innerHTML = "Something Went Wrong"
    }

    //this function will manipulate the DOM based on the user's input & response from the server
    function renderHTML(data) {

        for (let x of data) {
            let row = document.createElement("tr");
            let cell = document.createElement("td");
            let cell2 = document.createElement("td");
            let cell3 = document.createElement("td");
            cell.innerHTML = x.amount
            row.appendChild (cell) 
            cell2.innerHTML = x.status_id_fk
            row.appendChild(cell2)
            cell3.innerHTML = x.type_id_fk
            row.appendChild (cell3)
            console.log(x)
            // reamount.innerHTML = x.amount
            // restatus.innerText = x.status_id_fk
            // reid.innerText = x.type_id_fk
                document.getElementById("append").appendChild(row)
                
        }
        

 }

}