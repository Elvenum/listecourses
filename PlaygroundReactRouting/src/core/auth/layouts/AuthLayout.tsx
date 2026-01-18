import { Outlet } from "react-router"
import "./AuthLayout.css"

export default function AuthLayout() {
    return <section className="authContainer">
        <Outlet/>
    </section>
}