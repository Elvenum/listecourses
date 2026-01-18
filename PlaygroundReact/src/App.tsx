
import { Component, createContext, useReducer, useState } from 'react';
import './App.css'
import type User from './types/user';
import LoginFormComponent from './components/LoginFormComponent';
import ComputerManagerComponent from './components/ComputerManagerComponent';
import ComputerProvider from './contexts/ComputerContext';



export const AuthContext = createContext({});

export default function App() {
  
  const [user,setUser] = useState<User | null>(null);

 return <>
      <AuthContext.Provider value={{user, setUser}}>
        <LoginFormComponent/>
          <ComputerProvider>
            <ComputerManagerComponent/>
          </ComputerProvider>
        </AuthContext.Provider> 
    </>
}
