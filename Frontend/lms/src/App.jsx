import React from 'react';
import {Link} from 'react-router-dom'
//import logo from './logo.svg';
import './App.css';
//import RegisterForm from './Component/RegisterForm'; // Import the RegisterForm component
//import UserList from './Component/UserList'; // Import the UserList component

function App() {
  

  return (
      <>
        <div className='Nav-Bar'>
          
          <h2>LMS</h2>
          <nav className='nav-cont'>
            <input type='text' placeholder='Search..'></input>
              <ul>
                <li>
                  <Link to="/Home">Home</Link>
                </li>
                <li>
                  <Link to="/About">About</Link>
                </li>
                <li>
                  <Link to="/Contact">Contact</Link>
                </li>
                <li>
                  <Link to="/Login">Login</Link>
                </li>
              </ul>
          </nav>
        </div>
        
        <div className='Hero_bg'>
            <h1>Welcome to LMS</h1>
            <p>One place to learn all</p>
        </div>
      </>
  )
}

export default App
