function fetchCustomers() {
    const apiUrl = "http://localhost:8080/admin/allCustomers";
    axios.get(apiUrl, {
            headers: {
                Authorization: `Bearer ${localStorage.getItem('token')}`
            }
        })
        .then((response) => {
            console.log(response);
            const data = response.data;
            console.log(data);
            const customerTableBody = document.getElementById('customerTableBody');
            customerTableBody.innerHTML = '';

            data.forEach((customer, index) => {
                const row = document.createElement('tr');

                row.innerHTML = `
                    <th scope="row">${index + 1}</th>
                    <td>${customer.fName}</td>
                    <td>${customer.lName}</td>
                    <td>${customer.houseNo}</td>
                    <td>${customer.state}</td>
                    <td>${customer.city}</td>
                    <td>${customer.country}</td>
                    <td>${customer.pinCode}</td>
                    <td>${customer.gender}</td>
                    <td>${customer.aadhaarNo}</td>
                    <td>${customer.pEmail}</td>
                `;
                customerTableBody.appendChild(row);
            })
        })
        .catch(error => {
           console.error('Error fetching data: ', error);
       });
}

window.addEventListener('load', fetchCustomers());
