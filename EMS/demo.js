
//Get the iframe element
const iframe = document.getElementById("myIframe");
console.log("This is iframe: " + iframe);

iframe.addEventListener("load", () => {
    const empListDoc = iframe.contentDocument;

    const tbody = empListDoc.getElementById("tab_body");

    const empForm = document.getElementById("employee-add-form");

    const modal = document.getElementById("add-eemployee-modal");


    empForm.addEventListener('submit', (e) => {
        e.preventDefault();

        //get the form data
        const name = empForm.elements.name.value;
        const email = empForm.elements.email.value;
        const phone = empForm.elements.phone.value;
        const designation = empForm.elements.designation.value;
        const dob = empForm.elements.dob.value;


        const row = empListDoc.createElement('tr');
        console.log(row);
        row.innerHTML = `
        <td>${name}</td>
        <td>${email}</td>
        <td>${phone}</td>
        <td>${designation}</td>
        <td>${dob}</td>
        `;

        tbody.appendChild(row);

        empForm.reset();

    });
});
