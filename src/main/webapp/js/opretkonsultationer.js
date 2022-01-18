async function opretKonsultation(){
    let formElement = document.getElementById("aftaleform");
    let formData = new FormData(formElement);
    let json= Object.fromEntries(formData);
    let res = await fetch("rest/aftaler", {
        method:"POST",
        body: JSON.stringify(json),
        headers:{
            'content-type':"application/json",
            "authorization": "Bearer " + localStorage.getItem("token")
        }
    })

}

async function  SeKonsultation(){
    let result = await fetch("rest/aftaler", {
            headers: {
                "authorization": "Bearer " + localStorage.getItem("token")
            }
        }
    );
    console.log(result.status)
    if (result.status!=200){
        alert("noget gik galt!");
    }
    let json = await result.json();
    console.log(json)

    let listelements =""
    json.forEach(function(element){
        listelements +=("<li>"+element.date+"</li>")
    })

    let list = document.getElementById("aftaler");
    list.innerHTML=listelements
}

async function Logud(){
    localStorage.setItem("token"," ");
    window.location.href="index.html"

}

async function Tilbage(){
    localStorage.setItem("token"," ");
    window.location.href="patientForside.html"

}