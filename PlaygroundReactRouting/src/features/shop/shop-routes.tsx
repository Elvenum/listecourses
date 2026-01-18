import { Route } from "react-router";
import ShopLayout from "./layouts/ShopLayout";
import CategoriesComponent from "./components/CategoriesComponent";

export default [
      <Route path="shop" element={<ShopLayout/>}>
    <Route path="categories/:categorySlug?" element={<CategoriesComponent/>}/>
    </Route>
];