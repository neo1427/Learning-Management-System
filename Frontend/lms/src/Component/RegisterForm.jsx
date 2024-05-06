import React, { useState, useEffect } from 'react';
import axios from 'axios';

const RegisterForm = () => {
  const [formData, setFormData] = useState({
    userId: '',
    name: '',
    password: '',
    role: ''
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('/lms/admin/register/student', formData);
      // Handle success
    } catch (error) {
      // Handle error
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input type="text" name="userId" value={formData.userId} onChange={handleChange} />
      <input type="text" name="name" value={formData.name} onChange={handleChange} />
      <input type="password" name="password" value={formData.password} onChange={handleChange} />
      <select name="role" value={formData.role} onChange={handleChange}>
        <option value="STUDENT">Student</option>
        <option value="TEACHER">Teacher</option>
      </select>
      <button type="submit">Register</button>
    </form>
  );
};

export default RegisterForm;

