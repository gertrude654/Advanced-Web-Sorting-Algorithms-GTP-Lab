document.addEventListener('DOMContentLoaded', () => {
    loadStudents();

    document.getElementById('addStudentForm').addEventListener('submit', (e) => {
        e.preventDefault();
        const id = document.getElementById('studentId').value;
        const name = document.getElementById('studentName').value;
        console.log(`Form Submitted: ID=${id}, Name=${name}`);
        addStudent(id, name, attribute);
    });
});

function loadStudents() {
    fetch('/api/students')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById('studentsTableBody');
            tableBody.innerHTML = '';
            data.forEach(student => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${student.content.id}</td>
                    <td>${student.content.name}</td>
                    <td>
                        <button class="btn btn-danger" onclick="deleteStudent(${student.content.id})">Delete</button>
                    </td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Error loading students:', error));
}

function addStudent(id, name) {
    fetch('/api/students', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ id, name })
    })
    .then(response => {
        if (response.ok) {
            console.log('Student added successfully');
            document.getElementById('studentId').value = '';
            document.getElementById('studentName').value = '';
            loadStudents();
        } else {
            console.error('Error adding student:', response.statusText);
        }
    })
    .catch(error => console.error('Error adding student:', error));
}

function deleteStudent(id) {
    fetch(`/api/students/${id}`, { method: 'DELETE' })
    .then(response => {
        if (response.ok) {
            console.log('Student deleted successfully');
            loadStudents();
        } else {
            console.error('Error deleting student:', response.statusText);
        }
    })
    .catch(error => console.error('Error deleting student:', error));
}

function sortStudents(algorithm) {
    fetch(`/api/students/sort/${algorithm}`)
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById('studentsTableBody');
            tableBody.innerHTML = '';
            data.forEach(student => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${student.content.id}</td>
                    <td>${student.content.name}</td>
                    <td>
                        <button class="btn btn-danger" onclick="deleteStudent(${student.content.id})">Delete</button>
                    </td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Error sorting students:', error));
}
