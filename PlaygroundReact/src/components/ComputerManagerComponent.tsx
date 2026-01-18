import { useReducer, useState } from "react";
import type Computer from "../types/Computer";
import ComputerFormComponent from "./ComputerFormComponent";
import ComputerListComponent from "./ComputerListComponent";
import { useComputers, useComputersDispatch } from "../contexts/ComputerContext";


export default function ComputerManagerComponent(){
    const computers = useComputers();
    const dispatch = useComputersDispatch;
    const [currentEditedComputer , setCurrentEditedComputer]= useState<Computer | null>(null);

    return <> 
        <ComputerListComponent computers={computers}
      onComputerUpdate={(computer: Computer) => setCurrentEditedComputer(computer)} 
      onComputerDeleted={(computer: Computer) => {
        if (confirm("Are you sure that you want to delete this copmputer ?"))
            dispatch({type: "DELETE_COMPUTER", computer: computer});
      }}
      />
      {currentEditedComputer
        ? <>
          <h2>Update computer</h2> 
          <ComputerFormComponent
            ComputerUpdated={currentEditedComputer}
            onComputerChanged={(computer: Computer) => {
              dispatch({type: "UPDATE_COMPUTER", computer: computer});
              setCurrentEditedComputer(null);
              return true;
            }}
        /></>
        
        : <>
          <h2>Add computer</h2>
          <ComputerFormComponent
          onComputerChanged={(computer: Computer) => {
            if (computers.some(c => c.name.toLowerCase() === computer.name.toLowerCase())) 
              return false;
            
            dispatch({type: "ADD_COMPUTER", computer: computer});
            return true;
          }}        
        /></>
      }
    
    </>
}