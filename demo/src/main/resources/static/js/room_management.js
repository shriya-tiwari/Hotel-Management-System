function fetchRoomTypes() {
    const apiUrl = "http://localhost:8080/admin/getRoomTypes";
    axios.get(apiUrl, {
            headers: {
                Authorization: `Bearer ${localStorage.getItem('token')}`
            }
        })
        .then((response) => {
            console.log(response);
            const data = response.data;
            console.log(data);
            const roomTypeTableBody = document.getElementById('roomTypeTableBody');
            const roomTypeFilter = document.getElementById("roomTypeFilter");
            roomTypeTableBody.innerHTML = '';

            data.forEach((room, index) => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${index+1}</td>
                    <td>${room.totalRooms}</td>
                    <td>${room.typeName}</td>
                    <td>${room.typeDescription}</td>

                `;
                roomTypeTableBody.appendChild(row);

                const option = document.createElement("option");
                option.value = room.typeName;
                option.text = room.typeName;
                roomTypeFilter.appendChild(option);
            })
        })
        .catch(error => {
           console.error('Error fetching data: ', error);
       });
}



async function loadRooms() {
    const apiUrl = "http://localhost:8080/admin/getAllRooms";
    axios.get(apiUrl, {
                headers: {
                    Authorization: `Bearer ${localStorage.getItem('token')}`
                }
            })
            .then((response) => {
                console.log(response);
                const data = response.data;
                console.log(data);
                const tableBody = document.getElementById("roomTableBody");
                tableBody.innerHTML = '';

                data.forEach((room, index) => {
                    const row = document.createElement("tr");
                    row.innerHTML = `
                        <td>${index+1}</td>
                        <td>${room.roomType}</td>
                        <td>${room.cost}</td>
                        <td>${room.occupancyLimit}</td>
                    `;
                    tableBody.appendChild(row);
                });
            })
            .catch(error => {
               console.error('Error fetching data: ', error);
           });
}

window.addEventListener('load', fetchRoomTypes());
window.addEventListener('load', loadRooms());

function filterRooms() {
    const selectedRoomType = document.getElementById("roomTypeFilter").value;
    const rows = document.querySelectorAll("#roomTableBody tr");

    rows.forEach((row) => {
        const roomType = row.cells[1].textContent;
        if (selectedRoomType === "all" || roomType === selectedRoomType) {
            row.style.display = "";
        } else {
            row.style.display = "none";
        }
    })
}
