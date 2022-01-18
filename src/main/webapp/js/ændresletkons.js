async function Logud(){
    localStorage.setItem("token"," ");
    window.location.href="index.html"

}

async function Tilbage(){
    localStorage.setItem("token"," ");
    window.location.href="konsultationer.html"

}

async function ændrekons(){
    let token = localStorage.getItem("token")
    fetch("rest/tokentest",{
        method:"POST",
        body: token,
        headers: {
            "authorization": "Bearer "+localStorage.getItem("token")
        }
    })
    {
        window.alert("Bekræft ændring af konsultation")
    }
}

async function opretnykons(){
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

    {
       alert("Ny konsultation oprettet")
    }
}

async function sletkons(){
    let token = localStorage.getItem("token")
    fetch("rest/tokentest",{
        method:"POST",
        body: token,
        headers:{
            "authorization": "Bearer "+localStorage.getItem("token")
        }
    })

    {
        alert("Bekræft sletning af konsultation")
    }
}