async function Logud(){
    localStorage.setItem("token"," ");
    window.location.href="index.html"

}

async function Tilbage(){
    localStorage.setItem("token"," ");
    window.location.href="vælgbruger.html"

}

async function gotoopretkonsultation(){
    let token = localStorage.getItem("token")
    fetch("rest/tokentest",{
        method:"POST",
        body: token,
        headers: {
            "authorization": "Bearer "+localStorage.getItem("token")
        }
    })
    window.location.href="konsultationer.html"
}

async function journal(){
    let token = localStorage.getItem("token")
    fetch("rest/tokentest",{
        method:"POST",
        body: token,
        headers:{
            "authorization": "Bearer "+localStorage.getItem("token")
        }
    })
    window.location.href="journal.html"
}