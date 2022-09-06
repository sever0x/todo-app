function changeTodoState(checkboxElem) {
    var task = checkboxElem.parentNode.parentNode.querySelector('.task');
    if (checkboxElem.checked) {
        task.classList.add('complete');
    } else {
        task.classList.remove('complete');
    }
    $.post("/change-state/" + checkboxElem.id);
}