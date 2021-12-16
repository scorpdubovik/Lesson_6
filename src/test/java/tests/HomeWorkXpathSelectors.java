package tests;

public class HomeWorkXpathSelectors {

    static String URL = "http://www.ktto.com.ua/calculation/p_kompensator";

    private static String absolutePath = "//html/head/script"; // Поиск элемента по абсолютному пути

    private static String allElementsInHTMLPath = "//*";  // Все элементы на странице начиная с html - тэга

    private static String bodyPath = "//body";  // Элемент по тэгу

    private static String childPath = "//div/script";  // Дочерний элемент относительно родителя

    private static String tagWithAttrPath = "//ins[@class='adsbygoogle']";  // Поиск элемента с аттрибутом и его значением

    private static String parentPath = "//ins[@class='adsbygoogle']//..";  // Поиск родителя у элемента с аттрибутом и его значением

    private static String elementByIndexPath = "(//span)[3]";  // Поиск элемента по индексу

    private static String searchByTextPath = "//*[text()='Рекомендации к монтажу']";  // Поиск элемента по полному соответствию по тексту
    private static String searchByTextPath1 = "//*[.='Рекомендации к монтажу']";  // Поиск элемента по полному соответствию по тексту

    private static String searchBySubstringPath = "//*[contains(text(), 'монтажу')]";  // Поиск элемента по подстроке текста




//*[text()='Рекомендации к монтажу']
//*[contains(text(), 'монтажу')]















    //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
    private static String path4_1 = "//div[@id='large_img']/following::strong";
    private static String path4_2 = "//div[@id='large_img']/following::div/*[@style=\"margin-left:5px;\"])[2]";


}
