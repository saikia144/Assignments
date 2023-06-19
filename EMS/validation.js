function validateForm() {
    const uname = document.forms["myForm"]["uname"].value;
    const pwd = document.forms["myForm"]["pwd"].value;

    if (uname != "admin" || pwd != "root") {
        alert('Please enter correct credentials')
        return false;
    }
}