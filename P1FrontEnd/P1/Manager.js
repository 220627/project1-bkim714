
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
            let cell4 = document.createElement("td");
            let cell5 = document.createElement("td");
            if(x.author_fk === 2){
             s = "Ben P."
            } else{
                s = "Null"
            }
            if (x.status_id_fk === 1){
                b = "Approved"
            } else if(x.status_id_fk === 2) {
                b = "Denied"
            } else {
                b = "Pending"
            }
            if (x.type_id_fk === 1){
                c = "General Principle"
            } else {
                c = "Boss Hog Outlaw"
            }
            cell.innerHTML = s
            row.appendChild (cell)
            cell2.innerHTML = x.amount
            row.appendChild (cell2) 
            cell3.innerHTML = b
            row.appendChild(cell3)
            cell4.innerHTML = c
            row.appendChild (cell4)
            cell5.innerHTML = x.reimb_id
            row.appendChild (cell5)
            
                
            console.log(x)
            // reamount.innerHTML = x.amount
            // restatus.innerText = x.status_id_fk
            // reid.innerText = x.type_id_fk
                document.getElementById("append").appendChild(row)
                
        }

 }

}