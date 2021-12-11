package tests;

import org.openqa.selenium.By;

public class HomeWorkCssSelectors {
    static String URL = "https://www.spiraxsarco.com/resources-and-design-tools/calculators/pipes/steam/sizing-new-pipes";

    private void cssSelectors(){
     By classSelector = By.cssSelector(".btn__text");  // Поиск по классу btn__text
     By classSelector1 = By.className("btn__text");    // Поиск по классу btn__text

     By idSelector = By.cssSelector("#WelmntTUV_txtValue");  // Поиск по id
     By idSelector1 = By.id("WelmntTUV_txtValue");    // Поиск по id

     By tagSelector = By.cssSelector("script"); // Поиск по tag
     By tagSelector1 = By.tagName("script"); // Поиск по tag

     By tagAttributeSelector = By.cssSelector("input[type='text']"); // Поиск по tag и атрибуту с значением
     By tagAttributeSelector1 = By.cssSelector("input[type]"); // Поиск по tag и присутсвием атрибута

     By multipleClassesSelector = By.cssSelector(".location-bar__cta.btn.btn--small"); // Поиск по двум классам в элементе

     By simpleHierarchicalSelector = By.cssSelector(".topbar .logo"); // Поиск простого дочернего элемента

     By searchLikeContainsSelector = By.cssSelector("button[data-api*='sxsapi']"); //Поиск с вхождением подстроки в значении аттрибута
     By searchByWordSelector = By.cssSelector("div[class~=pos-fixed]"); //Поиск с вхождением слова в значении аттрибута

     By valueStartsFromSelector = By.cssSelector("a[href^='https:']"); //Поиск с элемента с аттрибутом значение которого начинается с

     By valueEndsWithSelector = By.cssSelector("a[href$='spiraxsarcoengineering.com/']']"); //Поиск с элемента с аттрибутом значение которого аканчивается на

     By childRightAfterParentSelector = By.cssSelector("td>img"); //Поиск дочернего img у которого родитель td

     By elementRightAfterElementSelector = By.cssSelector("script+iframe"); //Поиск элемента iframe который идет сразу после элемента script
     By elementOnTheSameLevelSelector = By.cssSelector("footer~div"); //Поиск элементов div которым предшествует элемент footer

     By firstChildSelector = By.cssSelector("nav:first-child"); //Поиск 1го дочернего элемента
     By lastChildSelector = By.cssSelector("script:last-child"); //Поиск последнего дочернего элемента
     By nthChildFromBeginSelector = By.cssSelector("meta:nth-child(4)"); //Поиск n-го дочернего элемента с начала
     By nthChildFromEndSelector = By.cssSelector("meta:nth-last-child(3)"); //Поиск n-го дочернего элемента с конца

    }
}
