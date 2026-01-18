import { Route } from "react-router";
import AuthLayout from "./layouts/AuthLayout";
import RegisterComponent from "./components/RegisterComponent";
import LoginComponent from "./components/LoginComponent";

export default [
    <Route path="auth" element={<AuthLayout/>}>
        <Route path="register" element={<RegisterComponent/>}/>
        <Route path="login" element={<LoginComponent/>}/>
    </Route>
];