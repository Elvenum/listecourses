import type Computer from '../types/Computer';


interface Props {
    computers: Computer[];
    onComputerDeleted: (computer: Computer) => void;
    onComputerUpdate : (computer: Computer) => void;
}
export default function ComputerListComponent({computers,onComputerDeleted,onComputerUpdate}:Props) {
    return <ul>
    {computers.map(computer => <li key={computer.name}>
        {computer.name} {computer.price} {computer.ownerName}
        <button onClick={() => onComputerDeleted(computer)}>❌</button>
        <button onClick={() => onComputerUpdate(computer)}>🖍️</button>
        </li>)}
        </ul>   
        
    }
    