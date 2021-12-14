package tests;

public class HomeWorkXpathSelectors {

    static String URL = "http://www.ktto.com.ua/calculation/p_kompensator";

    private static String absolutePath = "//html/head/script"; // Поиск элемента по абсолютному пути







































    //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
    private static String path4_1 = "//div[@id='large_img']/following::strong";
    private static String path4_2 = "//div[@id='large_img']/following::div/*[@style=\"margin-left:5px;\"])[2]";



}
