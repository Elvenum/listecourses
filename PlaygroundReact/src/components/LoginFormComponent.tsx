import { useContext, useRef, type FormEvent } from "react";
import { AuthContext } from "../App";

export default function LoginFormComponent() {
    const {setUser} = useContext(AuthContext)
    const pseudoRef = useRef<HTMLInputElement>(null);
    
    function handleSubmit (event :FormEvent<HTMLFormElement>):void {
        event.preventDefault();
        
        if(pseudoRef.current){
            setUser({
            pseudo: pseudoRef.current?.value
        });
        }
    }

    return <form onSubmit={handleSubmit}>
        <label>
            Pseudo: <input type="text" ref={pseudoRef}/>
        </label>
        <input type="submit" value="Se connecter"/>
    </form>
}