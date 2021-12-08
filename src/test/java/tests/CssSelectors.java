package tests;

import org.openqa.selenium.By;

public class CssSelectors {

    private void cssSelectors(){
        By classSelector = By.cssSelector(".radio"); //Поиск по классу radio
        By classSelector1 = By.className("radio"); //Поиск по классу radio

        By idSelector = By.cssSelector("#suite_mode_single"); //Поиск по id
        By idSelector1 = By.id("#suite_mode_single"); //Поиск по id

        By tagSelector = By.cssSelector("label"); //Поиск по tag
        By tagSelector1 = By.tagName("label"); //Поиск по tag

        By tagAttributeSelector = By.cssSelector("label[for='name']"); //Поиск по tag и аттрибуту с значением
        By tagAttributeSelector1 = By.cssSelector("label[for]"); //Поиск по tag и присутсвием аттрибута

        By multipleClassesSelector = By.cssSelector(".column.overflow-content']"); //Поиск по двум классам в элементе
        By simpleHierarchicalSelector = By.cssSelector(".table .content-inner"); //Поиск простого дочернего элемента

        By fullHierarchicalSelector = By.cssSelector("body .table .content-inner"); //Использование 3х уровневой иерархии для поиска дочернего элемента

        By searchLikeContainsSelector = By.cssSelector("form[action*='admin']"); //Поиск с вхождением подстроки в значении аттрибута
        By searchByWordSelector = By.cssSelector("form[action~='admin']"); //Поиск с вхождением слова в значении аттрибута

        By valueStartsFromSelector = By.cssSelector("a[href^='https://']"); //Поиск с элемента с аттрибутом значение которого начинается с

        By valueEndsWithSelector = By.cssSelector("a[href$='@gmail.com']"); //Поиск с элемента с аттрибутом значение которого аканчивается на


    }
}
