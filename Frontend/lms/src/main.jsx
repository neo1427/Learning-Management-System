import React from "react";
import ReactDOM from 'react-dom/client'
import App from "./App";
import { BrowserRouter } from "react-router-dom";
import {Routes} from "react-router-dom"
import Contact from "./Component/Contact";
import About from "./Component/About";
import Home from "./Component/Home";
import Login from "./Component/Login";

export default Routing = () => {
    return(
      <BrowserRouter>
        <Routes>
          <Routes path='/' element={<App />}/>
          <Routes path="/Home" element={<Home/>}/>
          <Routes path="/About" element={<About></About>}/>
          <Routes path="/Contact" element={<Contact></Contact>}/>
          <Routes path="/Login" element={<Login></Login>}/>
        </Routes>
      </BrowserRouter>
    )
  }
  