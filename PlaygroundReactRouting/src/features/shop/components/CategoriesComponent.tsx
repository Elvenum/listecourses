import { useParams } from "react-router"

export default function CategoriesComponent () {
    const {categorySlug} = useParams();
    return <>
        {     
            categorySlug
            ? `gg gros ${categorySlug}`
            :"All categories"
        }
    </>
}