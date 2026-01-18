import { createContext, useContext, useReducer } from "react";
import type Computer from "../types/Computer";

const ComputerContext = createContext({});
const ComputerDispatchContext = createContext({});


export default function ComputerProvider({children}) {
    const [computers,dispach] = useReducer(reducer, []);

    return (
        <ComputerContext.Provider value={computers}>
            <ComputerDispatchContext.Provider value={dispach}>
                {children}
            </ComputerDispatchContext.Provider>
        </ComputerContext.Provider>
    );
}

export const useComputers = () => useContext(ComputerContext);
export const useComputersDispatch = (p0: { type: string; computer: Computer; }) => useContext(ComputerDispatchContext);

type ActionType = "ADD_COMPUTER" | "DELETE_COMPUTER" | "UPDATE_COMPUTER";
interface Action { type: ActionType, computer: Computer }

function reducer(computers: Computer[], action: Action) {
  switch(action.type){
    case "ADD_COMPUTER":
      action.computer.id = action.computer.name + action.computer.price;
      return [...computers,action.computer];
    case "DELETE_COMPUTER":
      return computers.filter(item => item.name !== action.computer.name);
    case "UPDATE_COMPUTER":
      return computers.map(item => (item.id === action.computer.id) ? {...item,...action.computer}:item);
    default : 
    throw Error("Unknown type :"+ action.type);
  }
}
