function formatDate(date) {
  const day = String(date.getDate()).padStart(2, '0');
  const month = String(date.getMonth() + 1).padStart(2, '0');
  const year = date.getFullYear();

  return `${day}-${month}-${year}`;
}

function fetchBookings() {
    const apiUrl = "http://localhost:8080/getBookings";
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
                console.log(booking.getCheckInDate);
                const inDate = new Date(booking.getCheckInDate);
                const outDate = new Date(booking.getCheckOutDate);

                const checkInDate = formatDate(inDate);
                const checkOutDate = formatDate(outDate);

                row.innerHTML = `
                    <th scope="row">${index + 1}</th>
                    <td>${checkInDate}</td>
                    <td>${checkOutDate}</td>
                    <td>${booking.getNoOfGuests}</td>
                    <td>${booking.typeName}</td>
                    <td>${booking.roomNo}</td>
                    <td>${booking.cost}</td>
                    <td>
                        <a href='/dashboard/avail_service' class="abtn">Avail Services</a>

                    </td>
                `;
                bookingTableBody.appendChild(row);
            })
        })
        .catch(error => {
           console.error('Error fetching data: ', error);
       });
}

window.addEventListener('load', fetchBookings());

function logOutUser() {
    localStorage.removeItem('token');
    axios
        .get('http://localhost:8080/logout')
        .then((response) => {
          console.log('User logged out successfully');
          window.location.href = '/login';
        })
        .catch((error) => {
          console.error('Error logging out:', error);
        });
}

function cancelBooking(bookingID) {
    const apiUrl = "http://localhost:8080/deleteBooking";
    console.log(`http://localhost:8080/deleteBooking/${bookingID}`);
    const data = {
        bookingID: bookingID,
    }
    axios.post(apiUrl, data, { headers: { Authorization: `Bearer ${localStorage.getItem('token')}`}})
    .then((response) => {
        console.log(response.data);
        alert("Booking cancelled successfully");
        window.location.reload();
    })
    .catch(error => {
       alert("Some error occurred!! Please try again later");
       console.error('Error fetching data: ', error);
   });

}