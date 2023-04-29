function resetError(block) {
    // block.className = '';
    if (block.lastChild.className == "ermessage") {
        block.removeChild(block.lastChild);
    }
}

function showError(block, errorMessage) {
    // block.className = 'form-group';
    var errorSpan = document.createElement('span');
    errorSpan.className = "ermessage";
    errorSpan.innerHTML = errorMessage;
    block.appendChild(errorSpan);
}

function trim(stroka) {
    stroka = stroka.replace(/\s+/g, "");
    return stroka;
}
function validateUser(form) {
    var elementsForm = form.elements;
    var checker = true;
    resetError(elementsForm.login.parentNode);
    if (elementsForm.login.value.length == 0) {
        showError(elementsForm.login.parentNode, 'Укажите логин');
        checker = false;
    }
    if ((trim(elementsForm.login.value)).length == 0 && elementsForm.login.value.length > 0) {
        showError(elementsForm.login.parentNode, 'Логин не может состоять только из пробелов!');
        elementsForm.login.value = "";
        checker = false;
    }

    resetError(elementsForm.password.parentNode);
    if (elementsForm.password.value.length == 0) {
        showError(elementsForm.password.parentNode, 'Укажите логин');
        checker = false;
    }
    if ((trim(elementsForm.password.value)).length == 0 && elementsForm.password.value.length > 0) {
        showError(elementsForm.password.parentNode, 'Логин не может состоять только из пробелов!');
        elementsForm.password.value = "";
        checker = false;
    }

    resetError(elementsForm.password2.parentNode);
    if (elementsForm.password2.value != elementsForm.password.value) {
        showError(elementsForm.password2.parentNode, 'Пароли не совпадают');
        elementsForm.password2.value = "";
        checker = false;
    }

    if (!checker)
        event.preventDefault()
}