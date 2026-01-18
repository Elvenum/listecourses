import { useContext, useEffect, useRef, useState, type ChangeEvent, type FormEvent } from "react";
import type  Computer  from "../types/Computer";
import type computer from "../types/Computer";
import { AuthContext } from "../App";

interface Props {
    onComputerChanged: (computer:Computer) => boolean
    ComputerUpdated?: Computer;
}
export default function ComputerFormComponent({onComputerChanged, ComputerUpdated}:Props){
    const {user} = useContext(AuthContext);
    const [inputs, setInputs] = useState<computer>({name: "", price: 0});
    const [formValid,setFormValid] = useState<boolean>(false);
    const nameRef = useRef<HTMLInputElement>(null);

    useEffect(() => {
        updateFormValidity();
    }, [inputs]);

    useEffect(() => {
        if(ComputerUpdated)
            setInputs({id: ComputerUpdated!.id,name: ComputerUpdated!.name,price: ComputerUpdated!.price})
    }, [ComputerUpdated]);


    const handleSubmit = (event: FormEvent<HTMLFormElement>): void  => {
        event.preventDefault();
        const computerEmitted : Computer = {...inputs};
        if(user)
            computerEmitted.ownerName = user.pseudo;
        
        onComputerChanged(computerEmitted);
        setInputs({name: "",price: 0});
        nameRef.current?.focus();
    };

    const handleChange = (event: ChangeEvent<HTMLInputElement>): void => {
        const {name,value} = event.target;
        //sans les [ ] c'est la clé literale name avec ca lit la valeur de name dans la const et ca la transforme en clé 
        setInputs({...inputs, [name]:value});
        updateFormValidity();
    };

    const updateFormValidity = () => {
        // !! pour avoir la valeur boolean de l'input 
        setFormValid(!!inputs.name.length && inputs.price > 0)
    }

    return <form onSubmit={handleSubmit}>
        <div>
            <label>
                Name : <input type="text" ref={nameRef} value={inputs.name} name="name" onChange={handleChange}/>
            </label>
        </div>
        <div>
            <label>
                Price : <input type="number"value={inputs.price} name="price" onChange={handleChange}/>
            </label>
        </div> 
        <input type="submit" value="Create computer" disabled={!formValid}/>
    </form>


}
