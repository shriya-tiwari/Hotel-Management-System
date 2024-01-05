function deleteEmployee() {
    const employeeEmail = document.getElementById("employeeEmail").value;

    const apiUrl = "http://localhost:8080/admin/deleteEmployee";

    if (confirm(`Are you sure you want to delete the employee with email: ${employeeEmail}?`)) {
        const data = {
                pEmail: employeeEmail,
        }
        axios.post(apiUrl, data, { headers: { Authorization: `Bearer ${localStorage.getItem('token')}`}})
        .then((response) => {
            console.log(response.data);
            alert("Employee deleted successfully");
            window.location.reload();
        })
        .catch(error => {
           alert("Some error occurred!! Please try again later");
           console.error('Error fetching data: ', error);
       });
     }
}