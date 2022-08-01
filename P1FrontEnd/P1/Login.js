
const url = "http://localhost:3000"



//when the user clicks the button, execute the fetchData function
document.getElementById("btn").onclick = loginFunction;
//this is a cleaner way to add an event listener to an element

async function loginFunction(){

    //put the user input into a variable
    let username = document.getElementById("Username").value;
    let password = document.getElementById("password").value;
    let user = {
        username: username,
        password: password,
    };
    let post = {
        method: "POST",
        body: JSON.stringify(user),
        credentials: "include",
    };
    
    let response = await fetch(url + "/login", post) //await  pauses the function until data comes back
    //fetch sends a GET request by default, this one takes our base URL plus the user's input

    //now we need to check if the promise returned successfully
    if(response.status === 202) {
        let data = await response.json() //turn the JSON data into JS
        console.log(data);
        localStorage.setItem("user", JSON.stringify(data));
        let user = JSON.parse(localStorage.getItem("user"));
        if(user.user_id === 1){
            window.location.href = "./Manager.html";

        } else {
            window.location.href = "./Employee.html";
        }
   

    }



}