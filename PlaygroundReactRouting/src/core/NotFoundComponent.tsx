import { useParams } from "react-router"

export default function NotFoundComponent() {
    
    const{"*":splat} = useParams();

    console.log(splat);
    
    return <div>
        Not found  gros béta !
    </div>
}