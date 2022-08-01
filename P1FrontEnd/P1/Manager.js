
const url = "http://localhost:3000"



document.getElementById("btn").onclick = approveFunction
document.getElementById("btn2").onclick = viewFunction

async function approveFunction(){

   
    let userId = document.getElementById("userId").value;
    let userType = document.getElementById("userType").value;
    //console.log(typeof(userType))
    let submit = {
        reimb_id: userId,
        status_id_fk: userType,
    };

    let put = {
        method: "PUT",
        body: JSON.stringify(submit),
        credentials: "include",
    };
    
    let response = await fetch(url + "/status", put) 
    console.log(response)
    
    if(response.status === 202) {
        let data = await response.json()
        console.log(data);
        document.getElementById("header").innerHTML = "Submit Successful"
        

        } else {
            document.getElementById("header").innerHTML = "Did Not Submit"
        }

}



async function viewFunction() {

   

    let response = await fetch(url + "/view");
    
    if(response.status === 200) {
        let data = await response.json() 
        
        renderHTML(data)  
        
    } else {
        document.getElementById("header").innerHTML = "Something Went Wrong"
    }

    
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