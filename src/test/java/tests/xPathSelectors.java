package tests;

public class xPathSelectors {
    private static String absolutePath = "/html/body/div";

    private static String allElementsInHTMLPath = "//*";  // Все элементы на странице начиная с html - тэга

    private static String bodyPath = "//body";  // Элемент по тэгу

    private static String childPath = "//form/input";  // Дочерний элемент относительно родителя

    private static String tagWithAttrPath = "//span[@id='access--1']";  // Поиск элемента с аттрибутом и его значением

    private static String parentPath = "//span[@id='access--1']//..";  // Поиск родителя у элемента с аттрибутом и его значением

    private static String elementByIndexPath = "(//form)[4]";  // Поиск элемента по индексу

    private static String searchByTextPath = "//*[text()='New Widget')]";  // Поиск элемента по полному соответствию по тексту
    private static String searchByTextPath1 = "//*[.='New Widget')]";  // Поиск элемента по полному соответствию по тексту


    private static String searchBySubstringPath = "//*[contains(text(),'Widget')]";   // Поиск элемента по подстроке в тексте

    private static String searchByTwoAttrPath = "//*[@class='form-control ' and @type='text']";   // Использование логического оператора

    private static String searchBySpecificAttrPath = "//input[@type != 'hidden']";   // Использование логического оператора



//*[contains(text(),'Ne') and contains(text(),'et')]
}
