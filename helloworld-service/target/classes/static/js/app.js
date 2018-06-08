function validate() {
	var name = document.getElementById("country").value;
	if (name == '') {
		alert('Please enter a valid value.');
		return false;
	} else {
		return true;
	}
}