async function sejournal(){
    let token = localStorage.getItem("token")
    fetch("rest/tokentest",{
        method:"POST",
        body: token,
        headers: {
            "authorization": "Bearer "+localStorage.getItem("token")
        }
    })
}

async function Tilbage() {
    window.location.href = "PatientForside.html"

}