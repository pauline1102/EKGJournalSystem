async function opretPatient() {
    let formElement = document.getElementById("formOP");
    let formData = new FormData(formElement);
    let json = Object.fromEntries(formData);
    let res = await fetch("rest/patienter",{
            method: "POST",
            body: JSON.stringify(json),
            headers: {
                "content-type": "application/json",
                "authorization": "Bearer " + localStorage.getItem("token")
            }

        })
    {

        let confirmAction=confirm("Bekærft oprettelse af patient");
        if(confirmAction){
            alert("Patient oprettet");
        }
        else{
            alert("Oprettelse af patient annulleret");
        }

        console.log(confirmAction);
        //OK=true, Cancel=false

    }
}


async function Tilbage(){
    localStorage.setItem("token"," ");
    window.location.href="konsultationer.html"

}