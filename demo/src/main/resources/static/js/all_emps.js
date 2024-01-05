function fetchEmployees() {
    const apiUrl = "http://localhost:8080/admin/getAllEmployees";
    axios.get(apiUrl, {
            headers: {
                Authorization: `Bearer ${localStorage.getItem('token')}`
            }
        })
        .then((response) => {
            console.log(response);
            const data = response.data;
            console.log(data);
            const employeeTableBody = document.getElementById('employeeTableBody');
            employeeTableBody.innerHTML = '';

            data.forEach((employee, index) => {
                const row = document.createElement('tr');

                row.innerHTML = `
                    <th scope="row">${index + 1}</th>
                    <td>${employee.fName}</td>
                    <td>${employee.lName}</td>
                    <td>${employee.houseNo}</td>
                    <td>${employee.state}</td>
                    <td>${employee.city}</td>
                    <td>${employee.country}</td>
                    <td>${employee.pincode}</td>
                    <td>${employee.gender}</td>
                    <td>${employee.aadhaarNo}</td>
                    <td>${employee.pEmail}</td>
                    <td>${employee.role}</td>
                    <td>${employee.salary}</td>
                    <td>${employee.loan}</td>
                    <td>${employee.loanDetails}</td>
                    <td>${employee.accountNo}</td>
                    <td>${employee.ifsccode}</td>
                    <td>${employee.bankName}</td>
                `;
                employeeTableBody.appendChild(row);
            })
        })
        .catch(error => {
           console.error('Error fetching data: ', error);
       });
}

window.addEventListener('load', fetchEmployees());
