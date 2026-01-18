interface Props {
    value: number;
    increment: () => React.Dispatch<React.SetStateAction<number>>;
}

export default function IncrementCounterComponent({value, increment}:Props){
    return <div>
        <span>{value}</span>
        <button onClick={increment}>Increment</button>
    </div>
}