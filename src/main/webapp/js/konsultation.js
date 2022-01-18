async function Logud(){
    localStorage.setItem("token"," ");
    window.location.href="index.html"

}

async function Tilbage(){
    localStorage.setItem("token"," ");
    window.location.href="vælgbruger.html"

}


async function opret(){
    let token = localStorage.getItem("token")
    fetch("rest/tokentest",{
        method:"POST",
        body: token,
        headers: {
            "authorization": "Bearer "+localStorage.getItem("token")
        }
    })
    window.location.href="opretkonsultation.html"
}

async function hent() {
    let token = localStorage.getItem("token")
    fetch("rest/tokentest", {
        method: "POST",
        body: token,
        headers: {
            "authorization": "Bearer " + localStorage.getItem("token")
        }
    })
    window.location.href = "hentkons.html"
}

async function ændre() {
    let token = localStorage.getItem("token")
    fetch("rest/tokentest", {
        method: "POST",
        body: token,
        headers: {
            "authorization": "Bearer " + localStorage.getItem("token")
        }
    })
    window.location.href = "ændrekonsultation.html"
}
async function slet() {
    let token = localStorage.getItem("token")
    fetch("rest/tokentest", {
        method: "POST",
        body: token,
        headers: {
            "authorization": "Bearer " + localStorage.getItem("token")
        }
    })

    window.location.href = "sletkonsultation.html"
}