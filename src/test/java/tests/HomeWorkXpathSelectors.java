package tests;

public class HomeWorkXpathSelectors {

    static String URL = "http://www.ktto.com.ua/calculation/p_kompensator";

    private static String absolutePath = "//html/head/script"; // Поиск элемента по абсолютному пути

    private static String allElementsInHTMLPath = "//*";  // Все элементы на странице начиная с html - тэга

    private static String bodyPath = "//body";  // Элемент по тэгу

    private static String childPath = "//div/script";  // Дочерний элемент относительно родителя

    private static String tagWithAttrPath = "//ins[@class='adsbygoogle']";  // Поиск элемента с аттрибутом и его значением

    private static String parentPath = "//ins[@class='adsbygoogle']//..";  // Поиск родителя у элемента с аттрибутом и его значением
    private static String parentPath1 = "//*[@class='adsbygoogle']//parent::div";  // Поиск родителя у элемента с аттрибутом и его значением

    private static String elementByIndexPath = "(//span)[3]";  // Поиск элемента по индексу

    private static String searchByTextPath = "//*[text()='Рекомендации к монтажу']";  // Поиск элемента по полному соответствию по тексту
    private static String searchByTextPath1 = "//*[.='Рекомендации к монтажу']";  // Поиск элемента по полному соответствию по тексту

    private static String searchBySubstringPath = "//*[contains(text(), 'монтажу')]";  // Поиск элемента по подстроке в тексте

    private static String searchByStartsWithPath = "//input[starts-with(@type, 'te')]"; // Поиск элемента по аттрибуту значение которого начинается с

    private static String searchByTwoAttrPath = "//*[@type='text/javascript' and @charset='UTF-8']"; // Использование логического оператора

    private static String searchBySpecificAttrPath = "//div[@style != 'width: 48%;']";  // Использование логического оператора

    // Axes - Оси
    // Использование ancestor - все предки текущего узла
    private static String path1 = "//*[@name='form']/ancestor::div";

    //Использование child - все потомки текущего узла зависят от уровня
    private static String Path2_1 = "//ol/child::li";
    private static String Path2_2 = "//ol/li";  // аналог только проще

    //Использование descendant - все потомки текущего узла не зависимо от уровня
    private static String Path3_1 = "//ol/descendant::li";
    private static String Path3_2 = "//ol//li";  // аналог только проще

    //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
    private static String path4_1 = "//div[@id='large_img']/following::strong";
    private static String path4_2 = "(//div[@id='large_img']/following::div/*[@style='margin-left:5px;'])[2]";

    //Использование following-sibling - Выбирает все узлы одного уровня после текущего узла
    private static String path5_1 = "//div[@id='large_img']/following-sibling::p";

    //Использование preceding- Выбирает все узлы, которые появляются перед текущим узлом в документе
    private static String path6_1 = "//div[@id='large_img']/preceding::script";

    //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
    private static String path7_1 = "//div[@id=\"share_more___uptlk6982\"]/preceding-sibling::iframe";
}
