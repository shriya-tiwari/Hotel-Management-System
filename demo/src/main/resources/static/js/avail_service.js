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
            console.log(data.length)


            const choices = document.getElementById('bookingNo');
            choices.innerHTML = '';
            const bookingTableBody = document.getElementById('bookingTableBody');
            bookingTableBody.innerHTML = '';
            var count = 0;
            data.forEach((booking, index) => {
                const row = document.createElement('tr');

                console.log(booking.getCheckInDate);
                const inDate = new Date(booking.getCheckInDate);
                const outDate = new Date(booking.getCheckOutDate);

                const checkInDate = formatDate(inDate);
                const checkOutDate = formatDate(outDate);

                const d = new Date();
                console.log(outDate);
                console.log(inDate);
                console.log(d);
                if(outDate >= d) {
                    count += 1;
                    row.innerHTML = `
                       <th scope="row">${count}</th>
                       <td>${checkInDate}</td>
                       <td>${checkOutDate}</td>
                   `;
                   bookingTableBody.appendChild(row);
                   const option = document.createElement('option');
                   option.value = booking.getBookingID;
                   option.innerHTML = `Booking ${count}`;
                   choices.appendChild(option);
                }
            })
            if(count == 0) {
                const button = document.querySelector(".rbtn");
                button.disabled = true;
                const el = document.getElementById("error-text");
                el.innerHTML = "No bookings available for availing services";
            }
        })
        .catch(error => {
           console.error('Error fetching data: ', error);
       });
}

window.addEventListener('load', fetchBookings());

function logoutUser() {
    const LOGOUT_API_URL = 'localhost:8080/logout';
    fetch(LOGOUT_API_URL, {
        method: 'POST', // Use the appropriate HTTP method for your API
    })
    .then(response => response.json())
    .then(result => {
        if (result.success) {
            window.location.href = 'login.html';
        } else {
            alert('Logout failed. Please try again.');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('An error occurred while logging out. Please try again later.');
    });
}

function requestService() {
    const serviceType = document.getElementById('serviceType').value;
    const serviceDetails = document.getElementById('serviceDetails').value;
    const bookingID = document.getElementById('bookingNo').value;

    const apiUrl = "http://localhost:8080/addService";

    const data = {
        serviceName: serviceType,
        serviceDetails: serviceDetails,
        bookingID: bookingID
    }

    axios.post(apiUrl, data, {headers: { Authorization: `Bearer ${localStorage.getItem('token')}`}})
    .then((response) => {
            console.log(response);
            alert("Service added to the booking.");

     })
     .catch(error => {
        console.error('Error fetching data: ', error);
    });
}