package ru.mibix.im.parser.model;

/**
 * Класс для хранения информации о модели (товаре) из Яндекса
 */
public class YmModel extends AbstractModel
{
    private int offersCount;
    private int rating;
    private int reviewsCount;
    private int articlesCount;
    private int categoryId;
    // photos
    private String link;
    private String vendor;
    private String name;
    // prices
    private String description;
    private String facts;
    private String mainPhoto;


}
