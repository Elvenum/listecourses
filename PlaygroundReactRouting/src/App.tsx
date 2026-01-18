import { NavLink, Route, Routes } from "react-router";
import "./App.css"
import IndexComponent from "./IndexComponent";
import NotFoundComponent from "./core/NotFoundComponent";
import authRoutes from "./core/auth/auth-routes";
import shopRoutes from "./features/shop/shop-routes";


export default function App() {
  return <>
  <nav className="nav">
  <NavLink to="/">Home</NavLink>
  <NavLink to="/auth/register">Register</NavLink>
  <NavLink to="/auth/login">Login</NavLink>
  </nav>
  <nav className="nav">
    <NavLink to="/shop/AllCategories">All categories</NavLink>
    <NavLink to="/shop/categories/technologies">Technologies</NavLink>
    <NavLink to="/shop/categories/foods">Foods</NavLink>
  </nav>
  <Routes>
    <Route index element={<IndexComponent />}/>
    {authRoutes}
    {shopRoutes}

    <Route path="*" element={<NotFoundComponent/>}/>
  </Routes>
  </>
}