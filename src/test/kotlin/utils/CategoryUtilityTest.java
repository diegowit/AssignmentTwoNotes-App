
package utils


import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import utils.CategoryUtility.categories
import utils.CategoryUtility.isValidCategory

import static com.sun.org.apache.xerces.internal.impl.xpath.regex.Token.categories;
import static utils.CategoryUtility.isValidCategory;

internal class CategoryUtilityTest {
    @Test
    fun categoriesReturnsFullCategoriesSet(){
        Assertions.assertEquals(2, categories.size)
        Assertions.assertTrue(categories.contains("Home"))
        Assertions.assertTrue(categories.contains("College"))
        Assertions.assertFalse(categories.contains(""))
    }

    @Test
    fun isValidCategoryTrueWhenCategoryExists(){
        Assertions.assertTrue(isValidCategory("Home"))
        Assertions.assertTrue(isValidCategory("home"))
        Assertions.assertTrue(isValidCategory("COLLEGE"))
    }

    @Test
    fun isValidCategoryFalseWhenCategoryDoesNotExist(){
        Assertions.assertFalse(isValidCategory("Hom"))
        Assertions.assertFalse(isValidCategory("colllege"))
        Assertions.assertFalse(isValidCategory(""))
    }
}

