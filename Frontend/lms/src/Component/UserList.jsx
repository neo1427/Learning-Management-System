import React, { useState, useEffect } from 'react';
import axios from 'axios';
import RegisterForm from './RegisterForm';
const UserList = () => {
    const [users, setUsers] = useState([]);
  
    useEffect(() => {
      const fetchUsers = async () => {
        try {
          const response = await axios.get('/lms/admin/getAll/users');
          setUsers(response.data);
        } catch (error) {
          // Handle error
        }
      };
      fetchUsers();
    }, []);
  
    return (
      <div>
        <h2>User List</h2>
        <ul>
          {users.map((user) => (
            <li key={user.id}>{user.name}</li>
          ))}
        </ul>
      </div>
    );
  };
  
  const App = () => {
    return (
      <div>
        <h1>Admin Dashboard</h1>
        <RegisterForm />
        <UserList />
      </div>
    );
  };
  
  export default UserList;