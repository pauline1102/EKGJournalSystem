async function Logud(){
    localStorage.setItem("token"," ");
    window.location.href="index.html"

}


async function patient(){
    let token = localStorage.getItem("token")
    fetch("rest/tokentest",{
        method:"POST",
        body: token,
        headers: {
            "authorization": "Bearer "+localStorage.getItem("token")
        }
    })
    window.location.href="PatientForside.html"
}

async function læge(){
    let token = localStorage.getItem("token")
    fetch("rest/tokentest",{
        method:"POST",
        body: token,
        headers:{
            "authorization": "Bearer "+localStorage.getItem("token")
        }
    })
    window.location.href="lægeForside.html"
}