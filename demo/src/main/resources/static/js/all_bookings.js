function formatDate(date) {
  const day = String(date.getDate()).padStart(2, '0');
  const month = String(date.getMonth() + 1).padStart(2, '0');
  const year = date.getFullYear();

  return `${day}-${month}-${year}`;
}

function fetchBookings() {
    const apiUrl = "http://localhost:8080/admin/getAllBookings";
    axios.get(apiUrl, {
            headers: {
                Authorization: `Bearer ${localStorage.getItem('token')}`
            }
        })
        .then((response) => {
            console.log(response);
            const data = response.data;
            console.log(data);
            const bookingTableBody = document.getElementById('bookingTableBody');
            bookingTableBody.innerHTML = '';

            data.forEach((booking, index) => {
                const row = document.createElement('tr');
                console.log(booking.checkInDate);
                const inDate = new Date(booking.checkInDate);
                const outDate = new Date(booking.checkOutDate);

                const checkInDate = formatDate(inDate);
                const checkOutDate = formatDate(outDate);

                row.innerHTML = `
                    <th scope="row">${index + 1}</th>
                    <td>${checkInDate}</td>
                    <td>${checkOutDate}</td>
                    <td>${booking.noOfGuests}</td>
                    <td>${booking.customerID}</td>
                `;
                bookingTableBody.appendChild(row);
            })
        })
        .catch(error => {
           console.error('Error fetching data: ', error);
       });
}

window.addEventListener('load', fetchBookings());