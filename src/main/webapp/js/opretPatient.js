async function opretPatient() {
    let formElement = document.getElementById("formOP");
    let formData = new FormData(formElement);
    let json = Object.fromEntries(formData);
    let res = await fetch(
        "rest/patienter", {
            method: "POST",
            body: JSON.stringify(json),
            headers: {
                "content-type": "application/json",
                "authorization": "Bearer " + localStorage.getItem("token")
            }
        })
}